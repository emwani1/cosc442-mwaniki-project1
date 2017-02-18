package edu.towson.cis.cosc442.project1.monopoly.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import edu.towson.cis.cosc442.project1.monopoly.RespondDialog;
import edu.towson.cis.cosc442.project1.monopoly.TradeDeal;


// TODO: Auto-generated Javadoc
/**
 * The Class GUIRespondDialog.
 */
public class GUIRespondDialog extends JDialog implements RespondDialog {
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The response. */
	private boolean response;
    
    /** The txt message. */
    JTextArea txtMessage = new JTextArea();
    
    /**
     * Instantiates a new GUI respond dialog.
     */
    public GUIRespondDialog() {
        JButton btnYes = new JButton("Yes");
        JButton btnNo = new JButton("No");
        txtMessage.setPreferredSize(new Dimension(300, 200));
        txtMessage.setEditable(false);
        txtMessage.setLineWrap(true);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(txtMessage, BorderLayout.CENTER);
        JPanel pnlButtons = new JPanel();
        pnlButtons.add(btnYes);
        pnlButtons.add(btnNo);
        contentPane.add(pnlButtons, BorderLayout.SOUTH);
        
        btnYes.addActionListener(new ActionListener(){
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
                response = true;
                hide();
            }
        });

        btnNo.addActionListener(new ActionListener(){
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
                response = false;
                hide();
            }
        });
    
        setModal(true);
        pack();
    }

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.RespondDialog#getResponse()
     */
    public boolean getResponse() {
        return response;
    }
    
    /**
     * Sets the deal.
     *
     * @param deal the new deal
     */
    public void setDeal(TradeDeal deal) {
        txtMessage.setText(deal.makeMessage());
    }

}
