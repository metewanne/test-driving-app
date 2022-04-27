import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    Customer customer = new Customer();
    //@Test
    //Check that car class exists
    @Test
    public void testClassExists() {
        try {
            Class.forName("Car");
        } catch (ClassNotFoundException e) {
            Assert.fail("Should have class called Car");
        }
    }

    @Test
    public void testEmptyList() throws Exception {
        assertThat(customer.showBrandList().size()).isGreaterThan(0);
    }

}
