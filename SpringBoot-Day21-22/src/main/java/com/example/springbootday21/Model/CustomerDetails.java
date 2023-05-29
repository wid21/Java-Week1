package com.example.springbootday21.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class CustomerDetails {

    @Id
    private Integer id;
    private String gender;
    private int age;
    private String email;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customer;
}