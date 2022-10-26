package za.ac.cput.factory.restaurant;

/* Order.java
   This is Order factory class
   @Author: Lihle Njobe(218193882)

 */

import za.ac.cput.domain.restaurant.Order;
import za.ac.cput.util.genericHelper;

public class OrderFactory {
    public static Order createOrder(String orderItem, String date, int amount) {
        if (genericHelper.isNullOrEmpty(orderItem) || genericHelper.isNullOrEmpty(date))
            return null;

        int orderId = genericHelper.generateIntId();
        Order order = new Order.Builder()
                .setOrderId(orderId)
                .setOrderItem(orderItem)
                .setDate(date)
                .setAmount(amount)
                .build();

        return order;

    }

    public static Order createOrder(String orderItem) {
        return null;
    }
}

