package com.example.student_registration.repository;

import com.example.student_registration.DTO.EduHistoryDto;
import com.example.student_registration.entity.EduHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EduHistoryRepository extends JpaRepository<EduHistory, Long> {

}
