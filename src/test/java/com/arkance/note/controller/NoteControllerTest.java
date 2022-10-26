package com.arkance.note.controller;

import com.arkance.note.service.ClassService;
import com.arkance.note.utils.dto.ClassDTO;
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

    @MockBean
    private ClassService classService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_classes_and_principal_teacher() throws Exception {
        given(classService.getClassesAndPrincipalTeacher())
                .willReturn(Arrays.asList(new ClassDTO("baccalaureat", "Adam Benjbara")));

        MvcResult result = mockMvc.perform(get("/classes"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();

        assertThat(result.getResponse().getContentAsString()).contains("levelName\":\"baccalaureat");

    }

}
