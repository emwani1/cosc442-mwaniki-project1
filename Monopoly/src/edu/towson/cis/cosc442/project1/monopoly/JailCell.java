package edu.towson.cis.cosc442.project1.monopoly;

public class JailCell extends Cell {
	public static int BAIL = 50;
	private boolean available = true;
	
	public JailCell() {
		setName("Jail");
	}
	
	public boolean playAction(String msg) {
		return false;
		
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

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
