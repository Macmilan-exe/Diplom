package by.gomel.ggmk.beans;

import by.gomel.ggmk.enums.Fields;
import by.gomel.ggmk.exceptions.EmptyArgumentException;
import by.gomel.ggmk.exceptions.NonPositiveArgumentException;

public class Car implements Comparable<Car>{
    private final String name;
    private double mass;

    public Car(String name, double mass) {
        if (mass <= 0){
            throw new NonPositiveArgumentException(Fields.MASS);
        }
        this.mass = mass;

        if (name.isEmpty()){
            throw new EmptyArgumentException(Fields.NAME);
        }
        this.name = name;
    }

    public Car(Car car){
        this(car.name,car.mass);
    }

    public Car(String csv){
        this(getValidCar(csv));
    }

    private static Car getValidCar(String csv){
        final int INDEX_NAME = 0;
        final int INDEX_MASS = 1;
        String[] args = csv.split(Constants.DELIMITER);
        return new Car(args[INDEX_NAME],Double.parseDouble(args[INDEX_MASS]));
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.mass, mass) == 0 &&
                name.equals(car.name);
    }

    @Override
    public String toString() {
        return name + Constants.DELIMITER + mass ;
    }

    @Override
    public int compareTo(Car o) {
        int comp = Double.compare(mass,o.mass);
        if (comp == 0){
            comp = name.compareTo(o.getName());
        }
        return comp;
    }


}
