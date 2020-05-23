//Kevin Lopez 5/9/2019 Week 02 Lab 02
//This program finds out the taxable income of a single filer.
import javax.swing.JOptionPane;

//I split the JOptionFrame part into different lines because the 1 (one) line syntax was going passed the text border

public class TaxableIncome {

	public static void main(String[] args) {

		String income;
		//asking for the income using JOptionFrame
		income = JOptionPane.showInputDialog(null,
				"Please provide your taxable income:",
				"Taxable Income dialog 1",
				JOptionPane.QUESTION_MESSAGE);
		
		int value = Integer.parseInt(income);
		double output = 0;
		//these if statements are here to find out how much the person gets taxed. It depends on where
		//the income lies in this if statement block.
		//The formulas were given by the lab 
		if(value >= 0 && value <= 9325) {
			 output = value * 0.10;
		}
		if(value > 9325 && value >= 37950) {
			output = 932.50 + (0.15*(value-9325));
		}
		if(value > 37950 && value <= 91900) {
			output = 5226.25 + (0.25*(value-37950));
		}
		if(value > 91900 && value <= 191650) {
			output = 18713.75 + (0.28*(value-91900));
		}
		if(value > 191650 && value <= 416700) {
			output = 18713.57 + (0.33*(value-191650));
		}
		if(value > 416700 && value <= 418400) {
			output = 120910.25 + (0.35*(value-416700));
		}
		if(value > 418400) {
			output = 121505.25 + (0.396*(value-418400));
		}
		//JOptionPane dialog box 
		JOptionPane.showMessageDialog(null,
				"Your federal income tax is $" + output,
				"Taxable Income dialog 2",
				JOptionPane.INFORMATION_MESSAGE);

	}

}
