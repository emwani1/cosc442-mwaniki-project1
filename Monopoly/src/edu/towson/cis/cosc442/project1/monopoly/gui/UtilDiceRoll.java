package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.towson.cis.cosc442.project1.monopoly.GameMaster;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilDiceRoll.
 */
public class UtilDiceRoll extends JDialog {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Show dialog.
	 *
	 * @return the int
	 */
	@SuppressWarnings("deprecation")
	public static int showDialog() {
		UtilDiceRoll dialog = new UtilDiceRoll();
		dialog.show();
		return dialog.diceValue;
	}
	
	/** The btn dice. */
	JButton btnDice = new JButton("Roll the Dice!");
	
	/** The btn OK. */
	private JButton btnOK = new JButton("OK");
	
	/** The dice value. */
	private int diceValue;
	
	/** The lbl prompt. */
	private JLabel lblPrompt = new JLabel();

	/**
	 * Instantiates a new util dice roll.
	 */
	public UtilDiceRoll() {
		setModal(true);
		btnOK.setEnabled(false);
		lblPrompt.setText("Please roll the dice to determine your utility bill.");
		Container contentPane = getContentPane();
		JPanel pnlButtons = new JPanel();
		pnlButtons.add(btnDice);
		pnlButtons.add(btnOK);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(lblPrompt, BorderLayout.CENTER);
		contentPane.add(pnlButtons, BorderLayout.SOUTH);
		btnDice.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				rollDice();
			}
		});
		btnOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				okClicked();
			}
		});
		this.pack();
	}
	
	/**
	 * Ok clicked.
	 */
	public void okClicked(){
		this.dispose();
	}
	
	/**
	 * Roll dice.
	 */
	public void rollDice() {
		int[] diceRoll = GameMaster.instance().rollDice();
		this.diceValue = diceRoll[0] + diceRoll[1];
		lblPrompt.setText("You rolled " + diceValue);
		btnDice.setEnabled(false);
		btnOK.setEnabled(true);
	}
}
