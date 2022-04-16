import javax.swing.JOptionPane;

public class Main {
	// **********************************************
	// Written by: Nathan Welsh
	// For: COP 2800 Java Programming
	// Where: FSW Computer Science Program www.fsw.edu
	// Professor: Dr. Roger Webster
	// When: FALL 2020
	// ***********************************************

	public static void main(String[] args) {

		final double CentimetersInanInch = 2.54;
		int yards = 0;
		int feet = 0;
		int inches = 0;
		double cm = 0;
		double meters = 0, feetcm = 0, yardscm = 0, totalcm = 0;

		String thedata = JOptionPane.showInputDialog("please type in yards. ");
		yards = Integer.parseInt(thedata);

		thedata = JOptionPane.showInputDialog("please type in feet. ");
		feet = Integer.parseInt(thedata);
		thedata = JOptionPane.showInputDialog("please type in inches. ");
		inches = Integer.parseInt(thedata);

		meters = (yards * 0.9144 + feet * 0.3048) + (inches * 0.0254);

		String outputmsg = yards + " yards " + feet + " feet and  " + inches + " inches equals " + meters + " meters";
		JOptionPane.showMessageDialog(null, outputmsg);
	}

}
