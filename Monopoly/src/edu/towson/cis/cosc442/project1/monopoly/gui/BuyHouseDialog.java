
package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import edu.towson.cis.cosc442.project1.monopoly.Player;


// TODO: Auto-generated Javadoc
/**
 * The Class BuyHouseDialog.
 */
public class BuyHouseDialog extends JDialog {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cbo monopoly. */
	private JComboBox<?> cboMonopoly;
	
	/** The cbo number. */
	private JComboBox<?> cboNumber;

	/** The player. */
	private Player player;

	/**
	 * Instantiates a new buy house dialog.
	 *
	 * @param player the player
	 */
	public BuyHouseDialog(Player player) {
		this.player = player;
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3, 2));
		c.add(new JLabel("Select monopoly"));
		c.add(buildMonopolyComboBox());
		c.add(new JLabel("Number of houses"));
		c.add(buildNumberComboBox());
		c.add(buildOKButton());
		c.add(buildCancelButton());
		c.doLayout();
		this.pack();
	}

	/**
	 * Builds the cancel button.
	 *
	 * @return the j button
	 */
	private JButton buildCancelButton() {
		JButton btn = new JButton("Cancel");
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				cancelClicked();
			}
		});
		return btn;
	}

	/**
	 * Builds the monopoly combo box.
	 *
	 * @return the j combo box
	 */
	private JComboBox<?> buildMonopolyComboBox() {
		cboMonopoly = new JComboBox<Object>(player.getMonopolies());
		return cboMonopoly;
	}
	
	/**
	 * Builds the number combo box.
	 *
	 * @return the j combo box
	 */
	private JComboBox<?> buildNumberComboBox() {
		cboNumber = new JComboBox<Object>(new Integer[]{
				new Integer(1),
				new Integer(2),
				new Integer(3),
				new Integer(4),
				new Integer(5)});
		return cboNumber;
	}

	/**
	 * Builds the OK button.
	 *
	 * @return the j button
	 */
	private JButton buildOKButton() {
		JButton btn = new JButton("OK");
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				okClicked();
			}
		});
		return btn;
	}
	
	/**
	 * Cancel clicked.
	 */
	private void cancelClicked() {
		this.dispose();
	}
	
	/**
	 * Ok clicked.
	 */
	private void okClicked() {
		String monopoly = (String)cboMonopoly.getSelectedItem();
		int number = cboNumber.getSelectedIndex() + 1;
		player.purchaseHouse(monopoly, number);
		this.dispose();
	}
}
