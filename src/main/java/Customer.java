import java.util.Scanner;
import java.util.regex.Pattern;

public class Customer {


    public static Scanner inputCustomerName(Scanner scanName) throws Exception {

        String name = scanName.nextLine();

        if (name == null || name.trim().equals("")) {
            throw new Exception("Empty input");
        }
        char[] letters = name.toCharArray();
        for (char c : letters) {
            if (Character.isDigit(c)) {
                throw new Exception("Incorrect type of input");
            }
        }

        return scanName;
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

        System.out.print("Enter surname");
        String surname = scanName.next();


        inputCustomerName(scanName);
    }

}
