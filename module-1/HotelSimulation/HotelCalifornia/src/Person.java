public class Person {

    private String name;
    private Hotel hotel;
    private int key;

    public Person(String name, Hotel hotel, int key) {
        this.name = name;
        this.hotel = hotel;
        this.key = key;

    }

    public void checkIn() {
        this.key = hotel.checkIn();

    }

    public void checkOut() {
        hotel.checkOut(key);

    }
}
