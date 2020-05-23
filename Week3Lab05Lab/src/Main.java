//Kevin Lopez 17/09/2019 Week 3 Lab 05 Pets

//We are simulting one of those old games where we had a virtual pet.

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		System.out.println("-Virtual Orangutan-");
		System.out.println("-----m------m------");
		System.out.println("     @(o.o)@");
		System.out.println("       (0)~~");
		System.out.println("       o o");
		System.out.println("Please Enter a name for your pet Orangutan ");

		String name = reader.nextLine();
		// reating the pet, playing God.
		Pet Orangutan = new Pet(name);
		System.out.println("Initializing stats...");
		System.out.println(Orangutan.getName() + "'s Stats-");
		Orangutan.displayStats();
		int x = 0;
		System.out.println(Orangutan.getName() + " was born!");

		// while loop and switch case to do the loop and menu
		while (x < 10) {
			Orangutan.setAge(Orangutan.getAge() + 1);
			printMainMenu();
			int input;
			input = reader.nextInt();
			switch (input) {

			case 1:
				Orangutan.feed();
				System.out.println("WOW HE SWALLLOWED THE BANANA WHOLE and winked! ");
				checkAttributes(Orangutan);
				Orangutan.displayStats();
				break;
			case 2:
				Orangutan.wash();
				System.out.println(Orangutan.getName() + " seems to really enjoy cleaning certain parts..");
				checkAttributes(Orangutan);

				Orangutan.displayStats();

				break;
			case 3:
				Orangutan.play();
				System.out.println(Orangutan.getName() + " is a bit agressive");
				checkAttributes(Orangutan);

				Orangutan.displayStats();
				break;
			case 4:
				Orangutan.health();
				System.out.println(Orangutan.getName() + " has a wierd bump on his butt");
				checkAttributes(Orangutan);

				Orangutan.displayStats();
				break;
			case 5:
				x = 10;
				break;

			}

			x++;
			if (x == 10 || Attribute_Tool.isZero(Orangutan)) {
				// shame..
				System.out.println(Orangutan.getName() + " this foo died ! ");
				System.out.println("Quitting program...");
			}
		}
	}

	// created a function to print the menu to avoid boiler plate code (?)
	public static void printMainMenu() {
		System.out.println("Main Menu:");
		System.out.println(" 1. Feed \n 2. Wash \n 3. Play \n 4. Health\n 5. -Quit- \n");
		System.out.println("Enter a number 1-5");

	}

	public static void checkAttributes(Pet orangutan) {
		Attribute_Tool.checkCleanliness(orangutan);
		Attribute_Tool.checkHappiness(orangutan);
		Attribute_Tool.checkHealth(orangutan);
		Attribute_Tool.checkHunger(orangutan);
	}
}
