package com.arkance.note.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class NoteKey implements Serializable {

    @Column(name = "subject_id")
    Long subjectId;

    @Column(name = "student_id")
    Long studentId;
}
