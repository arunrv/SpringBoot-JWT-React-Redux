package com.qp.pms.resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookResourceTests {

	@Autowired
    private MockMvc mvc;

    private MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON.getType(),
    MediaType.APPLICATION_JSON.getSubtype(),
    Charset.forName("utf8"));
    
    @Before
    public void setup() throws Exception {
    }
    
    @Test
    public void getBooks() throws Exception {
        ResultActions result = mvc.perform(get("/api/book").accept(mediaType));

		result
            .andExpect(status().isOk())
            .andExpect(content().contentType(mediaType))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id", is(1)))
            .andExpect(jsonPath("$[0].name", is("Mastering Spring Boot")))
            .andExpect(jsonPath("$[0].author", is("John Doe")))
            .andExpect(jsonPath("$[1].id", is(2)))
            .andExpect(jsonPath("$[1].name", is("Mastering React")))
            .andExpect(jsonPath("$[1].author", is("Jane Doe")));
    }

    @Test
    public void getBook() throws Exception {
        mvc.perform(get("/api/book/1").accept(mediaType))
        .andExpect(status().isOk())
        .andExpect(content().contentType(mediaType))
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.name", is("Mastering Spring Boot")))
        .andExpect(jsonPath("$.author", is("John Doe")));
    }

}
