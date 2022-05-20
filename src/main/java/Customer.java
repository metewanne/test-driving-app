import java.util.*;
import java.util.regex.Pattern;


public class Customer {

    static Map<Brand, List<CarModel>> brandMap = Map.of(new Brand("bmw"), List.of(new CarModel("X5", 5000), new CarModel("X6", 1000)), new Brand("tesla"), List.of(new CarModel("S", 2000), new CarModel("3", 100)));
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
        for (Brand key : brandMap.keySet()){
            System.out.println(key.getBrandName());
        }

        Brand chosenBrand = new Brand();
        String brandInput = customerInput.next();
        chosenBrand.setBrandName(brandInput);
        String brandName = brandMatch(chosenBrand, brandMap);

        System.out.println("Please select car model");
        for (CarModel model : showCarModels(brandName)){
            System.out.println(model);
        }
        String modelChoice = customerInput.next();
        CarModel model = new CarModel();
        model.setCarModelName(modelChoice);
        System.out.println(checkCarModel(brandName, modelChoice));
        //System.out.println(brandMap.get();

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
        for (Brand key : brandMap.keySet()){
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

    public static CarModel checkCarModel(String chosenBrand, String chosenModel) throws Exception{
        List<CarModel> listOfModels = showCarModels(chosenBrand);
        CarModel existingModel = null;
        for (CarModel model : listOfModels){
            if(model.getCarModelName().equals(chosenModel)){
                existingModel = model;
                break;
            }
        }
        if (existingModel == null) {
            throw new Exception("model does not exist");
        }
        return existingModel;
    }

    public static CarModel filterCarModel(String brandMatchOutput, String carModel) throws Exception {
        return showCarModels(brandMatchOutput).stream()
            .filter(currentCarModel -> currentCarModel.getCarModelName().equals(carModel)).findFirst().orElseThrow(Exception :: new);
    }

}
