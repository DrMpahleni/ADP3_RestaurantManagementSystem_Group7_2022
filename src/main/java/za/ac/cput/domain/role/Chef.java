/*
    Chef Class
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.domain.role;
import java.io.Serializable;


public class Chef implements Serializable {
//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int chefId;
    private int positionId;

    public Chef() {}
    public Chef(Builder builder){
        this.positionId = builder.positionId;
        if(builder.chefId != 0){
            this.chefId = builder.chefId;
        }
    }

    public int getChefId() {
        return chefId;
    }

    public int getPositionId() {
        return positionId;
    }

    public static class Builder {
        private int chefId, positionId;

        public Builder setPositionId(int positionId){
            this.positionId = positionId;
            return this;
        }

        public Builder copy(Chef chef){
            this.chefId = chef.chefId;
            this.positionId = chef.positionId;
            return this;
        }

        public Chef build(){
            return new Chef(this);
        }

    }

    @Override
    public String toString() {
        return "Chef{" +
                "chefId=" + chefId +
                ", positionId=" + positionId +
                '}';
    }
}
