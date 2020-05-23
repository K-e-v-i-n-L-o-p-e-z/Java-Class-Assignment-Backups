import java.util.Scanner;


/* why Java is good 
 * 		0) it is cross-platform
 * 		0) in java you can have a class within a class
 * 
 */

/*
 *  Class name is an Identifier 
 *  must begin with a capital letter
 *  Cannot begin with a number
 */
/*
 * keyword for creating an instance is "new" 
 */
public class Main {

	/*
	 * public is an "access specifier" 
	 *can be used without an instance of the class
	 * void - no output (no return type)
	 * String[] args is an array of strings it takes as arguments 
	 * 
	 */
	public static void main(String[] args) {
		/*
		 * System is a static class
		 * out is a property of the System class
		 * println is a function of the class
		 */
		
		Scanner reader = new Scanner(System.in);
		System.out.println("What is your age? ");
		String input = reader.nextLine();
		System.out.println("You are " + input);
		/*
		 * there are a lot of functions you can use
		 * theres
		 * next()
		 * nextInt()
		 * nextDouble()
		 * hasNext() //returns a boolean
		 */
		
		System.out.println("What is your favorite number? ");
		int fav = reader.nextInt();
		
		System.out.println("Your favorite number is: " + fav);
		
//		
//		double base;
//		double height;
//		double hypotenuse;
//		
//		System.out.println("Enter the base: ");
//		base = reader.nextDouble();
//		System.out.println("Enter the height: ");
//		height = reader.nextDouble();
//		hypotenuse = Math.sqrt(Math.pow(height, 2) + Math.pow(base, 2));
//		System.out.println("The Hypotenuse is: " + hypotenuse);
//		
//		
		
		System.out.println("What is your name? ");
		
		String name = reader.nextLine();

		System.out.println("Hello " + name);
		reader.close();
		
		
		
		
	}

}
