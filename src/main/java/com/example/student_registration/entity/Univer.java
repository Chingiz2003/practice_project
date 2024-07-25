package com.example.student_registration.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Univer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String country;
    private String city;
    private String address;

    @ManyToMany
    @JoinTable(
            name = "student_univer",
            joinColumns = @JoinColumn(name = "univer_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
}
