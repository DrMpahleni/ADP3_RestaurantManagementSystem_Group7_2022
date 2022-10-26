package za.ac.cput.domain.restaurant;

/* Order.java
   This is Order domain class
   @Author: Lihle Njobe(218193882)
 */


import java.io.Serializable;

public class Order implements Serializable {

    private int orderId;
    private String orderItem;
    private String date;
    private int amount;

    public Order() {

    }

    private Order (Builder builder) {
        this.orderId = builder.orderId;
        this.orderItem = builder.orderItem;
        this.date = builder.date;
        this.amount = builder.amount;

    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderItem='" + orderItem + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }
    public static class Builder {
        private int orderId;
        private String orderItem;
        private String date;
        private int amount;

        public Builder setOrderId(int orderId) {
            this.orderId = orderId;

            return this;
        }

        public Builder setOrderItem(String orderItem) {
            this.orderItem = orderItem;

            return this;
        }

        public Builder setDate(String date) {
            this.date = date;

            return this;
        }

        public Builder setAmount(int amount) {
            this.amount = amount;

            return this;
        }

        public Order build () {
            return new Order(this);
        }
        public Builder copy(Order order) {
            this.orderId = order.orderId;
            this.orderItem = order.orderItem;
            this.date = order.date;
            this.amount = order.amount;

            return this;

        }

    }
}
