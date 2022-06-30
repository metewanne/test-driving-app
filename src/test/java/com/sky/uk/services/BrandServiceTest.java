package com.sky.uk.services;

import com.sky.uk.model.Brand;
import com.sky.uk.model.CarModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class BrandServiceTest {
    BrandService brandService;

    @BeforeEach
    public void setUpClasses() {
        brandService = new BrandService();
    }


    @Mock
    Brand brand;
    Map<Brand, List<CarModel>> brandMap = Map.of(new Brand("bmw"), List.of(new CarModel("X5", 5000, 28000, 2019), new CarModel("X6", 1000, 20000, 2020)),
            new Brand("tesla"), List.of(new CarModel("S", 2000, 50000, 2020), new CarModel("X", 100, 40000, 2021), new CarModel("3", 45000, 55000, 2022)),
            new Brand("mercedes"), List.of(new CarModel("A-Class", 500, 30000, 2010), new CarModel(("E-Class"), 14000, 15000, 2016)),
            new Brand("audi"), List.of(new CarModel("A3", 1000, 65000, 2005), new CarModel("Q5", 5000, 40500, 2011), new CarModel("R8", 3000, 48000, 2015)),
            new Brand("ferrari"), List.of(new CarModel("488", 100, 90000, 2003), new CarModel("F8", 10000, 80000, 2012)),
            new Brand("porsche"), List.of(new CarModel("911", 400, 100000, 2000), new CarModel("Panamera", 500, 95000, 2015), new CarModel("Cayenne", 2000, 75000, 2002)));

    @Test
    public void correctBrandMatchInput() throws Exception {
        when(brand.getBrandName()).thenReturn("audi");
        String returnValue = brandService.brandMatch(brand, null);
        assertEquals("audi", returnValue);
    }

    @Test
    public void incorrectBrandMatchInput() throws Exception {
        when(brand.getBrandName()).thenReturn("invalid brand").thenReturn("audi");
        Scanner scanner = new Scanner("audi");
        String returnValue = brandService.brandMatch(brand, scanner);
        assertEquals("audi", returnValue);
        verify(brand, times(1)).setBrandName("audi");
    }

    //to check car model list is not empty - To do
    @Test
    public void testCarModelListIsEmpty() throws Exception {
        Map<Brand, List<CarModel>> brandMap = Map.of(new Brand("bmw"), List.of(new CarModel("X5"), new CarModel("X6")), new Brand("tesla"), List.of(new CarModel("S"), new CarModel("3")));
        assertThat(brandService.showCarModels("bmw")).size().isGreaterThan(0);

    }

    @Test
    public void testChosenModelIsInModelList() throws Exception {
        List<CarModel> listOfModels = brandService.showCarModels("bmw");
        assertEquals(2, listOfModels.size());
        assertEquals("X5", listOfModels.get(0).getCarModel());
        assertEquals("X6", listOfModels.get(1).getCarModel());

    }

    @Test
    public void testChosenModelIsValid() throws Exception {
        assertThrows(Exception.class, () -> brandService.showCarModels("ew"));
    }

    @Test
    public void testSortBrandsAlphabetically() throws Exception {

        List<String> listOfBrands = brandService.printListOfBrands();
        Collections.sort(listOfBrands);

        assertEquals(6, listOfBrands.size());
        assertEquals("Audi", listOfBrands.get(0));
        assertEquals("BMW", listOfBrands.get(1));
        System.out.println(listOfBrands);

    }

    @Test
    public void testSortYear() throws Exception {
        List<CarModel> sortedModelsByYear = brandService.sortCars("year", "tesla");
        assertAll(
                () -> assertEquals(2022, sortedModelsByYear.get(0).getYear()),
                () -> assertEquals(2021, sortedModelsByYear.get(1).getYear()),
                () -> assertEquals(2020, sortedModelsByYear.get(2).getYear()),
                () -> assertEquals(3, sortedModelsByYear.size())
        );
        System.out.println(sortedModelsByYear);
    }

    @Test
    public void testSortMileage() throws Exception {
        List<CarModel> sortedModelsByMileage = brandService.sortCars("mileage", "audi");
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
        List<CarModel> sortedModelsByPrice = brandService.sortCars("price", "audi");
        assertAll(
                () -> assertEquals(40500, sortedModelsByPrice.get(0).getPrice()),
                () -> assertEquals(48000, sortedModelsByPrice.get(1).getPrice()),
                () -> assertEquals(65000, sortedModelsByPrice.get(2).getPrice()),
                () -> assertEquals(3, sortedModelsByPrice.size())
        );
        System.out.println(sortedModelsByPrice);
    }

}

