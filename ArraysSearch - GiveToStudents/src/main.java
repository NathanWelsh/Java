import javax.swing.JOptionPane;
import java.util.Random;

public class main {

	// **********************************************
	// Written by: Nathan Welsh
	// For: COP 2800 Java Programming
	// Where: FSW Computer Science Program www.fsw.edu
	// Professor: Dr. Roger Webster
	// ***********************************************
	static String States[] = new String[50];
	static String Capitals[] = new String[50];

	public static void LoadStates() {
		States[0] = "Alabama";
		Capitals[0] = "Montgomery";
		States[1] = "Alaska";
		Capitals[1] = "Juneau";
		States[2] = "Arizona";
		Capitals[2] = "Phoenix";
		States[3] = "Arkansas";
		Capitals[3] = "Little Rock";
		States[4] = "California";
		Capitals[4] = "Sacramento";
		States[5] = "Colorado";
		Capitals[5] = "Denver";
		States[6] = "Connecticut";
		Capitals[6] = "Hartford";
		States[7] = "Delaware";
		Capitals[7] = "Dover";
		States[8] = "Florida";
		Capitals[8] = "Tallahassee";
		States[9] = "Georgia";
		Capitals[9] = "Atlanta";
		States[10] = "Hawaii";
		Capitals[10] = "Honolulu";
		States[11] = "Idaho";
		Capitals[11] = "Boise";
		States[12] = "Illinois";
		Capitals[12] = "Springfield";
		States[13] = "Indiana";
		Capitals[13] = "Indianapolis";
		States[14] = "Iowa";
		Capitals[14] = "Des Moines";
		States[15] = "Kansas";
		Capitals[15] = "Topeka";
		States[16] = "Kentucky";
		Capitals[16] = "Frankfort";
		States[17] = "Louisiana";
		Capitals[17] = "Baton Rouge";
		States[18] = "Maine";
		Capitals[18] = "Augusta";
		States[19] = "Maryland";
		Capitals[19] = "Annapolis";
		States[20] = "Massachusetts";
		Capitals[20] = "Boston";
		States[21] = "Michigan";
		Capitals[21] = "Lansing";
		States[22] = "Minnesota";
		Capitals[22] = "St. Paul";
		States[23] = "Mississippi";
		Capitals[23] = "Jackson";
		States[24] = "Missouri";
		Capitals[24] = "Jefferson City";
		States[25] = "Montana";
		Capitals[25] = "Helena";
		States[26] = "Nebraska";
		Capitals[26] = "Lincoln";
		States[27] = "Nevada";
		Capitals[27] = "Carson City";
		States[28] = "New Hampshire";
		Capitals[28] = "Concord";
		States[29] = "New Jersey";
		Capitals[29] = "Trenton";
		States[30] = "New Mexico";
		Capitals[30] = "Santa Fe";
		States[31] = "New York";
		Capitals[31] = "Albany";
		States[32] = "North Carolina";
		Capitals[32] = "Raleigh";
		States[33] = "North Dakota";
		Capitals[33] = "Bismarck";
		States[34] = "Ohio";
		Capitals[34] = "Columbus";
		States[35] = "Oklahoma";
		Capitals[35] = "Oklahoma City";
		States[36] = "Oregon";
		Capitals[36] = "Salem";
		States[37] = "Pennsylvania";
		Capitals[37] = "Harrisburg";
		States[38] = "Rhode Island";
		Capitals[38] = "Providence";
		States[39] = "South Carolina";
		Capitals[39] = "Columbia";
		States[40] = "South Dakota";
		Capitals[40] = "Pierre";
		States[41] = "Tennessee";
		Capitals[41] = "Nashville";
		States[42] = "Texas";
		Capitals[42] = "Austin";
		States[43] = "Utah";
		Capitals[43] = "Salt Lake City";
		States[44] = "Vermont";
		Capitals[44] = "Montpelier";
		States[45] = "Virginia";
		Capitals[45] = "Richmond";
		States[46] = "Washington";
		Capitals[46] = "Olympia";
		States[47] = "West Virginia";
		Capitals[47] = "Charleston";
		States[48] = "Wisconsin";
		Capitals[48] = "Madison";
		States[49] = "Wyoming";
		Capitals[49] = "Cheyenne";

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		String inputstring1 = "What is the Capital of: ";
		String finalinputstring = "";
		String correctoutputmsg = "";
		String outputmsg = "";
		String msg = "";
		String caps = "";
		String state = "";
		String Answer = "";
		Boolean keepgoing = true;
		int totalqs = 0;
		int countright = 0;

		LoadStates();

		while (keepgoing) {
			double num = 0;

			int row = GetNextStateIndex(rand);

			try {

				finalinputstring = inputstring1 + States[row];

				// this is where the input is done
				Answer = JOptionPane.showInputDialog(finalinputstring);

				if (Answer == null || Answer.equals("")) {
					keepgoing = false;
				} else {
					String answerlowercase = Answer.toLowerCase();
					String caplowercase = Capitals[row].toLowerCase();

					if (caplowercase.equals(answerlowercase)) {
						countright++;
						correctoutputmsg = answerlowercase + " is correct! \n You have " + countright
								+ " correct answers so far.";
						JOptionPane.showMessageDialog(null, correctoutputmsg);
					} else {
						correctoutputmsg = answerlowercase + " is not correct! " + "It is " + caplowercase;
						JOptionPane.showMessageDialog(null, correctoutputmsg);
					}

					totalqs++;
				}

			} catch (ArithmeticException myex) {

				String errormsg = "Exception error: " + myex.toString();
				JOptionPane.showMessageDialog(null, errormsg);

			} catch (ArrayIndexOutOfBoundsException myex) {

				String errormsg = "Array out of bounds Exception error: " + myex.toString();
				JOptionPane.showMessageDialog(null, errormsg);

			}

		}
	}

	public static int GetNextStateIndex(Random rand) {
		final int min = 0;
		final int max = 50;
		int value = rand.nextInt((max - min) + 1) + min;
		return (value);
	}

}
