package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;

// TODO: Auto-generated Javadoc
/**
 * The Class FreeParkingCellInfoFormatter.
 */
public class FreeParkingCellInfoFormatter implements CellInfoFormatter {
    
    /** The Constant FP_CELL_LABEL. */
    public static final String FP_CELL_LABEL = "<html><b>Free Parking</b></html>";
    
    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.gui.CellInfoFormatter#format(edu.towson.cis.cosc442.project1.monopoly.Cell)
     */
    public String format(Cell cell) {
        return FP_CELL_LABEL;
    }
}
