package za.ac.cput.factory.gender;

import za.ac.cput.util.genericHelper;

/* EmployeeGenderFactory.java
 This is an Employee Gender Factory Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: October April 2022
  */
public class EmployeeGenderFactory {
    public static za.ac.cput.domain.gender.EmployeeGender createEmployeeGender(String employeeId, String genderId){
        String employeeID = genericHelper.generateId();
        za.ac.cput.domain.gender.EmployeeGender employeeGender = new za.ac.cput.domain.gender.EmployeeGender.Builder()
                .setEmployeeId(employeeId)
                .setGenderId(genderId)
                .build();
        return employeeGender;
    }
}
