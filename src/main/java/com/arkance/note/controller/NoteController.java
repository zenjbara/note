package com.arkance.note.controller;

import com.arkance.note.Repository.TeacherRepository;
import com.arkance.note.service.ClassService;
import com.arkance.note.service.StudentService;
import com.arkance.note.service.TeacherService;
import com.arkance.note.utils.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {

    private ClassService classService;

    private StudentService studentService;

    private TeacherService teacherService;

    @Autowired
    public NoteController(ClassService classService, StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.classService = classService;
        this.teacherService = teacherService;
    }

    /**
     *
     * @return List of all classes and their principal teacher
     */
    @GetMapping("/classes")
    public List<ClassDTO> classesList(){

        return classService.getClassesAndPrincipalTeacher();
    }

    /**
     *  @return List of Students by class
     */
    @GetMapping("/class/{classId}/students")
    public ClassAndStudentDTO studentByClass(@PathVariable Long classId){
        return classService.getStudentByClass(classId);
    }

    /**
     *
     * @return List of student notes by subject
     */
    @GetMapping("/student/{studentId}/notes")
    public List<StudentNote> studentNotesBySubject(@PathVariable Long studentId){
        return studentService.getStudentNotesBySubject(studentId);
    }

    /**
     *
     * @return student list sorted by first-name and last-name
     */
    @GetMapping("/students")
    public List<StudentDTO> studentsSortedByName(){
        return studentService.getStudents();
    }

    @GetMapping("/teachers/subject")
    public List<TeacherDTO> teachersSubject(){
        return teacherService.getTeachersAndSubjects();
    }

}
