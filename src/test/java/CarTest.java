
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
    Map<String, List<CarModel>> brandMap;
    CarModel carModel = new CarModel();


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
        assertThat(customer.showBrandList().size()).isGreaterThan(0);
    }

    @Test
    public void testBrandList() throws Exception {
        brand.setBrandName("BMW");
        assertThat(customer.brandMatch(brand, customer.showBrandList()));
    }

    //to check car model list is not empty - To do
    @Test
    public void testCarModelListIsEmpty() throws Exception {
        List<CarModel> modelList = new ArrayList<>();
        modelList.add(new CarModel("i8"));
        brandMap = Map.of("bmw", modelList);

        assertThat(Customer.showCarModels("bmw", brandMap)).size().isGreaterThan(0);

    }

    @Test
    public void testInputIsInModelList() throws Exception {
        Map<String, List<CarModel>> brandMap = Map.of("bmw", List.of(new CarModel("X5"), new CarModel("X6")), "tesla", List.of(new CarModel("S"), new CarModel("3")));
        List<CarModel> listOfModels = Customer.showCarModels("bmw", brandMap);
        assertEquals(2, listOfModels.size());
        assertEquals("X5", listOfModels.get(0).getCarModel());
        assertEquals("X6", listOfModels.get(1).getCarModel());

    }

    @Test
    public void testInputIsValid() throws Exception {
        Map<String, List<CarModel>> brandMap = Map.of("bmw", List.of(new CarModel("X5"), new CarModel("X6")), "tesla", List.of(new CarModel("S"), new CarModel("3")));
        assertThrows(Exception.class, () -> Customer.showCarModels("ew", brandMap));
    }


    }




