import org.junit.jupiter.api.Test;
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
    public void testUsingSimpleRegex() throws Exception {
        String emailAddress = "username@domain.com";
        String regexPattern = "^(.+)@(\\S+)$";
        assertTrue(Customer.patternMatches(emailAddress, regexPattern));
    }




}
