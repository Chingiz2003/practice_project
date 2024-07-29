package com.example.student_registration.DTO;

import com.example.student_registration.entity.EduCard;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class EduCardDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    public static EduCardDto createEduCard(EduCard eduCard){
        return new EduCardDto(
                eduCard.getId(),
                eduCard.getStartDate(),
                eduCard.getEndDate()
        );
    }

    public static List<EduCardDto> createEduCardList(List<EduCard> eduCardList){
        return eduCardList.stream().map(EduCardDto::createEduCard).collect(Collectors.toList());
    }
}
