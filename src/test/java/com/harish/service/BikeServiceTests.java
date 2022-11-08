package com.harish.service;

import com.harish.model.Bike;
import com.harish.repository.BikeRepository;
import com.harish.utils.BikeNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BikeServiceTests {

    @Mock
    private BikeRepository bikeRepository;

    private BikeService bikeService;

    @Before
    public void setUp() {
        bikeService = new BikeService(bikeRepository);
    }

    @Test
    public void getBikeDetails_returnsBikeInfo() {

        given(bikeRepository.findByName("Royal Enfield Himalayan"))
                .willReturn(new Bike("Royal Enfield Himalayan","Red"));
        Bike bike = bikeService.getBikeDetails("Royal Enfield Himalayan");
        assertThat(bike.getName()).isEqualTo("Royal Enfield Himalayan");
        assertThat(bike.getColor()).isEqualTo("Red");
    }

    @Test(expected = BikeNotFoundException.class)
    public void getBikeDetails_WhenBikeNotFount() {
        given(bikeRepository.findByName("Royal Enfield Himalayan")).willReturn(null);
        bikeService.getBikeDetails("Royal Enfield Himalayan");
    }
}