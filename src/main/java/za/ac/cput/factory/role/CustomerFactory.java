package za.ac.cput.factory.role;

import za.ac.cput.domain.role.Customer;
import za.ac.cput.util.genericHelper;

public class CustomerFactory {

    public static Customer createCustomer(String customerId, String customerName) {
        String customerID = genericHelper.generateId();
        Customer customer = new Customer.Builder()
                .setCustomerId(customerId)
                .setCustomerName(customerName)
                .build();
        return customer;

    }
}