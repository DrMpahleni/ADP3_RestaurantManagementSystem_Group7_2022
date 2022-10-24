package za.ac.cput.factory.employee;
/* EmployeeContactFactory.java
 This is a Employee Contact Factory Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
import za.ac.cput.domain.employeeContact.EmployeeContact;
import za.ac.cput.util.genericHelper;

public class EmployeeContactFactory {
    public static EmployeeContact createEmployeeContact(String employeeId, String contactTypeId, String contact) {

        String employeeID = genericHelper.generateId();
        EmployeeContact employeeContact = new EmployeeContact.Builder().
                setEmployeeID(employeeID)
                .setContactTypeId(contactTypeId)
                .setContact(contact)
                .build();
        return employeeContact;

    }
}