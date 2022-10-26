package za.ac.cput.domain.race;

/* Race.java
   This is a Race domain class
   @Author: Lihle Njobe(218193882)
 */

import java.io.Serializable;

public class Race implements Serializable {

    private int id;
    private String name;

    public Race() {
    }

    private Race(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private String name;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Race build() {
            return new Race(this);
        }

        public Builder copy(Race race) {
            this.id = race.id;
            this.name = race.name;

            return this;

        }

    }
}

