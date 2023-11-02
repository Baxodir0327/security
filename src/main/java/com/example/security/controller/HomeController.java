package com.example.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String hi() {
        return "HELLO";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "admin page";
    }


    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping("/manager")
    public String manager() {
        return "manager page";
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/all")
    public String all() {
        return "all page";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user")
    public String user() {
        return "user page";
    }
}
