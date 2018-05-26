package ru.kai.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class HorseControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private HorseController horseController;

    @Before
    public void setUp() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(horseController)
                .build();
    }

    @Test
    public void testIsPathInController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/horse/servlet/count?width=8&height=8&start=A1&end=B3"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("count", "1"));
    }

    @Test
    public void testIsNotPathInController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/horse/servlet/count?width=8&height=8&start=A1&end=A1"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("count", "-1"));
    }

    @Test
    public void testThreeMovesPathInController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/horse/servlet/count?width=8&height=8&start=A1&end=F5"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("count", "3"));
    }

    @Test
    public void testNotEnoughOfDataInController() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/horse/servlet/count"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("count", "недостаточно данных"));
    }
}