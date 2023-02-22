package com.example.learningspring.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Taco {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    private List<Ingredient> ingredients;
}
