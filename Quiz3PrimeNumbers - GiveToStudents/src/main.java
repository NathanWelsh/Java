import java.text.DecimalFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

public class main {

	// **********************************************
	// Written by: Nathan Welsh
	// For: COP 2800 Java Programming
	// Where: FSW Computer Science Program www.fsw.edu
	// Professor: Dr. Roger Webster
	// Quiz 3 More Loops Programming in Java
	// GiveToStudents Code
	// ***********************************************
	public static void main(String[] args) {

		String inputstring1 = "Enter Starting Number";
		String inputstring2 = "Enter Ending Number";

		String outputmsg = "Prime Numbers\n";
		String thedata = "";

		int start = 0;
		int end = 0;

		thedata = JOptionPane.showInputDialog(inputstring1);
		// this makes the string a number
		start = Integer.parseInt(thedata);

		thedata = JOptionPane.showInputDialog(inputstring2);
		// this makes the string a number
		end = Integer.parseInt(thedata);

		for (int i = start; i <= end; i++) {

			outputmsg += primefact(i) + "\n";

		}

		JOptionPane.showMessageDialog(null, outputmsg);

	}

	static boolean evenlydivides(int mynum, int mydivisor) {
		if (mynum % mydivisor == 0)
			return (true);
		else
			return (false);

	}

	static String primefact(int num) {
		int divisor = 2;
		int count = 0;
		String outputmsg = num + " = ";

		while (num > 1) {

			if (evenlydivides(num, divisor)) {

				count++;
				if (count > 1) //
					outputmsg += " x ";
				outputmsg += divisor;
				num = num / divisor;

			} else {
				divisor = divisor + 1;
			}

		} // end while

		if (count == 1)
			outputmsg += " .... this is PRIME!!";

		return (outputmsg);

	}// end Primefact()
}
