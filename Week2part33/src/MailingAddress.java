import java.util.*;
public class MailingAddress {

	public static void main(String[] args) {
		//simply just getting inputs and doing string concatenation
		Scanner reader = new Scanner(System.in);
		String street, city, state;
		int housenum,zip;
		System.out.println("Enter your street: ");
		street = reader.nextLine();
		System.out.println("Enter the house or apartment number: ");
		housenum = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter the city: ");
		city = reader.nextLine();
		System.out.println("Enter the zip code: ");
		zip = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter the State: ");
		state = reader.nextLine();
		
		System.out.println(housenum + " " + street + ", " + city + ", " + state + " " + zip);
		
		
	}

}
