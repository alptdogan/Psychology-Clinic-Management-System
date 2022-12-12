package com.alpdogan.PsychologyClinic.controller;

import com.alpdogan.PsychologyClinic.entity.TherapyApproach;
import com.alpdogan.PsychologyClinic.service.TherapyApproachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/approach")
public class TherapyApproachController {

    @Autowired
    private TherapyApproachService therapyApproachService;

    @GetMapping
    public String displayApproaches(Model model) {

        List<TherapyApproach> approaches = therapyApproachService.getAllApproaches();
        model.addAttribute("therapyApproach", approaches);

        return "list-approaches";

    }

    @GetMapping("/new")
    public String displayApproachForm(Model model) {

        TherapyApproach approach = new TherapyApproach();
        model.addAttribute("therapyApproach", approach);

        return "new-approach";

    }

    @PostMapping("/addApproach")
    public String createApproach(@ModelAttribute("therapyApproach") TherapyApproach approach) {

        therapyApproachService.createApproach(approach);

        return "redirect:/approach";

    }

    @GetMapping("/update")
    public String displayApproachUpdateForm(@RequestParam("id") int id, Model model) {

        TherapyApproach approach = therapyApproachService.getApproachById(id);
        model.addAttribute("therapyApproach", approach);

        return "new-approach";

    }

    @GetMapping("/delete")
    public String deleteApproach(@RequestParam("id") int id, Model model) {

        therapyApproachService.deleteApproachById(id);

        return "redirect:/approach";

    }

}
