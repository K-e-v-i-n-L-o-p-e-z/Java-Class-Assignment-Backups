import java.util.Random;

//The helper class for the Pet project

public class Attribute_Tool {

	public static void checkCleanliness(Pet pet) {
		// check the cleanliness
		if (pet.getCleanliness() < 5) {
			// randomly choose out of two outputs
			int option = randomGen(2);
			// randomly remove 1 point from another stat
			randomDecrementer(pet);
			if (option == 1) {
				System.out.println("EEW wHAT the heck ! He smel bad. (-1 " +  );
			}
			if (option == 2) {
				System.out.println(pet.getName() + "'s stench is getting worse.");
			}
		}
	}

	// checks the pets happiness levels
	public static void checkHappiness(Pet pet) {
		if (pet.getHappiness() < 5) {
			randomDecrementer(pet);
			int option = randomGen(2);
			if (option == 1) {
				System.out.println(pet.getName() + " is displaying depression like symptoms (-1 Health)");
			}
			if (option == 2) {
				System.out.println(pet.getName() + " seems unsatisfied (-1 Health)");
			}
		}
	}

	// checks the pets health levels
	public static void checkHealth(Pet pet) {
		if (pet.getHealth() < 5) {
			randomDecrementer(pet);
			int option = randomGen(2);
			if (option == 1) {
				System.out.println(pet.getName() + " has a rash near his pooper (-1 Health)");
			}
			if (option == 2) {
				System.out.println(pet.getName() + " is displaying flu like symptoms (-1 Health)");
			}
		}
	}

	// checks the pets hunger levels
	public static void checkHunger(Pet pet) {
		if (pet.getHunger() < 5) {
			randomDecrementer(pet);
			int option = randomGen(2);
			if (option == 1) {
				System.out.println(pet.getName() + " ate his own feces out of hunger (-1 Health)");
			}
			if (option == 2) {
				System.out.println(pet.getName() + " ate a dog from starvation (-1 Health)");
			}
		}
	}

	// checks to see if one of the stats is zero or less-- if so-- kill it
	public static boolean isZero(Pet pet) {

		int clean = pet.getCleanliness();
		int happy = pet.getHappiness();
		int health = pet.getHealth();
		int hunger = pet.getHunger();

		if (clean <= 0 || happy <= 0 || health <= 0 || hunger <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static String randomDecrementer(Pet pet) {
		String output = "";
		int option = randomGen(4);
		if (option == 1) {
			pet.setCleanliness(pet.getCleanliness() - 1);
			output = "Cleanliness";
		}
		if (option == 2) {
			pet.setHappiness(pet.getHappiness() - 1);
			output = "Happiness";

		}
		if (option == 3) {
			pet.setHealth(pet.getHealth() - 1);
			output = "Health";

		}
		if (option == 4) {
			pet.setHunger(pet.getHunger() - 1);
			output = "Hunger";
		}
		return output;
	}

	public static int randomGen(int number) {
		Random rand = new Random();
		int k = rand.nextInt(number) + 1;
		return k;
	}

	public void scanPet(Pet pet) {
		checkCleanliness(pet);
		checkHappiness(pet);
		checkHealth(pet);
		checkHunger(pet);
	}
}
