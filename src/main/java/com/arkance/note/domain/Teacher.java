package com.arkance.note.domain;

import com.arkance.note.utils.Gender;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="first_name", length=50, nullable=false)
    private String firstName;

    @Column(name="last_name", length=50, nullable=false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name="class_id", nullable=false)
    private Class classRoom;

    @OneToOne(mappedBy = "teacher", cascade = CascadeType.REFRESH)
    @PrimaryKeyJoinColumn
    private Subject subject;
}
