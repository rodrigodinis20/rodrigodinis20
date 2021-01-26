public class Sandbox {


    public static void main(String[] args){

        Room[] rooms = new Room[]{new Room(), new Room(), new Room()};

        Hotel hotel = new Hotel(rooms);

        Person p1 = new Person("Alberto", hotel, 2);


        p1.checkIn();
        p1.checkOut();

    }
}
