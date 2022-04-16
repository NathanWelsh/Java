import java.util.Scanner;
import java.io.*;
import javax.swing.*; // For JFrame and JPanel
import java.awt.*; // For Color, Container, and GridLayout

public class Main {

	// *********************************************************
	// Modified by: Nathan Welsh
	// For: COP 2800 Java Programming
	// Where: FSW Computer Science Program www.fsw.edu
	// Professor: Dr. Roger Webster
	// Originally written by Lori Schmoyer and Dr. Roger Webster
	// *********************************************************

	public static void main(String[] args) {

		JFrame theGUI = new JFrame();
		theGUI.setTitle("WordFind Answer Program");
		theGUI.setSize(400, 800);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			ThePuzzle puzzle = new ThePuzzle("puzzle5.txt", "words3.txt");
			ColorPanel graphics = new ColorPanel(puzzle);
			Container pane = theGUI.getContentPane();
			pane.add(graphics);
		} catch (Exception e) {
			System.out.println("exception in ReadFile: " + e.toString());
		}

		theGUI.setVisible(true);
	}

}
