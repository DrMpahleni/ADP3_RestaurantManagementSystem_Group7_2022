package za.ac.cput.factory.gender;
/* GenderFactory.java
 This is a Gender Factory Class
 Author: Vuyisa Nkangana(218192215)
 Due Date: 10 April 2022
  */
import za.ac.cput.domain.gender.Gender;
import za.ac.cput.util.genericHelper;


public class GenderFactory {
    public static Gender createGender(String Id, String name){
        String ID = genericHelper.generateId();
        Gender gender = new Gender.Builder().setId(Id)
                .setName(name)
                .build();
        return gender;
    }
}
