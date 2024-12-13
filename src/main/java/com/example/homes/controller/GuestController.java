package com.example.homes.controller;

import com.example.homes.model.BookingDetails;
import com.example.homes.model.Hotel;
import com.example.homes.service.BookingService;
import com.example.homes.service.EmailService;
import com.example.homes.service.HotelService;
import com.example.homes.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    // Modified method to handle hotel search
    @GetMapping
    public String viewHotels(@RequestParam(value = "searchQuery", required = false) String searchQuery, Model model) {
        List<Hotel> hotels = hotelService.findAllHotels();

        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            hotels = hotels.stream()
                    .filter(hotel -> hotel.getName().toLowerCase().contains(searchQuery.toLowerCase()))
                    .collect(Collectors.toList());
        }

        List<Hotel> hotelsWithEncodedImages = hotels.stream().map(hotel -> {
            if (hotel.getImages() != null && !hotel.getImages().isEmpty()) {
                List<String> base64Images = hotel.getImages().stream()
                        .map(imagePath -> {
                            try {
                                Path path = Paths.get("src/main/resources/static/" + imagePath);
                                if (Files.exists(path)) {
                                    byte[] imageBytes = Files.readAllBytes(path);
                                    return Base64.encodeBase64String(imageBytes);
                                } else {
                                    return encodeDefaultImage();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                return encodeDefaultImage();
                            }
                        })
                        .filter(base64 -> base64 != null)
                        .collect(Collectors.toList());
                hotel.setBase64Images(base64Images);
            }
            return hotel;
        }).collect(Collectors.toList());

        model.addAttribute("hotels", hotelsWithEncodedImages);
        if (hotelsWithEncodedImages.isEmpty()) {
            model.addAttribute("errorMessage", "No hotels are available at the moment.");
        }
        model.addAttribute("searchQuery", searchQuery);

        return "guest"; // Correct path to guest.html in templates/
    }

    private String encodeDefaultImage() {
        try {
            Path defaultImagePath = Paths.get("src/main/resources/static/images/default.jpg");
            byte[] imageBytes = Files.readAllBytes(defaultImagePath);
            return Base64.encodeBase64String(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Show Booking Form for a specific hotel
    @GetMapping("/booking/form/{hotelId}")
    public String bookHotelForm(@PathVariable Long hotelId, Model model, Principal principal) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        if (hotel == null) {
            model.addAttribute("errorMessage", "Hotel not found.");
            return "error";
        }
        model.addAttribute("hotel", hotel);
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("guestName", username);
        }
        return "booking-details"; // Correct path to booking-details.html in templates/
    }

    // Consolidated method for booking form (GET method)
    @GetMapping("/booking/form")
    public String showBookingForm(
            @RequestParam("hotelId") Long hotelId,
            @RequestParam(value = "totalPrice", defaultValue = "0.0") Double totalPrice,
            @RequestParam(value = "roomCounts", required = false) String roomCountsJson,
            @RequestParam(value = "days", defaultValue = "0") Integer days,
            Model model) {
        System.out.println("hotelId: " + hotelId);
        System.out.println("totalPrice: " + totalPrice);
        System.out.println("roomCountsJson: " + roomCountsJson);
        System.out.println("days: " + days);

        Map<String, Integer> roomCounts = null;
        if (roomCountsJson != null && !roomCountsJson.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                roomCounts = objectMapper.readValue(roomCountsJson, new TypeReference<Map<String, Integer>>() {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Hotel hotel = hotelService.findHotelById(hotelId);
        if (hotel == null) {
            model.addAttribute("errorMessage", "Hotel not found.");
            return "error";
        }

        model.addAttribute("hotel", hotel);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("roomCounts", roomCounts);
        model.addAttribute("days", days);

        return "booking-form"; // Ensure this matches the template name
    }


    // Confirmation Page (after successful booking)
    @GetMapping("/confirmation")
    public String bookingConfirmation() {
        return "booking-confirmation-success"; // Correct path to booking-confirmation-success.html in templates/
    }

    // Error handling method (if anything fails)
    /*@GetMapping("/error")
    public String handleError(Model model) {
        model.addAttribute("errorMessage", "An unexpected error occurred. Please try again later.");
        return "error"; // Return a custom error page
    }*/

    @PostMapping("/confirm-booking")
    public String confirmBooking(
            @RequestParam("hotelId") Long hotelId,
            @RequestParam("guestFullName") String guestFullName,
            @RequestParam("guestNID") String guestNID,
            @RequestParam("guestContactNumber") String guestContactNumber,
            @RequestParam("guestEmail") String guestEmail,
            @RequestParam("paymentMethod") String paymentMethod,
            @RequestParam("totalPrice") Double totalPrice,
            @RequestParam("days") Integer days,
            @RequestParam("roomCounts") String roomCountsJson) {

        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setHotelId(hotelId);
        bookingDetails.setGuestFullName(guestFullName);
        bookingDetails.setGuestNID(guestNID);
        bookingDetails.setGuestContactNumber(guestContactNumber);
        bookingDetails.setGuestEmail(guestEmail);
        bookingDetails.setPaymentMethod(paymentMethod);
        bookingDetails.setTotalPrice(totalPrice);
        bookingDetails.setDays(days);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Integer> roomCounts = objectMapper.readValue(roomCountsJson, new TypeReference<Map<String, Integer>>() {
            });
            bookingDetails.setRoomCounts(roomCounts);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bookingService.saveBookingDetails(bookingDetails);


        // Send email
        Hotel hotel = hotelService.findHotelById(hotelId);
        String subject = "Booking Confirmation";
        String text = String.format("Dear %s,\n\nYour booking has been confirmed.\n\nDetails:\nHotel: %s\nContact: %s\nNID: %s\nTotal Price: %.2f\nPayment Method: %s\nDays: %d\n\nThank you for booking with us!",
                guestFullName, hotel.getName(), guestContactNumber, guestNID, totalPrice, paymentMethod, days);
        emailService.sendBookingConfirmation(guestEmail, subject, text);

        if ("cash".equals(paymentMethod)) {
            return "redirect:/guest/congratulations";
        } else if ("credit_card".equals(paymentMethod)) {
            return "redirect:/guest/card?hotelId=" + hotelId + "&totalPrice=" + totalPrice;
        } else {
            return "redirect:/guest/error";
        }
    }

    @GetMapping("/congratulations")
    public String congratulations() {
        return "congratulations"; // Correct path to congratulations.html in templates/
    }

    @GetMapping("/card")
    public String card(@RequestParam("hotelId") Long hotelId,
                       @RequestParam(value = "totalPrice", defaultValue = "0.0") Double totalPrice,
                       Model model) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        if (hotel == null) {
            model.addAttribute("errorMessage", "Hotel not found.");
            return "error";
        }

        model.addAttribute("hotel", hotel);
        model.addAttribute("totalPrice", totalPrice);
        return "card"; // Correct path to card.html in templates/
    }

    @PostMapping("/confirm-payment")
    public String confirmPayment(Principal principal, Model model) {

        return "redirect:/guest/congratulations";
    }


}