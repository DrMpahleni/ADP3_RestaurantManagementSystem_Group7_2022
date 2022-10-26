package za.ac.cput.factory.race;

/* RaceFactory.java
   This is a Race factory class
   @Author: Lihle Njobe(218193882)
 */


import za.ac.cput.domain.race.Race;
import za.ac.cput.util.genericHelper;

public class RaceFactory {
    public static Race createRace(String name) {
        if (genericHelper.isNullOrEmpty(name))
            return null;

        int id = genericHelper.generateIntId();
        Race race = new Race.Builder().setId(id)
                .setName(name)
                .build();
        return race;
    }

}

