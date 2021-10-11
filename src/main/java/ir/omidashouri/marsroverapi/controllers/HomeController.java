package ir.omidashouri.marsroverapi.controllers;

import ir.omidashouri.marsroverapi.dto.HomeDto;
import ir.omidashouri.marsroverapi.model.responses.MarsRoverApiResponse;
import ir.omidashouri.marsroverapi.services.MarsRoverApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.InvocationTargetException;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final MarsRoverApiService marsRoverApiService;

    @GetMapping(value = {"/"})
    public String getHomeView(ModelMap modelMap, HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {
        if (StringUtils.isEmpty(homeDto.getMarsApiRoverData())) {
            homeDto.setMarsApiRoverData("Opportunity");
        }
        if (homeDto.getMarsSol() == null) {
            homeDto.setMarsSol(1);
        }
        MarsRoverApiResponse marsRoverApiResponse = marsRoverApiService
                .getRoverData(homeDto);
        modelMap.put("marsRoverData", marsRoverApiResponse);
        modelMap.put("homeDto", homeDto);
        modelMap.put("validCameras", marsRoverApiService.getValidCameras().get(homeDto.getMarsApiRoverData()));
        return "index";
    }

    @PostMapping(value = {"/"})
    public String postHomeView(@ModelAttribute(value = "homeDto")HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {
        System.out.println(homeDto);
        return "redirect:/";
    }

    @GetMapping(value = {"/2"})
    public String getHomeView(ModelMap modelMap, @RequestParam(required = false) String marsApiRoverData,
                              @RequestParam(required = false) Integer marsSol,
                              @RequestParam(required = false) Boolean defaultCheck1) {
        if (StringUtils.isEmpty(marsApiRoverData)) {
            marsApiRoverData = "opportunity";
        }
        if (marsSol == null) {
            marsSol = 1;
        }
        MarsRoverApiResponse marsRoverApiResponse = marsRoverApiService.getRoverData(marsApiRoverData, marsSol);
        modelMap.put("marsRoverData", marsRoverApiResponse);
        return "index2";
    }


//    change post tget
/*    @GetMapping(value = {"/"})
    public String getHomeView(ModelMap modelMap) {
        MarsRoverApiResponse marsRoverApiResponse = marsRoverApiService.getRoverData("opportunity");
        modelMap.put("marsRoverData", marsRoverApiResponse);
        return "index";
    }

    //    when redirect data is not saved in the page
    @PostMapping("/")
    public String getHomeView(ModelMap modelMap, @RequestParam String marsApiRoverData) {
        MarsRoverApiResponse marsRoverApiResponse = marsRoverApiService.getRoverData(marsApiRoverData);
        modelMap.put("marsRoverData", marsRoverApiResponse);
        return "redirect:/";
    }*/


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
