/*
    ChefFactory Class
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.factory.role;

import za.ac.cput.domain.role.Chef;
import za.ac.cput.util.genericHelper;

public class ChefFactory {
    public static Chef createChef(int positionId){
        if(genericHelper.isValid(positionId)){
            return new Chef.Builder().setPositionId(positionId).build();
        }
        return null;
    }
}
