package za.ac.cput.domain.gender;
/* EmployeeGender.java
 This is an Employee Gender Entity
 Author: Vuyisa Nkangana(218192215)
 Due Date: October 2022
  */
public class EmployeeGender {
    private String employeeId;
    private String genderId;

    public EmployeeGender(){

    }
    public EmployeeGender (Builder builder){
        this.employeeId = builder.employeeId;
        this.genderId = builder.genderId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getGenderId() {
        return genderId;
    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "employeeId=" + employeeId +
                ", genderId=" + genderId +
                '}';
    }
    public static class Builder{
        private String employeeId, genderId;

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setGenderId(String genderId) {
            this.genderId = genderId;
            return this;
        }
        public EmployeeGender build(){
            return new EmployeeGender(this);
        }
        public Builder copy(EmployeeGender employeeGender){
            this.employeeId = employeeGender.employeeId;
            this.genderId = employeeGender.genderId;
            return this;
        }
    }
}
