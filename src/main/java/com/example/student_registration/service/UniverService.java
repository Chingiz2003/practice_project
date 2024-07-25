package com.example.student_registration.service;

import com.example.student_registration.DTO.UniverDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniverService {

    List<UniverDto> univers = new ArrayList<>();
    private long ID = 0;

    {
        univers.add(new UniverDto(ID++, "KarTU", "Kazakhstan", "Karaganda", "Bulvar mira 56"));
        univers.add(new UniverDto(ID++, "Astana IT", "Kazakhstan", "Astana", "Mangilik El"));
    }

    public List<UniverDto> getUnivers() {
        return univers;
    }

    public void addUniver(UniverDto univerDto) {
        univerDto.setId(ID++);
        univers.add(univerDto);
    }

    public void deleteUniver(Long id) {
        univers.removeIf(univerDto1 -> univerDto1.getId().equals(id));
    }

    public UniverDto getUniverById(Long id) {
        for (UniverDto univerDto : univers) {
            if(univerDto.getId().equals(id)) return univerDto;
        }
        return null;
    }

    public void updateUniver(Long id, UniverDto updatedUniver) {
        for (UniverDto univerDto : univers) {
            if(univerDto.getId().equals(id)){
                univerDto.setName(updatedUniver.getName());
                univerDto.setCountry(updatedUniver.getCountry());
                univerDto.setCity(updatedUniver.getCity());
                univerDto.setAddress(updatedUniver.getAddress());
                break;
            }
        }
    }
}
