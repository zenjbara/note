package com.arkance.note.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Class {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="level_name", length=50, nullable=false)
    private String levelName;

    @OneToMany(mappedBy="classRoom")
    List<Student> students;
}
