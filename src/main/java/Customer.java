import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Customer {

    public String inputCustomerName(String customerName) throws Exception {

        if (customerName == null || customerName.trim().equals("")) {
            throw new Exception("Empty input");
        }

        char[] letters = customerName.toCharArray();
        for (char c : letters) {
            if (Character.isDigit(c)) {
                throw new Exception("Incorrect type of input");
            }
        }

        return "Hi";

    }

}
