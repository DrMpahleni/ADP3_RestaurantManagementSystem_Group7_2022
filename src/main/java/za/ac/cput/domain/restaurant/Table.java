package za.ac.cput.domain.restaurant;

import java.io.Serializable;

public class Table implements Serializable {

    private String tblNum;
    private String seatAmount;

    public Table(){

    }

    private Table(Builder builder){

        this.tblNum = builder.tblNum;
        this.seatAmount = builder.seatAmount;

    }

    public String getTblNum() {
        return tblNum;
    }

    public String getSeatAmount() {
        return seatAmount;
    }

    public void setTblNum(String tblNum) {
        this.tblNum = tblNum;
    }

    public void setSeatAmount(String seatAmount) {
        this.seatAmount = seatAmount;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Table{" +
                "tblNum=" + tblNum +
                ", seatAmount=" + seatAmount +
                '}';
    }

    public static class Builder{

        private String tblNum;
        private String seatAmount;

        public Table.Builder setTblNum(String tblNum){
            this.tblNum = tblNum;
            return this;
        }

        public Table.Builder setSeatAmount(String seatAmount){
            this.seatAmount = seatAmount;
            return this;
        }

        public Table build(){
            return new Table(this);
        }

        public Table.Builder copy(Table table){
            this.tblNum = table.tblNum;
            this.seatAmount = table.seatAmount;
            return this;
        }
    }
}
