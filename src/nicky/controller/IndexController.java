package nicky.controller;

import javax.inject.Inject;

import nicky.service.interfaces.ITestService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class IndexController extends MultiActionController{
    @Inject
    private ITestService testServiceImpl;
    @RequestMapping("/")
    public ModelAndView index() {
        return indexView();
    }
    @RequestMapping(value = "/index")
    public ModelAndView indexView() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("name", "Nicky!  " +  testServiceImpl.find());
        return mav;
    }
}
