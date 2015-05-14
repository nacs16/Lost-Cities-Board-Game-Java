package lostcities;
import java.util.*;

public class DiscardPile{
	
	private ArrayList<Card> Cards;
	
	public DiscardPile(){
		this.Cards = new ArrayList<Card>();
	}
	
	public void add(Card card){
		this.Cards.add(card);
	}
	
	public boolean isEmpty(){
		return this.Cards.isEmpty();
	}
	
	//Top is the end of the ArrayList Cards
	public Card peekAtTop(){
		int x = this.Cards.size();
		return this.Cards.get(x-1);
	}
	
	//returns the top card and removes it from the list
	public Card takeTop(){
		int x = this.Cards.size();
		Card c = this.Cards.get(x-1);
		this.Cards.remove(x-1);
		return c;
	}
	
}
