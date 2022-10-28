package com.arkance.note.domain;

import com.arkance.note.utils.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {

    public Student(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "student" )//, cascade = CascadeType.PERSIST)
    private List<Note> notes;

    public void addNote(Note note){
        if(this.getNotes() == null){
            notes = new ArrayList<>();
        }
        notes.add(note);
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }
}
