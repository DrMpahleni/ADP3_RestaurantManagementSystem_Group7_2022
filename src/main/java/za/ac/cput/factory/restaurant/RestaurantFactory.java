package za.ac.cput.factory.restaurant;

import za.ac.cput.domain.restaurant.Restaurant;
import za.ac.cput.util.genericHelper;

public class RestaurantFactory {

    public static Restaurant createRestaurant(String name, String address, int phone) {

        if (genericHelper.isNullOrEmpty(name) || genericHelper.isNullOrEmpty(address))
            return null;

        Restaurant restaurant = new Restaurant.Builder().setName(name).
                setAddress(address).
                setPhone(phone).
                build();

        return restaurant;
    }
}
