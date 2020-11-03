package by.gomel.ggmk.factories;

import by.gomel.ggmk.beans.Bus;
import by.gomel.ggmk.beans.Car;
import by.gomel.ggmk.beans.Constants;

import java.util.ArrayList;
import java.util.Arrays;

public class CarFactory {
    enum KindCar {
        CAR {
            public Car getCar(String csv) {
                return new Car(csv);
            }
        },
        BUS {
            public Car getCar(String csv) {
                return new Bus(csv);
            }
        };

        public abstract Car getCar(String csv);
    }

    public static Car getCarFromFactory(String csv) {
        try {
            String[] args = csv.split(Constants.DELIMITER, 2);
            return KindCar.valueOf(args[0].toUpperCase()).getCar(args[1]);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw new IllegalArgumentException("Invalid file");
        }
    }

    public static Car getCarFromFactory(ArrayList<String> carList) {
        return getCarFromFactory(String.join(";", carList));
    }
}
