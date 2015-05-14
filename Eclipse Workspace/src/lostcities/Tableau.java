package lostcities;
import lostcities.Card.*;

public class Tableau {
	//BLUE, RED, GREEN, YELLOW, WHITE
	
	private Expedition blue, red, green, yellow, white;
	
	public Tableau(){
		this.blue = new Expedition(Suit.BLUE);
		this.red = new Expedition(Suit.RED);
		this.green = new Expedition(Suit.GREEN);
		this.yellow = new Expedition(Suit.YELLOW);
		this.white = new Expedition(Suit.WHITE);
	}
	
	//adds card to appropriate expedition. returns true if added, false if not
	public boolean addCard(Card card){
		boolean answer = false;
		switch (card.getSuit()) {
			case BLUE:
				answer = this.blue.addCard(card);
				break;
			case RED:
				answer = this.red.addCard(card);
				break;
			case GREEN:
				answer = this.green.addCard(card);
				break;
			case YELLOW:
				answer = this.yellow.addCard(card);
				break;
			case WHITE:
				answer = this.white.addCard(card);
				break;
		}
		return answer;
	}
	
	//returns score of all expeditions
	public int score(){
		int score = 0;
		score += blue.Score();
		score += red.Score();
		score += green.Score();
		score += yellow.Score();
		score += white.Score();
		return score;
	}
	
}
