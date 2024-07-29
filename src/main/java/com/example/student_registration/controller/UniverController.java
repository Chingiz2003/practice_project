package com.example.student_registration.controller;

import com.example.student_registration.DTO.UniverDto;
import com.example.student_registration.service.UniverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/univer")
public class UniverController {

    public final UniverService univerService;

    @GetMapping("/univerAll")
    public ResponseEntity<List<UniverDto>> univers(){
        List<UniverDto> listUniver = univerService.getUnivers();
        return ResponseEntity.ok(listUniver);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniverDto> univerInfo(@PathVariable Long id){
        UniverDto univer = univerService.getUniver(id);
        return ResponseEntity.ok(univer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniverDto> updateUniver(@PathVariable Long id, @RequestBody UniverDto univerDto){
        univerService.updateUniver(id, univerDto);
        return ResponseEntity.ok().build();
    }
}
