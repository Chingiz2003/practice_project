package com.example.student_registration.controller;

import com.example.student_registration.DTO.StudentDto;
import com.example.student_registration.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
@Tag(name = "Student Api")
public class StudentController {

    public final StudentService studentService;

    @GetMapping("/studentAll")
    @Operation(summary = "Получение всех студентов")
    public ResponseEntity<List<StudentDto>> students() {
        List<StudentDto> listStudent = studentService.getStudents();
        return ResponseEntity.ok(listStudent);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение студента по id")
    public ResponseEntity<StudentDto> studentInfo(@PathVariable Long id) {
        StudentDto studentDto = studentService.getStudent(id);
        return ResponseEntity.ok(studentDto);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createStudent(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменение информации студениа")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok().build();
    }

}
