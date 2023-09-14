package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reservation {
	private int roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	// instanciação do tipo data no formato static pois so vai ser feito 1 vez.
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(int roomNumber, Date checkIn, Date checkOut) throws DomainException{
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Rersevation error: Check-out date must be after Check-in date");
		}
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
	public void updateDates(Date checkIn, Date checkOut) throws DomainException{
		Date agora = new Date();
		if(checkIn.before(agora) || checkOut.before(agora)) {
			//foi instanciada a classe de exceção que ja vem no Java "IllegalArgumentException" 
			//para mostrar a exceção. 
			throw new DomainException("Rersevation dates for update must be future dates");
			// tradução de = "throw new IllegalArgumentException"
			// lançar nova exceção de argumento ilegal
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Rersevation error: Check-out date must be after Check-in date");
		}
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
