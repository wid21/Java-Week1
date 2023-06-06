package com.example.springboothw28.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "quantity cannot be null")
    @Column(columnDefinition = "int not null")
    private  int quantity;

    @Column(columnDefinition = "date")
    private Date date;

    @NotEmpty(message = "status should not be empty")
    @Column(columnDefinition = "varchar(25) not null check (status='new' or status='inProgress' or status='completed')")
    private String status;

    @NotNull(message = "total Price should not  be null")
    @Column(columnDefinition = "double not null")
    private double totalPrice;


    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @JsonIgnore
    private User user;


    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;
  }
