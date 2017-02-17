package edu.towson.cis.cosc442.project1.monopoly;

import java.util.ArrayList;
import java.util.Hashtable;

public class GameBoard {

	private GameBoardProduct gameBoardProduct = new GameBoardProduct();
	private ArrayList<Card> chanceCards = new ArrayList<Card>();
	private ArrayList<Card> communityChestCards = new ArrayList<Card>();
	public GameBoard() {
		Cell go = new GoCell();
		addCell(go);
	}

    public void addCard(Card card) {
        if(card.getCardType() == Card.TYPE_CC) {
            communityChestCards.add(card);
        } else {
            chanceCards.add(card);
        }
    }
	
	public void addCell(Cell cell) {
		gameBoardProduct.getCells().add(cell);
	}
	
	public void addCell(PropertyCell cell) {
		gameBoardProduct.addCell(cell);
	}

    public Card drawCCCard() {
        Card card = (Card)communityChestCards.get(0);
        communityChestCards.remove(0);
        addCard(card);
        return card;
    }

    public Card drawChanceCard() {
        Card card = (Card)chanceCards.get(0);
        chanceCards.remove(0);
        addCard(card);
        return card;
    }

	public Cell getCell(int newIndex) {
		return gameBoardProduct.getCell(newIndex);
	}
	
	public int getCellNumber() {
		return gameBoardProduct.getCellNumber();
	}
	
	public PropertyCell[] getPropertiesInMonopoly(String color) {
		return gameBoardProduct.getPropertiesInMonopoly(color);
	}
	
	public int getPropertyNumberForColor(String name) {
		return gameBoardProduct.getPropertyNumberForColor(name);
	}

	public Cell queryCell(String string) {
		return gameBoardProduct.queryCell(string);
	}
	
	public int queryCellIndex(String string){
		return gameBoardProduct.queryCellIndex(string);
	}

    public void removeCards() {
        communityChestCards.clear();
    }
}
