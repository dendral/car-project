package com.dev.center.service.impl;

import com.dev.center.dao.Car;
import com.dev.center.dao.repository.CarRepository;
import com.dev.center.dao.repository.LogRepository;
import com.dev.center.model.CarDownload;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CarServiceImplTest {
    public CarServiceImplTest(){

    }

    @MockBean
    CarRepository carRepository;

    @MockBean
    LogRepository logRepository;

    @Test
    public void testQueryCarByIdAndDate() {
        /*Assertions.assertThrows(NullPointerException.class, () -> {
            carRepository.queryCarByIdAndDate(1, new Date());
        });*/
        assertThat(carRepository.queryCarByIdAndDate(1, new Date()));
    }

    @Test
    public void testDownloadCars() {
        when(carRepository.retrievaAllCars()).thenReturn(new ArrayList<>());
        assertThat(carRepository.retrievaAllCars()).isEmpty();
    }

    @Test
    public void testSaveLog() {
    }
}