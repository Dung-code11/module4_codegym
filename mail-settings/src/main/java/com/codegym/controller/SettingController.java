package com.codegym.mailsettings.controller;

import com.codegym.mailsettings.model.MailSettings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SettingsController {

    private MailSettings currentSettings = new MailSettings();

    public SettingsController() {
        // Khởi tạo giá trị mặc định
        currentSettings.setLanguage("English");
        currentSettings.setPageSize(25);
        currentSettings.setEnableSpamFilter(false);
        currentSettings.setSignature("Thor\nKing, Asgard");
    }

    @GetMapping("/settings")
    public String showSettings(Model model) {
        model.addAttribute("settings", currentSettings);
        return "settings";
    }

    @PostMapping("/settings")
    public String updateSettings(@ModelAttribute MailSettings settings, Model model) {
        this.currentSettings = settings;
        model.addAttribute("settings", currentSettings);
        model.addAttribute("message", "Settings updated successfully!");
        return "settings";
    }
}
