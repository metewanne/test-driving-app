package com.sky.uk.services;

import com.sky.uk.model.Brand;
import com.sky.uk.model.CarModel;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class CarService {

    BrandService brandService = new BrandService();

    Map <Brand, List<CarModel>> listOfCars = brandService.getMapOfCars();

    public String confirmationOfCarModelBooking(Scanner customerInput, CarModel selectedCar) throws Exception {
        String customerChoice = "";
        boolean selectCarAgain = true;
        while (selectCarAgain) {
            selectedCar = brandService.selectCarBooking(customerInput);
            System.out.println("\n" + "Do you want to confirm booking for " + selectedCar.getBrand().getBrandName() + " " +
                    brandService.checkChosenCarModel(selectedCar.getBrandName(), selectedCar.getCarModel()) + "?");
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
    public void confirmCarBooking(String confirmationChoice) {
        if (confirmationChoice.equals("yes") || confirmationChoice.equals("y")) {
            System.out.println("Booking confirmed");
        }
    }

    //Is this necessary to make private as nothing in the method can be amended?
    public Map<Brand, List<CarModel>> removeCarModelFromList(CarModel selectedCar) {
        for (var entry : listOfCars.entrySet()) {
            if (entry.getKey().getBrandName().equals(selectedCar.getBrand())) {
                List<CarModel> carModelList = listOfCars.get(entry.getKey());
                carModelList = carModelList.stream().filter(x -> !x.getCarModelName().equalsIgnoreCase(selectedCar.getCarModelName()))
                        .collect(toList());
                listOfCars.put(entry.getKey(), carModelList);
            }
        }
        return listOfCars;
    }
//    public Map<Brand, List<CarModel>> getRemovedCarModelFromList(CarModel selectedCar) {
//        return removeCarModelFromList(selectedCar);
//    }

    //Is this necessary to make private as nothing in the method can be amended?
    public List<CarModel> addToConfirmedBookingList(CarModel selectedCar) {
        List<CarModel> bookingList = new ArrayList<>();
        bookingList.add(selectedCar);
        return bookingList;
    }
//    public List<CarModel> getConfirmedCarToBookingList(CarModel selectedCar) {
//        return addToConfirmedBookingList(selectedCar);
//    }

}

