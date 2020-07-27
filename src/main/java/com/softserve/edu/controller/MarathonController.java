package com.softserve.edu.controller;


import com.softserve.edu.service.MarathonService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Data
public class MarathonController {
    private MarathonService marathonService;

    @GetMapping("/marathons")
    public String getAllMarathons(Model model) {
        //TODO
        return "marathons";
    }

    //TODO implement other needed methods
}
