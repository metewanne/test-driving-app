package com.sky.uk.services;

public enum BrandTypes {
    BMW("bmw"),
    TESLA("tesla"),
    MERCEDES("mercedes"),
    AUDI("audi"),
    FERRARI("ferrari"),
    PORSCHE("porsche");

    private String name;


    BrandTypes(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}

//EnumMap<com.sky.uk.services.BrandTypes, String> carBrands


