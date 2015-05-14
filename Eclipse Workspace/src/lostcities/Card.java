package lostcities;


public class Card{
	
	public static enum Rank {HANDSHAKE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN};
	
	public static enum Suit {BLUE, RED, GREEN, YELLOW, WHITE};
	
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/* compareTo CardA.compareto(CardB)
	 *  1 if CardA > CardB
	 *  0 if CardA = CardB
	 * -1 if CardA < CardB
	 */
	public int compareTo(Card card){
		int x=0;int y=0;
		Rank c1 = this.getRank();
		Rank c2 = card.getRank();
		if (c1 == c2) return 0;
		
		for (Rank r : Rank.values()){
			if (r == c1) break;
			x++;
		}
		for (Rank r : Rank.values()){
			if (r == c2) break;
			y++;
		}
		
		if (x > y) return 1;
		return -1;
	}
	
	public boolean equals(Card c1, Card c2){
		if(c1.getRank() == c2.getRank()) return true;
		else return false;
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
}
