package com.arkance.note.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="last_name", length=50, nullable=false)
    private String name;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id")
    private Class teacher;

    @OneToMany(mappedBy = "subject")
    private List<Note> notes;
}
