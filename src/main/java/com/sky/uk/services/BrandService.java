package com.sky.uk.services;

import com.sky.uk.model.Brand;
import com.sky.uk.model.CarModel;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class BrandService {
    private static final Map<Brand, List<CarModel>> brandMap = new HashMap<>(Map.of(new Brand(BrandTypes.BMW.toString()), List.of(new CarModel("X5", 5000, 28000, 2019), new CarModel("X6", 1000, 20000, 2020)),
            new Brand(BrandTypes.TESLA.toString()), List.of(new CarModel("S", 2000, 50000, 2020), new CarModel("X", 100, 40000, 2021), new CarModel("3", 45000, 55000, 2022)),
            new Brand(BrandTypes.MERCEDES.toString()), List.of(new CarModel("A-Class", 500, 30000, 2010), new CarModel(("E-Class"), 14000, 15000, 2016)),
            new Brand(BrandTypes.AUDI.toString()), List.of(new CarModel("A3", 1000, 65000, 2005), new CarModel("Q5", 5000, 40500, 2011), new CarModel("R8", 3000, 48000, 2015)),
            new Brand(BrandTypes.FERRARI.toString()), List.of(new CarModel("488", 100, 90000, 2003), new CarModel("F8", 10000, 80000, 2012)),
            new Brand(BrandTypes.PORSCHE.toString()), List.of(new CarModel("911", 400, 100000, 2000), new CarModel("Panamera", 500, 95000, 2015), new CarModel("Cayenne", 2000, 75000, 2002))));

    public static Map<Brand, List<CarModel>> getBrandsAndModelsMap() {
        return brandMap;
    }

    public static String brandMatch(Brand brandInput, Scanner scanner) throws Exception {

        List<String> lowerCaseBrands = new ArrayList<>();
        for (Brand key : getBrandsAndModelsMap().keySet()) {
            lowerCaseBrands.add(key.getBrandName().toLowerCase());
        }
        while (!lowerCaseBrands.contains(brandInput.getBrandName().toLowerCase())) {
            System.out.println("Here is a list of all available cars:" + "\n");
            getBrandsAndModelsMap().forEach((key, value) -> System.out.println(key.getBrandName() + " : " + value.stream()
                    .map(CarModel::getCarModelName).collect(toList())));

            System.out.println();
            System.out.println("Car brand is not available - please select your new brand");
            String newBrandSelection = scanner.next();
            brandInput.setBrandName(newBrandSelection);

        }

        return brandInput.getBrandName().toLowerCase();
    }

    // method takes brand user input and matches it to key in brandMap to show list of car models
    public static List<CarModel> showCarModels(String brandMatchOutput) throws Exception {

        Brand brandOutput = new Brand();
        brandOutput.setBrandName(brandMatchOutput);
        List<CarModel> listOfModels = getBrandsAndModelsMap().get(brandOutput);
        if (listOfModels == null || listOfModels.isEmpty()) {
            throw new Exception("no car model available");
        } else {
            return listOfModels;
        }
    }

    // checks if chosen car model is in list of car models
    public static CarModel checkCarModel(String chosenBrand, String chosenModel) throws Exception {

        List<CarModel> listOfModels = showCarModels(chosenBrand);
        CarModel existingModel = null;
        for (CarModel model : listOfModels) {
            if (model.getCarModelName().equalsIgnoreCase(chosenModel)) {
                existingModel = model;
                break;
            }
        }
        if (existingModel == null) {
            System.out.println("Incorrect car model. Please select model from the list above.");
            Scanner secondModelInput = new Scanner(System.in);
            String secondChoice = secondModelInput.next();
            existingModel = checkCarModel(chosenBrand, secondChoice);
        }

        return existingModel;
    }

    public static List<String> printListOfBrands() {
        List<String> listOfBrands = new ArrayList<>();
        for (Brand key : getBrandsAndModelsMap().keySet()) {
            String nameOfBrand;
            if (key.getBrandName().equals("bmw")) {
                nameOfBrand = key.getBrandName().toUpperCase();
                listOfBrands.add(nameOfBrand);
            } else {
                nameOfBrand = key.getBrandName().substring(0, 1).toUpperCase() + key.getBrandName().substring(1);
                listOfBrands.add(nameOfBrand);
            }
        }
        return listOfBrands;
    }

    public static void chooseToSortBrands(String userChoice) {
        Scanner customerInput = new Scanner(System.in);
        if (userChoice.equals("yes") || userChoice.equals("y")) {
            System.out.println("Please select a brand: " );
            List<String> listOfBrands = printListOfBrands();
            Collections.sort(listOfBrands);
            for (String brand: listOfBrands){
                System.out.println(brand);
            }
        } else if (userChoice.equals("no") || userChoice.equals("n")) {
            System.out.println("Please select a brand:");
            Brand.printBrands(printListOfBrands());
        } else {
            System.out.println("Invalid input - You can only write y/yes or n/no.");
            System.out.println("Do you want to see the brands in alphabetic order?");
            String userSecondChoice = customerInput.next().toLowerCase();
            chooseToSortBrands(userSecondChoice);
        }
    }

//    Allows the user to select the car brand and model
    public static CarModel selectCarBooking(Scanner customerInput) throws Exception {

        System.out.println("Do you want to see the brands in alphabetic order?");
        String userChoice = customerInput.next().toLowerCase();
        chooseToSortBrands(userChoice);

        Brand chosenBrand = new Brand();
        String brandInput = customerInput.next();
        chosenBrand.setBrandName(brandInput);
        String brandName = brandMatch(chosenBrand, customerInput);

        System.out.println("\n" + "Do you want to sort the cars by mileage or price or year?");
        String sortChoice = customerInput.next().toLowerCase();
        System.out.println("Please select a car model:");
        CarService.sortCars(sortChoice, brandName);
        String modelChoice = customerInput.next();
        CarModel model = new CarModel();
        model.setCarModelName(modelChoice);
        model.setBrandName(brandName);
        model.setBrand(chosenBrand);
        List<CarModel> modelsOfSelectedBrand = getBrandsAndModelsMap().get(model.getBrand());
        Optional<CarModel> selectedModel = modelsOfSelectedBrand.stream().filter(carModel -> carModel.getCarModelName().equalsIgnoreCase(model.getCarModelName())).findFirst();
        System.out.println(selectedModel.isPresent());

        return model;
    }


}






