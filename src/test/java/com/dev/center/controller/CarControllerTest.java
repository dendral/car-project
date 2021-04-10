package com.dev.center.controller;

import com.dev.center.dao.repository.CarRepository;
import com.dev.center.dao.repository.LogRepository;
import com.dev.center.service.CarService;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.junit.Test;


import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CarControllerTest {

    public CarControllerTest(){

    }

    @MockBean
    private CarController carController;

    @Autowired
    CarService carService;

    @MockBean
    CarRepository cr;
    @MockBean
    LogRepository lr;

    @Test
    public void queryNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            carService.queryCarByIdAndDate("1", null);
        });
    }

    @Test
    public void queryParse() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carService.queryCarByIdAndDate("one", "2020-12-12");
        });
    }
}