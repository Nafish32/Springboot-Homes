    package com.example.homes.controller;

    import com.example.homes.model.Booking;
    import com.example.homes.model.Hotel;
    import com.example.homes.model.User;
    import com.example.homes.repository.HotelRepository;
    import com.example.homes.service.BookingService;
    import com.example.homes.service.HotelService;
    import com.example.homes.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;
    import org.springframework.web.servlet.mvc.support.RedirectAttributes;

    import java.io.File;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.util.ArrayList;
    import java.util.List;

    @Controller
    @RequestMapping("/admin")
    public class AdminController {

        @Autowired
        private UserService userService;

        @Autowired
        private HotelService hotelService;

        @Autowired
        private HotelRepository hotelRepository;

        // Welcome Page (default view for Admin)
        @GetMapping("/welcome")
        public String welcome(Model model) {
            model.addAttribute("admin", "Admin");
            model.addAttribute("section", "welcome");
            return "admin"; // Loads the admin.html page with the welcome section
        }

        // View Registered Users
        @GetMapping("/users")
        public String listUsers(Model model) {
            List<User> users = userService.findAllUsers();
            model.addAttribute("users", users);
            model.addAttribute("section", "user");
            return "admin"; // Loads the admin.html page with the users section
        }

        // Add New Hotel Form
        @GetMapping("/add-hotel")
        public String addHotelForm(Model model) {
            model.addAttribute("hotel", new Hotel());  // Create an empty hotel object for form binding
            model.addAttribute("section", "addHotel");
            return "admin"; // Loads the admin.html page with the add-hotel form section
        }



        @PostMapping("/add-hotel")
        public String addHotel(@ModelAttribute Hotel hotel,
                               @RequestParam("hotelImages") List<MultipartFile> hotelImages,
                               RedirectAttributes redirectAttributes) throws IOException {
            // Ensure the upload directory exists
            String uploadDir = "uploads/";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();  // Create the uploads directory if it doesn't exist
            }

            // Ensure the upload path exists
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);  // Creates the uploads directory if it doesn't exist
            }

            // Handle file uploads
            if (!hotelImages.isEmpty()) {
                List<String> imagePaths = new ArrayList<>();
                for (MultipartFile file : hotelImages) {
                    // Get the original file name
                    String fileName = file.getOriginalFilename();

                    // Create a path for the file to be stored
                    Path filePath = uploadPath.resolve(fileName);

                    // Save the file to the upload directory
                    file.transferTo(filePath);

                    // Add the file path to the list
                    imagePaths.add(filePath.toString());
                }

                // Set the images field of the hotel object
                hotel.setImages(imagePaths);
            }

            // Save the hotel object (including the image paths) to the database
            hotelService.saveHotel(hotel);

            // Redirect with success message
            redirectAttributes.addFlashAttribute("message", "Hotel added successfully!");
            return "redirect:/admin/welcome";  // Redirect to the admin welcome page or appropriate page
        }



        // Delete User by ID
        @PostMapping("/delete/{id}")
        public String deleteUser(@PathVariable Long id) {
            userService.deleteUserById(id);
            return "redirect:/admin/users"; // Redirect to the users list after deletion
        }

        // Handle Logout for Admin
        @GetMapping("/logout")
        public String logout() {
            return "redirect:/"; // Redirect to home page after logout
        }

        @Autowired
        private BookingService bookingService;

        // View All Bookings
        @GetMapping("/bookings")
        public String viewBookings(Model model) {
            List<Booking> bookings = bookingService.findAllBookings();
            model.addAttribute("bookings", bookings);
            return "admin-bookings"; // Loads admin-bookings.html page with booking details
        }
    }