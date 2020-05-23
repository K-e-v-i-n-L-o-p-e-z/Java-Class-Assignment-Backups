import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int year;
		System.out.println("Enter a year: ");
		year = reader.nextInt();
		
		/* To check if it is a leap year
		 * The year can be evenly divided by 4;
		 * If the year can be evenly divided by 100, it is NOT a leap year, unless;
		 * The year is also evenly divisible by 400. Then it is a leap year.
		 */
		
		if(year % 4 == 0)
		{
			if(year % 100 == 0)
			{
				if(year % 400 == 0)
				{
					System.out.println(year + " is a leap year.");
				}
				else
				{
					System.out.println(year + " is not a leap year.");
				}
			}
			else
			{
				System.out.println(year + " is a leap year.");
			}
		}
		else
		{
			System.out.println(year + " is a leap year.");
		}
		
	}

}
