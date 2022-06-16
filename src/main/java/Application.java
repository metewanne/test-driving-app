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

        CarModel selectedCar = new CarModel();
        String choice = carService.confirmationOfCarModel(customerInput, selectedCar);
        carService.confirmBooking(choice);

        System.out.println(carService.removeCarModelFromList(selectedCar));

    }



    }
