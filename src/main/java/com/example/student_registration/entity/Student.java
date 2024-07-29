package com.example.student_registration.entity;


import com.example.student_registration.DTO.UniverDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable=false)
    private String firstName;

    @Column(name = "last_name", nullable=false)
    private String lastName;

    @Column(name = "iin", nullable=false)
    private String iin;

    @Column(name = "date_of_birth", nullable=false)
    private LocalDate dateOfBirth;

    @Column(name = "email", nullable=false)
    private String email;

//    @Column(name = "univer_id")
//    private Long univer_id;


    @ManyToOne
    @JoinColumn(name = "univer_id")
    private Univer univer;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<EduCard> eduCards;
}
