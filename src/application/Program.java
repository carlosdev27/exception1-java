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
		
		// 1. PRIMEIRA VALIDAÇÃO: Check-out após Check-in
		if(!checkOut.after(checkIn)) {
			out.println("Error in reservation: Check-out date must be after check-in date"); // Usar println
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			out.println("Reservation: " + reservation);
			
			out.println();
			out.println("Enter data to update the reservation: ");
			out.print("Check-in date (dd/MM/yyyy): "); // Adicionado print
			
			checkIn = sdf.parse(sc.next());
			out.print("Check-out date (dd/MM/yyyy): "); // Adicionado print
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			// 2. SEGUNDA VALIDAÇÃO: Datas futuras
			if(checkIn.before(now) || checkOut.before(now)) {
				out.println("Error in reservation: Reservation dates for update must be future dates!");
			}
			// 3. TERCEIRA VALIDAÇÃO: Check-out após Check-in (Novas datas)
			else if(!checkOut.after(checkIn)) {
				// ESTE ERA O BLOCO VAZIO
				out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				// Somente se TODAS as validações passarem, a atualização é feita.
				reservation.updateDates(checkIn, checkOut);
				out.println("Reservation updated: " + reservation);
			}
		}
		
		sc.close();
	}
}
