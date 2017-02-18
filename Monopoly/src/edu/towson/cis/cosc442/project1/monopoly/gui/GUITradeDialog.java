package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import edu.towson.cis.cosc442.project1.monopoly.*;

// TODO: Auto-generated Javadoc
/**
 * The Class GUITradeDialog.
 */
public class GUITradeDialog extends JDialog implements TradeDialog {
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The btn cancel. */
	private JButton btnOK, btnCancel;
    
    /** The cbo properties. */
    private JComboBox<Object> cboSellers, cboProperties;

    /** The deal. */
    private TradeDeal deal;
    
    /** The txt amount. */
    private JTextField txtAmount;
    
    /**
     * Instantiates a new GUI trade dialog.
     *
     * @param parent the parent
     */
    public GUITradeDialog(Frame parent) {
        super(parent);
        
        setTitle("Trade Property");
        cboSellers = new JComboBox<Object>();
        cboProperties = new JComboBox<Object>();
        txtAmount = new JTextField();
        btnOK = new JButton("OK");
        btnCancel = new JButton("Cancel");
        
        btnOK.setEnabled(false);
        
        buildSellersCombo();
        setModal(true);
             
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 2));
        contentPane.add(new JLabel("Sellers"));
        contentPane.add(cboSellers);
        contentPane.add(new JLabel("Properties"));
        contentPane.add(cboProperties);
        contentPane.add(new JLabel("Amount"));
        contentPane.add(txtAmount);
        contentPane.add(btnOK);
        contentPane.add(btnCancel);
        
        btnCancel.addActionListener(new ActionListener(){
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
                GUITradeDialog.this.hide();
            }
        });
        
        cboSellers.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                Player player = (Player)e.getItem();
                updatePropertiesCombo(player);
            }
        });
        
        btnOK.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
                int amount = 0;
                try{
                    amount = Integer.parseInt(txtAmount.getText());
                } catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(GUITradeDialog.this,
                            "Amount should be an integer", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Cell cell = (Cell)cboProperties.getSelectedItem();
                if(cell == null) return;
                Player player = (Player)cboSellers.getSelectedItem();
                Player currentPlayer = GameMaster.instance().getCurrentPlayer();
                if(currentPlayer.getMoney() > amount) { 
	                deal = new TradeDeal();
	                deal.setAmount(amount);
	                deal.setPropertyName(cell.getName());
	                deal.setSellerIndex(GameMaster.instance().getPlayerIndex(player));
                }
                hide();
            }
        });
        
        this.pack();
    }

    /**
     * Builds the sellers combo.
     */
    private void buildSellersCombo() {
        List<?> sellers = GameMaster.instance().getSellerList();
        for (Iterator<?> iter = sellers.iterator(); iter.hasNext();) {
            Player player = (Player) iter.next();
            cboSellers.addItem(player);
        }
        if(sellers.size() > 0) {
            updatePropertiesCombo((Player)sellers.get(0));
        }
    }

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.TradeDialog#getTradeDeal()
     */
    public TradeDeal getTradeDeal() {
        return deal;
    }

    /**
     * Update properties combo.
     *
     * @param player the player
     */
    private void updatePropertiesCombo(Player player) {
        cboProperties.removeAllItems();
        IOwnable[] cells = player.getAllProperties();
        btnOK.setEnabled(cells.length > 0);
        for (int i = 0; i < cells.length; i++) {
            cboProperties.addItem(cells[i]);
        }
    }

}
