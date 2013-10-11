package nicky.controller;

import java.util.List;

import nicky.bean.FileMeta;
import nicky.service.interfaces.IFileService;
import nicky.service.interfaces.ITestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class IndexController extends MultiActionController{
    @Autowired
    private ITestService testServiceImpl;
    @Autowired
    private IFileService fileServiceImpl;

    @RequestMapping("/")
    public ModelAndView index() {
        return indexView();
    }
    @RequestMapping(value = "/index")
    public ModelAndView indexView() {
        ModelAndView mav = new ModelAndView("index/index");
//        mav.addObject("name", "Nicky!  " +  testServiceImpl.find());
        mav.addObject("name", "Nicky!  " +  testServiceImpl.find());
        List<FileMeta> pictures = fileServiceImpl.findAllFiles();
        mav.addObject("pictures", pictures);
        return mav;
    }
}
