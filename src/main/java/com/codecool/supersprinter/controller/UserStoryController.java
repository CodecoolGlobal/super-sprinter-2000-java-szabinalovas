package com.codecool.supersprinter.controller;

import com.codecool.supersprinter.model.UserStory;
import com.codecool.supersprinter.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserStoryController {

    private final UserStoryService service;

    public UserStoryController(UserStoryService service) {
        this.service = service;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("userStories", service.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddNewStoryForm(@ModelAttribute("userStory") UserStory userStory) {
        return "story";
    }

    @PostMapping("/story")
    public String save(@ModelAttribute("userStory") UserStory userStory, Model model) {
        model.addAttribute("userStory", service.save(userStory));
        return "redirect:/";
    }

    @GetMapping("/story/{id}")
    public String findById(@PathVariable("id") Long id) {
        service.findById(id);
        return "redirect:/index";
    }

    @PutMapping("/update/{id}")
    public UserStory update(@PathVariable("id") Long id, @RequestBody UserStory userStory) {
        return service.update(id, userStory);
    }
}
