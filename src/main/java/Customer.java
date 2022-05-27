import java.util.regex.Pattern;

public class Customer {

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


}
