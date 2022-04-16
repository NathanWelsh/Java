
import javax.swing.JOptionPane;

// **********************************************
// Written by: Nathan Welsh
// For: COP 2800 Java Programming
// Where: FSW Computer Science Program www.fsw.edu
// Professor: Dr. Roger Webster
// When: FALL 2020
// ***********************************************
public class Main {

	public static void main(String[] args) {
		// This program calculates L and R
		int numRightHanders = 0;
		int numLeftHanders = 0;
		String input = "N";
		int total = 0;
		boolean keepgoing = true;

		while (keepgoing) {

			input = JOptionPane.showInputDialog("Which Hand is your dominate Hand?");

			if (input == null || input.equals("")) {

				keepgoing = false;

			} else if (input.equalsIgnoreCase("R")) {
				numRightHanders++;
				total++;
			} else if (input.equalsIgnoreCase("L")) {
				numLeftHanders++;
				total++;
			}

		}

		// input = JOptionPane.showInputDialog("Which Hand is your dominate Hand?");

		String outputmsg = "The Total Number of people is " + total + "\nThe Number of Right handers is "
				+ numRightHanders + "\nThe Number of Left handers is  " + numLeftHanders;

		JOptionPane.showMessageDialog(null, outputmsg);

		System.exit(0);
	}

}
