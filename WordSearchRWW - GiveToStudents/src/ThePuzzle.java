/* * ThePuzzle.java
 * Created on July 27, 2006, 11:13 AM */

import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

// *********************************************************
// Modified by: Nathan Welsh
// For: COP 2800 Java Programming
// Where: FSW Computer Science Program www.fsw.edu
// Professor: Dr. Roger Webster
// Originally written by Lori Schmoyer and Dr. Roger Webster
// *********************************************************
public class ThePuzzle {

	char[][] puzzle = new char[15][15];
	String[] words = new String[50];
	int numWords = 0;
	int numWordsFound = 0;
	int puzzlelength = 15;

	/** Creates a new instance of ThePuzzle */
	public ThePuzzle(String puzzleFile, String wordsFile) throws IOException {
		File thefile;

		try {
			thefile = new File(puzzleFile);
			if (!thefile.exists()) {
				JOptionPane.showMessageDialog(null, "Puzzle Files Not Found");
				return;
			}
			Scanner readPuzzle = new Scanner(thefile);
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++)
					puzzle[i][j] = readPuzzle.next().charAt(0);

			Scanner readWords = new Scanner(new File(wordsFile));
			while (readWords.hasNext()) {
				words[numWords] = readWords.next();
				numWords++;
			}
		} catch (Exception e) {
			System.out.println("exception in ReadFile: " + e.toString());
		}

	}

	public void printPuzzle() {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[i].length; j++)
				System.out.print(puzzle[i][j] + " ");
			System.out.println();
		}
	}

	public void printWordList() {
		for (int i = 0; i < numWords; i++)
			System.out.println(puzzle[i]);
	}

	public void findWords(Graphics g) {
		// you add code here

		char[][] puzzle = getPuzzle();
		String[] words = getWordList();
		for (int row = 0; row < puzzle.length; row++) {
			for (int col = 0; col < puzzle[0].length; col++) {

				// to iterate for each word in words for a specific char in 2-d array
				for (int word_ind = 0; word_ind < numWords; word_ind++) {
					String word = words[word_ind];
					if (word.charAt(0) != puzzle[row][col])
						continue;
					int len = 0, r1 = row, c1 = col;

					// to check if the word is in same column
					while (len < word.length() && c1 < puzzle[0].length && word.charAt(len) == puzzle[r1][c1]) {
						len++;
						c1++;
					}
					if (len == word.length()) {
						numWordsFound += 1;
						g.drawOval(50 + 20 * col - 10, 50 + 20 * row - 17, len * 21, 25);
					}
					c1 = col;
					len = 0;

					// to check if the word is in same row
					while (len < word.length() && r1 < puzzle.length && word.charAt(len) == puzzle[r1][c1]) {
						len++;
						r1++;
					}
					if (len == word.length()) {
						numWordsFound += 1;
						g.drawOval(50 + 20 * col - 10, 50 + 20 * row - 17, 25, len * 21);
					}
				}
			}
		}

	}

	public char[][] getPuzzle() {

		return puzzle;
	}

	public String[] getWordList() {
		String[] w = new String[50];
		for (int i = 0; i < numWords; i++)
			w[i] = words[i];
		return w;
	}

	public int getNumWords() {
		return numWords;
	}

	// when you find a word
	// this paints it horizontally on the graphics area
	// g.drawOval(50 + 20 * initialColumn - 10, 50 + 20 * initialRow -
	// 17,word.length() * 21, 25);

	// this paints it vertically on the graphics area
//		g.drawOval(50 + 20 * initialColumn - 10, 50 + 20 * initialRow - 17, 25, word.length() * 21);

}
