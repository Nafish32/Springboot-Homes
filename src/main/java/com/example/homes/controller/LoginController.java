package com.example.homes.controller;

import com.example.homes.model.Hotel;
import com.example.homes.model.User;
import com.example.homes.service.HotelService;
import com.example.homes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private HotelService hotelService;

    // Landing Page
    @GetMapping("/")
    public String startPage(Model model) {
        // Fetch hotels from the database
        List<Hotel> hotels = hotelService.findAllHotels();

        // Add hotels to the model to be passed to start.html
        model.addAttribute("hotels", hotels);

        return "start";  // This will render start.html
    }

    // Home Page for Hotel
    @GetMapping("/home")
    public String homePage(Model model) {
        // Example: Fetch hotel-related data if needed
        List<Hotel> hotels = hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "home"; // Render home.html
    }

    // Login Page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Handle Login Form Submission
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                return "redirect:/admin/welcome"; // Redirect to Admin Welcome Page
            } else if ("GUEST".equalsIgnoreCase(user.getRole())) {
                return "redirect:/guest"; // Redirect to Guest Page
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "login"; // Return to login page with error message
    }

    // Registration Page
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // Handle Registration Form Submission
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String role, @RequestParam(required = false) String adminKey, Model model) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            userService.saveUser(user, adminKey);  // This will validate the admin key
            return "redirect:/register?success=true";  // Redirect with success message
        } catch (IllegalArgumentException e) {
            return "redirect:/register?error=true";  // Redirect with error message
        }
    }

    // Handle Logout
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/"; // Redirect to home page after logout
    }
}
