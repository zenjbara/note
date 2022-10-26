package com.arkance.note.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Class {

    public Class(String levelName, Teacher teacher) {
        this.levelName = levelName;
        this.teacher = teacher;
    }


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="level_name", length=50, nullable=false)
    private String levelName;

    @OneToMany(mappedBy="classRoom")
    List<Student> students;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


}
