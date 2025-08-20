package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {

    private final PasswordEncoder passwordEncoder;
    private final StudentService studentService;

    public StudentController(StudentService studentService, PasswordEncoder passwordEncoder) {
        this.studentService = studentService;
        this.passwordEncoder = passwordEncoder;
    }

    // List all students
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    // Show create student form
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_student";
    }

    // Save new student
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        // Encode password before saving
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // Show edit form
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    // Update student
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setAddress(student.getAddress());

        if (student.getPassword() != null && !student.getPassword().isBlank()) {
            existingStudent.setPassword(passwordEncoder.encode(student.getPassword()));
        }

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    // Delete student (URL should be something like /students/delete/5)
    @PostMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id,Model model) {
    	model.addAttribute("student",studentService.getStudentById(id));
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
    
    //student login controller
    /**
     * Student login GET request to show login form
     */
    @GetMapping("/student/login")
    public String showStudentLoginForm() {
        return "student-login"; // Thymeleaf: student-login.html
    }

    /**
     * Student login POST request to validate credentials
     */
    @PostMapping("/student/login")
    public String handleStudentLogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {

        Student student = studentService.getStudentByEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


        if (student != null && encoder.matches(password, student.getPassword())) {
            model.addAttribute("student", student);
            return "student-dashboard"; // Thymeleaf: student-dashboard.html
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "student-login"; // back to login form
        }
    }
    
  //student signup controller
    @GetMapping("/student/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-signup"; // Thymeleaf template
    }
    
    @PostMapping("/student/signup")
    public String registerStudent(
            @ModelAttribute("student") Student student,
            @RequestParam("confirmPassword") String confirmPassword,
            RedirectAttributes redirectAttributes) {

        // 1. Password match validation
        if (!student.getPassword().equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("error", "Passwords do not match.");
            return "redirect:/student/signup";
        }

        // 2. Email uniqueness check
        if (studentService.existsByEmail(student.getEmail())) {
            redirectAttributes.addFlashAttribute("error", "Email is already registered.");
            return "redirect:/student/signup";
        }

        // 3. Encrypt password before saving
        student.setPassword(passwordEncoder.encode(student.getPassword()));

        // 4. Save student
        studentService.saveStudent(student);

        // 5. Success message and redirect
        redirectAttributes.addFlashAttribute("success", "Signup successful. Please login.");
        return "redirect:/student/login";
    }
}
