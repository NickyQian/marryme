package nicky.controller;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nicky.bean.FileMeta;
import nicky.common.Constants;
import nicky.service.interfaces.IFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping("/maintain")
public class MaintainController extends MultiActionController {
    @Autowired
    private IFileService fileServiceImpl;
    
    @RequestMapping(value = "/index")
    public ModelAndView loginView(HttpServletRequest request) {
        // check if cookie or session exists.
        Cookie[] cookies = request.getCookies();// get cookies
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginuser")) {
                    request.getSession().setAttribute("loginuser",
                            cookie.getValue());
                    return new ModelAndView("maintain/index");
                }
            }
        } 
        String loginUserName = (String) request.getSession().getAttribute(
                "loginuser");
        if (loginUserName != null) {
            return new ModelAndView("maintain/index");
        } else {
            return new ModelAndView("maintain/login");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,
            HttpServletResponse response, String userName, String password,
            boolean isRemember) {
        if (userName.equals("Nicky") && password.equals("NIcky")) {
            request.getSession().setAttribute("loginuser", userName);
            if (isRemember) {
                // set cookie
                Cookie cookie = new Cookie("loginuser", userName);
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
            }
            return new ModelAndView("maintain/index");
        }
        return new ModelAndView("common/error");
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        Cookie[] cookies = request.getCookies();// get cookies
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginuser")) {
                // 0 ：delete immediately; 
                //-1 : delete after close the browser
                cookie.setMaxAge(0); 
                response.addCookie(cookie); 
            }
        }
        return new ModelAndView("photo/photo_list");
    }

    /***************************************************
     * URL: /maintain/upload upload(): receives files
     * 
     * @param request
     *            : MultipartHttpServletRequest auto passed
     * @param response
     *            : HttpServletResponse auto passed
     * @return LinkedList<FileMeta> as json format
     * @throws UnsupportedEncodingException
     ****************************************************/
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    List<FileMeta> upload(MultipartHttpServletRequest request,
            HttpServletResponse response) throws UnsupportedEncodingException, Exception {
        LinkedList<FileMeta> files = new LinkedList<FileMeta>();
        FileMeta fileMeta = null;
        // 1. build an iterator
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = null;

        /* 上传原图的路径 */
        String uploadPath = request.getSession().getServletContext()
                .getRealPath(Constants.PIC_FILE_PATH)
                + File.separator;
        /* 缩略图存放的路径 */
        String thumbnailPath = request.getSession().getServletContext()
                .getRealPath(Constants.PIC_TUMBNIAL_PATH)
                + File.separator;

        // 2. get each file
        while (itr.hasNext()) {
            // 2.1 get next MultipartFile
            mpf = request.getFile(itr.next());
            /* 用当前时间重命名文件 */
            String fileName = generateFileName();
            /* 照片的title */
            String fileTitle = mpf.getOriginalFilename().replace(".jpg", "");
            // /* 照片的描述 */
            // String fileDescript;

            // // 2.2 if files > 10 remove the first from the list
            // if (files.size() >= 10)
            // files.pop();

            // 2.3 create new fileMeta
            fileMeta = new FileMeta();
            fileMeta.setFileName(fileName);
            fileMeta.setFileTitle(fileTitle);
            fileMeta.setFileSize(mpf.getSize() / 1024);

            try {
                fileMeta.setBytes(mpf.getBytes());

                // copy file to local disk (make sure the path exists)
                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(
                        uploadPath + fileName));
                System.out.println(fileTitle + " uploaded! ");
                createPreviewImage(uploadPath + fileName, thumbnailPath
                        + fileName);

                // 相关数据存入数据库
                fileServiceImpl.saveFileInfo(fileMeta);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 2.4 add to files
            files.add(fileMeta);
        }
        // result will be like this
        // [{"fileId": "121", "fileName":"app_engine-85x77.png", "fileTitle": "图片",
        // "fileSize":"8 Kb","fileType":"image/jpg"},...]
        return files;
    }

    @RequestMapping(value = "/batch_save", method = RequestMethod.POST)
    public String batchSaveFile(Long[] fileId, String[] fileTitle, String[] fileDesc) {
        fileServiceImpl.batchSaveFile(fileId, fileTitle, fileDesc);
        return "redirect:/maintain/index";
    }

    /**
     * 创建缩略图
     */
    private final int IMAGE_WIDTH = 300;
    public File createPreviewImage(String srcFile, String destFile) {
        try {
            File fi = new File(srcFile); // src
            File fo = new File(destFile); // dest
            /* 如果不存在就新建 */
            if (!fo.exists()) {
                fo.mkdirs();
            }
            BufferedImage bis = ImageIO.read(fi);

            int w = bis.getWidth();
            int h = bis.getHeight();
            int nw = IMAGE_WIDTH;
            int nh = (nw * h) / w;
            if (nh > IMAGE_WIDTH) {
                nh = IMAGE_WIDTH;
                nw = (nh * w) / h;
            }
            double sx = (double) nw / w;
            double sy = (double) nh / h;

            AffineTransform transform = new AffineTransform();
            transform.setToScale(sx, sy);
            AffineTransformOp ato = new AffineTransformOp(transform, null);
            BufferedImage bid = new BufferedImage(nw, nh,
                    BufferedImage.TYPE_3BYTE_BGR);
            ato.filter(bis, bid);
            ImageIO.write(bid, "jpg", fo);
            return fo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                    " Failed in create preview image. Error:  "
                            + e.getMessage());
        }
    }

    /**
     * 获得以当前时间戳的照片名
     * 
     * @return
     */
    public String generateFileName() {
        Long fileName = System.currentTimeMillis();
        return fileName.toString() + ".jpg";
    }

}
