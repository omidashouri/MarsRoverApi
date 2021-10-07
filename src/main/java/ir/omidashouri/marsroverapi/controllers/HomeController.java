package ir.omidashouri.marsroverapi.controllers;

import ir.omidashouri.marsroverapi.model.responses.MarsRoverApiResponse;
import ir.omidashouri.marsroverapi.services.MarsRoverApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final MarsRoverApiService marsRoverApiService;

    @GetMapping(value = {"/"})
    public String getHomeView(ModelMap modelMap) {
//        curiosity opportunity
        MarsRoverApiResponse marsRoverApiResponse = marsRoverApiService.getRoverData("opportunity");
        modelMap.put("marsRoverData", marsRoverApiResponse);
        return "index";
    }

/*
    @GetMapping(value = {"/redirect"})
    public String redirectPostResponseToHomeView(ModelMap modelMap){
        MarsRoverApiResponse marsRoverApiResponse = marsRoverApiService.getRoverData("opportunity");
        modelMap.put("marsRoverData", marsRoverApiResponse);
        return "index";
    }
*/

    //    when redirect data is not saved in the page
    @PostMapping("/")
    public String getHomeView(ModelMap modelMap, @RequestParam String marsApiRoverData) {
        MarsRoverApiResponse marsRoverApiResponse = marsRoverApiService.getRoverData(marsApiRoverData);
        modelMap.put("marsRoverData", marsRoverApiResponse);
//        return "index";
        return "redirect:/";
    }


    @GetMapping("/1")
    public String getHomeView1(Model model) {
        //we can use 'ModelMap' instead 'Model' and use modelMap.put("name", "omidashouri")
        model.addAttribute("name", "omidashouri");
        return "index1";
    }

    @GetMapping("/modelMap")
    public String getHomeView1(ModelMap modelMap){
        modelMap.put("name", "omidashouri from modelMap");
        return "index1";
    }

}
