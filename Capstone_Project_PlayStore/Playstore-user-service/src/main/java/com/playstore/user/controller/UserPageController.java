package com.playstore.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user/register")
    public String userRegisterPage() {
        return "user-register";
    }

    @GetMapping("/user/login")
    public String userLoginPage() {
        return "user-login";
    }
    
    @GetMapping("/user/dashboard")
    public String userDashboardPage() {
        return "user-dashboard";      
    }
    
    @GetMapping("/user/apps")
    public String appsPage() {
        return "user-apps";          
    }
    
    @GetMapping("/apps/{id}")
    public String appDetailsPage() {
        return "user-app-details";    
    }
}
