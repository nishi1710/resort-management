package com.example.resortmanagement.controller;

import com.example.resortmanagement.model.Booking;
import com.example.resortmanagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepo;

    @GetMapping("/book")
    public String showBookingForm(@RequestParam String resortName, Model model) {
        model.addAttribute("resortName", resortName);
        return "book_resort";
    }

    @PostMapping("/book")
public String submitBooking(@ModelAttribute Booking booking, Model model) {
    bookingRepo.save(booking);
    return "redirect:/my_bookings?email=" + booking.getEmail(); // or use username
}

}
