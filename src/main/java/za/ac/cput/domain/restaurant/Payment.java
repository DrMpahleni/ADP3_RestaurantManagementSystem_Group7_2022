/*
    Payment.java
    Payment domain
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.domain.restaurant;

import java.io.Serializable;

public class Payment implements Serializable {

    private String paymentId;
    private String customerId;
    private String orderID;
    private int amount;
    private String paymentType;

    public Payment() {
    }

    private Payment (Builder builder) {
        this.paymentId = builder.paymentId;
        this.customerId = builder.customerId;
        this.orderID = builder.orderId;
        this.paymentType = builder.paymentType;
        this.amount = builder.amount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getOrderID() {
        return orderID;
    }

    public int getAmount() {
        return amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderID='" + orderID + '\'' +
                ", amount=" + amount +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }

    public static class Builder {
        private String paymentId, customerId, orderId, paymentType;
        private int amount;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;

            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;

            return this;
        }

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;

            return this;
        }

        public Builder setPaymentType(String paymentType) {
            this.paymentType = paymentType;

            return this;
        }

        public Builder setAmount(int amount) {
            this.amount = amount;

            return this;
        }

        public Payment build () {
            return new Payment(this);
        }

        public Builder copy (Payment payment) {
            this.paymentId = payment.paymentId;
            this.customerId = payment.customerId;
            this.orderId = payment.orderID;
            this.paymentType = payment.paymentType;
            this.amount = payment.amount;

            return this;
        }
    }
}
