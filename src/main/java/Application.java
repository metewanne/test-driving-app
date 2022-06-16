import java.util.ArrayList;
import java.util.List;
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

        String customerChoice;
        CarModel selectedCar;

        do {
            selectedCar = carService.selectCarBooking(customerInput);
            System.out.println("\n" + "Do you want to confirm booking for " + selectedCar.getBrand() + " " +
                    carService.checkCarModel(selectedCar.getBrand(), selectedCar.getCarModel()) + "?");
            customerChoice = customerInput.next();
            while (!customerChoice.equals("no") || !customerChoice.equals("n") || !customerChoice.equals("yes") || !customerChoice.equals("y")) {
                System.out.println("Please enter yes or no");
            }
        }
        while (customerChoice.equals("no") || customerChoice.equals("n"));
        carService.confirmBooking(customerChoice);

        System.out.println(carService.removeCarModelFromList(selectedCar));




    }



    }
