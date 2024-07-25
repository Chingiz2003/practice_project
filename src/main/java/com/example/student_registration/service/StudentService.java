package com.example.student_registration.service;

import com.example.student_registration.DTO.StudentDto;
import com.example.student_registration.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
    List<StudentDto> students = new ArrayList<>();
    private long ID = 0;

    private final StudentRepository studentRepository;

//    {
//        students.add(new StudentDto(
//                ID++,
//                "Chingiz",
//                "Shalbayev",
//                "030303441777",
//                LocalDate.of(2003, 07, 03),
//                "china@gmail.com"));
//
//        students.add(new StudentDto(
//                ID++,
//                "Azamat",
//                "Dauletov",
//                "070601661888",
//                LocalDate.of(2005, 04, 01),
//                "aza@gmail.com"));
//    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void addStudent(StudentDto student) {
        student.setId(++ID);
        students.add(student);
    }

    public void deleteStudent(Long id) {
        students.removeIf(student1 -> student1.getId().equals(id));
    }

    public StudentDto getStudentsByID(Long id) {
        for(StudentDto student : students) {
            if(student.getId().equals(id)) return student;
        }
        return null;
    }

    public void updateStudent(Long id, StudentDto updatedStudent) {
        for(StudentDto student : students) {
            if(student.getId().equals(id)) {
                student.setFirstName(updatedStudent.getFirstName());
                student.setLastName(updatedStudent.getLastName());
                student.setIin(updatedStudent.getIin());
                student.setDateOfBirth(updatedStudent.getDateOfBirth());
                student.setEmail(updatedStudent.getEmail());
                break;
            }
        }
    }
}
