import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class BillingGUI {

    public static void main(String[] args) throws FileNotFoundException {
        // Load customers from CSV file
        List<Customer> customers = FileUtils.loadCustomerData();

        // Initialize the frame and components
        JFrame frame = new JFrame("BSS Billing System");
        JButton generateBillButton = new JButton("Generate Bill");
        JTextArea billArea = new JTextArea(10, 30);
        billArea.setEditable(false);

        // Dropdown to select a customer
        JComboBox<String> customerComboBox = new JComboBox<>();
        for (Customer customer : customers) {
            customerComboBox.addItem(customer.getCustomerName());
        }

        generateBillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected customer from the dropdown
                String selectedCustomerName = (String) customerComboBox.getSelectedItem();
                Customer selectedCustomer = null;

                // Find the corresponding customer object
                for (Customer customer : customers) {
                    if (customer.getCustomerName().equals(selectedCustomerName)) {
                        selectedCustomer = customer;
                        break;
                    }
                }

                if (selectedCustomer != null) {
                    // Calculate the bill for the selected customer
                    BillingSystem billingSystem = new BillingSystem();
                    double bill = billingSystem.calculateBill(selectedCustomer);


                    billArea.setText("Bill for " + selectedCustomer.getCustomerName() + ":\n");
                    billArea.append("Service Plan: " + selectedCustomer.getServicePlan() + "\n");
                    billArea.append("Data Usage: " + selectedCustomer.getDataUsage() + " MB\n");
                    billArea.append("Call Minutes: " + selectedCustomer.getCallMinutes() + " mins\n");
                    billArea.append("SMS Count: " + selectedCustomer.getSmsCount() + "\n");
                    billArea.append("Total Amount: Rs." + bill);
                }
            }
        });

        // Set up the layout
        JPanel panel = new JPanel();
        panel.add(new JLabel("Select Customer:"));
        panel.add(customerComboBox);
        panel.add(generateBillButton);
        panel.add(new JScrollPane(billArea));

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
