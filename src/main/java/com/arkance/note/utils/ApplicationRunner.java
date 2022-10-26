package com.arkance.note.utils;


import com.arkance.note.Repository.ClassRepository;
import com.arkance.note.domain.Class;
import com.arkance.note.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private  ClassRepository classRepository;

    @Autowired
    public ApplicationRunner(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Teacher teacherAdam = new Teacher("Adam" , "Benjbara" , Gender.MALE);
        Teacher teacherAymane = new Teacher("Aymane" , "Benjbara" , Gender.MALE);

        Class class1 = new Class("Cinquième" , teacherAdam);
        Class class2 = new Class("Baccalaureat" , teacherAymane);

        classRepository.save(class1);
        classRepository.save(class2);

    }
}
