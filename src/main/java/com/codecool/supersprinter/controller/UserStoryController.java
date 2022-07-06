package com.codecool.supersprinter.controller;

import com.codecool.supersprinter.model.UserStory;
import com.codecool.supersprinter.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String save(@Valid @ModelAttribute("userStory") UserStory userStory, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "story";
        }
        model.addAttribute("userStory", service.save(userStory));
        return "redirect:/";
    }

    @GetMapping("/story/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        UserStory userStory = service.findById(id);
        model.addAttribute("userStory", userStory);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid@ModelAttribute("userStory") UserStory userStory, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "update";
        }
        service.save(userStory);
        return "redirect:/";
    }
}
