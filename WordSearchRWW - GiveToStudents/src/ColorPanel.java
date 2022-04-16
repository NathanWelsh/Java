
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JOptionPane;

// *********************************************************
// Modified by: Nathan Welsh
// For: COP 2800 Java Programming
// Where: FSW Computer Science Program www.fsw.edu
// Professor: Dr. Roger Webster
// Originally written by Lori Schmoyer and Dr. Roger Webster
// *********************************************************

public class ColorPanel extends JPanel implements ActionListener {

	private ThePuzzle puzzle;
	private JButton ans;
	private int xCoord, yCoord;
	private boolean moving = false;
	Graphics ColorPanelGraphics = null;
	Boolean buttonpressed = false;

	public ColorPanel(ThePuzzle p) {
		ColorPanelGraphics = this.getGraphics();
		setBackground(Color.black);
		puzzle = p;
		JButton ans = new JButton("Find Words in Puzzle");
		add(ans);
		ans.addActionListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = 50;
		int y = 50;
		ColorPanelGraphics = g;
		g.setColor(Color.white);
		Font font = new Font("Courier New", Font.BOLD, 16);
		g.setFont(font);

		// prints puzzle
		char[][] p = puzzle.getPuzzle();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				g.drawString(p[i][j] + "", x, y);
				x += 20;
			}
			x = 50;
			y = y + 20;
		}

		x = 150;
		y += 30;
		// prints wordlist
		String words[] = puzzle.getWordList();
		for (int i = 0; i < puzzle.getNumWords(); i++) {
			g.drawString(words[i] + "", x, y);
			y += 20;
			x = 150;
		}
		g.setColor(Color.green);
		if (buttonpressed) {
			puzzle.findWords(g);
			buttonpressed = false;
			int numwords = puzzle.numWords;
			;// fix this puzzle.NumWords();
			int numwordsfound = puzzle.numWordsFound; // fix this puzzle.NumWordsFound();
			String msg = "The Number of Words is " + numwords;
			String msg2 = "The Number Found is " + numwordsfound;
			x = 50;
			y = 700;
			g.drawString(msg + "", x, y);
			y = y + 20;
			g.drawString(msg2 + "", x, y);

		}

	}

	public void actionPerformed(ActionEvent e) {

		buttonpressed = true;
		this.repaint();

	}

}
