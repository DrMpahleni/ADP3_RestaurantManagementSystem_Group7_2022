package za.ac.cput.domain.employeeContact;
/* EmployeeContact.java
 This is an Employee Contact Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: October 2022
  */
import java.io.Serializable;

public class EmployeeContact implements Serializable {
    private String  employeeId;
    private String contactTypeId;
    private String contact;

    public EmployeeContact(){

    }
    private EmployeeContact (Builder builder){
        this.employeeId = builder.employeedId;
        this.contactTypeId = builder.contactTypeId;
        this.contact = builder.contact;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getContactTypeId() {
        return contactTypeId;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "EmployeeContact{" +
                "employeeID=" + employeeId +
                ", contactTypeID=" + contactTypeId +
                ", contact='" + contact + '\'' +
                '}';
    }
    public static class Builder{
        private String employeedId;
        private String contactTypeId;
        private String contact;


        public Builder setEmployeeID(String employeeId){
            this.employeedId = employeeId;
            return this;
        }

        public Builder setContactTypeId(String contactTypeId) {
            this.contactTypeId = contactTypeId;
            return this;
        }

        public Builder setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public EmployeeContact build(){
            return new EmployeeContact(this);
        }

        public Builder copy(EmployeeContact employeeContact){
            this.employeedId = employeeContact.employeeId;
            this.contactTypeId = employeeContact.getContactTypeId();
            this.contact = employeeContact.contact;
            return this;
        }

    }
}
