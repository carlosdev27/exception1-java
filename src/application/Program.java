package application;

import static java.lang.System.out;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		out.print("Room number: ");
		int number = sc.nextInt();
		
		out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		
		out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		
		if(!checkOut.after(checkIn)) {
			out.println("Error in reservation: Check-out date must be after check-in date"); 
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			out.println("Reservation: " + reservation);
			
			out.println();
			out.println("Enter data to update the reservation: ");
			out.print("Check-in date (dd/MM/yyyy): "); 
			
			checkIn = sdf.parse(sc.next());
			out.print("Check-out date (dd/MM/yyyy): "); 
			checkOut = sdf.parse(sc.next());
									
			
			String error = reservation.updateDates (checkIn, checkOut);
				
			if(error != null) {
				out.println("Error in reservation: "+ error);
				}
				else {
					out.println("Reservation updated: " + reservation);
				}
				
		}
		
		sc.close();
	}
}
