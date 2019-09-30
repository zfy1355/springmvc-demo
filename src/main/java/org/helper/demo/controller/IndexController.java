package org.helper.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Value("${appName}")
    private String appName;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("appName",appName);
        return "index";
    }

    @RequestMapping("/vm")
    public String vmDemo(Model model){
        model.addAttribute("appName",appName);
        return "vm";
    }

    @RequestMapping("/jsp")
    public String jspDemo(){
        ModelAndView model = new ModelAndView();
        model.addObject("appName",appName);
        return "jsp";
    }

}
