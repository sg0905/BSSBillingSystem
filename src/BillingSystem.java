/* ----------LOGIC Class-------
*
*
* Basic plan fees = 10
* Advance plan fees = 20 */


public class BillingSystem {
    public double calculateBill(Customer customer) {
        double totalAmount = 0;

        if(customer.getServicePlan().equals("Basic")){
            totalAmount += 10;
        }
        if(customer.getServicePlan().equals("Advanced")){
            totalAmount += 20;
        }
        totalAmount += customer.getDataUsage()*0.1;
        totalAmount += customer.getCallMinutes()*0.05;
        totalAmount += customer.getSmsCount()*0.02;

        return totalAmount;
    }
}
