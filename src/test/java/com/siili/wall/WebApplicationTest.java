package com.siili.wall;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class WebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnBoard1() throws Exception {
        this.mockMvc.perform(get("/boards")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Board1")));
    }

    @Test
    public void shouldReturnColumn1() throws Exception {
        this.mockMvc.perform(get("/columns")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Column1")));
    }

    @Test
    public void shouldReturnCard1() throws Exception {
        this.mockMvc.perform(get("/cards")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Card1")));
    }
}
