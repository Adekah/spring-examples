package com.adekah.service;

import com.adekah.dto.Car;
import com.adekah.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private static List<Car> carList = new ArrayList<>();

    @PostConstruct
    public void init() {
        carList.add(new Car("Car A", "Brand A"));
        carList.add(new Car("Car B", "Brand B"));
        carList.add(new Car("Car C", "Brand C"));
    }

    public Car getCar(String name) {
        if (name.startsWith("X")) {
            throw new IllegalArgumentException();
        }

        return carList.stream().filter(item -> item.getName().equals(name)).findFirst()
                .orElseThrow(() -> new EntityNotFoundException(name));
    }
}
