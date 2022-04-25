import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {

    Customer customer = new Customer();
    Scanner scanName = new Scanner(System.in);

    @Test
    public void testEmptyInput() {

        assertThrows(Exception.class, () -> customer.inputCustomerName(scanName));

    }


    @Test
    public void testInputIsInt() {

        assertThrows(Exception.class, () -> customer.inputCustomerName(scanName));

    }

    @Test
    public void testUsingSimpleRegex() {
        String emailAddress = "username@domain.com";
        String regexPattern = "^(.+)@(\\S+)$";
        Customer EmailValidation = null;
        assertTrue(EmailValidation.patternMatches(emailAddress, regexPattern));
    }


}
