package com.example.student_registration.repository;

import com.example.student_registration.entity.Univer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniverRepository extends JpaRepository<Univer, Long> {

}
