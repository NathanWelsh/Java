import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Locale;

//**********************************************
// Written by: Nathan Welsh
// For: COP 2800 Java Programming
// Where: FSW Computer Science Program www.fsw.edu
// Professor: Dr. Roger Webster
// Quiz GiveToStudents
//***********************************************
public class Main {

	public static void main(String[] args) {

		final double BONUS_1 = 50.00;
		final double BONUS_2 = 75.00;
		final double BONUS_3 = 100.00;
		final double BONUS_4 = 200.00;

		String inputstring0 = "What is your name?";
		String inputstring1 = "Enter number of shifts?";
		String inputstring2 = "Enter number of transactions?";
		String inputstring3 = "Enter transactions dollar value?";

		String outputmsg = "";
		String thedata = "";
		String employeeName;
		double numTransactions;
		double numShifts;
		double dollarValue;
		double productivityscore = 0;
		double bonus = 0;
		String bonusmoneyformatted = "";

		// this is where the input is done
		employeeName = JOptionPane.showInputDialog(inputstring0);

		thedata = JOptionPane.showInputDialog(inputstring1);
		numShifts = Double.parseDouble(thedata);

		thedata = JOptionPane.showInputDialog(inputstring2);
		numTransactions = Double.parseDouble(thedata);

		thedata = JOptionPane.showInputDialog(inputstring3);
		dollarValue = Double.parseDouble(thedata);

// add more input here

		productivityscore = (dollarValue / numTransactions) / numShifts;

		if (productivityscore <= 30) {
			bonus = BONUS_1;
		} else if (productivityscore < 70 && productivityscore > 30) {
			bonus = BONUS_2;
		} else if (productivityscore >= 70 && productivityscore < 200) {
			bonus = BONUS_3;
		} else {
			bonus = BONUS_4;
		}

		bonusmoneyformatted = DecimalFormat.getCurrencyInstance(Locale.US).format((double) bonus);

		// this is the message we want to show
		outputmsg = employeeName + "\nYour productivity score is: " + productivityscore + "\nYour Bonus is: "
				+ bonusmoneyformatted;
		// output to the window is here
		JOptionPane.showMessageDialog(null, outputmsg);

	}

}
