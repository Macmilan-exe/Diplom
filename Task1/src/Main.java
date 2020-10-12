import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Car car1 = new Car("Volvo", 10);
        Car car2 = new Car("Mercedes", 12.5);
        Car car3 = new Car("Lada", 15);

        System.out.println(car1.equals(car2));
        System.out.println(car2.equals(car3));

        System.out.printf("\n%s\n%s\n%s\n", car1, car2, car3);

        Engine engine1 = new Engine("Name1", 145, 52);
        Engine engine2 = new Engine("Name2", 205, 72);
        Engine engine3 = new Engine("Name3", 175, 62);

        System.out.printf("\n%s\n%s\n%s\n", engine1, engine2, engine3);

        Bus bus1 = new Bus("BMW", 17.2, 15);
        Bus bus2 = new Bus("Lada", 18.5, 17);
        Bus bus3 = new Bus("Acura", 15.6, 19);

        System.out.printf("\n%s\n%s\n%s\n\n", bus1, bus2, bus3);

        List<Car> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(bus1);
        list.add(bus2);
        list.add(bus3);
        list.add(new Car("Lcura",15.0));
        list.remove(1);
        System.out.println("SORTED");
        Collections.sort(list);
/*        list.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                int comp = (int) (o1.getMass() - o2.getMass());
                if (comp == 0){
                    comp = o1.getName().compareTo(o2.getName());
                }
                return comp;
           //     return o1.getName().compareTo(o2.getName());
            }
        });*/
     //   list.sort(Comparator.comparing(Car::getName));
        for (Car car : list) {
            System.out.println(car);
        }

        int index = Collections.binarySearch(list, new Car("BMW", 15555), new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(index);
    }
}
