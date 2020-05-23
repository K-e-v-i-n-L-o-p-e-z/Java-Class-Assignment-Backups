import java.util.Random;

//Create a virtual pet class. A pet is identified by its attributes of name,
//hunger, cleanliness, happiness, health, and age. Display a menu with
//actions to improve one of the attributes by 1. With every action the pet's
//age is increased by 1. When the pet is 10 years old it dies of old age

public class Pet {
	String name;
	int hunger, cleanliness, happiness, health, age;

	// just a contstructor
	public Pet(String name) {
		this.name = name;
		this.hunger = randomGen();
		this.cleanliness = randomGen();
		this.happiness = randomGen();
		this.health = randomGen();
		this.age = 0;
	}

	// created a function to randomly generate a number from 1 to 10
	public int randomGen() {
		Random rand = new Random();
		int number = rand.nextInt(10) + 1;
		return number;
	}

	// the following are just getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(int cleanliness) {
		this.cleanliness = cleanliness;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// to feed the ped
	public void feed() {
		this.hunger += 1;
	}

	// to wash the pet
	public void wash() {
		this.cleanliness += 1;
	}

	// to play with the pet
	public void play() {
		this.happiness += 1;
	}

	// to take care of the pet
	public void health() {
		this.health += 1;
	}

	// created a function because I dont want to type more often.
	public void displayStats() {

		System.out.println("Hunger: " + this.hunger);
		System.out.println("Cleanliness: " + this.cleanliness);
		System.out.println("Happiness: " + this.happiness);
		System.out.println("Health: " + this.health);

	}

}
