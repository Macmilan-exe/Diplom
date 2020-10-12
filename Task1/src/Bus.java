public class Bus extends Car{
    private int place;

    public Bus(String name, double mass, int place) {
        super(name, mass);
        this.place = place;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return super.toString() + Constants.DELIMITER + place;        //return getName() + Constants.DELIMITER + getMass() + Constants.DELIMITER + place + Constants.DELIMITER;
    }
}
