
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class CarTest {

    Customer customer = new Customer();
    Brand brand = new Brand();

    //@Test
    //Check that car class exists
    @Test
    public void testClassExists() {
        try {
            Class.forName("CarModel");
        } catch (ClassNotFoundException e) {
            Assert.fail("Should have class called Car");
        }
    }

    @Test
    public void testEmptyList() throws Exception {
        //assertThat(customer.showBrandList().size()).isGreaterThan(0);
        assertThat(customer.brandMap.size()).isGreaterThan(0);
    }

    @Test
    public void testBrandList() throws Exception {
        brand.setBrandName("hfrukdk");
        assertThat(customer.brandMap.get(brand.getBrandName()));
    }

    //to check car model list is not empty - To do
    @Test
    public void testCarModelListIsEmpty() throws Exception {
        Map<Brand, List<CarModel>> brandMap = Map.of(new Brand("bmw"), List.of(new CarModel("X5"), new CarModel("X6")), new Brand("tesla"), List.of(new CarModel("S"), new CarModel("3")));
        assertThat(Customer.showCarModels("bmw")).size().isGreaterThan(0);

    }

    @Test
    public void testChosenModelIsInModelList() throws Exception {
        Map<Brand, List<CarModel>> brandMap = Map.of(new Brand("bmw"), List.of(new CarModel("X5"), new CarModel("X6")), new Brand("tesla"), List.of(new CarModel("S"), new CarModel("3")));
        List<CarModel> listOfModels = Customer.showCarModels("bmw");
        assertEquals(2, listOfModels.size());
        assertEquals("X5", listOfModels.get(0).getCarModel());
        assertEquals("X6", listOfModels.get(1).getCarModel());

    }

    @Test
    public void testChosenModelIsValid() throws Exception {
        Map<Brand, List<CarModel>> brandMap = Map.of(new Brand("bmw"), List.of(new CarModel("X5"), new CarModel("X6")), new Brand("tesla"), List.of(new CarModel("S"), new CarModel("3")));
        assertThrows(Exception.class, () -> Customer.showCarModels("ew"));
    }


    }




