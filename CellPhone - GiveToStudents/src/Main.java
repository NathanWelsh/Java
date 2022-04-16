import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

// **********************************************
// Written by: Nathan Welsh
// For: COP 2800 Java Programming
// Where: FSW Computer Science Program www.fsw.edu
// Professor: Dr. Roger Webster
// ***********************************************
public class Main {

	public static void main(String[] args) {
		int talk;
		int texts;
		int data;
		final int TALK_MIN = 500;
		final int TEXTS_MIN = 100;
		final int DATA_MIN = 2;
		final int PRICEA = 49;
		final int PRICEB = 55;
		final int PRICEC = 61;
		final int PRICED = 70;
		final int PRICEE = 79;
		final int PRICEF = 87;
		String entry, message;
		int price = 0;
		String plan = "";

		String name = JOptionPane.showInputDialog(null, "What is your name?");

		entry = JOptionPane.showInputDialog(null, "Enter talk minutes needed");
		talk = Integer.parseInt(entry);

		entry = JOptionPane.showInputDialog(null, "Enter text messages needed");
		texts = Integer.parseInt(entry);

		entry = JOptionPane.showInputDialog(null, "Enter gigabytes of data needed");
		data = Integer.parseInt(entry);


		if (talk <= TALK_MIN) {
			if (texts == 0) {
			plan = "A";
			price = PRICEA;
			}
			
		} if (texts > 0) {
			plan = "B";
			price = PRICEB;
		} if (talk > TALK_MIN) {
			if (texts > TEXTS_MIN) {
				plan = "D";
				price = PRICED;
			} else {
				plan = "C";
				price = PRICEC;
			}
		}
		
		if (data > 0) {

			if (data > DATA_MIN) {
				plan = "F";
				price = PRICEF;
			} else {
				plan = "E";
				price = PRICEE;
			}
		}

		message = name + " Your Plan is: Plan " + plan + " at $" + price + " per month";
		JOptionPane.showMessageDialog(null, message);

		// String totalmoneyformatted =
		// DecimalFormat.getCurrencyInstance(Locale.US).format((double) federalTax);
		// totalmoneyformatted = totalmoneyformatted.replaceAll("\\.00", "");

		System.exit(0);

	}

}
