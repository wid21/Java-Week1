package com.example.springboothw21.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DtoAddress {

    private Integer teacher_id;
    private String area;
    private String street;
    private int buildingNumber;

}
