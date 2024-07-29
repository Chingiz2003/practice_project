package com.example.student_registration.service;

import com.example.student_registration.DTO.StudentDto;
import com.example.student_registration.entity.Student;
import com.example.student_registration.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
    List<StudentDto> students = new ArrayList<>();

    private final StudentRepository studentRepository;

    public List<StudentDto> getStudents() {
        List<Student> student = studentRepository.findAll();
        return StudentDto.createListStudentDto(student);
    }

    public StudentDto getStudent(Long id){
        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found with id "+id));
        return  StudentDto.createStudent(student);
    }

    public void addStudent(StudentDto studentDto) {
        Student student = new Student();
        studentRepository.save(student);
    }

    public void updateStudent(Long id, StudentDto updatedStudentDto) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setFirstName(updatedStudentDto.getFirstName());
            student.setLastName(updatedStudentDto.getLastName());
            student.setIin(updatedStudentDto.getIin());
            student.setDateOfBirth(updatedStudentDto.getDateOfBirth());
            student.setEmail(updatedStudentDto.getEmail());
            studentRepository.save(student);
        }
    }
}
