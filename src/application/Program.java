package application;

import static java.lang.System.out;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			out.print("Room number: ");
			int number = sc.nextInt();
			
			out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			out.println("Reservation: " + reservation);
			
			out.println();
			out.println("Enter data to update the reservation: ");
			out.print("Check-in date (dd/MM/yyyy): "); 
			checkIn = sdf.parse(sc.next());
			out.print("Check-out date (dd/MM/yyyy): "); 
			checkOut = sdf.parse(sc.next());
									
			
			reservation.updateDates (checkIn, checkOut);
				
			out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			out.println("Invalid date format!");
		}
		catch(DomainException e) {
			out.println("Error in reservation "+e.getMessage());
		}
		catch(RuntimeException e) {
			out.println("Unexpected error");
		}
		sc.close();
	}
				
		
			
	
}
