import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVCreator {
    public static void main(String[] args) {
        // Sample customer data
        String[][] customers = {
                {"1", "John Doe", "Basic", "500", "120", "50"},
                {"2", "Jane Smith", "Premium", "800", "150", "75"},
                {"3", "Michael Brown", "Premium", "1200", "180", "100"},
                {"4", "Emily Davis", "Basic", "400", "100", "30"},
                {"5", "David Wilson", "Premium", "1500", "200", "150"},
                {"6", "Olivia Johnson", "Basic", "600", "130", "60"},
                {"7", "James White", "Premium", "1000", "170", "90"},
                {"8", "Sophia Harris", "Basic", "700", "140", "80"},
                {"9", "Daniel Clark", "Premium", "1300", "190", "120"},
                {"10", "Charlotte Lewis", "Basic", "450", "110", "40"}
        };

        // Define the CSV file path
        String csvFile = "customers.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            // Write the header row
            writer.write("Customer ID,Customer Name,Service Plan,Data Usage (MB),Call Minutes,SMS Count");
            writer.newLine();

            // Write the customer data
            for (String[] customer : customers) {
                writer.write(String.join(",", customer));
                writer.newLine();
            }

            System.out.println("CSV file '" + csvFile + "' created successfully with sample data.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
