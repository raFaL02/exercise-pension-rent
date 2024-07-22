package entities;

public class Room {

    private String name;
    private String email;
    private int roomNumber;
    private boolean rented;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.rented = false;
        this.name = null;
        this.email = null;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isRented() {
        return rented;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void rent(String name, String email) {
        this.rented = true;
        this.name = name;
        this.email = email;
    }
}
