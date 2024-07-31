package com.example.student_registration.controller;

import com.example.student_registration.DTO.UniverDto;
import com.example.student_registration.entity.Univer;
import com.example.student_registration.service.UniverService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/univer")
public class UniverController {

    public final UniverService univerService;

    @GetMapping("/univerAll")
    @Operation(summary = "Получение всех университетов")
    public ResponseEntity<List<UniverDto>> univers(){
        List<UniverDto> listUniver = univerService.getUnivers();
        return ResponseEntity.ok(listUniver);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Получение универа по id")
    public ResponseEntity<UniverDto> univerInfo(@PathVariable Long id){
        UniverDto univer = univerService.getUniver(id);
        return ResponseEntity.ok(univer);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменение информации университета")
    public ResponseEntity<UniverDto> updateUniver(@PathVariable Long id, @RequestBody UniverDto univerDto){
        univerService.updateUniver(id, univerDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paged")
    @Operation(summary = "Пагинация универов")
    public ResponseEntity<Page<UniverDto>> universPage(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "2") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<UniverDto> univerPage = univerService.getUniversPage(pageable);
        return ResponseEntity.ok(univerPage);

    }

    @GetMapping("/filter")
    @Operation(summary = "Фильтр по городам")
    public ResponseEntity<Page<UniverDto>> UniverByCityPase(@RequestParam String city,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "2") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<UniverDto> citiesPage = univerService.getUniversCity(city, pageable);
        return ResponseEntity.ok(citiesPage);
    }

}
