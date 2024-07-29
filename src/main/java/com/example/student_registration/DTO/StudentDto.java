package com.example.student_registration.DTO;

import com.example.student_registration.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data

@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String iin;
    private LocalDate dateOfBirth;
    private String email;

    public static StudentDto createStudent(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getIin(),
                student.getDateOfBirth(),
                student.getEmail()
        );
    }

    public static List<StudentDto> createListStudentDto(List<Student> studentList){
        return  studentList.stream()
                .map(StudentDto::createStudent)
                .collect(Collectors.toList());

    }


}
