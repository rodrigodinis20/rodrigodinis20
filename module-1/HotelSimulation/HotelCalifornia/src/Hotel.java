import java.sql.SQLOutput;

public class Hotel {
    private Room[] rooms;


    public Hotel(Room[] rooms) {
        this.rooms = rooms;

    }

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
                System.out.println("There is no room");
            }
        }
        return -1;
    }

    public void checkOut(int roomNumber) {
        rooms[roomNumber].setAvailability(false);
        System.out.println("Your check out is complete.");

    }



}
