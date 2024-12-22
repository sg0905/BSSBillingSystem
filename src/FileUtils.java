import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    // Method to save customer data to CSV file
    public static void saveCustomerData(Customer customer) throws IOException {
//        // Check if the directory exists; if not, create it
//        File directory = new File("resources");
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }

        // Append customer data to the CSV file
        try (FileWriter writer = new FileWriter("resources/customers.csv", true)) {
            writer.append(customer.getCustomerId() + ","
                    + customer.getCustomerName() + ","
                    + customer.getServicePlan() + ","
                    + customer.getDataUsage() + ","
                    + customer.getCallMinutes() + ","
                    + customer.getSmsCount() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Error saving customer data to file", e);
        }
    }

    // Method to load customer data from CSV file
    public static List<Customer> loadCustomerData() {
        List<Customer> customers = new ArrayList<>();

        // Ensure the file exists before reading it
        File file = new File("customers.csv");
        if (!file.exists()) {
            System.out.println("Customer data file not found.");
            return customers;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip the header line if it exists
                if (line.startsWith("Customer ID")) {
                    continue; // Skip header row
                }

                String[] data = line.split(",");
                if (data.length == 6) {
                    try {
                        // Parse the data
                        int customerId = Integer.parseInt(data[0].trim());
                        String customerName = data[1].trim();
                        String servicePlan = data[2].trim();
                        int dataUsage = Integer.parseInt(data[3].trim());
                        int callMinutes = Integer.parseInt(data[4].trim());
                        int smsCount = Integer.parseInt(data[5].trim());

                        // Create a Customer object and add it to the list
                        Customer customer = new Customer( customerName,customerId, servicePlan, dataUsage, callMinutes, smsCount);
                        customers.add(customer);

                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid data line: " + line);
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading customer data file", e);
        }
        return customers;
    }
}
