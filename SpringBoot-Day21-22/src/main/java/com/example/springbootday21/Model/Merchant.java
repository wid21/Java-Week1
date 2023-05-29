package com.example.springbootday21.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

   @OneToMany(cascade = CascadeType.ALL,mappedBy = "merchant")
    private Set<Branch> branchSet;
}
