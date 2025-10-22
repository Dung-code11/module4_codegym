package com.codegym.healthform.controller;

import com.codegym.healthform.model.HealthDeclaration;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class HealthFormController {

    private HealthDeclaration savedDeclaration = null;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("healthDeclaration", new HealthDeclaration());
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@Valid @ModelAttribute("healthDeclaration") HealthDeclaration declaration,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        this.savedDeclaration = declaration;
        return "redirect:/info";
    }

    @GetMapping("/info")
    public String showInfo(Model model) {
        if (savedDeclaration == null) {
            return "redirect:/form";
        }
        model.addAttribute("healthDeclaration", savedDeclaration);
        return "info";
    }

    @GetMapping("/edit")
    public String editInfo(Model model) {
        model.addAttribute("healthDeclaration", savedDeclaration);
        return "form";
    }
}
