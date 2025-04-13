package com.example.resortmanagement.controller;

import com.example.resortmanagement.model.Resort;
import com.example.resortmanagement.repository.ResortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ResortController {

    @Autowired
    private ResortRepository resortRepo;

    @GetMapping("/")
    public String listResorts(Model model) {
        model.addAttribute("resorts", resortRepo.findAll());
        return "resorts";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("resort", new Resort());
        return "add_resorts";
    }

    @PostMapping("/save")
    public String saveResort(@ModelAttribute Resort resort) {
        resortRepo.save(resort);
        return "redirect:/";
    }
}
