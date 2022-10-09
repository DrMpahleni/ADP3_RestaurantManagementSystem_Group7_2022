/*
    Employee.java
    Employee domain
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.domain.employee;

import java.io.Serializable;

public class Employee implements Serializable {

    private String employeeId;
    private String firstName;
    private String lastName;

    public Employee() {
    }

    private Employee (Builder builder) {

        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getEmployeeId() {

        return employeeId;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder {

        private String employeeId, firstName, lastName;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;

            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;

            return this;
        }

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;

            return this;
        }

        public Employee build () {

            return new Employee(this);
        }

        public Builder copy(Employee employee) {
            this.employeeId = employee.employeeId;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;

            return this;
        }
    }
}
