package com.arkance.note.utils;


import com.arkance.note.Repository.ClassRepository;
import com.arkance.note.Repository.StudentRepository;
import com.arkance.note.domain.Class;
import com.arkance.note.domain.Student;
import com.arkance.note.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private  ClassRepository classRepository;

    private StudentRepository studentRepository;

    @Autowired
    public ApplicationRunner(ClassRepository classRepository, StudentRepository studentRepository) {
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
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

        studentDavid.setClassRoom(class1);
        studentPolly.setClassRoom(class1);

        classRepository.save(class1);
        classRepository.save(class2);

        studentRepository.save(studentDavid);
        studentRepository.save(studentPolly);





    }
}
