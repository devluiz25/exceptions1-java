package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			return "AS DATAS DE RESERVA TEM QUE SER DATAS FUTURAS!";
		}  
		if (!checkOut.after(checkIn)) {
			return "A DATA DE CHECK-OUT DEVE SER APÓS A DATA DE CHECK-IN!";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}

	@Override
	public String toString() {
		return "QUARTO " 
			+ roomNumber 
			+ ", CHECK-IN: " 
			+ sdf.format(checkIn) 
			+ ", CHECK-OUT: " 
			+ sdf.format(checkOut) 
			+ ", " 
			+ duration() 
			+ " NOITES";
		}
	}
