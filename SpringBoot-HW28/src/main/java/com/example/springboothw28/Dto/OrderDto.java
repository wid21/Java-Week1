package com.example.springboothw28.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {


    @NotNull(message = "quantity can not be null")
    private Integer quantity;

    private Integer productId;
}
