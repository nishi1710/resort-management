package com.example.resortmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.resortmanagement.entity.User;
import com.example.resortmanagement.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        User user = userService.authenticate(email, password);

        if (user != null) {
            // Assign role if it's admin or manager
            if (email.equals("admin@example.com") && password.equals("admin123")) {
                user.setRole("ADMIN");
            } else if (email.equals("manager@example.com") && password.equals("manager123")) {
                user.setRole("MANAGER");
            }

            session.setAttribute("loggedInUser", user);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials. Don't have an account? <a href='/register'>Register here</a>");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        if (userService.emailExists(user.getEmail())) {
            model.addAttribute("error", "An account with this email already exists. Please log in.");
            return "register";
        }

        user.setRole("CUSTOMER");
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        model.addAttribute("user", user);

        return switch (user.getRole()) {
            case "ADMIN" -> "admin_dashboard";
            case "MANAGER" -> "manager_dashboard";
            default -> "customer_dashboard";
        };
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout"; // redirect to the login page with the 'logout' message
    }
}
