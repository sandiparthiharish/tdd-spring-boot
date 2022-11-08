package com.harish.controller;

import com.harish.model.Bike;
import com.harish.service.BikeService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BikeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BikeService bikeService;

    @Test
    public void getBike_WithName_ReturnsBike() throws Exception {

        when(bikeService.getBikeDetails("Royal Enfield Himalayan"))
                .thenReturn(new Bike("Royal Enfield Himalayan","Red"));

        mockMvc.perform(get("/bike/{name}", "Royal Enfield Himalayan"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Royal Enfield Himalayan"))
                .andExpect(jsonPath("color").value("Red"));
    }

    @Test
    public void getBike_NotFount_Returns404() throws Exception {

        when(this.bikeService.getBikeDetails(any())).thenReturn(null);
        mockMvc.perform(get("/bike/{name}","Royal Enfield Himalayan"))
                .andExpect(status().isNotFound());
    }
}