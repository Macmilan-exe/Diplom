package by.gomel.ggmk.beans;

import by.gomel.ggmk.enums.Fields;
import by.gomel.ggmk.exceptions.EmptyArgumentException;
import by.gomel.ggmk.exceptions.NonPositiveArgumentException;

import java.util.Objects;

public class Engine {
    private final String name;
    private final double power;
    private final double volume;

    public Engine(String name, double power, double volume) {
        if (name.equals("")){
            throw new EmptyArgumentException(Fields.NAME);
        }
        this.name = name;
        if (power <= 0 || volume <= 0){
            throw new NonPositiveArgumentException(Fields.POWER);
        }
        this.power = power;
        if (volume <= 0){
            throw new NonPositiveArgumentException(Fields.VOLUME);
        }
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Double.compare(engine.power, power) == 0 &&
                Double.compare(engine.volume, volume) == 0 &&
                Objects.equals(name, engine.name);
    }

    @Override
    public String toString() {
        return name + Constants.DELIMITER + power + Constants.DELIMITER + volume ;
    }
}
