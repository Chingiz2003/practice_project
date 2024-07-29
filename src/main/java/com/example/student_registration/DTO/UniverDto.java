package com.example.student_registration.DTO;


import com.example.student_registration.entity.Univer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UniverDto {
    private Long id;
    private String name;
    private String country;
    private String city;
    private String address;

    public static UniverDto createUniver(Univer univer){
        return new UniverDto(
                univer.getId(),
                univer.getName(),
                univer.getCountry(),
                univer.getCity(),
                univer.getAddress()
        );
    }

    public static List<UniverDto> createListUniverDto(List<Univer> univerList){
        return univerList.stream().map(UniverDto::createUniver).collect(Collectors.toList());
    }
}
