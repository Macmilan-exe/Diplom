package by.gomel.ggmk.beans;

import by.gomel.ggmk.enums.Fields;
import by.gomel.ggmk.exceptions.NonPositiveArgumentException;

public class Bus extends Car{
    private int place;

    public Bus(String name, double mass, int place) {
        super(name, mass);
        if (place <= 0){
            throw new NonPositiveArgumentException(Fields.PLACE);
        }
        this.place = place;
    }

    public Bus(Bus bus){
        this(bus.getName(), bus.getMass(), bus.place);
    }

    public Bus(String csv){
        this(getValidBus(csv));
    }

    private static Bus getValidBus(String csv){
        final int INDEX_NAME = 0;
        final int INDEX_MASS = 1;
        final int INDEX_PLACE = 2;
        String[] args = csv.split(Constants.DELIMITER);
        return new Bus(args[INDEX_NAME],Double.parseDouble(args[INDEX_MASS]), Integer.parseInt(args[INDEX_PLACE]));
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return super.toString() + Constants.DELIMITER + place;
    }
}
