package models;

public class Passenger {

    PassengerClass pClass;
    String name;

    public String getName() {
        return name;
    }

    public PassengerClass getpClass() {
        return pClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setpClass(PassengerClass pClass) {
        this.pClass = pClass;
    }

    public Passenger(PassengerClass pClass, String name) {
        this.pClass = pClass;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "pClass='" + pClass + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
