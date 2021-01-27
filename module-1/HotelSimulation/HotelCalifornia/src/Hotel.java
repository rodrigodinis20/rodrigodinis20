import java.sql.SQLOutput;

public class Hotel {
    private String name;
    private Room[] rooms;

    public Hotel(String name, int numRooms) {
        this.name = name;
        rooms = new Room[numRooms];

        for(int i = 0; i < numRooms; i++){
            rooms[i] = new Room();
        }
    }

    /*public Hotel(Room[] rooms, String name) {
        this.rooms = rooms;
        this.name = name;


    }

     */

    public Room[] getRooms() {
        return this.rooms;

    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;

    }

    public int checkIn() {

        for (int i = 0; i < rooms.length; i++) {

            if (rooms[i].getAvailability() == true) {
                rooms[i].setAvailability(false);
                System.out.println("Your check in is complete.");
                return i;
            }
            else {
                System.out.println("There is no rooms.");
            }
        }
        return -1;
    }

    public void checkOut(int roomNumber) {
        rooms[roomNumber].setAvailability(true);
        System.out.println("Your check out is complete.");

    }



}
