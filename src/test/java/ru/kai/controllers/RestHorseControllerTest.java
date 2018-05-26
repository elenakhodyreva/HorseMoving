package ru.kai.controllers;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class RestHorseControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private RestHorseController restHorseController;

    @Before
    public void setUp() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(restHorseController)
                .build();
    }

    //один ход
    @Test
    public void testJsonIsPath() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/horse/rest/count?width=8&height=8&start=A1&end=B3")
                .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.moveCount", Matchers.is("1")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(1)));
    }

    //нет ходов, возвращается единица
    @Test
    public void testJsonIsNotPath() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/horse/rest/count?width=8&height=8&start=A1&end=A1")
                .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.moveCount", Matchers.is("-1")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(1)));
    }

    //три хода
    @Test
    public void testThreeMovesPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/horse/rest/count?width=8&height=8&start=A1&end=F5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.moveCount", Matchers.is("3")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(1)));
    }

    @Test
    public void testNotEnoughOfData() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/horse/rest/count"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.moveCount", Matchers.is("недостаточно данных")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(1)));
    }
}