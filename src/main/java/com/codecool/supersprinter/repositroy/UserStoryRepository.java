package com.codecool.supersprinter.repositroy;

import com.codecool.supersprinter.model.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryRepository extends JpaRepository<UserStory, Long> {
}
