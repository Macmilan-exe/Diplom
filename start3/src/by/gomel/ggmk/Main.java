package by.gomel.ggmk;

import by.gomel.ggmk.beans.Car;
import by.gomel.ggmk.factories.CarFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new FileReader(args[0]))) {
            List<Car> cars = new ArrayList<>();
            while (scanner.hasNextLine()){
                Car car = CarFactory.getCarFromFactory(scanner.nextLine());
                cars.add(car);
            }
            for (Car car : cars) {
                System.out.println(car);
            }
        }catch ( Exception e){
            System.err.println(e.getMessage());
        }
    }
}
