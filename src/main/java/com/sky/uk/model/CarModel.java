package com.sky.uk.model;

import java.util.Objects;

public class CarModel {

    private String carModelName;
    private int mileage;
    private double price;
    private int year;
    private String brandName;
    private Brand brand;


    public CarModel() {
    }

    public CarModel(String carModelName, int mileage, double price, int year) {
        this.carModelName = carModelName;
        setMileage(mileage);
        setPrice(price);
        this.year = year;
    }

    public CarModel(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarModel() {
        return carModelName;
    }


    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(carModelName, carModel.carModelName);
    }

    @Override
    public String toString() {
        return "model: " + carModelName +
                ", mileage: " + mileage +
                ", year: " + year +
                ", price: £" + price;
    }
}
