import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Load customer data
        List<Customer> customers = FileUtils.loadCustomerData();

        // Print customer details (for testing)
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Customer Name: " + customer.getCustomerName());
            System.out.println("Service Plan: " + customer.getServicePlan());
            System.out.println("Data Usage: " + customer.getDataUsage() + " MB");
            System.out.println("Call Minutes: " + customer.getCallMinutes() + " mins");
            System.out.println("SMS Count: " + customer.getSmsCount());
            System.out.println("----------------------------");
        }
    }
}
