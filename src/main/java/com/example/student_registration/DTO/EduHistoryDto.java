package com.example.student_registration.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EduHistoryDto {
    private int id;
    private EduCardDto eduCardId;
    private StudentDto studentId;
    private UniverDto univerId;
}
