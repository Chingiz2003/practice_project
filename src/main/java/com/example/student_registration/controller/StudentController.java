package com.example.student_registration.controller;

import com.example.student_registration.DTO.StudentDto;
import com.example.student_registration.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {

    public final StudentService studentService;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "student/student-main";
    }

    @GetMapping("student/{id}")
    public String studentInfo(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentsByID(id));
        return "student/student-info";
    }

    @PostMapping("student/create")
    public String createStudent(StudentDto student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @PostMapping("student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }

    @GetMapping("/student/student/update/{id}")
    public String updateStudentForm(@PathVariable Long id, Model model) {
        StudentDto student = studentService.getStudentsByID(id);
        model.addAttribute("student", student);
        return "student/student-update";
    }

    @PostMapping("/student/student/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute StudentDto student) {
        studentService.updateStudent(id, student);
        return "redirect:/";
    }
}
