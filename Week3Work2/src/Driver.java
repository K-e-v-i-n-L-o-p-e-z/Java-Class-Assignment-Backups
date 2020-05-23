
public class Driver {
	
	
	
	
	public static void main(String[] args) {
		display();
		
	}
	public static void display() {
		System.out.println("XYZ Company");
		System.out.println("8900 U.S. May 14");
		Employee clerk = new Employee();
		clerk.setLastName("Timmy");
		System.out.println("His name was " + clerk.getLastName());
		clerk.setEmpNum(17);
		System.out.println("His Employee number was " + clerk.getEmpNumber());
		
		
		Employee teacher = new Employee();
		teacher.setSalaray(10000);
		System.out.println("The teacher's salary is: " + teacher.getSalary());
		
		

		
		
	}
}
