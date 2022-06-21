import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    Customer customer = new Customer();

    @Test
    public void inputCustomerName_succeed_whenValidInput() {
        assertDoesNotThrow(() -> customer.inputCustomerName("asdf"));
    }

//    @Test
//    public void testInputIsSpecialChar() {
//        assertThrows(Exception.class, () -> customer.inputCustomerName("asdf@!£$"));
//    }

    @ParameterizedTest(name = "[{index} test for: {0} expecting exception: {1}]")
    @CsvSource({"' ', 'Empty input'", "'', 'Empty input'", "'123', 'Incorrect type of input'"})
    public void inputCustomerName_throwsException_whenInputInvalid(String customerName, String exceptionMessage) {
        Exception exception = assertThrows(Exception.class, () -> customer.inputCustomerName(customerName));

        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void validateEmail_succeeds_whenValidEmail() throws Exception {
        String emailAddress = "username@domain.com";
        assertTrue(customer.validateEmail(emailAddress));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "  ", "asdf@", "@asdf", "asdf@."})
    public void validateEmail_throwsException_whenInvalidEmail(String email) {
        Exception exception = assertThrows(Exception.class, () -> customer.validateEmail(email));

        assertEquals("Invalid email", exception.getMessage());
    }
}
