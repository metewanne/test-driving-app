import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Customer {

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

        if (!listOfBrands.contains(chosenBrand.getBrandName())) {
            throw new Exception("Brand not in list");
        }
        return chosenBrand.getBrandName();
    }

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
        brandMatch(brand1, showBrandList());
        //System.out.println(brand1.getBrandName());

    }

    public static List<Brand> brandList() {
        List<Brand> carBrands = new ArrayList<>();
        carBrands.add(new Brand("BMW"));
        carBrands.add(new Brand("Tesla"));
        carBrands.add(new Brand("Mercedes"));
        carBrands.add(new Brand("Rolls Royce"));
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

}
