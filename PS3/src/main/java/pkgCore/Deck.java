package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;


import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {
		int iCardNbr = 0;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank, ++iCardNbr));
			}
		}
		Collections.shuffle(cardsInDeck);
	}
	

	public ArrayList<Card> getCardsInDeck() {
		return cardsInDeck;
	}


	private void setCardsInDeck(ArrayList<Card> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}


	//Complete: Fix the Draw method so it throws an exception if the deck is empty
	public Card Draw() throws DeckException {
		if (cardsInDeck.isEmpty()) {
			throw new DeckException(null);
		}
			return cardsInDeck.remove(0);
	}
	
	//Complete: Write an overloaded Draw method to Draw a card of a given eSuit
	
	public Card Draw(eSuit eSuit)
	{
		for (Card c: this.cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		
		return null;
	}
	
	//Complete: Write an overloaded Draw method to Draw a card of a given eRank (same thing but rank)
	
	public Card Draw(eRank eRank)
	{
		for (Card c: this.cardsInDeck) {
			if (c.geteRank() == eRank) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}

	//Complete: Write a method that will return the number of a given eSuit left in the deck.
	
	public int SuitCount(eSuit eSuit)
	{
		 ArrayList<Card> oneSuit = cardsInDeck.stream()
				.filter( c -> c.geteSuit() == eSuit)
				.collect(Collectors.toCollection(ArrayList::new));
		 return oneSuit.size();			
	}
	
	//Complete: Write a method that will return the number of a given eRank left in the deck.
	
	public int RankCount(eRank eRank)
	{
		 ArrayList<Card> oneRank = cardsInDeck.stream()
				.filter( c -> c.geteRank() == eRank)
				.collect(Collectors.toCollection(ArrayList::new));
		 return oneRank.size();			
	}
	
	//Complete: Write a method that will return 0 or 1 if a given card is left in the deck.
	
	public int FindCard(Card c)
	{
		for (Card crds: cardsInDeck)
		{
			if (crds == c)
				return 1;
		}
		return 0; 
	}
	
}
