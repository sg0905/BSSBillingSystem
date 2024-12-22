
/* MODEL class */

public class Customer {
    private String CustomerName;
    private int customerId;
    private String servicePlan;
    private int dataUsage;
    private int callMinutes;
    private int smsCount;

    // Creating constructor for Customer
    Customer(String CustomerName, int customerId, String servicePlan, int dataUsage, int callMinutes, int smsCount) {
        this.CustomerName = CustomerName;
        this.customerId = customerId;
        this.servicePlan = servicePlan;
        this.dataUsage = dataUsage;
        this.callMinutes = callMinutes;
        this.smsCount = smsCount;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getServicePlan() {
        return servicePlan;
    }

    public void setServicePlan(String servicePlan) {
        this.servicePlan = servicePlan;
    }

    public int getDataUsage() {
        return dataUsage;
    }

    public void setDataUsage(int dataUsage) {
        this.dataUsage = dataUsage;
    }

    public int getCallMinutes() {
        return callMinutes;
    }

    public void setCallMinutes(int callMinutes) {
        this.callMinutes = callMinutes;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }
}
