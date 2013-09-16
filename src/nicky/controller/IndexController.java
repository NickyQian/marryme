package nicky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class IndexController extends MultiActionController{
    @RequestMapping("/")
    public ModelAndView index() {
        return indexView();
    }
    @RequestMapping(value = "/index")
    public ModelAndView indexView() {
        ModelAndView mav = new ModelAndView("index");
//        mav.addObject("name", "Nicky!");
        return mav;
    }
}
