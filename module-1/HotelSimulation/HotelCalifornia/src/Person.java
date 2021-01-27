public class Person {

    private String name;
    private Hotel hotel;
    private int key;

    public Person(String name, Hotel hotel, int key) {
        this.name = name;
        this.hotel = hotel;
        this.key = key;

    }

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setKey(int key){
        this.key = key;
    }

    public int getKey(){
        return key;
    }



    public void setHotel(String name){
        this.hotel = hotel;
    }

    public String getHotel(){
        return this.hotel;
    }


    public void checkIn() {
        this.key = hotel.checkIn();

        System.out.println( getHotel() + "The room " + getKey() + " is now registered for " + getName());
    }

    public void checkOut() {
        hotel.checkOut(key);

    }
}
