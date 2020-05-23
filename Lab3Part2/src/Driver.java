
//Kevin Lopez 10/9/2019 Week 03 Lab 03
//This is a Dice Game Program that uses JOptionPane and Math.random() 
import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args) {
		int selection;
		boolean chosenOption;
		boolean value = true;
		// while loop because we want this to go on forever until they dont want to play
		while (value) {
			selection = JOptionPane.showConfirmDialog(null, "Do you want to play the dice game? ", "Dice Game Begin 1",
					JOptionPane.YES_NO_OPTION);
			chosenOption = (selection == JOptionPane.YES_OPTION);
			if (chosenOption) {
				// creating the random variables
				int random1 = (int) (Math.random() * 6) + 1;
				int random2 = (int) (Math.random() * 6) + 1;
				int random3 = (int) (Math.random() * 6) + 1;
				String message = "Die 1: " + random1 + " \n" + "Die 2: " + random2 + "\n" + "Die 1: " + random3;
				JOptionPane.showMessageDialog(null, message, "Roll Results", JOptionPane.INFORMATION_MESSAGE);
				// checking to see if 3 of them are the same
				if (random1 == random2 || random1 == random3 || random1 == random3) {
					String warning = "Two of your dice are a match!";
					JOptionPane.showMessageDialog(null, warning, "WINNER", JOptionPane.WARNING_MESSAGE);
					selection = JOptionPane.showConfirmDialog(null, "Would you like to play again? ",
							"Dice Game Begin 2", JOptionPane.YES_NO_OPTION);
					if (selection == 1) {
						value = false;
						// redundant?
						break;
					}
				}
				// checking to see if 2 of them are the same
				if ((random1 == random2) && (random2 == random3)) {
					String warning2 = "All three of your dice are a match!";
					JOptionPane.showMessageDialog(null, warning2, "WINNER", JOptionPane.WARNING_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "Better luck next time", "Loser", JOptionPane.ERROR_MESSAGE);
					selection = JOptionPane.showConfirmDialog(null, "Would you like to play again? ",
							"Dice Game Begin 2", JOptionPane.YES_NO_OPTION);
					if (selection == 1) {
						value = false;
						break;
					}

					}
			} else 
				{
				// nothing happens.
				}	
			value = false;
			break;

		}

	}

}
