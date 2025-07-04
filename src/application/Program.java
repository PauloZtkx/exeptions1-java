package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn =  sdf.parse(sc.next());
        System.out.print("Check- out date (dd/MM/yyyy): ");
        Date chckOut = sdf.parse(sc.next());

        if (!chckOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after ckeck-in date");
        }
        else{
            Reservation reservation = new Reservation(number,checkIn,chckOut);
            System.out.println("Reservation "+ reservation);


            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn =  sdf.parse(sc.next());
            System.out.print("Check- out date (dd/MM/yyyy): ");
            chckOut = sdf.parse(sc.next());

            String error = reservation.updateDates(checkIn,chckOut);
            if (error != null){
                System.out.println("Erro in reservation: " + error);
            }
            else{
                System.out.println("Reservation "+ reservation);
            }

        }
        sc.close();
    }
}
