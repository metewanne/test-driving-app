import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws Exception {

        Scanner customerInput = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = customerInput.next();
        Customer.inputCustomerName(firstName);

        System.out.println("Enter surname");
        String surname = customerInput.next();
        Customer.inputCustomerName(surname);

        System.out.println("Enter email address");
        String email = customerInput.next();
        Customer.patternMatches(email, "^(.+)@(\\S+)$");

        System.out.println("Do you want to see the brands in alphabetic order?");
        String userChoice = customerInput.next().toLowerCase();
        CarService.chooseToSortBrands(userChoice);

        Brand chosenBrand = new Brand();
        String brandInput = customerInput.next();
        chosenBrand.setBrandName(brandInput);
        String brandName = CarService.brandMatch(chosenBrand, CarService.brandMap);

        System.out.println("\n" + "Do you want to sort the cars by mileage or price or year? If not, please type no");
        String sortChoice = customerInput.next().toLowerCase();
        System.out.println("Please select a car model:");
        CarService.sortCars(sortChoice, brandName);
        String modelChoice = customerInput.next();
        CarModel model = new CarModel();
        model.setCarModelName(modelChoice);
        System.out.println(CarService.checkCarModel(brandName, modelChoice));

    }
}
