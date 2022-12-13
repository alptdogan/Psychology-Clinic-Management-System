package com.alpdogan.PsychologyClinic.controller;

import com.alpdogan.PsychologyClinic.entity.Modality;
import com.alpdogan.PsychologyClinic.service.ModalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/modality")
public class ModalityController {

    @Autowired
    private ModalityService modalityService;

    @GetMapping
    public String displayApproaches(Model model) {

        List<Modality> modalities = modalityService.getAllModalities();
        model.addAttribute("modality", modalities);

        return "list-modalities";

    }

    @GetMapping("/new")
    public String displayApproachForm(Model model) {

        Modality modality = new Modality();
        model.addAttribute("modality", modality);

        return "new-modality";

    }

    @PostMapping("/addModality")
    public String createModality(@ModelAttribute("modality") Modality modality) {

        modalityService.createModality(modality);

        return "redirect:/modality";

    }

    @GetMapping("/update")
    public String displayModalityUpdateForm(@RequestParam("id") int id, Model model) {

        Modality modality = modalityService.getModalityById(id);
        model.addAttribute("modality", modality);

        return "new-modality";

    }

    @GetMapping("/delete")
    public String deleteModality(@RequestParam("id") int id, Model model) {

        modalityService.deleteModalityById(id);

        return "redirect:/modality";

    }

}
