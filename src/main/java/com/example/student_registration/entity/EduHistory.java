package com.example.student_registration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "edu_history")
public class EduHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
