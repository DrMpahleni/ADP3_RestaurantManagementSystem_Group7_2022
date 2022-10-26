package za.ac.cput.factory.race;

/* EmployeeRaceFactory.java
   This is Employee Race domain class
   @Author: Lihle Njobe(218193882)

 */

import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.util.genericHelper;

public class EmployeeRaceFactory {
    public static EmployeeRace createEmployeeRace(String raceName) {
        if (genericHelper.isNullOrEmpty(raceName))
            return null;

        int raceId = genericHelper.generateIntId();
        EmployeeRace employeeRace = new EmployeeRace.Builder().setRaceId(raceId)
                .setRaceName(raceName)
                .build();

        return employeeRace;


    }
}
