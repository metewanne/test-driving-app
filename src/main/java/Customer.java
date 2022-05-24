import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Customer {

    static Map<Brand, List<CarModel>> brandMap = Map.of(new Brand("bmw"), List.of(new CarModel("X5", 5000, 28000, 2019), new CarModel("X6", 1000, 20000, 2020)),
            new Brand("tesla"), List.of(new CarModel("S", 2000, 50000, 2020), new CarModel("X", 100, 40000, 2021), new CarModel("3", 45000, 55000, 2022)),
            new Brand("mercedes"), List.of(new CarModel("A-Class", 500, 30000, 2010), new CarModel(("E-Class"), 14000, 15000, 2016)),
            new Brand("audi"), List.of(new CarModel("A3", 1000, 65000, 2005), new CarModel("Q5", 5000, 40500, 2011), new CarModel("R8", 3000, 48000, 2015)),
            new Brand("ferrari"), List.of(new CarModel("488", 100, 90000, 2003), new CarModel("F8", 10000, 80000, 2012)),
            new Brand("porsche"), List.of(new CarModel("911", 400, 100000, 2000), new CarModel("Panamera", 500, 95000, 2015), new CarModel("Cayenne", 2000, 75000, 2002)));

    public static void main(String[] args) throws Exception {

        Scanner customerInput = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = customerInput.next();
        inputCustomerName(firstName);

        System.out.println("Enter surname");
        String surname = customerInput.next();
        inputCustomerName(surname);

        System.out.println("Enter email address");
        String email = customerInput.next();
        patternMatches(email, "^(.+)@(\\S+)$");

        System.out.println("Please select a brand");
        for (Brand key : brandMap.keySet()) {
            if (key.getBrandName().equals("bmw")) {
                System.out.println(key.getBrandName().toUpperCase());
            } else {
                System.out.println(key.getBrandName().substring(0, 1).toUpperCase() + key.getBrandName().substring(1));

            }
        }

        Brand chosenBrand = new Brand();
        String brandInput = customerInput.next();
        chosenBrand.setBrandName(brandInput);
        String brandName = brandMatch(chosenBrand, brandMap);

        System.out.println("Do you want to sort the cars by mileage or price or year? If not, please type no");
        String sortMileageChoice = customerInput.next().toLowerCase();
        sortCars(sortMileageChoice, brandName);
        String modelChoice = customerInput.next();
        CarModel model = new CarModel();
        model.setCarModelName(modelChoice);
        System.out.println(checkCarModel(brandName, modelChoice));

    }


    public static String inputCustomerName(String customerName) throws Exception {

        if (customerName == null || customerName.trim().equals("")) {
            throw new Exception("Empty input");
        }
        char[] letters = customerName.toCharArray();
        for (char c : letters) {
            if (Character.isDigit(c)) {
                throw new Exception("Incorrect type of input");
            }
        }

        return customerName;
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) throws Exception {

        if (!emailAddress.matches(regexPattern)) {
            throw new Exception("Invalid email");
        }
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static String brandMatch(Brand brandInput, Map<Brand, List<CarModel>> brandMap) throws Exception {

        List<String> lowerCaseBrands = new ArrayList<>();
        for (Brand key : brandMap.keySet()) {
            lowerCaseBrands.add(key.getBrandName().toLowerCase());
        }
        if (!lowerCaseBrands.contains(brandInput.getBrandName().toLowerCase())) {
            throw new Exception("Brand not in list");
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

    public static List<CarModel> sortCars(String sortMileageChoice, String brandName) throws Exception {

        List<CarModel> listOfModels = showCarModels(brandName);
        if (sortMileageChoice.equals("mileage")) {
            List<CarModel> sortedCarModel = listOfModels.stream()
                    .sorted(Comparator.comparingInt(CarModel::getMileage))
                    .collect(Collectors.toList());
            sortedCarModel.forEach(System.out::println);
        } else if (sortMileageChoice.equals("price")) {
            List<CarModel> sortedPrice = listOfModels.stream()
                    .sorted(Comparator.comparingDouble(CarModel::getPrice))
                    .collect(Collectors.toList());
            sortedPrice.forEach(System.out::println);
        } else if (sortMileageChoice.equals("year")) {
            List<CarModel> sortedYear = listOfModels.stream()
                    .sorted(Comparator.comparingInt(CarModel::getYear)
                            .reversed())
                    .collect(Collectors.toList());
            sortedYear.forEach(System.out::println);
        } else if (sortMileageChoice.equals("n") || sortMileageChoice.equals("no")) {
            System.out.println("Please select car model");
            for (CarModel model : showCarModels(brandName)) {
                System.out.println(model.getCarModelName());
            }
        }
        return listOfModels;
    }

    public static CarModel filterCarModel(String brandMatchOutput, String carModel) throws Exception {
        return showCarModels(brandMatchOutput).stream()
                .filter(currentCarModel -> currentCarModel.getCarModelName().equals(carModel)).findFirst().orElseThrow(Exception::new);
    }

}
