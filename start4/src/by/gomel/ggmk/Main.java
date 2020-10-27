package by.gomel.ggmk;

import by.gomel.ggmk.beans.Car;
import by.gomel.ggmk.enums.WeeksDay;
import by.gomel.ggmk.factories.CarFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new FileReader(args[0]))) {
            Map<WeeksDay, Car> carMap = new EnumMap<>(WeeksDay.class);
            Map<WeeksDay, Car> carMap2 = new EnumMap<>(WeeksDay.class);
            while (scanner.hasNextLine()){
                String [] argc = scanner.nextLine().split(";",2);
                Car car = CarFactory.getCarFromFactory(argc[1]);
                WeeksDay day = WeeksDay.valueOf(argc[0].toUpperCase());
                carMap2.put(day,car);
                if (!carMap.containsKey(day)){
                    carMap.put(day,car);
                }
            }

            for (Map.Entry<WeeksDay, Car> car:carMap.entrySet()) {
                System.out.println(car.getKey() + "\t" + car.getValue());
            }
            System.out.println("");
            for (Map.Entry<WeeksDay, Car> car:carMap2.entrySet()) {
                System.out.println(car.getKey() + "\t" + car.getValue());
            }
        }catch (IOException e){
            System.err.println("Problem with file");
            System.err.println(e.getMessage());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
