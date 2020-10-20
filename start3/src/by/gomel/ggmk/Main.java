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
            List<Car> cars = new ArrayList<>();
            Map<WeeksDay, Car> carMap = new EnumMap<>(WeeksDay.class);
            while (scanner.hasNextLine()){
                String [] argg = scanner.nextLine().split(";",2);
                Car car = CarFactory.getCarFromFactory(argg[1]);
                WeeksDay day = WeeksDay.valueOf(argg[0].toUpperCase());
                carMap.put(day,car);
                //map для хранения повторных значений
            }
            for (Map.Entry<WeeksDay, Car> car:carMap.entrySet()) {
                System.out.println(car.getKey() + "\t" + car.getValue());
            }
        }catch ( IOException e){
            System.err.println("Problem with file");
            System.err.println(e.getMessage());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
