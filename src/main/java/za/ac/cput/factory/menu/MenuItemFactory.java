package za.ac.cput.factory.menu;

/* menuItemFactory.java
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/

import za.ac.cput.domain.menu.MenuItem;
import za.ac.cput.util.genericHelper;

public class MenuItemFactory {

    public static MenuItem createMenuItem(String portion,Double price) {

        int menuItemID = genericHelper.generateIntId();
        MenuItem menuItem= new MenuItem.Builder()
                .setMenuItemID(menuItemID)
                .setPortion(portion)
                .setPrice(price)
                .build();

        return menuItem;
    }
}
