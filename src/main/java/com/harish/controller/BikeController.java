package com.harish.controller;

import com.harish.model.Bike;
import com.harish.service.BikeService;
import com.harish.utils.BikeNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BikeController {

    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("bike/{name}")
    public Bike getBike(@PathVariable String name) {
        Bike bike = bikeService.getBikeDetails(name);
        if(bike == null) {
            throw new BikeNotFoundException();
        }
        return bike;
    }
}