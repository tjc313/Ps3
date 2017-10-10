package pkgCore;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class DeckTest {

	@Test(expected = Exception.class)
	public void TestEmptyDeck() throws DeckException {
		//Complete: Build a deck, draw until you get a DeckException
		Deck testDeck = new Deck();
		for (Card c: testDeck.getCardsInDeck()) {
			testDeck.Draw();
		}
	} 
	
/*	@Test
	public void TestDrawSuit() {
		//TODO: Build a deck, test the Draw(eSuit) method
		Deck testDeck2 = new Deck();
		Card c = testDeck2.Draw(eSuit.CLUBS);
		assertTrue(c.geteSuit() == eSuit.CLUBS);
	}
	
	@Test
	public void TestDrawRank() {
		//TODO: Build a deck, test the Draw(eRank) method
		Deck testDeck3 = new Deck();
		Card c = testDeck3.Draw(eRank.ACE);
		assertTrue(c.geteRank() == eRank.ACE);
	}
*/	
	public void TestDeckRankCount() {
		//Complete: Build a deck, test the DeckRankCount method
		Deck testDeck4 = new Deck();
		assertEquals(testDeck4.RankCount(eRank.JACK), 4);
		testDeck4.Draw(eRank.JACK);
		testDeck4.Draw(eRank.JACK);
		assertEquals(testDeck4.RankCount(eRank.JACK), 2);
	}
	
	public void TestDeckSuitCount() {
		//Complete: Build a deck, test the DeckSuitCount method
		Deck testDeck5 = new Deck();
		assertEquals(testDeck5.SuitCount(eSuit.HEARTS), 13);
		testDeck5.Draw(eSuit.HEARTS);
		testDeck5.Draw(eSuit.HEARTS);
		testDeck5.Draw(eSuit.HEARTS);
		testDeck5.Draw(eSuit.HEARTS);
		testDeck5.Draw(eSuit.HEARTS);
		testDeck5.Draw(eSuit.HEARTS);
		testDeck5.Draw(eSuit.HEARTS);
		assertEquals(testDeck5.SuitCount(eSuit.HEARTS), 6);
	}

}
