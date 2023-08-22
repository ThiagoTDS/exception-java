package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner digitar = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = digitar.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(digitar.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(digitar.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Rersevation error: Check-out date must be after Check-in date");
		}else {
			Reservation reserva = new Reservation(number,checkIn,checkOut);
			System.out.println("Reservation: "+reserva);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(digitar.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(digitar.next());
			
			Date agora = new Date();
			if(checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Rersevation error: Check-out date must be after Check-in date");
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Rersevation error: Check-out date must be after Check-in date");
			}else {
				reserva.updateDates(checkIn, checkOut);
				System.out.println("Reservation: "+reserva);
			}
				
		}
		
		
		
		
		
		
		digitar.close();
	}

}
