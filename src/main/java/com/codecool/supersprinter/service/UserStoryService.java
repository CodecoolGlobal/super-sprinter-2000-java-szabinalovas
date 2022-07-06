package com.codecool.supersprinter.service;

import com.codecool.supersprinter.model.UserStory;
import com.codecool.supersprinter.repositroy.UserStoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStoryService {

    private final UserStoryRepository repository;

    public UserStoryService(UserStoryRepository repository) {
        this.repository = repository;
    }

    public UserStory save(UserStory userStory) {
        return repository.save(userStory);
    }

    public List<UserStory> findAll() {
        return repository.findAll();
    }

    public UserStory findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }
}
