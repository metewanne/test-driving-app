import com.sky.uk.model.Brand;
import com.sky.uk.model.CarModel;
import com.sky.uk.model.Customer;
import com.sky.uk.services.CarService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class CarServiceTest {


    Customer customer;
    CarService carService;
    Scanner customerInput = new Scanner(System.in);

    @Mock
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
    can declare the instance and create a method to assign a new object to the instance.

    @Before Each will initiate a new object for each test method in the test class. No longer need to initialise the
    object in each test method and stops duplication.
     */
    @BeforeEach
    public void setUpClasses(){
        customer = new Customer();
        carService = new CarService();
//        brand = new com.sky.uk.model.Brand("abc");

    }

    @Test
    public void testClassExists() {
        try {
            Class.forName("com.sky.uk.model.CarModel");
        } catch (ClassNotFoundException e) {
            Assert.fail("Should have class called Car");
        }
    }

    @Test
    public void testEmptyList() throws Exception {
        assertThat(carService.getBrandMap().size()).isGreaterThan(0);
    }

    @Test
    public void correctBrandMatchInput() throws Exception {
        when(brand.getBrandName()).thenReturn("audi");
        String returnValue = carService.brandMatch(brand, null);
        assertEquals("audi", returnValue);
    }

    @Test
    public void incorrectBrandMatchInput() throws Exception {
        when(brand.getBrandName()).thenReturn("invalid brand").thenReturn("audi");
        Scanner scanner = new Scanner("audi");
        String returnValue = carService.brandMatch(brand, scanner);
        assertEquals("audi", returnValue);
        verify(brand, times(1)).setBrandName("audi");
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
        System.out.println(listOfBrands);

    }

    @Test
    public void testSortMileage() throws Exception {
       List<CarModel> sortedModelsByMileage = carService.sortCars("mileage", "audi");
        assertAll(
                () -> assertEquals(1000, sortedModelsByMileage.get(0).getMileage()),
                () -> assertEquals(3000, sortedModelsByMileage.get(1).getMileage()),
                () -> assertEquals(5000, sortedModelsByMileage.get(2).getMileage()),
                () -> assertEquals(3, sortedModelsByMileage.size())
        );
        System.out.println(sortedModelsByMileage);

    }

    @Test
    public void testSortPrice() throws Exception {
        List<CarModel> sortedModelsByPrice = carService.sortCars("price", "audi");
        assertAll(
                () -> assertEquals(40500, sortedModelsByPrice.get(0).getPrice()),
                () -> assertEquals(48000, sortedModelsByPrice.get(1).getPrice()),
                () -> assertEquals(65000, sortedModelsByPrice.get(2).getPrice()),
                () -> assertEquals(3, sortedModelsByPrice.size())
        );
        System.out.println(sortedModelsByPrice);
    }

    @Test
    public void testSortYear() throws Exception {
        List<CarModel> sortedModelsByYear = carService.sortCars("year", "tesla");
        assertAll(
                () -> assertEquals(2022, sortedModelsByYear.get(0).getYear()),
                () -> assertEquals(2021, sortedModelsByYear.get(1).getYear()),
                () -> assertEquals(2020, sortedModelsByYear.get(2).getYear()),
                () -> assertEquals(3, sortedModelsByYear.size())
        );
        System.out.println(sortedModelsByYear);
    }




    // test that checks that a car is removed from list
//    @Test
//    public void testThatCarIsRemovedFromAvailabilityList() throws Exception {
//        List<com.sky.uk.model.CarModel> listWithoutSelectedCar = carService.removeCarModelFromAvailabilityList("bmw", "x5");
//        fail();
//    }

    // test that checks that the confirmed car is added to new list

    //test that checks if one of the car models are there

    // test that if selectedCar is not null



    }




