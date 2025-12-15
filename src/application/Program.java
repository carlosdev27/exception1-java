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
		
		out.println("Room number: ");
		int number = sc.nextInt();
		
		out.print("Check-in date(dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		
		out.print("Check-out date(dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			out.print("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkOut, checkOut);
		}
		
		
		
		sc.close();

	}

}
