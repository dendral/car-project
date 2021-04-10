package com.dev.center.dao;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date startDate;
    private Date endDate;
    private Double price;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "prices")
    private Set<Car> cars;

    public Price(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return id.equals(price1.id) &&
                startDate.equals(price1.startDate) &&
                endDate.equals(price1.endDate) &&
                price.equals(price1.price) &&
                Objects.equals(cars, price1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, price, cars);
    }
 */
}
