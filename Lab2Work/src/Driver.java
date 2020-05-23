import javax.swing.JOptionPane;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		  int num = 30;
//		  double bankbalance = 999.999;
//		  float myMoney = 47.82f;
//		  int dollars = (int) myMoney;
		
		//null makes it show up in the middle of your screen every time
		//JOptionPane.showMessageDialog(null, "Hello Dialogue!");
		
		//String result;
		//
		//result = JOptionPane.showInputDialog(null,"What is your name?");
		//JOptionPane.showMessageDialog(null, "Hello, " + result);

		
		//result = JOptionPane.showInputDialog(null,"Display Message", "Title Bar", JOptionPane.ERROR_MESSAGE);
		
		/*
		 * JOptionPane.ERROR_MESSAGE
		 * JOptionPane.INFORMATION_MESSAGE
		 * JOptionPane.QUESTION_MESSAGE
		 * JOptionPane.WARNING_MESSAGE
         */	
	
		int num;
		String result;
		result = JOptionPane.showInputDialog(null, "Enter a num");
		num = Integer.parseInt(result)*2;
		JOptionPane.showMessageDialog(null, "Your number x 2 is " + num);
	
	}

}
