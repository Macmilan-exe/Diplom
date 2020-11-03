package by.gomel.ggmk;

import by.gomel.ggmk.beans.Car;
import by.gomel.ggmk.beans.Constants;
import by.gomel.ggmk.enums.WeeksDay;
import by.gomel.ggmk.factories.CarFactory;

import java.io.FileReader;
import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> carList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schema_name", "misha", "98192713");
             PreparedStatement ps = con.prepareStatement("select * from table1;");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                carList.add(rs.getString("type") + ";" + rs.getString("name_c")
                        + ";" + rs.getString("mass") + ";" + rs.getString("place"));
            }

        } catch (SQLException ex) {
            System.out.println("Connection failed...");
            System.out.println(ex.getMessage());
        }

        try (Scanner scanner = new Scanner(new FileReader(args[0]))) {

            Map<WeeksDay, Car> carMap = new EnumMap<>(WeeksDay.class);
            Map<WeeksDay, Car> carMap2 = new EnumMap<>(WeeksDay.class);
            ArrayList<Car> carList2 = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String[] argc = scanner.nextLine().split(Constants.DELIMITER, 2);
                Car car = CarFactory.getCarFromFactory(argc[1]);
                WeeksDay day = WeeksDay.valueOf(argc[0].toUpperCase());
                carMap2.put(day, car);
                carMap.putIfAbsent(day, car);

                Car car2 = CarFactory.getCarFromFactory(argc[1]);
                carList2.add(car2);
            }

            carList2.forEach(System.out::println);
            System.out.println("========================");
            /*for (String stt : carList) {
                System.out.println(stt);
            }
            System.out.println("========================");*/
            carMap.forEach((key, value) -> System.out.println(key + "\t" + value));
            System.out.println("========================");
            carMap2.forEach((key, value) -> System.out.println(key + "\t" + value));

        } catch (Exception e) {
            System.err.println("Problem with file");
        }
    }
}
