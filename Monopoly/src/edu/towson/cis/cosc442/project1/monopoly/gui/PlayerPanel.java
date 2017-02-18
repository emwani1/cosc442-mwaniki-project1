package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;
import javax.swing.border.BevelBorder;

import edu.towson.cis.cosc442.project1.monopoly.*;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerPanel.
 */
public class PlayerPanel extends JPanel {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The btn buy house. */
	private JButton btnBuyHouse;
    
    /** The btn draw card. */
    private JButton btnDrawCard;
    
    /** The btn end turn. */
    private JButton btnEndTurn;
    
    /** The btn get out of jail. */
    private JButton btnGetOutOfJail;
    
    /** The btn purchase property. */
    private JButton btnPurchaseProperty;
    
    /** The btn roll dice. */
    private JButton btnRollDice;
    
    /** The btn trade. */
    private JButton btnTrade;
    
    /** The lbl money. */
    private JLabel lblMoney;
    
    /** The lbl name. */
    private JLabel lblName;
    
    /** The player. */
    private Player player;
    
    /** The txt property. */
    private JTextArea txtProperty;

    /**
     * Instantiates a new player panel.
     *
     * @param player the player
     */
    public PlayerPanel(Player player) {
        JPanel pnlAction = new JPanel();
        JPanel pnlInfo = new JPanel();
        btnRollDice = new JButton("Roll Dice");
        btnPurchaseProperty = new JButton("Purchase Property");
        btnEndTurn = new JButton("End Turn");
        btnBuyHouse = new JButton("Buy House");
        btnGetOutOfJail = new JButton("Get Out of Jail");
        btnDrawCard = new JButton("Draw Card");
        btnTrade = new JButton("Trade");
        this.player = player;
        lblName = new JLabel();
        lblMoney = new JLabel();
        txtProperty = new JTextArea(30, 70);

        txtProperty.setEnabled(false);

        JPanel pnlName = new JPanel();
        JPanel pnlProperties = new JPanel();

        pnlInfo.setLayout(new BorderLayout());
        pnlInfo.add(pnlName, BorderLayout.NORTH);
        pnlInfo.add(pnlProperties, BorderLayout.CENTER);

        pnlProperties.setLayout(new OverlayLayout(pnlProperties));

        pnlName.add(lblName);
        pnlName.add(lblMoney);
        pnlProperties.add(txtProperty);

        pnlAction.setLayout(new GridLayout(3, 3));
        pnlAction.add(btnBuyHouse);
        pnlAction.add(btnRollDice);
        pnlAction.add(btnPurchaseProperty);
        pnlAction.add(btnGetOutOfJail);
        pnlAction.add(btnEndTurn);
        pnlAction.add(btnDrawCard);
        pnlAction.add(btnTrade);

        pnlAction.doLayout();
        pnlInfo.doLayout();
        pnlName.doLayout();
        pnlProperties.doLayout();
        this.doLayout();

        setLayout(new BorderLayout());
        add(pnlInfo, BorderLayout.CENTER);
        add(pnlAction, BorderLayout.SOUTH);

        btnRollDice.setEnabled(false);
        btnPurchaseProperty.setEnabled(false);
        btnEndTurn.setEnabled(false);
        btnBuyHouse.setEnabled(false);
        btnGetOutOfJail.setEnabled(false);
        btnDrawCard.setEnabled(false);
        btnTrade.setEnabled(false);

        setBorder(new BevelBorder(BevelBorder.RAISED));

        btnRollDice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnRollDiceClicked();
            }
        });

        btnEndTurn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnEndTurnClicked();
            }
        });

        btnPurchaseProperty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnPurchasePropertyClicked();
            }
        });

        btnBuyHouse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnBuyHouseClicked();
            }
        });

        btnGetOutOfJail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnGetOutOfJailClicked();
            }
        });

        btnDrawCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Card card = GameMaster.instance().btnDrawCardClicked();
                JOptionPane
                        .showMessageDialog(PlayerPanel.this, card.getLabel());
                displayInfo();
            }
        });

        btnTrade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnTradeClicked();
            }
        });
    }

    /**
     * Display info.
     */
    public void displayInfo() {
        lblName.setText(player.getName());
        lblMoney.setText("$ " + player.getMoney());
        StringBuffer buf = new StringBuffer();
        IOwnable[] cells = player.getAllProperties();
        for (int i = 0; i < cells.length; i++) {
            buf.append(cells[i] + "\n");
        }
        txtProperty.setText(buf.toString());
    }
    
    /**
     * Checks if is buy house button enabled.
     *
     * @return true, if is buy house button enabled
     */
    public boolean isBuyHouseButtonEnabled() {
        return btnBuyHouse.isEnabled();
    }

    /**
     * Checks if is draw card button enabled.
     *
     * @return true, if is draw card button enabled
     */
    public boolean isDrawCardButtonEnabled() {
        return btnDrawCard.isEnabled();
    }

    /**
     * Checks if is end turn button enabled.
     *
     * @return true, if is end turn button enabled
     */
    public boolean isEndTurnButtonEnabled() {
        return btnEndTurn.isEnabled();
    }
    
    /**
     * Checks if is gets the out of jail button enabled.
     *
     * @return true, if is gets the out of jail button enabled
     */
    public boolean isGetOutOfJailButtonEnabled() {
        return btnGetOutOfJail.isEnabled();
    }
    
    /**
     * Checks if is purchase property button enabled.
     *
     * @return true, if is purchase property button enabled
     */
    public boolean isPurchasePropertyButtonEnabled() {
        return btnPurchaseProperty.isEnabled();
    }
    
    /**
     * Checks if is roll dice button enabled.
     *
     * @return true, if is roll dice button enabled
     */
    public boolean isRollDiceButtonEnabled() {
        return btnRollDice.isEnabled();
    }

    /**
     * Checks if is trade button enabled.
     *
     * @return true, if is trade button enabled
     */
    public boolean isTradeButtonEnabled() {
        return btnTrade.isEnabled();
    }

    /**
     * Sets the buy house enabled.
     *
     * @param b the new buy house enabled
     */
    public void setBuyHouseEnabled(boolean b) {
        btnBuyHouse.setEnabled(b);
    }

    /**
     * Sets the draw card enabled.
     *
     * @param b the new draw card enabled
     */
    public void setDrawCardEnabled(boolean b) {
        btnDrawCard.setEnabled(b);
    }

    /**
     * Sets the end turn enabled.
     *
     * @param enabled the new end turn enabled
     */
    public void setEndTurnEnabled(boolean enabled) {
        btnEndTurn.setEnabled(enabled);
    }

    /**
     * Sets the gets the out of jail enabled.
     *
     * @param b the new gets the out of jail enabled
     */
    public void setGetOutOfJailEnabled(boolean b) {
        btnGetOutOfJail.setEnabled(b);
    }

    /**
     * Sets the purchase property enabled.
     *
     * @param enabled the new purchase property enabled
     */
    public void setPurchasePropertyEnabled(boolean enabled) {
        btnPurchaseProperty.setEnabled(enabled);
    }

    /**
     * Sets the roll dice enabled.
     *
     * @param enabled the new roll dice enabled
     */
    public void setRollDiceEnabled(boolean enabled) {
        btnRollDice.setEnabled(enabled);
    }

    /**
     * Sets the trade enabled.
     *
     * @param b the new trade enabled
     */
    public void setTradeEnabled(boolean b) {
        btnTrade.setEnabled(b);
    }
}