import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class CarServiceTest {


    Customer customer;
    CarService carService;
    Brand brand;

    Map<Brand, List<CarModel>> brandMap = Map.of(new Brand("bmw"), List.of(new CarModel("X5", 5000, 28000, 2019), new CarModel("X6", 1000, 20000, 2020)),
            new Brand("tesla"), List.of(new CarModel("S", 2000, 50000, 2020), new CarModel("X", 100, 40000, 2021), new CarModel("3", 45000, 55000, 2022)),
            new Brand("mercedes"), List.of(new CarModel("A-Class", 500, 30000, 2010), new CarModel(("E-Class"), 14000, 15000, 2016)),
            new Brand("audi"), List.of(new CarModel("A3", 1000, 65000, 2005), new CarModel("Q5", 5000, 40500, 2011), new CarModel("R8", 3000, 48000, 2015)),
            new Brand("ferrari"), List.of(new CarModel("488", 100, 90000, 2003), new CarModel("F8", 10000, 80000, 2012)),
            new Brand("porsche"), List.of(new CarModel("911", 400, 100000, 2000), new CarModel("Panamera", 500, 95000, 2015), new CarModel("Cayenne", 2000, 75000, 2002)));

    //Notes on Testing:
    //You want to initialise a new object to each test
    //@Test - starts from a clean slate by using the object within the class.
    //Test methods should not be dependent on other test methods


    /*
    Methods should have their own initialised object for each test - Instead of creating an object for each method you
    can declare the instance and create a method to assign an new object to the instance.

    @Before Each will initiate a new object for each test method in the test class. No longer need to initialise the
    object in each test method and stops duplication.
     */
    @BeforeEach
    public void setUpClasses(){
        customer = new Customer();
        carService = new CarService();
        brand = new Brand();
    }

    @Test
    public void testBrandMatch() throws Exception {


    }

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
        assertThat(carService.brandMap.size()).isGreaterThan(0);
    }

    @Test
    public void testBrandList() throws Exception {
        brand.setBrandName("hfrukdk");
        assertThat(carService.brandMap.get(brand.getBrandName()));
    }

    //to check car model list is not empty - To do
    @Test
    public void testCarModelListIsEmpty() throws Exception {
        Map<Brand, List<CarModel>> brandMap = Map.of(new Brand("bmw"), List.of(new CarModel("X5"), new CarModel("X6")), new Brand("tesla"), List.of(new CarModel("S"), new CarModel("3")));
        assertThat(carService.showCarModels("bmw")).size().isGreaterThan(0);

    }

    @Test
    public void testChosenModelIsInModelList() throws Exception {
        List<CarModel> listOfModels = carService.showCarModels("bmw");
        assertEquals(2, listOfModels.size());
        assertEquals("X5", listOfModels.get(0).getCarModel());
        assertEquals("X6", listOfModels.get(1).getCarModel());

    }

    @Test
    public void testChosenModelIsValid() throws Exception {
        assertThrows(Exception.class, () -> carService.showCarModels("ew"));
    }

    @Test
    public void testSortBrandsAlphabetically() throws Exception {

        List<String> listOfBrands = carService.printListOfBrands();
        Collections.sort(listOfBrands);

        assertEquals(6, listOfBrands.size());
        assertEquals("Audi", listOfBrands.get(0));
        assertEquals("BMW", listOfBrands.get(1));

    }

   /*
   testSortMileage
   testSortPrice
   testSortYear

   They need to be combined to just test the method opposed to writing a test for each element.

    */

    @Test
    public void testSortMileage() throws Exception {
        brand.setBrandName("bmw");

        List<CarModel> listOfModels = carService.showCarModels(brand.getBrandName());

        List<CarModel> sortedCarModel = listOfModels.stream()
                .sorted(Comparator.comparingInt(CarModel::getMileage))
                .collect(Collectors.toList());

        assertEquals(1000, sortedCarModel.get(0).getMileage());
        assertEquals(5000, sortedCarModel.get(1).getMileage());

    }

    @Test
    public void testSortPrice() throws Exception {
        brand.setBrandName("bmw");
        List<CarModel> listOfModels = carService.showCarModels(brand.getBrandName());

        List<CarModel> sortedCarPrice = listOfModels.stream()
                .sorted(Comparator.comparingDouble(CarModel::getPrice))
                .collect(Collectors.toList());

        assertEquals(20000, sortedCarPrice.get(0).getPrice());
        assertEquals(28000, sortedCarPrice.get(1).getPrice());
    }

    @Test
    public void testSortYear() throws Exception {
        brand.setBrandName("bmw");
        List<CarModel> listOfModels = carService.showCarModels(brand.getBrandName());

        List<CarModel> sortedCarYear = listOfModels.stream()
                .sorted(Comparator.comparingInt(CarModel::getYear))
                .collect(Collectors.toList());

        assertEquals(2019, sortedCarYear.get(0).getYear());
        assertEquals(2020, sortedCarYear.get(1).getYear());
    }

    }




