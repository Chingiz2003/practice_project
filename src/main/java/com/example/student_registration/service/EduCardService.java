package com.example.student_registration.service;

import com.example.student_registration.DTO.EduCardDto;
import com.example.student_registration.entity.EduCard;
import com.example.student_registration.entity.Student;
import com.example.student_registration.entity.Univer;
import com.example.student_registration.repository.EduCardRepository;
import com.example.student_registration.repository.StudentRepository;
import com.example.student_registration.repository.UniverRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class EduCardService {

    private final EduCardRepository eduCardRepository;
    private final StudentService studentService;
    private final UniverService univerService;
    private final StudentRepository studentRepository;
    private final UniverRepository univerRepository;

    public EduCardDto getEduCardById(Long id) {
        EduCard eduCard = eduCardRepository.findById(id).orElseThrow(()-> new RuntimeException("EduCard with " + id + " not found"));
        return EduCardDto.createEduCard(eduCard);
    }

    public void enrollStudent(Long studentId, Long univerId, LocalDate startDate) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new RuntimeException("Student not found"));

        Univer univer = univerRepository.findById((univerId)).orElseThrow(() -> new RuntimeException("Univer not found"));

        EduCard eduCard = new EduCard();
        eduCard.setStudent(student);
        eduCard.setUniver(univer);
        eduCard.setStartDate(startDate);
        eduCard.setEndDate(null);

        eduCardRepository.save(eduCard);
    }

    public void withdrawStudent(Long studentId, LocalDate endDate) {
        EduCard eduCard = eduCardRepository.findByStudentIdAndEndDateIsNull(studentId).orElseThrow(()-> new RuntimeException("EduCard not found"));

        eduCard.setEndDate(endDate);
        eduCardRepository.save(eduCard);
    }


}
