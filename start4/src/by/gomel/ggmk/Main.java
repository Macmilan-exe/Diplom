package by.gomel.ggmk;

import by.gomel.ggmk.beans.Car;
import by.gomel.ggmk.enums.WeeksDay;
import by.gomel.ggmk.factories.CarFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schema_name", "misha", "98192713");
             PreparedStatement ps = con.prepareStatement("select * from table_name;");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("\t"+ rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));

            }
        } catch (SQLException ex) {
            System.out.println("Connection failed...");
            System.out.println(ex.getMessage());
        }

        try (
                Scanner scanner = new Scanner(new FileReader(args[0]))) {
            Map<WeeksDay, Car> carMap = new EnumMap<>(WeeksDay.class);
            Map<WeeksDay, Car> carMap2 = new EnumMap<>(WeeksDay.class);

            while (scanner.hasNextLine()) {
                String[] argc = scanner.nextLine().split(";", 2);
                Car car = CarFactory.getCarFromFactory(argc[1]);
                WeeksDay day = WeeksDay.valueOf(argc[0].toUpperCase());
                carMap2.put(day, car);
                carMap.putIfAbsent(day, car);
            }

            // carMap.forEach((key, value) -> System.out.println(key + "\t" + value));
            // System.out.println("");
            // carMap2.forEach((key, value) -> System.out.println(key + "\t" + value));
        } catch (
                Exception e) {
            System.err.println("Problem with file");
        }
    }
}
