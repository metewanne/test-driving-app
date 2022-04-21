public class Customer {

    public String inputCustomerName(String customerName) throws Exception {
        if (customerName == null || customerName.trim().equals("")) {
            throw new Exception("Incorrect input");
        }
        return "Hi";

    }

}
