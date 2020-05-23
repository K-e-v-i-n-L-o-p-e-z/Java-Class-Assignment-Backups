//JOptionPane Confirmation Dialog
import javax.swing.JOptionPane;

/*
 * JOptionPane.YES_OPTION return 0
 * JOptionPane.NO_OPTION return 1
 * JOptionPane.CANCEL_OPTION return 2
 */
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int selection;
//		boolean isYesOption;
//		
//		
//		//YES_OPTION is an enum and enums result in numbers - Professor
//		
//		selection = JOptionPane.showConfirmDialog(null, "Do you wish to upgrade to first class? ");
//		isYesOption = (selection == JOptionPane.YES_OPTION);
//		if(isYesOption) {
//			selection = 150;
//		}else {
//			selection = 100;
//		}
//		
//		JOptionPane.showMessageDialog(null, "You responded " + isYesOption + " which is $" + selection);
//		
//		JOptionPane.showConfirmDialog(null, "An error has occured, continue?", null, JOptionPane.YES_NO_CANCEL_OPTION);
		//Why did we not have to seed it? The JVM runs in a clock cycle that recycles. WHat is sEEding LMAO ? 
		
		int random1 = (int) (Math.random() * 6) + 1;
		int random2 = (int) (Math.random() * 6) + 1;
		System.out.println("Your die roll is: " + random1);
		System.out.println("Your die roll is: " + random2);
		if(random1 == random2) {
			System.out.println("You threw doubles! ");
		}
		
	}

}
