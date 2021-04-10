package com.dev.center.controller;

import com.dev.center.model.ResponseOne;
import com.dev.center.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static com.dev.center.util.Constants.*;

@RestController
@Validated
@RequestMapping("/api")
public class CarController {

    @Autowired
    CarService carService;

    /**
     * test endpoint
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "Greetings from Car management project!";
    }

    /**
     *
     * @param currentDate current application date
     * @param carId card unique id
     * @return the list of cars that match the criteria
     * @throws Exception
     */
    @RequestMapping("/query")
    public List<ResponseOne> query(@Valid @Pattern(regexp = DATE_REGEX) @RequestParam(name = "date") String currentDate,
                                   @Valid @Pattern(regexp = INT_REGEX) @RequestParam(name = "id") String carId) throws Exception{
        System.out.println("currentDate:" + currentDate);
        System.out.println("carId:" + carId);
        return carService.queryCarByIdAndDate(carId, currentDate);
    }

    /**
     * Download cars in an excel file
     * @return an excel file containing all the cars
     * @throws Exception
     */
    @RequestMapping("/download")
    public ResponseEntity<Resource> getFile() throws Exception{
        InputStreamResource file = new InputStreamResource(carService.downloadCars());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + FILE_NAME)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
}
