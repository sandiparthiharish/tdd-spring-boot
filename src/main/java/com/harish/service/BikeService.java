package com.harish.service;

import com.harish.model.Bike;
import com.harish.repository.BikeRepository;
import com.harish.utils.BikeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

    @Autowired
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Bike getBikeDetails(String name) {
        Bike bike = bikeRepository.findByName(name);
        if(bike == null) {
            throw new BikeNotFoundException();
        }
        return bike;
    }
}