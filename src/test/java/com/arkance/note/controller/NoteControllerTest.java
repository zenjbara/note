package com.arkance.note.controller;

import com.arkance.note.domain.Student;
import com.arkance.note.service.ClassService;
import com.arkance.note.service.StudentService;
import com.arkance.note.utils.Gender;
import com.arkance.note.utils.dto.ClassAndStudentDTO;
import com.arkance.note.utils.dto.ClassDTO;
import com.arkance.note.utils.dto.StudentDTO;
import com.arkance.note.utils.dto.StudentNote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NoteController.class)
public class NoteControllerTest {

    public static final String BACCALAUREAT = "baccalaureat";
    @MockBean
    private ClassService classService;

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_classes_and_principal_teacher() throws Exception {
        given(classService.getClassesAndPrincipalTeacher())
                .willReturn(Arrays.asList(new ClassDTO(BACCALAUREAT, "Adam Benjbara")));

        MvcResult result = mockMvc.perform(get("/classes"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();

        assertThat(result.getResponse().getContentAsString()).contains("levelName\":\"" + BACCALAUREAT);

    }

    @Test
    public void should_return_students_by_class() throws Exception {
        Long classId = 1l;

        given(classService.getStudentByClass(classId))
                .willReturn(new ClassAndStudentDTO(BACCALAUREAT, Arrays.asList("Anna Aquino","Halene leval")));

        MvcResult result = mockMvc.perform(get("/class/"+classId+"/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).contains("studentsFullName\":[\"Anna" );
    }

    @Test
    public void should_return_student_note_by_subject() throws Exception {
        Long studentId = 1l;

        given(studentService.getStudentNotesBySubject(studentId))
                .willReturn(Arrays.asList(new StudentNote("SVT", 17.5)));

        MvcResult result = mockMvc.perform(get("/student/"+studentId+"/notes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).contains("subjectName\":\"SVT" );
    }

    @Test
    public void should_return_students_sorted_by_name() throws Exception {

        given(studentService.getStudents())
                .willReturn(Arrays.asList(new StudentDTO("Lisa", "legrand", Gender.FEMALE)));

        MvcResult result = mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).contains("firstName\":\"Lisa" );
    }

}
