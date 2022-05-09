import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        List<CarModel> modelList = new ArrayList<>();
        modelList.add(new CarModel("i8"));
        brandMap = Map.of("bmw", modelList);
        assertThat(Customer.showCarModels("bmw", brandMap)).contains("i8");
    }

//        assertThat(Customer.showCarModels(Customer.brandMatch(brandMap, b));)
//      test input is not empty
//      test to check that input is in model list


}
