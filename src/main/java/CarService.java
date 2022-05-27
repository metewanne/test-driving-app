import java.util.*;

import static java.util.stream.Collectors.toList;

public class CarService {

    static Map<Brand, List<CarModel>> brandMap = Map.of(new Brand("bmw"), List.of(new CarModel("X5", 5000, 28000, 2019), new CarModel("X6", 1000, 20000, 2020)),
            new Brand("tesla"), List.of(new CarModel("S", 2000, 50000, 2020), new CarModel("X", 100, 40000, 2021), new CarModel("3", 45000, 55000, 2022)),
            new Brand("mercedes"), List.of(new CarModel("A-Class", 500, 30000, 2010), new CarModel(("E-Class"), 14000, 15000, 2016)),
            new Brand("audi"), List.of(new CarModel("A3", 1000, 65000, 2005), new CarModel("Q5", 5000, 40500, 2011), new CarModel("R8", 3000, 48000, 2015)),
            new Brand("ferrari"), List.of(new CarModel("488", 100, 90000, 2003), new CarModel("F8", 10000, 80000, 2012)),
            new Brand("porsche"), List.of(new CarModel("911", 400, 100000, 2000), new CarModel("Panamera", 500, 95000, 2015), new CarModel("Cayenne", 2000, 75000, 2002)));

    public static String brandMatch(Brand brandInput, Map<Brand, List<CarModel>> brandMap) throws Exception {

        List<String> lowerCaseBrands = new ArrayList<>();
        for (Brand key : brandMap.keySet()) {
            lowerCaseBrands.add(key.getBrandName().toLowerCase());
        }
        if (!lowerCaseBrands.contains(brandInput.getBrandName().toLowerCase())) {
            System.out.println("Here is a list of all available cars:" +  "\n");
            brandMap.forEach((key, value) -> System.out.println(key.getBrandName() + " : " + value.stream().map(CarModel::getCarModelName).collect(toList())));
        }
        return brandInput.getBrandName().toLowerCase();
    }

    // method takes brand user input and matches it to key in brandMap to show list of car models
    public static List<CarModel> showCarModels(String brandMatchOutput) throws Exception {

        Brand brandOutput = new Brand();
        brandOutput.setBrandName(brandMatchOutput);
        List<CarModel> listOfModels = brandMap.get(brandOutput);
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
            throw new Exception("model does not exist");
        }
        return existingModel;
    }

    public static List<CarModel> sortCars(String sortChoice, String brandName) throws Exception {

        List<CarModel> listOfModels = showCarModels(brandName);
        switch (sortChoice) {
            case "mileage":
                List<CarModel> sortedCarModel = listOfModels.stream()
                        .sorted(Comparator.comparingInt(CarModel::getMileage))
                        .collect(toList());
                sortedCarModel.forEach(System.out::println);
                break;
            case "price":
                List<CarModel> sortedPrice = listOfModels.stream()
                        .sorted(Comparator.comparingDouble(CarModel::getPrice))
                        .collect(toList());
                sortedPrice.forEach(System.out::println);
                break;
            case "year":
                List<CarModel> sortedYear = listOfModels.stream()
                        .sorted(Comparator.comparingInt(CarModel::getYear)
                                .reversed())
                        .collect(toList());
                sortedYear.forEach(System.out::println);
                break;
            case "n":
            case "no":
                for (CarModel model : showCarModels(brandName)) {
                    System.out.println(model.getCarModelName());
                }
                break;
        }
        return listOfModels;
    }

    public static List<String> printListOfBrands(){
        List<String> listOfBrands = new ArrayList<>();
        for (Brand key : brandMap.keySet()) {
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

    public static void chooseToSortBrands(String userChoice){
        if (userChoice.equals("yes")||userChoice.equals("y")) {
            System.out.println("Please select a brand:");
            List<String> listOfBrands = printListOfBrands();
            Collections.sort(listOfBrands);
            Brand.printBrands(listOfBrands);
        } else if (userChoice.equals("no")||userChoice.equals("n")) {
            System.out.println("Please select a brand:");
            Brand.printBrands(printListOfBrands());
        }
    }

    public static CarModel filterCarModel(String brandMatchOutput, String carModel) throws Exception {
        return showCarModels(brandMatchOutput).stream()
                .filter(currentCarModel -> currentCarModel.getCarModelName().equals(carModel)).findFirst().orElseThrow(Exception::new);
    }


//
//    public static String checkBrands(String brandInput) throws Exception {
//        if (brandInput.equals("bmw")){
//            Brand chosenBrand = new Brand();
//            String input = customerInput.next();
//            chosenBrand.setBrandName(input);
//            String brandName = brandMatch(chosenBrand, brandMap);
//        } else {
//            System.out.println("\n" + "Please select a brand from the list");
//            Brand chosen = new Brand();
//            String input = customerInput.next();
//            chosen.setBrandName(input);
//            String brandName = brandMatch(chosen, brandMap);
//
//        }
//    }


}
