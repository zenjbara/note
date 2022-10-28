package com.arkance.note.utils;


import com.arkance.note.Repository.ClassRepository;
import com.arkance.note.Repository.NoteRepository;
import com.arkance.note.Repository.StudentRepository;
import com.arkance.note.Repository.SubjectRepository;
import com.arkance.note.domain.*;
import com.arkance.note.domain.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private  ClassRepository classRepository;

    private StudentRepository studentRepository;

    private NoteRepository noteRepository;

    private SubjectRepository subjectRepository;


    @Autowired
    public ApplicationRunner(ClassRepository classRepository, StudentRepository studentRepository, NoteRepository noteRepository, SubjectRepository subjectRepository) {
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
        this.noteRepository = noteRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Teacher teacherAdam = new Teacher("Adam" , "Benjbara" , Gender.MALE);
        Teacher teacherAymane = new Teacher("Aymane" , "Benjbara" , Gender.MALE);

        Student studentDavid = new Student("David", "Coen", Gender.MALE);
        Student studentPolly = new Student("Polly", "Gray", Gender.FEMALE);

        Class class1 = new Class("Cinquième" , teacherAdam);
       // class1.setStudents(Arrays.asList(studentDavid,studentPolly));
        Class class2 = new Class("Baccalaureat" , teacherAymane);

        Subject subjectSVT = new Subject("SVT");
        Note note1 = new Note(studentDavid, subjectSVT, 12.5);
        Note note2 = new Note(studentPolly, subjectSVT, 18.0);

        studentDavid.setClassRoom(class1);
        studentPolly.setClassRoom(class1);

        //studentDavid.addNote(note1);
        //studentDavid.addNote(note2);

        classRepository.save(class1);
        classRepository.save(class2);

        subjectRepository.save(subjectSVT);

        studentRepository.save(studentDavid);
        studentRepository.save(studentPolly);

        noteRepository.save(note1);
        noteRepository.save(note2);


    }
}
