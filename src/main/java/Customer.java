import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.*;

public class Customer {

    static Map<String, List<CarModel>> brandMap = Map.of("bmw", List.of(new CarModel("X5"), new CarModel("X6")), "tesla", List.of(new CarModel("S"), new CarModel("3")));


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

        System.out.println(showBrandList());

        Brand brand1 = new Brand();
        String brand = customerInput.next();
        brand1.setBrandName(brand);
        String brandName = brandMatch(brand1, showBrandList());

        System.out.println(showCarModels(brandName, brandMap));


        System.out.println("Please select car model");
        CarModel model = new CarModel();
        String modelChoice = customerInput.next();
        model.setCarModel(modelChoice);






    }


    public static String inputCustomerName(String customerName) throws Exception {

        String name = customerName;

        if (name == null || name.trim().equals("")) {
            throw new Exception("Empty input");
        }
        char[] letters = name.toCharArray();
        for (char c : letters) {
            if (Character.isDigit(c)) {
                throw new Exception("Incorrect type of input");
            }
        }

        return name;
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) throws Exception {
        String email = emailAddress;

        if (!email.matches(regexPattern)) {
            throw new Exception("Invalid email");
        }
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static String brandMatch(Brand brand, List brandList) throws Exception {
        Brand chosenBrand = brand;
        List<String> listOfBrands = brandList;

        List<String> lowerCaseBrands = new ArrayList<>();
        for (int i = 0; i < listOfBrands.size(); i++) {
            lowerCaseBrands.add(listOfBrands.get(i).toLowerCase());
        }

        if (!lowerCaseBrands.contains(chosenBrand.getBrandName().toLowerCase())) {
            throw new Exception("Brand not in list");
        }
        return chosenBrand.getBrandName().toLowerCase();
    }

    public static List<Brand> brandList() {
        List<Brand> carBrands = new ArrayList<>();
        carBrands.add(new Brand("BMW"));
        carBrands.add(new Brand("Tesla"));
        carBrands.add(new Brand("Mercedes"));
        carBrands.add(new Brand("Bentley"));
        carBrands.add(new Brand("Ferrari"));
        return carBrands;
    }


    public static List<String> showBrandList() {

        List<String> brand = new ArrayList<>();
        for (int i = 0; i < brandList().size(); i++) {
            brand.add(brandList().get(i).getBrandName());
        }
        return brand;
    }

    public static List<CarModel> showCarModels(String brandMatch, Map<String, List<CarModel>> brandMap) throws Exception {
        if (brandMap.get(brandMatch).isEmpty()) {
            throw new Exception("no car model available");
        } else {
            return brandMap.get(brandMatch);
        }
    }







}
