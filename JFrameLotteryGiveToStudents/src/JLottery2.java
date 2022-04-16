import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.util.Locale;
import java.util.Random;
import java.text.Format;
import java.text.NumberFormat;
import java.text.DecimalFormat;

//**********************************************
//Originally Written by: Joyce Farrell 
//Modified by: Nathan Welsh
//Modified by Dr. Roger Webster
//For: COP 2800 Java Programming
//Where: FSW Computer Science Program www.fsw.edu
//Professor: Dr. Roger Webster
//***********************************************
public class JLottery2 extends JFrame implements ItemListener, ActionListener {
	private final int NUM = 54;
	private final int PICKS = 6;
	private JLabel greeting = new JLabel("Play the lottery - Select " + PICKS + " numbers");
	private Font serifBold = new Font("Serif", Font.BOLD, 20);
	private JCheckBox[] choice = new JCheckBox[NUM];
	private JLabel[] label = new JLabel[NUM];
	private String winningsString = "The winning numbers are: ";
	private String youPickedString = "You chose:   ";
	private JTextArea outArea = new JTextArea("Dr. Webster's COP 2800 Java Florida Lotto Game\n");
	private int x, y;
	private int[] ran = new int[PICKS];
	private int[] chosen = new int[PICKS];
	private int chosenCount = 0;
	private int matches = 0;
	int matches0 = 0;
	int matches1 = 0;
	int matches2 = 0;
	int matches3 = 0;
	int matches4 = 0;
	int matches5 = 0;
	int matches6 = 0;
	double MatchesPercent0;
	double MatchesPercent1;
	double MatchesPercent2;
	double MatchesPercent3;
	double MatchesPercent4;
	double MatchesPercent5;
	double MatchesPercent6;
	private int[] winDollars = { 0, 0, 0, 100, 10000, 50000, 1000000 };
	private JTextField title;
	private String finalresult = "";
	private JPanel panel = new JPanel();
	private JButton LottoLoopButton = new JButton();
	private JButton LottoPlayButton = new JButton();
	private GridBagConstraints c = new GridBagConstraints();
	private int row = 1;
	private int col = 0;
	private int playbuttonrow = 15;
	private int outarearow = 17;
	int totalmoneywon = 0;
	int totalspent = 0;
	private Random rand = new Random();

	public JLottery2() {
		super("Dr. Webster's COP 2800 Java Florida Lotto Lottery Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setLayout(new GridBagLayout());
		this.add(panel);

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 20;
		c.anchor = GridBagConstraints.CENTER;
		panel.add(title = new JTextField("Play the COP 2800 Java Florida Lotto!"), c);
		title.setFont(serifBold);
		title.setEditable(false);

		int checkboxnumber = 1;
		for (int row = 1; row <= 6; row++) {
			for (int col = 1; col <= 10; col++) {
				if (checkboxnumber < 54) {
					addCheckBox(checkboxnumber, row, col);
				}
				checkboxnumber++;
			}
		}
		for (int check = 1; check < 7; check++) {
			choice[check].setSelected(true);

		}
		createPlayButton();
		createLoopButton();
		createOutputArea();
	}

	public void addCheckBox(int x, int row, int col) {

		choice[x] = new JCheckBox();
		label[x] = new JLabel("             " + x);
		c.gridx = col;
		c.gridy = row;
		c.gridwidth = 1;
		panel.add(choice[x], c);
		panel.add(label[x], c);
		choice[x].addItemListener(this);

	}

	public void createPlayButton() {

		try {
			File mypic = new File("flamingoonetime.png");
			if (!mypic.exists()) {
				JOptionPane.showMessageDialog(null, "flamingoonetime.png File Not Found");
				return;
			}
			Image img = ImageIO.read(mypic);
			LottoPlayButton.setIcon(new ImageIcon(img));
			LottoPlayButton.addActionListener(this);

		} catch (IOException ex) {
			String msg = "The error is\n" + ex.toString();
			JOptionPane.showMessageDialog(null, msg);

		}
		c.gridx = 0;
		c.gridy = playbuttonrow;
		c.gridwidth = 5;
		panel.add(LottoPlayButton, c);
	}

	// this button says to do the looping!!!
	public void createLoopButton() {

		try {
			File mypic = new File("flamingo1million.png");
			if (!mypic.exists()) {
				JOptionPane.showMessageDialog(null, "flamingo1million.png File Not Found");
				return;
			}
			Image img = ImageIO.read(mypic);
			LottoLoopButton.setIcon(new ImageIcon(img));
			LottoLoopButton.addActionListener(this);

		} catch (IOException ex) {
			String msg = "The error is\n" + ex.toString();
			JOptionPane.showMessageDialog(null, msg);

		}

		c.gridx = 6;
		c.gridy = playbuttonrow;
		c.gridwidth = 5;
		panel.add(LottoLoopButton, c);
	}

	public void createOutputArea() {

		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(outArea);

		JScrollPane jsp = new JScrollPane(panel);
		jsp.setPreferredSize(new Dimension(320, 240));

		add(jsp, BorderLayout.SOUTH);
	}

	public String HowMuchDoIWin(int matches) {
		String FinalAnswer = "";

		switch (matches) {
		case 0:
			FinalAnswer = "0 dollars";
			matches0 = matches0 + 1;
			break;
		case 1:
			FinalAnswer = "0 dollars";
			matches1 = matches1 + 1;
			break;
		case 2:
			FinalAnswer = "Free Ticket!";
			totalmoneywon = totalmoneywon - 2;
			matches2++;
			break;
		case 3:
			FinalAnswer = "$25 dollars";
			totalmoneywon = totalmoneywon + 25;
			matches3++;
			break;
		case 4:
			FinalAnswer = "$380 dollars";
			totalmoneywon = totalmoneywon + 380;
			matches4++;
			break;
		case 5:
			FinalAnswer = "$26,500 dollars";
			totalmoneywon = totalmoneywon + 26500;
			matches5++;
			break;
		case 6:
			FinalAnswer = "$5 million dollars!!!";
			totalmoneywon = totalmoneywon + 5000000;
			matches6++;
			break;

		}

		return FinalAnswer;

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == LottoLoopButton) {// this is the LoopButton!!
			doitall();
		}
		if (e.getSource() == LottoPlayButton) {// this is the PlayButton!!

			CheckWinnings(true);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent check) {
		Object source = check.getItem();

		int select = check.getStateChange();

		if (select == ItemEvent.SELECTED) {
			if (chosenCount == PICKS) {
				for (x = 0; x < NUM; ++x) {
					if (source == choice[x]) {
						choice[x].setSelected(false);
					}
				}
				String msg = "You can only pick 6 numbers - maybe uncheck one..";
				JOptionPane.showMessageDialog(null, msg);
			}
		}
		chosenCount = addupallthepicks();

	}

	public int addupallthepicks() {
		youPickedString = "";
		chosenCount = 0;

		for (x = 1; x < NUM; ++x) {
			if (choice[x].isSelected()) {
				chosen[chosenCount] = x;
				youPickedString += x + "   ";
				chosenCount++;
			}

		}
		return (chosenCount);
	}

	public static double round2(double d) {

		final double WHOLE_NUMBER = 1L << 53;

		final double factor = 1e2;
		return d > WHOLE_NUMBER || d < -WHOLE_NUMBER ? d
				: (long) (d < 0 ? d * factor - 0.5 : d * factor + 0.5) / factor;
	}

	public void doitall() {
		// your code goes here
		Boolean lottonumnot6 = true;
		String msg = "";
		int count = 0;
		int nummatches = 0;

		while (lottonumnot6) {
			count++;
			totalspent = totalspent + 2;
			nummatches = CheckWinnings(false);

			if (count % 400000 == 0)

			{

				System.out.println("matches is " + matches + " COUNT IS " + count);
			}

			if (nummatches == 6) {
				lottonumnot6 = false;
			}

		}

		OutputMessages(msg, count);

	}

	public void OutputMessages(String msg, int count) {

		int TotalDifference = totalmoneywon - totalspent;

		String totalmoneySpent = DecimalFormat.getCurrencyInstance(Locale.US).format((double) totalspent);

		String totalmoneyWon = DecimalFormat.getCurrencyInstance(Locale.US).format((double) totalmoneywon);

		String totalmoneyDifference = DecimalFormat.getCurrencyInstance(Locale.US).format((double) TotalDifference);

		NumberFormat dollarFormatter = NumberFormat.getCurrencyInstance();
		dollarFormatter.format(totalspent);
		dollarFormatter.format(totalmoneywon);
		dollarFormatter.format(TotalDifference);

		String TotalNumberofTickets = NumberFormat.getNumberInstance(Locale.US).format((double) count);
		String totalmatches0 = NumberFormat.getNumberInstance(Locale.US).format((double) matches0);
		String totalmatches1 = NumberFormat.getNumberInstance(Locale.US).format((double) matches1);
		String totalmatches2 = NumberFormat.getNumberInstance(Locale.US).format((double) matches2);
		String totalmatches3 = NumberFormat.getNumberInstance(Locale.US).format((double) matches3);
		String totalmatches4 = NumberFormat.getNumberInstance(Locale.US).format((double) matches4);
		String totalmatches5 = NumberFormat.getNumberInstance(Locale.US).format((double) matches5);
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		

		MatchesPercent0 = (matches0 / (float) count) * 100.00;
		MatchesPercent1 = (matches1 / (float) count) * 100.00;
		MatchesPercent2 = (matches2 / (float) count) * 100.00;
		MatchesPercent3 = (matches3 / (float) count) * 100.00;
		MatchesPercent4 = (matches4 / (float) count) * 100.00;
		MatchesPercent5 = (matches5 / (float) count) * 100.00;
		MatchesPercent6 = (matches6 / (float) count) * 100.00;

		msg = "The Winning numbers are: \n" + winningsString + "\nYour numbers are: \n" + youPickedString
				+ "\nYou match " + matches + " numbers " + "\nCount is: " + TotalNumberofTickets + " tickets \n"
				+ "____________________________________\n"

				+ "\n matchescount[0] " + totalmatches0 + " -- " + (nf.format(MatchesPercent0)) + " %"
				+ "\n matchescount[1] " + totalmatches1 + " -- " + (nf.format(MatchesPercent1)) + " %"
				+ "\n matchescount[2] " + totalmatches2 + " -- "+ (nf.format(MatchesPercent2)) + " %"
				+ "\n matchescount[3] " + totalmatches3 + " -- " + (nf.format(MatchesPercent3)) + " %"
				+ "\n matchescount[4] " + totalmatches4 + " -- " + (nf.format(MatchesPercent4)) + " %"
				+ "\n matchescount[5] "+ totalmatches5 + " -- " + (nf.format(MatchesPercent5))  + " %"
				+ "\n matchescount[6] " + matches6 + " -- " + (nf.format(MatchesPercent6)) + " %" + "\n"

				+ "\n Total Spent is: " + totalmoneySpent 
				+ "\n Total Won is: " + totalmoneyWon
				+ "\n Total Difference is: "+ totalmoneyDifference;

		outArea.append(msg);

		JOptionPane.showMessageDialog(null, msg);

	}

	public int CheckWinnings(boolean onetime) {

		youPickedString = "";
		chosenCount = 0;
		winningsString = "";
		matches = 0;
		int max = 53;
		int min = 1;

		Arrays.sort(chosen);
		for (x = 1; x < NUM; ++x) {
			if (choice[x].isSelected()) {
				chosen[chosenCount] = x;
				youPickedString += x + "   ";
				++chosenCount;
			}

		}

		for (x = 0; x < PICKS; ++x) {

			int randomNum = rand.nextInt((max - min) + 1) + min;
			ran[x] = randomNum;
			for (y = 0; y < x; ++y)
				if (ran[x] == ran[y])
					--x;
		}
		Arrays.sort(ran);

		for (x = 0; x < PICKS; ++x) {
			winningsString += ran[x] + "   ";
		} //

		if (chosenCount == PICKS) {
			for (x = 0; x < PICKS; ++x)
				for (y = 0; y < PICKS; ++y)
					if (chosen[x] == ran[y])
						++matches;

			String howmuch = HowMuchDoIWin(matches);

			finalresult = "Your numbers are\n" + youPickedString + "\nYou matched " + matches + " numbers"
					+ "\nYou win: " + howmuch;
		}

		String msg = "The Winning Numbers are:\n " + winningsString + "\n" + finalresult;

		if (onetime) {
			outArea.append("\n_______________\n" + msg);
			JOptionPane.showMessageDialog(null, msg);
		}
		return (matches);

	}

}
