package za.ac.cput.factory.role;

/* managerFactory.java
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import za.ac.cput.domain.role.Manager;
import za.ac.cput.util.genericHelper;

public class ManagerFactory {

    public static Manager createManager(int positionID,  String firstName, String lastName,String phoneNo, String emailAddress) {

        int managerID = genericHelper.generateIntId();
        Manager manager= new Manager.Builder()
                .setManagerID(managerID)
                .setPositionID(positionID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNo(phoneNo)
                .setEmailAddress(emailAddress)
                .build();

        return manager;
    }
}
