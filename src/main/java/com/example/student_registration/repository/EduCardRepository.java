package com.example.student_registration.repository;

import com.example.student_registration.entity.EduCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EduCardRepository extends JpaRepository<EduCard, Long> {
    Optional<EduCard> findByStudentIdAndEndDateIsNull(Long studentId);
}
