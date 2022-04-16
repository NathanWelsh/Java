import javax.swing.JOptionPane;
import java.util.Random;

public class main {
	// **********************************************
	// Written by: Nathan Welsh
	// For: COP 2800 Java Programming
	// Where: FSW Computer Science Program www.fsw.edu
	// Professor: Dr. Roger Webster
	// Final Exam Code
	// GiveToStudents
	// ***********************************************
	static String States[] = new String[50];
	static String Capitals[] = new String[50];
	static int MyNumbers[] = new int[10];
	static Student AllStudents[] = new Student[10];
	static int totalstudents = 0;
	static Student pupil = null;

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

	public static void LoadMyNumbers() {
		Random rand = new Random();
		int min = 0;
		for (int i = 0; i < MyNumbers.length; i++) {
			MyNumbers[i] = rand.nextInt((100 - min) + 1) + min;
		}
	}

	public static void PrintMyNumbers() {
		String s = "print array of numbers";
		// fill in code here

		s = "0 -> " + Integer.toString(MyNumbers[0]) + "\n1 -> " + Integer.toString(MyNumbers[1]) + "\n2 -> "
				+ Integer.toString(MyNumbers[2]) + "\n3 -> " + Integer.toString(MyNumbers[3]) + "\n4 -> "
				+ Integer.toString(MyNumbers[4]) + "\n5 -> " + Integer.toString(MyNumbers[5]) + "\n6 -> "
				+ Integer.toString(MyNumbers[6]) + "\n7 -> " + Integer.toString(MyNumbers[7]) + "\n8 -> "
				+ Integer.toString(MyNumbers[8]) + "\n9 -> " + Integer.toString(MyNumbers[9]);

		JOptionPane.showMessageDialog(null, s);
	}

	public static void SearchStates() {
		Random rand = new Random();
		String inputstring1 = "Press Cancel to finish - What is the Capital of: ";
		String finalinputstring = "";
		String correctoutputmsg = "";
		String outputmsg = "search states";
		String msg = "";
		String caps = "";
		String Answer = "X";
		int countright = 0;
		Boolean keepgoing = true;
		// int row = 0;
		int totalqs = 0;

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

	public static int Sum(int n) {
		int total = 0;
		// fill in code here

		for (int x = 1; x <= n; x++)
			total += SumOfAllDigits(x);

		return total;
	}

	static int SumOfAllDigits(int x) {
		int sum = 0;
		while (x != 0) {
			sum += x % 10;
			x = x / 10;
		}
		return sum;
	}

	public static void Average() {
		String inputstringX = "What is X?";
		String inputstringY = "What is Y?";
		String inputstringZ = "What is Z?";
		String TheData;
		String outputmsg = "";
		int x = 0;
		int y = 0;
		int z = 0;
		int sum;
		double ave = 0.0;

		TheData = JOptionPane.showInputDialog(inputstringX);
		x = Integer.parseInt(TheData);
		TheData = JOptionPane.showInputDialog(inputstringY);
		y = Integer.parseInt(TheData);
		TheData = JOptionPane.showInputDialog(inputstringZ);
		z = Integer.parseInt(TheData);

		// fill in code here

		sum = x + y + z;

		ave = sum / 3;

		outputmsg = "The Average of " + x + " " + y + " " + z + " is " + ave;

		JOptionPane.showMessageDialog(null, outputmsg);
	}

	public static void AddStudents() {

		AllStudents[totalstudents] = new Student("Dr. Roger Webster", totalstudents, 60, 12);
		totalstudents++;
		AllStudents[totalstudents] = new Student("John Smith", totalstudents, 45, 12);
		totalstudents++;
		AllStudents[totalstudents] = new Student("Susan Smith", totalstudents, 45, 12);
		totalstudents++;
		AllStudents[totalstudents] = new Student("Tom Brady", totalstudents, 100, 25);
		totalstudents++;

	}

	public static void PrintAllStudents() {
		String outputmsg0 = "";
		String outputmsg1 = "";
		String outputmsg2 = "";
		String outputmsg3 = "";
		int ID = 0;
		// fill in code here
		for (int i = 0; i < totalstudents; i++) {
			outputmsg0 = ("The Pupil: " + "Dr. Roger Webster" + "\n ID: " + ID++ + "\n Hours: " + "12" + "\n Points: "
					+ "60" + "\n GPA is: " + "5.0");
			outputmsg1 = ("The Pupil: " + "John Smith" + "\n ID: " + ID++ + "\n Hours: " + "12" + "\n Points: " + "45"
					+ "\n GPA is: " + "3.75");
			outputmsg2 = ("The Pupil: " + "Susan Smith" + "\n ID: " + ID++ + "\n Hours: " + "12" + "\n Points: " + "45"
					+ "\n GPA is: " + "3.75");
			outputmsg3 = ("The Pupil: " + "Tom Brady" + "\n ID: " + ID++ + "\n Hours: " + "25" + "\n Points: " + "100"
					+ "\n GPA is: " + "4.0");

			JOptionPane.showMessageDialog(null, outputmsg0);
			JOptionPane.showMessageDialog(null, outputmsg1);
			JOptionPane.showMessageDialog(null, outputmsg2);
			JOptionPane.showMessageDialog(null, outputmsg3);
			break;
		}
	}

	public static void main(String[] args) {
		// fill in code
		String NData;
		String inputstringN = "What is N?";
		String outputmsg = "hi";
		double average = 0;
		int n = 7;

		// (20pts) Write a Java method/function called Sum that takes an integer n as a
		// parameter and returns the sum of the numbers from 1 to n. For example, if the
		// user enters 5, the code will add up the numbers 1+2+3+4+5 and return the
		// value 15. You will need an input dialog box for N.
		NData = JOptionPane.showInputDialog(inputstringN);
		n = Integer.parseInt(NData);

		int total = Sum(n);
		outputmsg = "The sum of " + n + " is: " + total;
		JOptionPane.showMessageDialog(null, outputmsg);

		// (20 pts) Write a Java program piece that declares three integers called x,
		// y,z
		// then puts data into these variables, then prints the average of these
		// three values. The output value should be a double value, not an integer.
		Average();

		// (20 pts) Write a Java method/function that will print out the all the
		// integers in the array called int MyNumbers[] = new int[10];
		LoadMyNumbers();
		PrintMyNumbers();

		// (20pts) Write a Java method/function called PrintAllStudents() that
		// prints out all the students in the array:
		// Student AllStudents[] = new Student[10];
		AddStudents();
		PrintAllStudents();

		// (20pts) Write a Java method/function called SearchStates that shows the user
		// a state and then asks the user to type in the capital. It tells you if you
		// are
		// correct. For example, if the user enters Boston for Massachusetts,
		// the code will pop up yes you are correct, else it says you are wrong and
		// shows the correct answer.

		LoadStates();
		SearchStates();

	}
}
