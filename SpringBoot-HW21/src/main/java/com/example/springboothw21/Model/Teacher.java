package com.example.springboothw21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @NotEmpty(message = "name should not be empty")
    private String name;
    @NotNull(message = "age should not be empty")
    private int age;
    @NotEmpty(message = "email should not be empty")
    private String email;
    private double salary;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany (cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> course;
}
