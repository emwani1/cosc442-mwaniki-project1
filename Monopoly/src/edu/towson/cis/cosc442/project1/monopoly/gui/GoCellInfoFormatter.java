package edu.towson.cis.cosc442.project1.monopoly.gui;

import edu.towson.cis.cosc442.project1.monopoly.Cell;

// TODO: Auto-generated Javadoc
/**
 * The Class GoCellInfoFormatter.
 */
public class GoCellInfoFormatter implements CellInfoFormatter {
    
    /** The Constant GO_CELL_LABEL. */
    public static final String GO_CELL_LABEL = "<html><b>Go</b></html>";
    
    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.gui.CellInfoFormatter#format(edu.towson.cis.cosc442.project1.monopoly.Cell)
     */
    public String format(Cell cell) {
        return GO_CELL_LABEL;
    }
}
