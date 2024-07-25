package com.example.student_registration.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String iin;
    private LocalDate dateOfBirth;
    private String email;
    private Long univer_id;


//    public static StudentDto createStudent(StudentDto student){
//        return new StudentDto(
//                student.getId(),
//                student.getFirstName(),
//                student.getLastName(),
//                student.getIin(),
//                student.getDateOfBirth(),
//                student.getEmail()
//        );
//    }
}
