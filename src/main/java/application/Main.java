package application;

import entities.Room;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Room[] rooms = new Room[10];

        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(i + 1);
        }

        System.out.print("How many rooms will be rented? ");
        int numberOfRooms = sc.nextInt();



        if (numberOfRooms < 0 || numberOfRooms > rooms.length) {
            System.out.println("Número inválido de quartos. Por favor, insira um número entre 0 e " + rooms.length);
        } else {
            sc.nextLine();
            for (int i = 0; i < numberOfRooms; i++) {
                System.out.println("Rent #" + (i + 1));

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Room: ");
                int roomNumber = sc.nextInt();
                sc.nextLine();

                if (roomNumber < 1 || roomNumber > 10) {
                    System.out.println("Room number invalid. Please insert a valid room!");
                    i--;
                } else if (rooms[roomNumber - 1].isRented()) {
                    System.out.println("Room rented. Please, choose another room");
                } else {
                    rooms[roomNumber - 1].rent(name, email);
                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);
                    System.out.println("Room: " + roomNumber);
                }
            }

            System.out.println("Room state:");
            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i].isRented()) {
                    System.out.println("Room: " + rooms[i].getRoomNumber() + ": Rented by: " + rooms[i].getName() + " (" + rooms[i].getEmail() + ")");
                } else {
                    System.out.println("Room: " + rooms[i].getRoomNumber() + " available");
                }
            }
        }

        sc.close();
    }
}
