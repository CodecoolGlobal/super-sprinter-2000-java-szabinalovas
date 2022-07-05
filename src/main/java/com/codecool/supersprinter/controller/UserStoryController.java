package com.codecool.supersprinter.controller;

import com.codecool.supersprinter.model.UserStory;
import com.codecool.supersprinter.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserStoryController {

    private final UserStoryService service;

    public UserStoryController(UserStoryService service) {
        this.service = service;
    }

    @PostMapping
    public UserStory save(@RequestBody UserStory userStory) {
        return service.save(userStory);
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("userStories", service.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public UserStory findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public UserStory update(@PathVariable("id") Long id, @RequestBody UserStory userStory) {
        return service.update(id, userStory);
    }
}
