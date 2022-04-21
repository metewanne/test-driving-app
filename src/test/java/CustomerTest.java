import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {

    Customer customer = new Customer();

    @Test
    public void testEmptyInput() {

        assertThrows(Exception.class, () -> customer.inputCustomerName(""));

    }


    @Test
    public void testInputIsInt() {

        assertThrows(Exception.class, () -> customer.inputCustomerName("1"));

    }


}
