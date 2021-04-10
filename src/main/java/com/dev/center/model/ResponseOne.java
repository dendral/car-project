package com.dev.center.model;

import java.util.Date;

/**
 * Car object and price information
 */
public interface ResponseOne {
    Integer getCarId();
    Integer getBrandId();
    Integer getPriceId();
    Double getPrice();
    Date getStartDate();
    Date getEndDate();
}
