/*
    WaiterFactory Class
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.factory.role;

import za.ac.cput.domain.role.Waiter;

import za.ac.cput.util.genericHelper;

public class WaiterFactory {
    public static Waiter createWaiter(int positionId){
        if(genericHelper.isValid(positionId)){
            return new Waiter.Builder().setPositionId(positionId).build();
        }
        return null;
    }
}
