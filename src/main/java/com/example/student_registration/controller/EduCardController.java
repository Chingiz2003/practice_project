package com.example.student_registration.controller;

import com.example.student_registration.DTO.EduCardDto;
import com.example.student_registration.entity.EduCard;
import com.example.student_registration.service.EduCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/edu/")
@RequiredArgsConstructor
@Tag(name = "EduCard Api")
public class EduCardController {

    private final EduCardService eduCardService;

    @GetMapping("/{id}")
    @Operation(summary = "Получение карточки студента по id")
    public ResponseEntity<EduCardDto> eduCardInfo(@PathVariable Long id){
        EduCardDto eduCardDto = eduCardService.getEduCardById(id);
        return ResponseEntity.ok(eduCardDto);
    }

    @PostMapping("/enroll")
    @Operation(summary = "Поступление в универ")
    public ResponseEntity<Void> enroll(@RequestParam Long studentId,
                                 @RequestParam Long univerId,
                                 @RequestParam LocalDate startDate) {
        eduCardService.enrollStudent(studentId, univerId, startDate);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/withdraw")
    @Operation(summary = "исключение из универа")
    public ResponseEntity<Void> withdraw(@RequestParam Long studentId,
                                         @RequestParam LocalDate endDate) {
        eduCardService.withdrawStudent(studentId, endDate);
        return ResponseEntity.ok().build();
    }
}
