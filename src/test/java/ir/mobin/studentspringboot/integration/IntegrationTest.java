package ir.mobin.studentspringboot.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.mobin.studentspringboot.dto.course.AddCourseDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations = {
        "classpath:application-test.properties"
})

@AutoConfigureMockMvc
public class IntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void givenValidData_whenSaveCourse_thenIsCreatedShouldBeReturn() throws Exception {


                //given
        AddCourseDto addCourseDto=new AddCourseDto();
        addCourseDto.setCode(5);
        addCourseDto.setTitle("title 2");
        addCourseDto.setUnits(6);

                //when
        mockMvc.perform(post("/course/create")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addCourseDto)))
                .andDo(print())
                //then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.code").value(addCourseDto.getCode()))
                .andExpect(jsonPath("$.title").value(addCourseDto.getTitle()))
                .andExpect(jsonPath("$.units").value(addCourseDto.getUnits()));

    }
}
