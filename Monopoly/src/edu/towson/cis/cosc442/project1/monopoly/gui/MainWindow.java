package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import edu.towson.cis.cosc442.project1.monopoly.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MainWindow.
 */
public class MainWindow extends JFrame implements MonopolyGUI{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The east panel. */
	JPanel eastPanel = new JPanel();
	
	/** The gui cells. */
	ArrayList<GUICell> guiCells = new ArrayList<GUICell>();

	/** The north panel. */
	JPanel northPanel = new JPanel();
	
	/** The player panels. */
	PlayerPanel[] playerPanels;
	
	/** The south panel. */
	JPanel southPanel = new JPanel();
	
	/** The west panel. */
	JPanel westPanel = new JPanel();

	/**
	 * Instantiates a new main window.
	 */
	public MainWindow() {
		northPanel.setBorder(new LineBorder(Color.BLACK));
		southPanel.setBorder(new LineBorder(Color.BLACK));
		westPanel.setBorder(new LineBorder(Color.BLACK));
		eastPanel.setBorder(new LineBorder(Color.BLACK));
		
		Container c = getContentPane();
		//setSize(800, 600);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setSize(d);
		c.add(northPanel, BorderLayout.NORTH);
		c.add(southPanel, BorderLayout.SOUTH);
		c.add(eastPanel, BorderLayout.EAST);
		c.add(westPanel, BorderLayout.WEST);
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * Adds the cells.
	 *
	 * @param panel the panel
	 * @param cells the cells
	 */
	private void addCells(JPanel panel, List<?> cells) {
		for(int x=0; x<cells.size(); x++) {
			GUICell cell = new GUICell((Cell)cells.get(x));
			panel.add(cell);
			guiCells.add(cell);
		}
	}
	
	/**
	 * Builds the player panels.
	 */
	private void buildPlayerPanels() {
		GameMaster master = GameMaster.instance();
		JPanel infoPanel = new JPanel();
        int players = master.getNumberOfPlayers();
        infoPanel.setLayout(new GridLayout(2, (players+1)/2));
		getContentPane().add(infoPanel, BorderLayout.CENTER);
		playerPanels = new PlayerPanel[master.getNumberOfPlayers()];
		for (int i = 0; i< master.getNumberOfPlayers(); i++){
			playerPanels[i] = new PlayerPanel(master.getPlayer(i));
			infoPanel.add(playerPanels[i]);
			playerPanels[i].displayInfo();
		}
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#enableEndTurnBtn(int)
	 */
	public void enableEndTurnBtn(int playerIndex) {
		playerPanels[playerIndex].setEndTurnEnabled(true);
	}
	
	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#enablePlayerTurn(int)
	 */
	public void enablePlayerTurn(int playerIndex) {
		playerPanels[playerIndex].setRollDiceEnabled(true);
		
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#enablePurchaseBtn(int)
	 */
	public void enablePurchaseBtn(int playerIndex) {
		playerPanels[playerIndex].setPurchasePropertyEnabled(true);
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#getDiceRoll()
	 */
	@SuppressWarnings("deprecation")
	public int[] getDiceRoll() {
		TestDiceRollDialog dialog = new TestDiceRollDialog(this);
		dialog.show();
		return dialog.getDiceRoll();
	}

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#isDrawCardButtonEnabled()
     */
    public boolean isDrawCardButtonEnabled() {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        return playerPanels[currentPlayerIndex].isDrawCardButtonEnabled();
    }

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#isEndTurnButtonEnabled()
     */
    public boolean isEndTurnButtonEnabled() {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        return playerPanels[currentPlayerIndex].isEndTurnButtonEnabled();
    }

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#isGetOutOfJailButtonEnabled()
	 */
	public boolean isGetOutOfJailButtonEnabled() {
		int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
		return playerPanels[currentPlayerIndex].isGetOutOfJailButtonEnabled();
	}

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#isTradeButtonEnabled(int)
     */
    public boolean isTradeButtonEnabled(int i) {
        return playerPanels[i].isTradeButtonEnabled();
    }
	
	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#movePlayer(int, int, int)
	 */
	public void movePlayer(int index, int from, int to) {
		GUICell fromCell = queryCell(from);
		GUICell toCell = queryCell(to);
		fromCell.removePlayer(index);
		toCell.addPlayer(index);
	}

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#openRespondDialog(edu.towson.cis.cosc442.project1.monopoly.TradeDeal)
     */
    @SuppressWarnings("deprecation")
	public RespondDialog openRespondDialog(TradeDeal deal) {
        GUIRespondDialog dialog = new GUIRespondDialog();
        dialog.setDeal(deal);
        dialog.show();
        return dialog;
    }

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#openTradeDialog()
     */
    @SuppressWarnings("deprecation")
	public TradeDialog openTradeDialog() {
        GUITradeDialog dialog = new GUITradeDialog(this);
        dialog.show();
        return dialog;
    }
	
	/**
	 * Query cell.
	 *
	 * @param index the index
	 * @return the GUI cell
	 */
	private GUICell queryCell(int index) {
		IOwnable cell = GameMaster.instance().getGameBoard().getCell(index);
		for(int x = 0; x < guiCells.size(); x++) {
			GUICell guiCell = (GUICell)guiCells.get(x);
			if(guiCell.getCell() == cell) return guiCell;
		}
		return null;
	}

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#setBuyHouseEnabled(boolean)
     */
    public void setBuyHouseEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setBuyHouseEnabled(b);
    }

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#setDrawCardEnabled(boolean)
     */
    public void setDrawCardEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setDrawCardEnabled(b);
    }

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#setEndTurnEnabled(boolean)
     */
    public void setEndTurnEnabled(boolean enabled) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setEndTurnEnabled(enabled);
    }

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#setGetOutOfJailEnabled(boolean)
     */
    public void setGetOutOfJailEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setGetOutOfJailEnabled(b);
    }

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#setPurchasePropertyEnabled(boolean)
     */
    public void setPurchasePropertyEnabled(boolean enabled) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setPurchasePropertyEnabled(enabled);
    }

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#setRollDiceEnabled(boolean)
     */
    public void setRollDiceEnabled(boolean b) {
        int currentPlayerIndex = GameMaster.instance().getCurrentPlayerIndex();
        playerPanels[currentPlayerIndex].setRollDiceEnabled(b);
    }

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#setTradeEnabled(int, boolean)
     */
    public void setTradeEnabled(int index, boolean b) {
        playerPanels[index].setTradeEnabled(b);
    }
	
	/**
	 * Sets the up game board.
	 *
	 * @param board the new up game board
	 */
	public void setupGameBoard(GameBoard board) {
		Dimension dimension = GameBoardUtil.calculateDimension(board.getCellNumber());
		northPanel.setLayout(new GridLayout(1, dimension.width + 2));
		southPanel.setLayout(new GridLayout(1, dimension.width + 2));
		westPanel.setLayout(new GridLayout(dimension.height, 1));
		eastPanel.setLayout(new GridLayout(dimension.height, 1));
		addCells(northPanel, GameBoardUtil.getNorthCells(board));
		addCells(southPanel, GameBoardUtil.getSouthCells(board));
		addCells(eastPanel, GameBoardUtil.getEastCells(board));
		addCells(westPanel, GameBoardUtil.getWestCells(board));
		buildPlayerPanels();
	}

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#showBuyHouseDialog(edu.towson.cis.cosc442.project1.monopoly.Player)
     */
    @SuppressWarnings("deprecation")
	public void showBuyHouseDialog(Player currentPlayer) {
        BuyHouseDialog dialog = new BuyHouseDialog(currentPlayer);
        dialog.show();
    }

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#showMessage(java.lang.String)
     */
    public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
    }

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#showUtilDiceRoll()
	 */
	public int showUtilDiceRoll() {
		return UtilDiceRoll.showDialog();
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#startGame()
	 */
	public void startGame() {
		int numberOfPlayers = GameMaster.instance().getNumberOfPlayers();
		for(int i = 0; i < numberOfPlayers; i++) {
			movePlayer(i, 0, 0);
		}
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.MonopolyGUI#update()
	 */
	public void update() {
		for(int i = 0; i < playerPanels.length; i++) {
			playerPanels[i].displayInfo();
		}
		for(int j = 0; j < guiCells.size(); j++ ) {
			GUICell cell = (GUICell)guiCells.get(j);
			cell.displayInfo();
		}
	}
}
