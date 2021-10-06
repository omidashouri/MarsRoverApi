package ir.omidashouri.marsroverapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomeView(Model model){

        //we can use 'ModelMap' instead 'Model' and use modelMap.put("name", "omidashouri")
        model.addAttribute("name", "omidashouri");


        return "index";
    }

    @GetMapping("/modelMap")
    public String getHomeView(ModelMap modelMap){
        modelMap.put("name", "omidashouri from modelMap");
        return "index";
    }

}
