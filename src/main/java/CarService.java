import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CarService {

    private final Map<Brand, List<CarModel>> brandMap = new HashMap<> (Map.of(new Brand(BrandTypes.BMW.toString()), List.of(new CarModel("X5", 5000, 28000, 2019), new CarModel("X6", 1000, 20000, 2020)),
            new Brand(BrandTypes.TESLA.toString()), List.of(new CarModel("S", 2000, 50000, 2020), new CarModel("X", 100, 40000, 2021), new CarModel("3", 45000, 55000, 2022)),
            new Brand(BrandTypes.MERCEDES.toString()), List.of(new CarModel("A-Class", 500, 30000, 2010), new CarModel(("E-Class"), 14000, 15000, 2016)),
            new Brand(BrandTypes.AUDI.toString()), List.of(new CarModel("A3", 1000, 65000, 2005), new CarModel("Q5", 5000, 40500, 2011), new CarModel("R8", 3000, 48000, 2015)),
            new Brand(BrandTypes.FERRARI.toString()), List.of(new CarModel("488", 100, 90000, 2003), new CarModel("F8", 10000, 80000, 2012)),
            new Brand(BrandTypes.PORSCHE.toString()), List.of(new CarModel("911", 400, 100000, 2000), new CarModel("Panamera", 500, 95000, 2015), new CarModel("Cayenne", 2000, 75000, 2002))));


    public Map<Brand, List<CarModel>> getBrandMap() {
        return brandMap;
    }

    public String brandMatch(Brand brandInput, Scanner scanner) throws Exception {

        List<String> lowerCaseBrands = new ArrayList<>();
        for (Brand key : brandMap.keySet()) {
            lowerCaseBrands.add(key.getBrandName().toLowerCase());
        }
        while (!lowerCaseBrands.contains(brandInput.getBrandName().toLowerCase())) {
            System.out.println("Here is a list of all available cars:" + "\n");
            brandMap.forEach((key, value) -> System.out.println(key.getBrandName() + " : " + value.stream()
                    .map(CarModel::getCarModelName).collect(toList())));

            System.out.println();
            System.out.println("Car brand is not available - please select your new brand");
            String newBrandSelection = scanner.next();
            brandInput.setBrandName(newBrandSelection);

        }

        return brandInput.getBrandName().toLowerCase();
    }

    // method takes brand user input and matches it to key in brandMap to show list of car models
    public List<CarModel> showCarModels(String brandMatchOutput) throws Exception {

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
    public CarModel checkCarModel(String chosenBrand, String chosenModel) throws Exception {

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

    public List<CarModel> sortCars(String sortChoice, String brandName) throws Exception {

        List<CarModel> listOfModels = showCarModels(brandName);
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
                for (CarModel model : showCarModels(brandName)) {
                    System.out.println(model.toString());
                }
                break;
        }
        return listOfModels;
    }

    public List<String> printListOfBrands() {
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

    public void chooseToSortBrands(String userChoice) {
        Scanner customerInput = new Scanner(System.in);
        if (userChoice.equals("yes") || userChoice.equals("y")) {
            System.out.println("Please select a brand:");
            List<String> listOfBrands = printListOfBrands();
            Collections.sort(listOfBrands);
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

    //Allows the user to select the car brand and model
    public CarModel selectCarBooking(Scanner customerInput) throws Exception {

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
        sortCars(sortChoice, brandName);
        String modelChoice = customerInput.next();
        CarModel model = new CarModel();
        model.setCarModelName(modelChoice);
        model.setBrand(brandName);

        return model;
    }

    public String confirmationOfCarModel(Scanner customerInput, CarModel selectedCar) throws Exception {
        String customerChoice = "";
        boolean selectCarAgain = true;
        while(selectCarAgain) {
            selectedCar = selectCarBooking(customerInput);
            System.out.println("\n" + "Do you want to confirm booking for " + selectedCar.getBrand() + " " +
                    checkCarModel(selectedCar.getBrand(), selectedCar.getCarModel()) + "?");
            customerChoice = customerInput.next();

            switch(customerChoice){
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
        for (var entry : brandMap.entrySet()) {
            if(entry.getKey().getBrandName().equals(selectedCar.getBrand())){
                List<CarModel> carModelList = brandMap.get(entry.getKey());
                carModelList = carModelList.stream().filter(x -> !x.getCarModelName().equalsIgnoreCase(selectedCar.getCarModelName()))
                        .collect(Collectors.toList());
                brandMap.put(entry.getKey(), carModelList);
            }
        }
        return brandMap;
    }
//
//    public CarModel filterCarModel(String brandMatchOutput, String carModel) throws Exception {
//        return showCarModels(brandMatchOutput).stream()
//                .filter(currentCarModel -> currentCarModel.getCarModelName().equals(carModel)).findFirst().orElseThrow(Exception::new);
//    }
}
