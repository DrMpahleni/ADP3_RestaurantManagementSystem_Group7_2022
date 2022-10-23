package za.ac.cput.factory.contactType;

import za.ac.cput.domain.contactType.ContactType;
import za.ac.cput.util.genericHelper;

/* EmployeeContactFactory.java
 This is a Contact Type Factory Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: October 2022
  */
public class ContactTypeFactory {
    public static ContactType createContactType(String Id, String name){
        String ID = genericHelper.generateId();
        ContactType contactType = new ContactType.Builder().setId(Id)
                .setName(name)
                .build();
        return contactType;
    }
}
