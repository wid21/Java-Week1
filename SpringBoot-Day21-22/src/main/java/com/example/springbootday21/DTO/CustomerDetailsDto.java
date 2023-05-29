package com.example.springbootday21.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerDetailsDto {

    private Integer customer_id;
    private String gender;
    private Integer age;
    private String email;
}
