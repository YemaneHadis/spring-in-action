package com.example.learningspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.reflect.Type;

@Data
@Entity
@NoArgsConstructor
public class Ingredient implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
//    private Type type;
}