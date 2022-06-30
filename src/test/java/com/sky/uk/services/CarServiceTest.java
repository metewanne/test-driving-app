package com.sky.uk.services;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceTest {
    CarService carService;

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
        carService = new CarService();
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
        assertThat(carService.brandsAndCarModels.size()).isGreaterThan(0);
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




