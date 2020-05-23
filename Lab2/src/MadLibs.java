//Kevin Lopez 5/9/2019 Week 02 Lab 02
//This program asks for at least 4 or 5 words or numbers and then creates and displays a nursery rhyme with them.
import javax.swing.JOptionPane;


public class MadLibs {
	
	
	public static void main(String[] args) {
		//These are the strings we used in the rhyme
		String firstWord, secondWord, thirdWord, fourthWord, fifthWord;
		firstWord = JOptionPane.showInputDialog(null,"Enter a noun");
		secondWord = JOptionPane.showInputDialog(null,"Enter another noun");
		thirdWord = JOptionPane.showInputDialog(null,"Enter an adjective");
		fourthWord = JOptionPane.showInputDialog(null,"Enter a past tense verb");
		//fifthWord = JOptionPane.showInputDialog(null,"What is your name?");
		String ryhme = " Mary had a little " + firstWord + "\n Its " + secondWord + " was " + thirdWord + " as snow\n"+
		" And everywhere that Mary " + fourthWord + "\n The " + firstWord + " was sure to go "; 
		
		//JOptionPane is what we use to create windows to show the program in
		JOptionPane.showMessageDialog(null, ryhme, "Mad Libs", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
