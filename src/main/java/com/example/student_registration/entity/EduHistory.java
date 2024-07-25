package com.example.student_registration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EduHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
