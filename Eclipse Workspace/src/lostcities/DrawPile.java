package lostcities;
import java.util.*;
import lostcities.Card.*;

public class DrawPile {
	
	public ArrayList<Card> Cards;
	
	//DrawPile() puts all cards in Cards
	public DrawPile(){
		this.Cards = new ArrayList<Card>();
		for (Suit s : Suit.values()){
			for (Rank r : Rank.values()){
				Card c = new Card(r, s);
				this.Cards.add(c);
				if (r == Rank.HANDSHAKE){
					this.Cards.add(c);
					this.Cards.add(c);
				}
			}
		}
		Collections.shuffle(this.Cards);
	}
	
	//draw() returns a card from the beginning of Cards and removes it
	public Card draw(){
		Card c = this.Cards.get(0);
		this.Cards.remove(0);
		return c;
	}
	
	//draw(int) returns an ArrayList<Card> containing the first x cards in Cards, and removes them.
	public ArrayList<Card> draw(int x){
		ArrayList<Card> top_cards = new ArrayList<Card>();
		for (int i = 0; i < x; i++){
			top_cards.add(this.Cards.get(0));
			this.Cards.remove(0);
		}		
		return top_cards;
	}
	public boolean isEmpty(){
		return this.Cards.isEmpty();
	}
	
	
}
