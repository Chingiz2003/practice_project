package com.example.student_registration.entity;


import com.example.student_registration.DTO.UniverDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "iin")
    private String iin;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "dateOfBirth")
    private String email;

//    @Column(name = "univer_id")
//    private Long univer_id;


    @ManyToMany(mappedBy = "students")
    private List<Univer> univers;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private EduCard eduCard;
}
