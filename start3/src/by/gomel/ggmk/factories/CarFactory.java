package by.gomel.ggmk.factories;

import by.gomel.ggmk.beans.Bus;
import by.gomel.ggmk.beans.Car;
import by.gomel.ggmk.beans.Constants;

public class CarFactory {
    private enum KindCar{
        CAR{
            public Car getCar(String csv){
                return new Car(csv);
            }
        },
        BUS{
            public Car getCar(String csv){
                return new Bus(csv);
            }
        };

        public abstract Car getCar(String csv);
    }

    public static Car getCarFromFactory (String csv) throws Exception {
        try {
            String[] args = csv.split(Constants.DELIMITER,2);
            return KindCar.valueOf(args[0].toUpperCase()).getCar(args[1]);
        } catch (IllegalArgumentException e){
            System.err.println(e);
           throw new Exception("Invalid file");
        }
    }
}
