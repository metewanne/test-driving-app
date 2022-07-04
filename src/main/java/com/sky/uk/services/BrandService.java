package com.sky.uk.services;

import com.sky.uk.model.Brand;
import com.sky.uk.model.CarModel;
import com.sky.uk.enums.BrandTypes;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class BrandService {
    private final Map<Brand, List<CarModel>> mapOfCars = new HashMap<>(Map.of(new Brand(BrandTypes.BMW.toString()), List.of(new CarModel("X5", 5000, 28000, 2019), new CarModel("X6", 1000, 20000, 2020)),
            new Brand(BrandTypes.TESLA.toString()), List.of(new CarModel("S", 2000, 50000, 2020), new CarModel("X", 100, 40000, 2021), new CarModel("3", 45000, 55000, 2022)),
            new Brand(BrandTypes.MERCEDES.toString()), List.of(new CarModel("A-Class", 500, 30000, 2010), new CarModel(("E-Class"), 14000, 15000, 2016)),
            new Brand(BrandTypes.AUDI.toString()), List.of(new CarModel("A3", 1000, 65000, 2005), new CarModel("Q5", 5000, 40500, 2011), new CarModel("R8", 3000, 48000, 2015)),
            new Brand(BrandTypes.FERRARI.toString()), List.of(new CarModel("488", 100, 90000, 2003), new CarModel("F8", 10000, 80000, 2012)),
            new Brand(BrandTypes.PORSCHE.toString()), List.of(new CarModel("911", 400, 100000, 2000), new CarModel("Panamera", 500, 95000, 2015), new CarModel("Cayenne", 2000, 75000, 2002))));

    public Map<Brand, List<CarModel>> getMapOfCars(){
        return mapOfCars;
    }

    public String checkChosenBrandIsInBrandMap(Brand brandInput, Scanner scanner) throws Exception {

        List<String> lowerCaseBrands = new ArrayList<>();
        for (Brand key : mapOfCars.keySet()) {
            lowerCaseBrands.add(key.getBrandName().toLowerCase());
        }
        while (!lowerCaseBrands.contains(brandInput.getBrandName().toLowerCase())) {
            System.out.println("Here is a list of all available cars:" + "\n");
            mapOfCars.forEach((key, value) -> System.out.println(key.getBrandName() + " : " + value.stream()
                    .map(CarModel::getCarModelName).collect(toList())));

            System.out.println();
            System.out.println("Car brand is not available - please select your new brand");
            String newBrandSelection = scanner.next();
            brandInput.setBrandName(newBrandSelection);
        }
        return brandInput.getBrandName().toLowerCase();
    }

    // method takes brand user input and matches it to key in brandMap to show list of car models
    protected List<CarModel> showCarModelsForSelectedBrand(String brandMatchOutput) throws Exception {

        Brand brandOutput = new Brand();
        brandOutput.setBrandName(brandMatchOutput);
        List<CarModel> listOfModels = mapOfCars.get(brandOutput);
        if (listOfModels == null || listOfModels.isEmpty()) {
            throw new Exception("no car model available");
        } else {
            return listOfModels;
        }
    }
    // checks if chosen car model is in list of car models
    public CarModel checkChosenCarModel(String chosenBrand, String chosenModel) throws Exception {

        List<CarModel> listOfModels = showCarModelsForSelectedBrand(chosenBrand);
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
            existingModel = checkChosenCarModel(chosenBrand, secondChoice);
        }

        return existingModel;
    }

    protected List<String> getListOfBrands() {
        List<String> listOfBrands = new ArrayList<>();
        for (Brand key : mapOfCars.keySet()) {
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

    private void chooseToSortCarBrands(String userChoice) {
        Scanner customerInput = new Scanner(System.in);
        if (userChoice.equals("yes") || userChoice.equals("y")) {
            System.out.println("Please select a brand: " );
            List<String> listOfBrands = getListOfBrands();
            Collections.sort(listOfBrands);
            for (String brand: listOfBrands){
                System.out.println(brand);
            }
        } else if (userChoice.equals("no") || userChoice.equals("n")) {
            System.out.println("Please select a brand:");
            Brand.printBrands(getListOfBrands());
        } else {
            System.out.println("Invalid input - You can only write y/yes or n/no.");
            System.out.println("Do you want to see the brands in alphabetic order?");
            String userSecondChoice = customerInput.next().toLowerCase();
            chooseToSortCarBrands(userSecondChoice);
        }
    }

    public List<CarModel> sortCars(String sortChoice, String brandName) throws Exception {

        List<CarModel> listOfModels = showCarModelsForSelectedBrand(brandName);
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
                for (CarModel model : showCarModelsForSelectedBrand(brandName)) {
                    System.out.println(model.toString());
                }
                break;
        }
        return listOfModels;
    }

//    Allows the user to select the car brand and model
    public CarModel selectCarBooking(Scanner customerInput) throws Exception {

        System.out.println("Do you want to see the brands in alphabetic order?");
        String userChoice = customerInput.next().toLowerCase();
        chooseToSortCarBrands(userChoice);

        Brand chosenBrand = new Brand();
        String brandInput = customerInput.next();
        chosenBrand.setBrandName(brandInput);
        String brandName = checkChosenBrandIsInBrandMap(chosenBrand, customerInput);

        System.out.println("\n" + "Do you want to sort the cars by mileage or price or year?");
        String sortChoice = customerInput.next().toLowerCase();
        System.out.println("Please select a car model:");
        sortCars(sortChoice, brandName);
        String modelChoice = customerInput.next();
        CarModel model = new CarModel();
        model.setCarModelName(modelChoice);
        model.setBrandName(brandName);
        model.setBrand(chosenBrand);
        List<CarModel> modelsOfSelectedBrand = mapOfCars.get(model.getBrand());
        Optional<CarModel> selectedModel = modelsOfSelectedBrand.stream().filter(carModel -> carModel.getCarModelName().equalsIgnoreCase(model.getCarModelName())).findFirst();

        model.setCarModelName(selectedModel.get().getCarModelName());
        model.setMileage(selectedModel.get().getMileage());
        model.setPrice(selectedModel.get().getPrice());
        model.setYear(selectedModel.get().getYear());

        return model;
    }
}






