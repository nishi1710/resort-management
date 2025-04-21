package com.example.resortmanagement.controller;

import com.example.resortmanagement.entity.User;
import com.example.resortmanagement.model.Booking;
import com.example.resortmanagement.repository.BookingRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepo;

    @GetMapping("/book")
public String showBookingForm(@RequestParam String resortName, Model model, HttpSession session) {
    User user = (User) session.getAttribute("loggedInUser");

    if (user == null) {
        return "redirect:/login";
    }

    model.addAttribute("email", user.getEmail());
    model.addAttribute("resortName", resortName);

    return "book_resort";
}

    @PostMapping("/book")
public String submitBooking(@ModelAttribute Booking booking, Model model) {
    bookingRepo.save(booking);
    return "redirect:/my_bookings?email=" + booking.getEmail(); // or use username
}

}
