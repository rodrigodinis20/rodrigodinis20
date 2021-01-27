public class Sandbox {


    public static void main(String[] args) {

        //Room[] rooms = new Room[]{new Room(), new Room(), new Room()};

        Hotel hotel1 = new Hotel("Caracol", 100);

        Person p1 = new Person("Alberto", hotel1, 4);


        p1.checkIn();
        p1.checkOut();



    }
}
