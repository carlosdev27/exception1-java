package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer rooNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer rooNumber, Date checkIn, Date checkOut) {
		this.rooNumber = rooNumber;
		this.checkIn = checkIn;
		checkOut = checkOut;
	}
	public Integer getRooNumber() {
		return rooNumber;
	}
	public void setRoomNumber(Integer rooNumber ) {
		this.rooNumber = rooNumber;
	}

	public Date getChekIn() {
		return checkIn;
	}

	
	public Date getCheckOut() {
		return checkOut;
	}
	
		
	public void setRooNumber(Integer rooNumber) {
		this.rooNumber = rooNumber;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS); 
		//Converte o tempo em milisegundos para dias com base nas duas datas.
	}
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room: "
				+ rooNumber 
				+ ", chekIn=" 
				+ checkIn 
				+ sdf.format(checkIn)
				+ ", check-Out"
				+sdf.format(checkOut)
				+", "
				+ duration()
				+ " nights";
	}
	
	
	
}
