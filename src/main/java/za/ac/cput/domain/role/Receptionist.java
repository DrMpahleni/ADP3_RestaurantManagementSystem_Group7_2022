package za.ac.cput.domain.role;

import java.io.Serializable;

public class Receptionist implements Serializable {

    private String receptionId;
    private int positionId;

    public Receptionist(){

    }

    private Receptionist(Builder builder){

        this.receptionId = builder.receptionId;
        this.positionId = builder.positionId;

    }

    public String getReceptionId() {
        return receptionId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setReceptionId(String receptionId) {
        this.receptionId = receptionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Receptionist{" +
                "receptionId=" + receptionId +
                ", positionId=" + positionId +
                '}';
    }

    public static class Builder{

        private String receptionId;
        private int positionId;

        public Builder setReceptionId(String receptionId){
            this.receptionId = receptionId;
            return this;
        }

        public Builder setPositionId( int positionId){
            this.positionId = positionId;
            return this;
        }

        public Receptionist build(){
            return new Receptionist(this);
        }

        public Receptionist.Builder copy(Receptionist receptionist) {
            this.receptionId = receptionist.receptionId;
            this.positionId = receptionist.positionId;

            return this;
        }
    }

}
