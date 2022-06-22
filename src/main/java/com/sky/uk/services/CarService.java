package com.sky.uk.services;

import com.sky.uk.model.Brand;
import com.sky.uk.model.CarModel;
import com.sky.uk.services.BrandService;


import java.util.*;

import static java.util.stream.Collectors.toList;

public class CarService {

    BrandService brandService = new BrandService();

    Map <Brand, List<CarModel>> brandsAndCarModels = brandService.getBrandMap();

//    public CarService(BrandService brandService) {
//        this.brandService = brandService;
//    }
//
//    public CarService() {
//    }





//    public String brandMatch(Brand brandInput, Scanner scanner) throws Exception {
//
//        List<String> lowerCaseBrands = new ArrayList<>();
//        for (Brand key : brandMap.keySet()) {
//            lowerCaseBrands.add(key.getBrandName().toLowerCase());
//        }
//        while (!lowerCaseBrands.contains(brandInput.getBrandName().toLowerCase())) {
//            System.out.println("Here is a list of all available cars:" + "\n");
//            brandMap.forEach((key, value) -> System.out.println(key.getBrandName() + " : " + value.stream()
//                    .map(CarModel::getCarModelName).collect(toList())));
//
//            System.out.println();
//            System.out.println("Car brand is not available - please select your new brand");
//            String newBrandSelection = scanner.next();
//            brandInput.setBrandName(newBrandSelection);
//
//        }
//
//        return brandInput.getBrandName().toLowerCase();
//    }
//
//    // method takes brand user input and matches it to key in brandMap to show list of car models
//    public List<CarModel> showCarModels(String brandMatchOutput) throws Exception {
//
//        Brand brandOutput = new Brand();
//        brandOutput.setBrandName(brandMatchOutput);
//        List<CarModel> listOfModels = brandService.brandMap.get(brandOutput);
//        if (listOfModels == null || listOfModels.isEmpty()) {
//            throw new Exception("no car model available");
//        } else {
//            return listOfModels;
//        }
//    }
//
//    // checks if chosen car model is in list of car models
//    public CarModel checkCarModel(String chosenBrand, String chosenModel) throws Exception {
//
//        List<CarModel> listOfModels = showCarModels(chosenBrand);
//        CarModel existingModel = null;
//        for (CarModel model : listOfModels) {
//            if (model.getCarModelName().equalsIgnoreCase(chosenModel)) {
//                existingModel = model;
//                break;
//            }
//        }
//        if (existingModel == null) {
//            System.out.println("Incorrect car model. Please select model from the list above.");
//            Scanner secondModelInput = new Scanner(System.in);
//            String secondChoice = secondModelInput.next();
//            existingModel = checkCarModel(chosenBrand, secondChoice);
//        }
//
//        return existingModel;
//    }



//    public List<String> printListOfBrands() {
//        List<String> listOfBrands = new ArrayList<>();
//        for (Brand key : brandService.brandMap.keySet()) {
//            String nameOfBrand;
//            if (key.getBrandName().equals("bmw")) {
//                nameOfBrand = key.getBrandName().toUpperCase();
//                listOfBrands.add(nameOfBrand);
//            } else {
//                nameOfBrand = key.getBrandName().substring(0, 1).toUpperCase() + key.getBrandName().substring(1);
//                listOfBrands.add(nameOfBrand);
//            }
//        }
//        return listOfBrands;
//    }
//
//    public void chooseToSortBrands(String userChoice) {
//        Scanner customerInput = new Scanner(System.in);
//        if (userChoice.equals("yes") || userChoice.equals("y")) {
//            System.out.println("Please select a brand: " );
//            List<String> listOfBrands = printListOfBrands();
//            Collections.sort(listOfBrands);
//            for (String brand: listOfBrands){
//                System.out.println(brand);
//            }
//        } else if (userChoice.equals("no") || userChoice.equals("n")) {
//            System.out.println("Please select a brand:");
//            Brand.printBrands(printListOfBrands());
//        } else {
//            System.out.println("Invalid input - You can only write y/yes or n/no.");
//            System.out.println("Do you want to see the brands in alphabetic order?");
//            String userSecondChoice = customerInput.next().toLowerCase();
//            chooseToSortBrands(userSecondChoice);
//        }
//    }

    //Allows the user to select the car brand and model
//    public CarModel selectCarBooking(Scanner customerInput) throws Exception {
//
//        System.out.println("Do you want to see the brands in alphabetic order?");
//        String userChoice = customerInput.next().toLowerCase();
//        brandService.chooseToSortBrands(userChoice);
//
//        Brand chosenBrand = new Brand();
//        String brandInput = customerInput.next();
//        chosenBrand.setBrandName(brandInput);
//        String brandName = brandService.brandMatch(chosenBrand, customerInput);
//
//        System.out.println("\n" + "Do you want to sort the cars by mileage or price or year?");
//        String sortChoice = customerInput.next().toLowerCase();
//        System.out.println("Please select a car model:");
//        sortCars(sortChoice, brandName);
//        String modelChoice = customerInput.next();
//        CarModel model = new CarModel();
//        model.setCarModelName(modelChoice);
//        model.setBrandName(brandName);
//        model.setBrand(chosenBrand);
//        List<CarModel> modelsOfSelectedBrand = brandService.getBrandsAndModelsMap().get(model.getBrand());
//        Optional<CarModel> selectedModel = modelsOfSelectedBrand.stream().filter(carModel -> carModel.getCarModelName().equalsIgnoreCase(model.getCarModelName())).findFirst();
//        System.out.println(selectedModel.isPresent());
//
//        return model;
//    }

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

    public Map<Brand, List<CarModel>> removeCarModelFromList(CarModel selectedCar) {
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

    public List<CarModel> addToBookingList(CarModel selectedCar) {
        List<CarModel> bookingList = new ArrayList<>();
        bookingList.add(selectedCar);
        return bookingList;
    }

//    public com.sky.uk.model.CarModel filterCarModel(String brandMatchOutput, String carModel) throws Exception {
//        return showCarModels(brandMatchOutput).stream()
//                .filter(currentCarModel -> currentCarModel.getCarModelName().equals(carModel)).findFirst().orElseThrow(Exception::new);
//    }
}

