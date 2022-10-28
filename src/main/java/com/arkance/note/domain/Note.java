package com.arkance.note.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Note {


    public Note(Student student, Subject subject, Double result) {
        this.student = student;
        this.subject = subject;
        this.result = result;
    }

    @EmbeddedId
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private NoteKey id = new NoteKey();

    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    private Double result;
}
