package com.sky.uk.services;

import com.sky.uk.model.Brand;
import com.sky.uk.model.CarModel;
import com.sky.uk.services.BrandService;


import java.util.*;

import static java.util.stream.Collectors.toList;

public class CarService {

    BrandService brandService = new BrandService();

    Map <Brand, List<CarModel>> brandsAndCarModels = brandService.getBrandMap();

    public String confirmationOfCarModel(Scanner customerInput, CarModel selectedCar) throws Exception {
        String customerChoice = "";
        boolean selectCarAgain = true;
        while (selectCarAgain) {
            selectedCar = brandService.selectCarBooking(customerInput);
            System.out.println("\n" + "Do you want to confirm booking for " + selectedCar.getBrand().getBrandName() + " " +
                    brandService.checkCarModel(selectedCar.getBrandName(), selectedCar.getCarModel()) + "?");
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

    private Map<Brand, List<CarModel>> removeCarModelFromList(CarModel selectedCar) {
        for (var entry : brandsAndCarModels.entrySet()) {
            if (entry.getKey().getBrandName().equals(selectedCar.getBrand())) {
                List<CarModel> carModelList = brandsAndCarModels.get(entry.getKey());
                carModelList = carModelList.stream().filter(x -> !x.getCarModelName().equalsIgnoreCase(selectedCar.getCarModelName()))
                        .collect(toList());
                brandsAndCarModels.put(entry.getKey(), carModelList);
            }
        }
        return brandsAndCarModels;
    }
    public Map<Brand, List<CarModel>> getRemovedCarModelFromList(CarModel selectedCar) {
        return removeCarModelFromList(selectedCar);
    }

    private List<CarModel> addToBookingList(CarModel selectedCar) {
        List<CarModel> bookingList = new ArrayList<>();
        bookingList.add(selectedCar);
        return bookingList;
    }
    public List<CarModel> addCarToBookingList(CarModel selectedCar) {
        return addToBookingList(selectedCar);
    }

}

