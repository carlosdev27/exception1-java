package model.entities;

import static java.lang.System.out;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRooNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer rooNumber ) {
		this.roomNumber = rooNumber;
	}

	public Date getChekIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
		
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); //Calcula a diferença entre as datas em milisegundos.
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS); //Converte o tempo em milisegundos para dias com base nas duas datas.
	}
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
		return "Reservation dates for update must be future dates!";
		}
		if(!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date" ;
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Room: "
				+ roomNumber 
				+ ", checkin: " 
				+ sdf.format(checkIn)
				+ ", check-Out: "
				+sdf.format(checkOut)
				+", "
				+ duration()
				+ " nights";
	}
	
	
	
}
