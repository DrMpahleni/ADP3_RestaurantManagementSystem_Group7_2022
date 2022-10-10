package za.ac.cput.factory.menu;

/* MenuFactory.java
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import za.ac.cput.domain.menu.Menu;
import za.ac.cput.util.genericHelper;

public class MenuFactory {

    public static Menu createMenu(String name) {

        int menuID = genericHelper.generateIntId();
        Menu menu= new Menu.Builder()
                .setMenuID(menuID)
                .setName(name)
                .build();

        return menu;
    }
}
