
public class Student {

	// **********************************************
	// Written by: Nathan Welsh
	// For: COP 2800 Java Programming
	// Where: FSW Computer Science Program www.fsw.edu
	// Professor: Dr. Roger Webster
	// GiveToStudents
	// ***********************************************

	// the private data members
	private int idNumber;
	private int hours;
	private int points;
	private String name = "";

	// Constructor default
	Student(String Name) {
		idNumber = 0;
		points = 0;
		hours = 0;
		name = Name;
	}

	// Constructor 2
	Student(String Name, int in_idNumber, int in_points, int in_hours) {
		idNumber = in_idNumber;
		points = in_points;
		hours = in_hours;
		name = Name;
	}
	// end of constructor added in part c

	// the public get and set methods

	public void setIDnumber(int number) {
		idNumber = number;
	}

	public String getName() {
		return name;
	}

	public int getIDnumber() {
		return idNumber;
	}

	public void setHours(int number) {
		hours = number;
	}

	public int getHours() {
		return hours;
	}

	public void setPoints(int number) {
		points = number;
	}

	public int getPoints() {
		return points;
	}

	public double getGradePoint() {
		return (points * 1.0 / hours);

	}
}
