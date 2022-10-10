package za.ac.cput.domain.role;


/* manager.java
Entity for the Manager
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import java.io.Serializable;


public class Manager implements Serializable {

    private int managerID;
    private int positionID;
    private String fisrtName;
    private String lastName;
    private String phoneNo;
    private String emailAddress;

    protected Manager() {

    }

    private Manager(Builder builder) {

        this.managerID = builder.managerID;
        this.positionID = builder.positionID;
        this.fisrtName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNo = builder.phoneNo;
        this.emailAddress = builder.emailAddress;
    }

    public Integer getPositionID() {
        return positionID;
    }
    public Integer getManagerID() {
        return managerID;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }



    @Override
    public String toString() {
        return "Manager{" +
                "managerID=" + managerID +
                ", positionID=" + positionID +
                ", fisrtName='" + fisrtName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public static class Builder
    {
        private int managerID;
        private int positionID;
        private String firstName;
        private String lastName;
        private String phoneNo;
        private String emailAddress;


        public Builder setManagerID(int managerID) {
            this.managerID = managerID;
            return this;
        }
        public Builder setPositionID(int positionID) {
            this.positionID = positionID;
            return this;
        }
        //Set Firstname
        public Builder setFirstName(String firstName)
        {
            this.firstName= firstName;
            return this;
        }
        //Set Lastname
        public Builder setLastName(String lastName)
        {
            this.lastName= lastName;
            return this;
        }

        //Set PhoneNumber
        public Builder setPhoneNo(String phoneNo)
        {
            this.phoneNo= phoneNo;
            return this;
        }

        //Set EmailAddress
        public Builder setEmailAddress(String emailAddress)
        {
            this.emailAddress= emailAddress;
            return this;
        }

        //Copy method
        public Builder copy(Manager manager)
        {
            this.managerID = manager.managerID;
            this.positionID = manager.positionID;
            this.firstName= manager.fisrtName;
            this.lastName= manager.lastName;
            this.phoneNo= manager.phoneNo;
            this.emailAddress= manager.emailAddress;
            return this;
        }

        public Manager build()
        {
            return new Manager(this);
        }
    }

}
