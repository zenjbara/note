package com.arkance.note.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Subject {

    public Subject(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="last_name", length=50, nullable=false)
    private String name;

  /**  @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;*/

    @OneToMany(mappedBy = "subject")
    private List<Note> notes;
}
