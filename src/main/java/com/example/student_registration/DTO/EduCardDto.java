package com.example.student_registration.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EduCardDto {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private StudentDto studentId;
    private Long univerId;
}
