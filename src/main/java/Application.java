import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws Exception {

        CarService carService = new CarService();
        Customer customer = new Customer();

        System.out.println(carService.getBrandMap());
        Scanner customerInput = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = customerInput.next();
        customer.inputCustomerName(firstName);

        System.out.println("Enter surname");
        String surname = customerInput.next();
        customer.inputCustomerName(surname);

        System.out.println("Enter email address");
        String email = customerInput.next();
        customer.validateEmail(email);

        CarModel selectedCar = carService.selectCarBooking(customerInput);
        String choice = carService.confirmationOfCarModel(customerInput, selectedCar);
        carService.confirmBooking(choice);
        /*
        String choice1 = customerInput.next();
        CarModel selectedCar = (CarModel) carService.getBrandMap().get(choice1);
        System.out.println(selectedCar);
        String choice = carService.confirmationOfCarModel(customerInput, selectedCar);
        carService.confirmBooking(choice);
        */

        System.out.println(selectedCar);
        System.out.println(carService.removeCarModelFromList(selectedCar));
        System.out.println(carService.addToBookingList(selectedCar));

    }



    }
