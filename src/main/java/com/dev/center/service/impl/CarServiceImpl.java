package com.dev.center.service.impl;

import com.dev.center.dao.LogRecord;
import com.dev.center.dao.repository.CarRepository;
import com.dev.center.dao.repository.LogRepository;
import com.dev.center.filter.CustomRequestFilter;
import com.dev.center.model.CarDownload;
import com.dev.center.model.ResponseOne;
import com.dev.center.service.CarService;
import com.dev.center.util.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private static Logger LOGGER = LoggerFactory.getLogger(CustomRequestFilter.class);

    @Autowired
    CarRepository carRepository;

    @Autowired
    LogRepository logRepository;

    @Override
    public List<ResponseOne> queryCarByIdAndDate(String id, String date) throws Exception{
        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        LOGGER.info(
                "Logging Request Data Date:{} Id:{}", fecha, id);
        return carRepository.queryCarByIdAndDate(Integer.parseInt(id), fecha);
    }

    @Override
    public ByteArrayInputStream downloadCars() throws Exception {
        List<CarDownload> carList = carRepository.retrievaAllCars();
        LOGGER.info("Downloading file");
        ByteArrayInputStream in = ExcelUtil.listToExcel(carList);
        return in;
    }

    @Override
    public LogRecord saveLog(LogRecord log) {
        return logRepository.save(log);
    }
}
