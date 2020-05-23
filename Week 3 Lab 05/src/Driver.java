
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students psychMajor = new Students(3.5);
		psychMajor.printStudent();
		
		double num1 = 3.5;
		int num2 = 4;
		simple(num1);
		
		simple(num2);

	}
	
	
	
	public static void simple(double num) {
		System.out.println("Function recieves Double number");
	}
	
	public static void simple(int num) {
		System.out.println("Function recieves int number");
	}

}
