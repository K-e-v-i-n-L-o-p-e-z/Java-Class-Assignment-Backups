import java.util.Scanner;

public class AgeChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		String name;
		int age;
		System.out.println("Please enter a person's name: ");
		name = reader.nextLine();
		System.out.println("Please enter the person's age? ");
		age = reader.nextInt();
		//checking the variable to see where the person belongs in life
		if (age < 1) {
			System.out.println(name + " is an infant");
		}
		if (age >=1 && age <= 3)
		{
			System.out.println(name + " is a toddler");
		}
		if (age >= 4 && age <= 5) {
			System.out.println(name + " is a preschooler");
		}
		if (age >= 6 && age <= 12) {
			System.out.println(name + " is a grade schooler");
		}
		if (age >= 13 && age <= 18) {
			System.out.println(name + " is a teenager");
		}
		if (age >= 19 && age <= 21) {
			System.out.println(name + " is a young adult");
		}
		if (age > 21) {
			System.out.println(name + " is an adult");
		}
	}

}
