package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final StudentService studentService;

    // Constructor Injection
    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Home page listing all students
     */
    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "welcomenew"; // Thymeleaf: welcomenew.html
    }

    /**
     * Admin login page
     */
    @GetMapping("/admin/login")
    public String showAdminLogin() {
        return "admin-login"; // Thymeleaf: admin-login.html
    }

    /**
     * Admin dashboard displaying student list
     */
    @GetMapping("/admin/dashboard")
    public String showAdminDashboard(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; // Thymeleaf: students.html
    }
    
}
