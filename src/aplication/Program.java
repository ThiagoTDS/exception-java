package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		Scanner digitar = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try 
		 {
			System.out.print("Room number: ");
			int number = digitar.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(digitar.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(digitar.next());
			
		
			Reservation reserva = new Reservation(number,checkIn,checkOut);
			System.out.println("Reservation: "+reserva);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(digitar.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(digitar.next());
			
			 reserva.updateDates(checkIn, checkOut);
			System.out.println("Reservation: "+reserva);
		 }
		catch(ParseException e) 
		{
			System.out.println("Ivalid date format");
		}
		catch(DomainException e) 
		{
			System.out.println("Error in reservation: "+e.getMessage());
		}
		catch(RuntimeException e) 
		{
			System.out.println("Unexpected");
		}
	
		digitar.close();
	}
}
