package com.adekah.api;

import com.adekah.dto.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarApi {
    @GetMapping
    public Car getCar(){

    }
}

