package za.ac.cput.factory.employee;

import za.ac.cput.domain.employee.Employee;
import za.ac.cput.util.genericHelper;

public class EmployeeFactory {

    public static Employee createEmployee(String firstName, String lastName) {

        if (genericHelper.isNullOrEmpty(firstName) || genericHelper.isNullOrEmpty(lastName))
            return null;

        String employeeId = genericHelper.generateId();

        Employee employee = new Employee.Builder().setEmployeeId(employeeId).
                setFirstName(firstName).
                setLastName(lastName).
                build();

        return employee;
    }
}
