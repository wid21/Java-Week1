package com.example.springbootday21.Model;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    @PrimaryKeyJoinColumn
    private CustomerDetails customerDetails;



}