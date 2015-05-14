package lostcities;
import java.util.*;
import lostcities.Card.*;

public class Expedition {
	
	private ArrayList<Card> Cards;
	private Suit suit;
	
	public Expedition(Suit s){
		this.suit = s;
		this.Cards = new ArrayList<Card>();
	}
	
	public Suit getSuit(){
		return this.suit;
	}
	
	public boolean addCard(Card card){
		if (card.getSuit() != this.suit) return false;
		if (this.Cards.isEmpty()){
			this.Cards.add(card);
			return true;
		}
		if (card.compareTo(this.Cards.get(this.Cards.size()-1)) != 1) return false;
		this.Cards.add(card);
		return true;
	}
	
	public int Score(){
		int score = -20;
		if (Cards.size() >= 8) score = 0;
		if (Cards.isEmpty()) return 0;
		int handshakes = 1;
		for (Card c : Cards){
			if (c.getRank() == Rank.HANDSHAKE){
				handshakes++;
				continue;
			}
			int value = 1;
			for (Rank r : Rank.values()){
				if (c.getRank() == r) break;
				value++;
			}
			score += value;
		}
		score = score * handshakes;
		return score;
	}
}
