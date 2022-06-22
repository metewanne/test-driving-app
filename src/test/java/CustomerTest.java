import com.sky.uk.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {

    Customer customer = new Customer();

    //test that it's not null
    @Test
    public void testNullInput() {
        assertThrows(Exception.class, () -> customer.inputCustomerName(null));
    }

    //test that it's not empty
    @Test
    public void testEmptyInput() {
        assertThrows(Exception.class, () -> customer.inputCustomerName(""));
    }

    //test that it's not an int
    @Test
    public void testInputIsInt() {
        assertThrows(Exception.class, () -> customer.inputCustomerName("123"));
    }

    //test that it doesn't contain special characters
    @Test
    public void testInputContainsSpecialCharacters() {
        assertThrows(Exception.class, () -> customer.inputCustomerName("ss@ss?!"));
    }

    //test that the correct input is given
    @Test
    public void testUsingSimpleRegex() throws Exception {
        String emailAddress = "username@domain.com";
        assertTrue(customer.validateEmail(emailAddress));
    }

    //test that email is not null



}
