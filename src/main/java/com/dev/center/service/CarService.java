package com.dev.center.service;

import com.dev.center.dao.Car;
import com.dev.center.dao.LogRecord;
import com.dev.center.model.CarDownload;
import com.dev.center.model.ResponseOne;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface CarService {
    public List<ResponseOne> queryCarByIdAndDate(String id, String date) throws Exception;

    public ByteArrayInputStream downloadCars() throws Exception;

    public LogRecord saveLog(LogRecord log);
}
