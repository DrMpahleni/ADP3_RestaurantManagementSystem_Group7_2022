package za.ac.cput.domain.restaurant;

import java.io.Serializable;

public class Reservation implements Serializable {

    private String name;
    private String amount;
    private String date;
    private String peoplePax;
    private String tblNum;

    public Reservation(){

    }

    private Reservation(Reservation.Builder builder){

        this.name = builder.name;
        this.amount = builder.amount;
        this.date = builder.date;
        this.peoplePax = builder.peoplePax;
        this.tblNum = builder.tblNum;


    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getPeoplePax() {
        return peoplePax;
    }

    public String getTblNum() {
        return tblNum;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeoplePax(String peoplePax) {
        this.peoplePax = peoplePax;
    }

    public void setTblNum(String tblNum) {
        this.tblNum = tblNum;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Reservation{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", peoplePax='" + peoplePax + '\'' +
                ", tblNum='" + tblNum + '\'' +
                '}';
    }

    public static class Builder{

        private String name;
        private String amount;
        private String date;
        private String peoplePax;
        private String tblNum;

        public Reservation.Builder setName(String name){
            this.name = name;
            return this;
        }

        public Reservation.Builder setAmount(String amount){
            this.amount = amount;
            return this;
        }

        public Reservation.Builder setDate(String date){
            this.date = date;
            return this;
        }

        public Reservation.Builder setPeoplePax (String peoplePax){
            this.peoplePax = peoplePax;
            return this;
        }

        public Reservation.Builder setTblNum (String tblNum){
            this.tblNum = tblNum;
            return this;
        }
        public Reservation build(){
            return new Reservation(this);
        }

        public Reservation.Builder copy(Reservation reservation) {
            this.name= reservation.name;
            this.amount = reservation.amount;
            this.date = reservation.date;
            this.peoplePax = reservation.peoplePax;
            this.tblNum = reservation.tblNum;

            return this;
        }
    }

}
