import javax.swing.JOptionPane;

//**********************************************
//Written by: Nathan Welsh
//For: COP 2800 Java Programming
//Where: FSW Computer Science Program www.fsw.edu
//Professor: Dr. Roger Webster
//***********************************************
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pennies = 0;
		int nickels = 0;
		String inputstring1 = "Dude type in the number of nickels";
		String inputstring2 = "Dude type in the number of pennies";
		String inputstring3 = "Dude what is your name";
		String outputmsg = "xxx";
		String thedata = "666";
		String Name = "";
		int totalcents = 0;
		int dollars = 0;
		int cents = 0;

		// this is where the input is done
		Name = JOptionPane.showInputDialog(inputstring3);

		// this is where the input is done
		thedata = JOptionPane.showInputDialog(inputstring1);

		// this makes the string a number
		nickels = Integer.parseInt(thedata);

		// this is where the input is done
		thedata = JOptionPane.showInputDialog(inputstring2);

		// this makes the string a number
		pennies = Integer.parseInt(thedata);

		// this converts total cents you put code in here

		totalcents = (5 * nickels) + pennies;
		dollars = totalcents / 100;
		cents = totalcents % 100;

		// this is the message we want to show
		outputmsg = Name + " Your collection is worth: " + dollars + " dollars  and  " + cents + " cents";

		// output to the window is here
		JOptionPane.showMessageDialog(null, outputmsg);

	}

}
