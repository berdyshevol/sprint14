package com.softserve.edu.controller;


import com.softserve.edu.model.Marathon;
import com.softserve.edu.service.MarathonService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Data
@AllArgsConstructor
public class MarathonController {
    private MarathonService marathonService;

    @GetMapping("/marathons")
    public String getAllMarathons(Model model) {
        List<Marathon> marathons = marathonService.getAll();
        model.addAttribute("marathons", marathons );
        return "marathons";
    }

    @GetMapping("/marathon/delete/{id}")
    public String deleteMarathon(@PathVariable(name="id") Long id) {
        marathonService.deleteMarathonById(id);
        return "redirect:/marathons";
    }

    @GetMapping("/createmarathon")
    public String creatMarathon(Model model) {
        Marathon marathon = new Marathon();
        model.addAttribute("marathon", marathon);
        return "createmarathon";
    }

    @PostMapping("/createMarathon")
    public String addMarathon(@ModelAttribute(name="marathon") Marathon marathon) {
        marathonService.createOrUpdate(marathon);
        return "redirect:/marathons";
    }
}
