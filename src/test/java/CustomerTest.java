import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.*;

public class CustomerTest {

    Customer customer1 = new Customer();

    @Test
    public void testEmptyInput() throws Exception {

        assertThrows(Exception.class, () -> customer1.inputCustomerName(""));

    }
    @Test
    public void testStuff() throws Exception {

        String name = customer1.inputCustomerName("Hi");

        assertThat(name).isEqualTo("Hi");


    }



}
