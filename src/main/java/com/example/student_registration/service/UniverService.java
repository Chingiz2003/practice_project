package com.example.student_registration.service;

import com.example.student_registration.DTO.UniverDto;
import com.example.student_registration.entity.Univer;
import com.example.student_registration.repository.UniverRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UniverService {

    List<UniverDto> univers = new ArrayList<>();
    private long ID = 0;

    private final UniverRepository univerRepository;

    public List<UniverDto> getUnivers() {
        List<Univer> univers = univerRepository.findAll();
        return UniverDto.createListUniverDto(univers);
    }

    public UniverDto getUniver(Long id) {
        Univer univer = univerRepository.findById(id).orElseThrow(()-> new RuntimeException("Univer not found with id: " + id));
        return UniverDto.createUniver(univer);
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

    public void updateUniver(Long id, UniverDto updatedUniverDto) {
        Optional<Univer> univerOptional = univerRepository.findById(id);
        if(univerOptional.isPresent()) {
            Univer univer = univerOptional.get();
            univer.setName(updatedUniverDto.getName());
            univer.setCountry(updatedUniverDto.getCountry());
            univer.setCity(updatedUniverDto.getCity());
            univer.setAddress(updatedUniverDto.getAddress());
            univerRepository.save(univer);
        }
    }

    public Page<UniverDto> getUniversPage(Pageable pageable){
        Page<Univer> univerPage = univerRepository.findAll(pageable);
        return univerPage.map(UniverDto::createUniver);
    }

    public Page<UniverDto> getUniversCity(String city, Pageable pageable){
        Page<Univer> univerPage = univerRepository.findByCity(city, pageable);
        return univerPage.map(UniverDto::createUniver);
    }
}
