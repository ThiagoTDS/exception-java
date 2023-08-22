package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private int roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	// instanciação do tipo data no formato static pois so vai ser feito 1 vez.
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(int roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public int getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	//METODO PARA CALCULAR EM DIAS A DIFERENÇA ENTRE OS TEMPOS. 
	public long  duration() {
		// long é um tipo de variavel diff recebe a quantidade de tempo em milesegundos de checkIn menos checkout. 
		long diff = checkOut.getTime() - checkIn.getTime();
		//converte o tempo em milisegundos em dias
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	@Override
	public String toString() {
		return "Romm "
				+roomNumber
				+", Check-in: "
				+sdf.format(checkIn)
				+", Check-out: "
				+sdf.format(checkOut)
				+", "
				+duration()
				+" nigths.";
	}	
}
