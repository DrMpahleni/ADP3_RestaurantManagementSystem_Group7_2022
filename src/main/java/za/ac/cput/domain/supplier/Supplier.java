package za.ac.cput.domain.supplier;

/* Supplier.java
Entity for the supplier
Author: Bongisa Mpahleni (216205999)
Date: 02 April 2022
*/



import java.io.Serializable;


public class Supplier implements Serializable {

    private int supplierID;
    private String supplierName;
    private String supplierEmail;
    private String supplierPhone;
    private String supplierAddress;

    protected Supplier() {

    }

    private Supplier(Builder builder) {

        this.supplierID = builder.supplierID;
        this.supplierName = builder.supplierName;
        this.supplierEmail = builder.supplierEmail;
        this.supplierPhone = builder.supplierPhone;
        this.supplierAddress = builder.supplierAddress;
    }


    public Integer getSupplierID() {
        return supplierID;
    }
    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }


    @Override
    public String toString() {
        return "supplier{" +
                "supplierID=" + supplierID +
                ", supplierName='" + supplierName + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                '}';
    }

    public static class Builder
    {
        private int supplierID;
        private String supplierName;
        private String supplierEmail;
        private String supplierPhone;
        private String supplierAddress;


        public Builder setSupplierID(int supplierID) {
            this.supplierID = supplierID;
            return this;
        }
        public Builder setSupplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder setSupplierEmail(String supplierEmail)
        {
            this.supplierEmail= supplierEmail;
            return this;
        }

        public Builder setSupplierPhone(String supplierPhone)
        {
            this.supplierPhone= supplierPhone;
            return this;
        }


        public Builder setSupplierAddress(String supplierAddress)
        {
            this.supplierAddress= supplierAddress;
            return this;
        }


        //Copy method
        public Builder copy(Supplier supplier)
        {
            this.supplierID = supplier.supplierID;
            this.supplierName = supplier.supplierName;
            this.supplierEmail= supplier.supplierEmail;
            this.supplierPhone= supplier.supplierPhone;
            this.supplierAddress= supplier.supplierAddress;
            return this;
        }

        public Supplier build()
        {
            return new Supplier(this);
        }
    }

}
