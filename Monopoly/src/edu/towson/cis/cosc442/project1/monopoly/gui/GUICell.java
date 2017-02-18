package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import edu.towson.cis.cosc442.project1.monopoly.*;

// TODO: Auto-generated Javadoc
/**
 * The Class GUICell.
 */
public class GUICell extends JPanel {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cell. */
	private Cell cell;
	
	/** The lbl info. */
	private JLabel lblInfo;
	
	/** The lbl players. */
	private JLabel[] lblPlayers = new JLabel[GameMaster.MAX_PLAYER];
	
    /**
     * Instantiates a new GUI cell.
     *
     * @param cell the cell
     */
    public GUICell(Cell cell) {
        this.cell = cell;
        setLayout(new OverlayLayout(this));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        JPanel pnlPlayer = new JPanel();
        pnlPlayer.setLayout(new GridLayout(2, 4));
        pnlPlayer.setOpaque(false);
        createPlayerLabels(pnlPlayer);
        add(pnlPlayer);
        setPreferredSize(new Dimension(100,100));
        addCellInfo();
        this.doLayout();
	}
	
	/**
	 * Adds the cell info.
	 */
	private void addCellInfo() {
        lblInfo = new JLabel();
		displayInfo();
        JPanel pnlInfo = new JPanel();
        pnlInfo.setLayout(new GridLayout(1, 1));
        pnlInfo.add(lblInfo);
        add(pnlInfo);
    }
	
	/**
	 * Adds the player.
	 *
	 * @param index the index
	 */
	public void addPlayer(int index) {
		Player player = GameMaster.instance().getPlayer(index);
		lblPlayers[index].setText(player.getName().substring(0, 1));
		lblPlayers[index].setOpaque(true);
	}

    /**
     * Creates the player labels.
     *
     * @param pnlPlayer the pnl player
     */
    private void createPlayerLabels(JPanel pnlPlayer) {
		for (int i = 0; i < GameMaster.MAX_PLAYER; i++) {
			lblPlayers[i] = new JLabel();
			lblPlayers[i].setBackground(Color.GREEN);
			pnlPlayer.add(lblPlayers[i]);
		}
	}

	/**
	 * Display info.
	 */
	public void displayInfo() {
		lblInfo.setText(InfoFormatter.cellInfo(cell));
        this.invalidate();
		this.repaint();
	}

	/**
	 * Gets the cell.
	 *
	 * @return the cell
	 */
	public IOwnable getCell() {
		return cell;
	}
	
	/**
	 * Removes the player.
	 *
	 * @param index the index
	 */
	public void removePlayer(int index) {
		lblPlayers[index].setText("");
		lblPlayers[index].setOpaque(false);
        this.repaint();
	}
}
