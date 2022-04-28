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

    public static void main(String[] args) throws Exception {

        Scanner customerInput = new Scanner(System.in);
        System.out.print("Enter first name");
        String firstName = customerInput.nextLine();
        inputCustomerName(firstName);
        System.out.print("Enter surname");
        String surname = customerInput.next();
        inputCustomerName(surname);

        System.out.print("Enter email address");
        String email = customerInput.next();
        patternMatches(email, "^(.+)@(\\S+)$");
        System.out.print("Please select a brand");

        String brand = customerInput.nextLine();
        System.out.print(brand);


    }

    public static List<Brand> showBrandList() {
        List<Brand> carBrands = new ArrayList<>();
        carBrands.add(new Brand("BMW"));
        carBrands.add(new Brand("Tesla"));
        carBrands.add(new Brand("Mercedes"));
        carBrands.add(new Brand("Rolls Royce"));
        carBrands.add(new Brand("Ferrari"));
        return carBrands;
    }

}
