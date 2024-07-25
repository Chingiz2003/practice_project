package com.example.student_registration.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UniverDto {
    private Long id;
    private String name;
    private String country;
    private String city;
    private String address;
}
