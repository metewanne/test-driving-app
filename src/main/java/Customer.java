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

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static void main(String[] args) throws Exception {

        Scanner scanName = new Scanner(System.in);
        System.out.print("Enter first name");
        String firstName = scanName.nextLine();
        inputCustomerName(firstName);
        System.out.print("Enter surname");
        String surname = scanName.next();
        inputCustomerName(surname);

    }

    public List<Brand> showBrandList() {
        List<Brand> carBrands = new ArrayList<>();
        carBrands.add(new Brand("BMW"));
        carBrands.add(new Brand("Tesla"));
        carBrands.add(new Brand("Mercedes"));
        carBrands.add(new Brand("Rolls Royce"));
        carBrands.add(new Brand("Ferrari"));
        return carBrands;
    }

}
