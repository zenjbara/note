package com.arkance.note.domain;

import com.arkance.note.utils.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Teacher {

    public Teacher(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="first_name", length=50, nullable=false)
    private String firstName;

    @Column(name="last_name", length=50, nullable=false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "teacher", cascade = CascadeType.REFRESH)
    @PrimaryKeyJoinColumn
    private Class classRoom;

    @OneToOne(mappedBy = "teacher", cascade = CascadeType.REFRESH)
    @PrimaryKeyJoinColumn
    private Subject subject;

    public String getFullName(){
        return firstName + " " + lastName;
    }
}
