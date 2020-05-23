//Kevin Lopez 12/9/2019 Week 3 Lab 04 "Classes"
//This project demonstrates the use of classes and objects and getters/setters

public class Driver {
	
	public static void main(String[] args) {
		//creating an instance of the Car class and giving the car the name of "Lola"
		Car Lola = new Car("Lola");
		System.out.println("Lola hasa current speed of " + Lola.getSpeed() + " and has gone a distance of " + Lola.getDistance());
		Lola.setSpeed(50);
		//System.out.println("speed: " + Lola.getSpeed());
		Lola.travel(1.5);		
		System.out.println("Lola hasa current speed of " + Lola.getSpeed() + " and has gone a distance of " + Lola.getDistance());
		Lola.decelerate(15);
		Lola.travel(1);
		System.out.println("Lola hasa current speed of " + Lola.getSpeed() + " and has gone a distance of " + Lola.getDistance());
		
	}
	
	
}
