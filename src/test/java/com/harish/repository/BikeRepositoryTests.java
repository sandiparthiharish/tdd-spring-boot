package com.harish.repository;

import com.harish.model.Bike;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BikeRepositoryTests {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByName_ReturnsBike() {
        Bike saveBike = testEntityManager.persistAndFlush(new Bike("Royal Enfield Himalayan","Red"));
        Bike bike = bikeRepository.findByName("Royal Enfield Himalayan");
        assertThat(bike.getName()).isEqualTo(saveBike.getName());
        assertThat(bike.getColor()).isEqualTo(saveBike.getColor());
    }
}