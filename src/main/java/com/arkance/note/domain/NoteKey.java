package com.arkance.note.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class NoteKey implements Serializable {
    @Column(name = "student_id")
    Long studentId;

    @Column(name = "subject_id")
    Long subjectId;
}
