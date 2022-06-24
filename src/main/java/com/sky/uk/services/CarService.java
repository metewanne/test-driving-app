package com.sky.uk.services;

import com.sky.uk.model.Brand;
import com.sky.uk.model.CarModel;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CarService {

    public static List<CarModel> sortCars(String sortChoice, String brandName) throws Exception {

        List<CarModel> listOfModels = BrandService.showCarModels(brandName);
        switch (sortChoice) {
            case "mileage":
                List<CarModel> sortedCarModel = listOfModels.stream()
                        .sorted(Comparator.comparingInt(CarModel::getMileage))
                        .collect(toList());
                sortedCarModel.forEach(System.out::println);
                return sortedCarModel;
            case "price":
                List<CarModel> sortedPrice = listOfModels.stream()
                        .sorted(Comparator.comparingDouble(CarModel::getPrice))
                        .collect(toList());
                sortedPrice.forEach(System.out::println);
                return sortedPrice;
            case "year":
                List<CarModel> sortedYear = listOfModels.stream()
                        .sorted(Comparator.comparingInt(CarModel::getYear)
                                .reversed())
                        .collect(toList());
                sortedYear.forEach(System.out::println);
                return sortedYear;
            default:
                for (CarModel model : BrandService.showCarModels(brandName)) {
                    System.out.println(model.toString());
                }
                break;
        }
        return listOfModels;
    }

    public String confirmationOfCarModel(Scanner customerInput, CarModel selectedCar) throws Exception {
        String customerChoice = "";
        boolean selectCarAgain = true;
        while (selectCarAgain) {
            selectedCar = BrandService.selectCarBooking(customerInput);
            System.out.println("\n" + "Do you want to confirm booking for " + selectedCar.getBrand() + " " +
                    BrandService.checkCarModel(selectedCar.getBrandName(), selectedCar.getCarModel()) + "?");
            customerChoice = customerInput.next();

            switch (customerChoice) {
                case "yes":
                case "y":
                    selectCarAgain = false;
                    break;
                default:
                    break;
            }
        }
        return customerChoice;
    }

    //Confirms the customers car booking
    public void confirmBooking(String confirmationChoice) {
        if (confirmationChoice.equals("yes") || confirmationChoice.equals("y")) {
            System.out.println("Booking confirmed");
        }
    }

    public Map<Brand, List<CarModel>> removeCarModelFromList(CarModel selectedCar) {
        for (var entry : BrandService.getBrandsAndModelsMap().entrySet()) {
            if (entry.getKey().getBrandName().equals(selectedCar.getBrand())) {
                List<CarModel> carModelList = BrandService.getBrandsAndModelsMap().get(entry.getKey());
                carModelList = carModelList.stream().filter(x -> !x.getCarModelName().equalsIgnoreCase(selectedCar.getCarModelName()))
                        .collect(toList());
                BrandService.getBrandsAndModelsMap().put(entry.getKey(), carModelList);
            }
        }
        return BrandService.getBrandsAndModelsMap();
    }

    public List<CarModel> addToBookingList(CarModel selectedCar) {
        List<CarModel> bookingList = new ArrayList<>();
        bookingList.add(selectedCar);
        return bookingList;
    }
}

