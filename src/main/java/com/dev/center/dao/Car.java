package com.dev.center.dao;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String model;
    private String color;

    @ManyToOne
    private Brand brand;

    @JoinTable(
            name = "car_price",
            joinColumns = @JoinColumn(name = "car_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="price_id", nullable = false)
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Price> prices;

    public Car(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }

}
