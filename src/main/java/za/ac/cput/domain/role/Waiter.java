/*
    Waiter Class
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.domain.role;

import java.io.Serializable;


public class Waiter implements Serializable {
//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int waiterId;
    private int positionId;

    public Waiter(){}
    public Waiter(Builder builder){
        this.positionId = builder.positionId;
        if(builder.waiterId != 0){
            this.waiterId = builder.waiterId;
        }
    }

    public int getWaiterId() {
        return waiterId;
    }

    public int getPositionId() {
        return positionId;
    }

    public static class Builder {
        private int waiterId, positionId;

        public Builder setPositionId(int positionId){
            this.positionId = positionId;
            return this;
        }

        public Builder copy(Waiter waiter){
            this.waiterId = waiter.waiterId;
            this.positionId = waiter.positionId;
            return this;
        }

        public Waiter build(){
            return new Waiter(this);
        }
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "waiterId=" + waiterId +
                ", positionId=" + positionId +
                '}';
    }
}
