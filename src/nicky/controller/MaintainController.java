package nicky.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import nicky.bean.FileMeta;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/index")
    public ModelAndView indexView() {
        ModelAndView mav = new ModelAndView("maintain/login");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String userName, String password) {
        if (userName.equals("Nicky") && password.equals("NIcky"))
            return new ModelAndView("maintain/index");
        return new ModelAndView("common/error");
    }

    LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;

    /***************************************************
     * URL: /rest/controller/upload upload(): receives files
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
    LinkedList<FileMeta> upload(MultipartHttpServletRequest request,
            HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        // 1. build an iterator
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = null;

        // 2. get each file
        while (itr.hasNext()) {

            // 2.1 get next MultipartFile
            String s2 = itr.next();
            mpf = request.getFile(s2);
            System.out.println(new String(mpf.getOriginalFilename().getBytes("ISO8859-1"), "utf-8") + " uploaded! "
                    + files.size());

            // 2.2 if files > 10 remove the first from the list
            if (files.size() >= 10)
                files.pop();

            // 2.3 create new fileMeta
            fileMeta = new FileMeta();
            fileMeta.setFileName(new String(mpf.getOriginalFilename().getBytes(), "utf-8"));
            fileMeta.setFileSize(mpf.getSize() / 1024 + " Kb");
            fileMeta.setFileType(mpf.getContentType());

            try {
                fileMeta.setBytes(mpf.getBytes());

                // copy file to local disk (make sure the path
                // "e.g. D:/temp/files" exists)
                String s = request.getSession()
                        .getServletContext()
                        .getRealPath("/photos/");
                FileCopyUtils.copy(
                        mpf.getBytes(),
                        new FileOutputStream(request.getSession()
                                .getServletContext()
                                .getRealPath("/photos")
                                + File.separator + mpf.getOriginalFilename()));

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 2.4 add to files
            files.add(fileMeta);
        }
        // result will be like this
        // [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
        return files;
    }

}
