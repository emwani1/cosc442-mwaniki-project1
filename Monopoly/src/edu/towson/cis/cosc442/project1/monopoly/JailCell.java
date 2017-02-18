package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class JailCell.
 */
public class JailCell extends Cell {
	
	/** The bail. */
	public static int BAIL = 50;
	
	/** The available. */
	private boolean available = true;
	
	/**
	 * Instantiates a new jail cell.
	 */
	public JailCell() {
		setName("Jail");
	}
	
	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.Cell#playAction(java.lang.String)
	 */
	public boolean playAction(String msg) {
		return false;
		
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.Cell#isAvailable()
	 */
	public boolean isAvailable() {
		return available;
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.Cell#setAvailable(boolean)
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.Cell#playerMoved(edu.towson.cis.cosc442.project1.monopoly.Player, int, edu.towson.cis.cosc442.project1.monopoly.GameMaster)
	 */
	public void playerMoved(Player player, int playerIndex, GameMaster gameMaster) {
		if (this.isAvailable()) {
			int price = this.getPrice();
			if (price <= player.getMoney() && price > 0) {
				gameMaster.getGUI().enablePurchaseBtn(playerIndex);
			}
		}
		gameMaster.getGUI().enableEndTurnBtn(playerIndex);
	}
}
