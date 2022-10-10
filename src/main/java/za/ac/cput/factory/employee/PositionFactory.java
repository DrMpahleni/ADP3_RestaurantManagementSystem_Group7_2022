/*
    PositionFactory Class
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */

package za.ac.cput.factory.employee;

import za.ac.cput.domain.employee.Position;
import za.ac.cput.util.genericHelper;

public class PositionFactory {
    public static Position createPosition(String positionName, String positionDescription, int jobId){
        if(genericHelper.isValid(positionName) && genericHelper.isValid(positionDescription) && genericHelper.isValid(jobId)){
            return new Position.Builder().setPositionName(positionName).setPositionDescription(positionDescription)
                    .setJobId(jobId).build();
        }
        return null;
    }
}
