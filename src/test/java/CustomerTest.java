import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {

    Customer customer = new Customer();

    @Test
    public void testEmptyInput() {
        assertThrows(Exception.class, () -> customer.inputCustomerName(""));
    }


    @Test
    public void testInputIsInt() {
        assertThrows(Exception.class, () -> customer.inputCustomerName("123"));
    }

    @Test
    public void testUsingSimpleRegex() {
        String emailAddress = "username@domain.com";
        String regexPattern = "^(.+)@(\\S+)$";
        Customer EmailValidation = null;
        assertTrue(EmailValidation.patternMatches(emailAddress, regexPattern));
    }


}
