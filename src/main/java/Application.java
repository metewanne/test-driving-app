import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws Exception {

        CarService carService = new CarService();
        Customer customer = new Customer();

        Scanner customerInput = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = customerInput.next();
        customer.inputCustomerName(firstName);

        System.out.println("Enter surname");
        String surname = customerInput.next();
        customer.inputCustomerName(surname);

        System.out.println("Enter email address");
        String email = customerInput.next();
        customer.patternMatches(email, "^(.+)@(\\S+)$");

        System.out.println("Do you want to see the brands in alphabetic order?");
        String userChoice = customerInput.next().toLowerCase();
        carService.chooseToSortBrands(userChoice);

        Brand chosenBrand = new Brand();
        String brandInput = customerInput.next();
        chosenBrand.setBrandName(brandInput);
        String brandName = carService.brandMatch(chosenBrand, carService.brandMap);

        System.out.println("\n" + "Do you want to sort the cars by mileage or price or year? If not, please type no");
        String sortChoice = customerInput.next().toLowerCase();
        System.out.println("Please select a car model:");
        carService.sortCars(sortChoice, brandName);
        String modelChoice = customerInput.next();
        CarModel model = new CarModel();
        model.setCarModelName(modelChoice);
        System.out.println(carService.checkCarModel(brandName, modelChoice));

    }
}
