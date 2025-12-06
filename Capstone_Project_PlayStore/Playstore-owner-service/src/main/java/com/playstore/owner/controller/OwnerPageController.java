package com.playstore.owner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerPageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/owner/register")
    public String ownerRegisterPage() {
        return "register";
    }

    @GetMapping("/owner/login")
    public String ownerLoginPage() {
        return "login";
    }
    @GetMapping("/owner/apps")
    public String ownerAppsPage() {
        return "owner-apps";
    }
    @GetMapping("/owner/dashboard")
    public String ownerDashboard() {
        return "owner-dashboard";
    }

}
