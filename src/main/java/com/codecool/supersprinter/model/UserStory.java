package com.codecool.supersprinter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 100, message = "Story Title length should remain between 5 and 100 characters")
    private String storyTitle;
    @Size(min = 5, max = 400, message = "Users Story length should remain between 5 and 400 characters")
    private String usersStory;
    @Size(min = 5, max = 400, message = "Acceptance criteria length should remain between 5 and 400 characters")
    private String acceptanceCriteria;
    private int businessValue;
    @DecimalMin("0.5")
    @DecimalMax("8.0")
    private double estimation;
    @NotBlank(message = "Status must not be empty")
    private String status;
}
