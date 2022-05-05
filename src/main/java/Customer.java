import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Customer {

    static Map <String, List <CarModel>> brandMap = Map.of("bmw", List.of(new CarModel("X5"), new CarModel("X6")), "tesla", List.of(new CarModel("S"), new CarModel("3")));



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



        showCarModels(brandName, brandMap);


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
        for(int i = 0; i < listOfBrands.size(); i++){
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


    public static List<String> showBrandList(){

        List<String> brand = new ArrayList<>();
        for (int i=0; i<brandList().size(); i++){
            brand.add(brandList().get(i).getBrandName());
        }
        return brand;
    }

    public static void showCarModels(String brandMatch, Map brandMap) throws Exception {

        // if statement broken
        List<Object> brandList = new ArrayList<>();
        for (Object key : brandMap.keySet()) {
            if (brandMatch == brandMap.get(key)) {
                for (int i = 0; i < brandMap.values().size(); i++){
                    brandList.add(brandMap.get(i));
                }
                System.out.println(brandList);
                }
            }
            System.out.println(brandList);
        }


//        switch (brandMatch) {
//            case "bmw":
//                List<CarModel> bmwModels = new ArrayList<>();
//                bmwModels.add(new CarModel("1"));
//                bmwModels.add(new CarModel("2"));
//                bmwModels.add(new CarModel("3"));
//                System.out.println(bmwModels.toString());
//                break;
//
//            case "tesla":
//                List<CarModel> teslaModels = new ArrayList<>();
//                teslaModels.add(new CarModel("a"));
//                teslaModels.add(new CarModel("b"));
//                teslaModels.add(new CarModel("c"));
//                System.out.println(teslaModels.toString());
//                break;
//
//            default:
//                System.out.println("No car selected");
//        }


//    public static ArrayList<CarModel> showCarModels(String brandMatch) {
//        switch(brandMatch) {
//            case "BMW":
//                ArrayList<CarModel> bmwModels = new ArrayList<>();
//                bmwModels.add(new CarModel("1"));
//                bmwModels.add(new CarModel("2"));
//                bmwModels.add(new CarModel("3"));
//                return bmwModels;
//                break;
//
//            case "Tesla":
//                ArrayList<CarModel> teslaModels = new ArrayList<>();
//                teslaModels.add(new CarModel("a"));
//                teslaModels.add(new CarModel("b"));
//                teslaModels.add(new CarModel("c"));
//                System.out.println(teslaModels.toString());
//                return teslaModels;
//                break;
//
//            default:
//                System.out.println("No car selected");
//        }


//    public static void addBrandAndCar(){
//
//        ArrayList<CarModel> carModelList = new ArrayList<CarModel>();
//
//        carModelList.add(new CarModel("X-5"));
//        carModelList.add(new CarModel("X-6"));
//
//        List<Brand> brandCar = new ArrayList<>();
//        brandCar.add(new Brand("BMW", carModelList));
//
//        System.out.println(brandCar);
//
//    }

//    public static void addBrandAndCar(String b, ArrayList<CarModel> addBrandAndCar){
//
//
//        Brand brandWithCarModels = new Brand(brandName, carModels);
//
//
//
//        // main()
//
//        // Brand BMWWithModels = addBrandAndCar("BMW", bmwCarModelList);
//        // System.out.println(BMWWithModels.printCarModels());
//    }



}
