
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

import java.util.*;
import java.util.stream.Collectors;

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

    @Test
    public void testSortBrandsAlphabetically() throws Exception {

        List<String> listOfBrands = Customer.printListOfBrands();
        Collections.sort(listOfBrands);

        assertEquals(6, listOfBrands.size());
        assertEquals("Audi", listOfBrands.get(0));
        assertEquals("BMW", listOfBrands.get(1));

    }

    @Test
    public void testSortMileage() throws Exception {
        brand.setBrandName("bmw");

        List<CarModel> listOfModels = Customer.showCarModels(brand.getBrandName());

        List<CarModel> sortedCarModel = listOfModels.stream()
                .sorted(Comparator.comparingInt(CarModel::getMileage))
                .collect(Collectors.toList());

        assertEquals(1000, sortedCarModel.get(0).getMileage());
        assertEquals(5000, sortedCarModel.get(1).getMileage());

    }

    //testSortPrice

    //testSortYear


    }




