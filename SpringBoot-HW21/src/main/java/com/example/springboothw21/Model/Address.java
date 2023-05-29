package com.example.springboothw21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Address {
    @Id
    private Integer id ;
    private String area;
    private String street;
    private int buildingNumber;


    @OneToOne
    @JsonIgnore
    @MapsId
    private Teacher teacher;
}
