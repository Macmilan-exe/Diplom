package by.gomel.ggmk;

import by.gomel.ggmk.beans.Car;
import by.gomel.ggmk.beans.Constants;
import by.gomel.ggmk.enums.WeeksDay;
import by.gomel.ggmk.exceptions.SourceException;
import by.gomel.ggmk.factories.CarFactory;
import by.gomel.ggmk.factories.SourceFactory;
import by.gomel.ggmk.interfaces.ReaderDAO;

import java.io.FileReader;
import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("data", Locale.US);
        try (ReaderDAO reader = SourceFactory.getReaderFromFactory(rb)){
            while (reader.hasNext()){
                System.out.println(reader.nextCar());
            }
        } catch (SourceException e){
            System.err.println(e.getMessage());
        }


    }
        /*ResourceBundle bundle;
        Scanner sc = new Scanner(System.in);
        System.out.println("What to read data from ? " + "(database or csv)");
        String st = sc.nextLine();

        if (st.equals("database")){
            bundle = ResourceBundle.getBundle("data", Locale.US);
            System.out.println(bundle.getString("message"));

            ArrayList<String> carList = new ArrayList<>();

            try (Connection con = DriverManager.getConnection(bundle.getString("url"), bundle.getString("username"), bundle.getString("password"));
                 PreparedStatement ps = con.prepareStatement("select * from table1;");
                 ResultSet rs = ps.executeQuery())
            //Подключение к базе (url, username, pass)
            //Выбор всех сьолбцов из таблицы table_name
            //Вывод результата
            {
                while (rs.next()) {
                    carList.add(rs.getString("type") + ";" + rs.getString("name_c")
                            + ";" + rs.getString("mass") + ";" + rs.getString("place"));
                    //Запись в list
                }
                carList.forEach(System.out::println);
            } catch (SQLException ex) {
                System.out.println("Connection failed...");
                System.out.println(ex.getMessage());
            }
        } else if (st.equals("csv")){
            bundle = ResourceBundle.getBundle("data", Locale.FRANCE);
            System.out.println(bundle.getString("message"));
            System.out.println("========================");

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
                carMap.forEach((key, value) -> System.out.println(key + "\t" + value));
                System.out.println("========================");
                carMap2.forEach((key, value) -> System.out.println(key + "\t" + value));

            } catch (Exception e) {
                System.err.println("Problem with file");
            }
        } else {
            System.out.println("...");
        }
    }*/
}
