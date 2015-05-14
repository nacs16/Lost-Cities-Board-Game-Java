package lostcities;
import java.util.*;

public class Game {
	
	public DrawPile draw_pile;
	public DiscardPile discardBlue, discardRed, discardGreen, discardYellow, discardWhite;
	public Player player1, player2;
	private int numRounds;
	
	public Game(Player player1, Player player2, int numRounds){
		this.player1 = player1;
		this.player2 = player2;
		this.numRounds = numRounds;
		this.draw_pile = new DrawPile();
		this.discardBlue = new DiscardPile();
		this.discardRed = new DiscardPile();
		this.discardGreen = new DiscardPile();
		this.discardYellow = new DiscardPile();
		this.discardWhite = new DiscardPile();
	}
	
	public DrawPile getDrawPile(){
		return this.draw_pile;
	}
	
	public ArrayList<DiscardPile> getDiscardPile(){
		ArrayList<DiscardPile> piles = new ArrayList<DiscardPile>();
		piles.add(discardBlue);
		piles.add(discardRed);
		piles.add(discardGreen);
		piles.add(discardYellow);
		piles.add(discardWhite);
		return piles;
	}
	
	public int[] play(){
		int[] scores = {0, 0};
		boolean setup = true;
		int turn_num = 1;
		while(this.numRounds > 0){
			if (setup){
				this.draw_pile = new DrawPile();
				this.player1.setHand(this.draw_pile.draw(8));
				this.player2.setHand(this.draw_pile.draw(8));
				setup = false;
			}
			System.out.println("Turn #"+Integer.toString(turn_num));
			System.out.println("Draw Pile Has "+this.draw_pile.Cards.size()+" Cards Remaining");
			System.out.println(this.player1.getName()+"'s Turn!");
			if (!this.draw_pile.isEmpty()) this.player1.takeTurn(this);
			System.out.println(this.player2.getName()+"'s Turn!");
			if (!this.draw_pile.isEmpty()) this.player2.takeTurn(this);
			turn_num++;
			if (this.draw_pile.isEmpty()){
				scores[0] += this.player1.tableau.score();
				this.player1.resetTableau();
				scores[1] += this.player2.tableau.score();
				this.player2.resetTableau();
				setup = true;
				this.numRounds--;
				System.out.println("\nROUND OVER:\n\t"+this.player1.getName()+"'s Score: "+scores[0]+"\n\t"+this.player2.getName()+"'s Score: "+scores[1]+"\n");
			}
		}
		return scores;
	}
}
