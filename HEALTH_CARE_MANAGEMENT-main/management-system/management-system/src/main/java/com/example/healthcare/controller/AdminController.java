package com.example.healthcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AdminController {

    @GetMapping("/{admin}")
    public String adminDashboard() {
        return "Admin";  // Return the admin dashboard page
    }
}
