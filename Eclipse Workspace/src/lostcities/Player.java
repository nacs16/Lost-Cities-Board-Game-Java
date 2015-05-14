package lostcities;
import java.util.*;

public class Player {
	
	public String name;
	private ArrayList<Card> Hand;
	public Tableau tableau;
	
	public Player(String name){
		this.name = name;
		this.tableau = new Tableau();
	}
	
	public void setHand(ArrayList<Card> cards){
		this.Hand = new ArrayList<Card>();
		for (Card c : cards){
			this.Hand.add(c);
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public Tableau getTableau(){
		return this.tableau;
	}
	
	public void resetTableau(){
		this.tableau = new Tableau();
	}
	
	public void takeTurn(Game game){
		Scanner keyboard = new Scanner(System.in);
		//playing
		while(true){
			int i = 0; // Hand index
			System.out.println("What do you want to do?\n\t1. Display Hand\n\t2. Play\n\t3. Discard\n");
			String pick = keyboard.next();
			if (!pick.equals("1") && !pick.equals("2") && !pick.equals("3")){
				System.out.println("Enter only '1', '2', or '3'");
				continue;
			}
			//display hand
			if (pick.equals("1")){
				System.out.println("Your Current Hand: ");
				i = 0;
				for (Card c : Hand){
					System.out.println("\t"+i+") "+c.getSuit()+" "+c.getRank());
					i++;
				}
			continue;
			}
			//play card
			if (pick.equals("2")){
				while(true){
					System.out.print("Enter the card number to play: ");
					i = keyboard.nextInt();
					if (i == -1) break;
					if (i >= 0 && i <= 7) break;
					else System.out.println("Invalid Input. ('-1' to go back)");
				}
				if (i == -1) continue;
				if (this.tableau.addCard(this.Hand.get(i))){
					System.out.println("Card: "+this.Hand.get(i).getSuit()+" "+this.Hand.get(i).getRank()+" Has been played!");
					this.Hand.remove(i);
					break;
				} else {
					System.out.println("Card: "+this.Hand.get(i).getSuit()+" "+this.Hand.get(i).getRank()+" cannot be played!\nChoose Again.");
					continue;
				}

			}
			//discard
			if (pick.equals("3")){
				while(true){
					System.out.print("Enter the card number to discard: ");
					i = keyboard.nextInt();
					if (i == -1) break;
					if (i >= 0 && i <= 7) break;
					else System.out.println("Invalid Input. ('-1' to go back)");
				}
				if (i == -1) continue;
				switch (this.Hand.get(i).getSuit()){
					case BLUE:
						game.discardBlue.add(this.Hand.get(i));
					case RED:
						game.discardRed.add(this.Hand.get(i));
					case GREEN:
						game.discardGreen.add(this.Hand.get(i));
					case YELLOW:
						game.discardYellow.add(this.Hand.get(i));
					case WHITE:
						game.discardWhite.add(this.Hand.get(i));
				}
				System.out.println("Card: "+this.Hand.get(i).getSuit()+" "+this.Hand.get(i).getRank()+" has been discarded.");
				this.Hand.remove(i);
				break;
			}
		}
		//drawing
		while(true){
			System.out.println("Draw Card From\n\t1. Draw Pile\n\t2. A Discard Pile");
			String pick = keyboard.next();
			//invalid input
			if (!pick.equals("1") && !pick.equals("2")){
				System.out.println("Enter only '1' or '2'");
				continue;
			}
			//draw from draw pile
			if (pick.equals("1")){
				this.Hand.add(game.draw_pile.draw());
				break;
			}
			//draw from discard piles
			boolean picked = false;
			if (pick.equals("2")){
				while(true){
					System.out.println("Choose Pile to Draw From: \n\t'B' BLUE\n\t'R' RED\n\t'G' GREEN\n\t'Y' YELLOW\n\t'W' WHITE");
					pick = keyboard.next().toUpperCase();
					if (pick.equals("X")) break;
					//invalid input
					if (!pick.equals("B") && !pick.equals("R") && !pick.equals("G") && !pick.equals("Y") && !pick.equals("W")){
						System.out.println("Invalid Input. ('X' to go back)");
					}
					String pick2;
					switch (pick){
						case "B":
							if (game.discardBlue.isEmpty()){
								System.out.println("Empty");
								break;
							}
							System.out.println("Top Card: "+game.discardBlue.peekAtTop().getSuit()+" "+game.discardBlue.peekAtTop().getRank()+"\nDraw This Card? ('Y' or 'N')");
							pick2 = keyboard.next().toUpperCase();
							if (pick2.equals("Y")){
								this.Hand.add(game.discardBlue.takeTop());
								picked = true;
								break;
							}
							else break;
						case "R":
							if (game.discardRed.isEmpty()){
								System.out.println("Empty");
								break;
							}
							System.out.println("Top Card: "+game.discardRed.peekAtTop().getSuit()+" "+game.discardRed.peekAtTop().getRank()+"\nDraw This Card? ('Y' or 'N')");
							pick2 = keyboard.next().toUpperCase();
							if (pick2.equals("Y")){
								this.Hand.add(game.discardRed.takeTop());
								picked = true;
								break;
							}
							else break;
						case "G":
							if (game.discardGreen.isEmpty()){
								System.out.println("Empty");
								break;
							}
							System.out.println("Top Card: "+game.discardGreen.peekAtTop().getSuit()+" "+game.discardGreen.peekAtTop().getRank()+"\nDraw This Card? ('Y' or 'N')");
							pick2 = keyboard.next().toUpperCase();
							if (pick2.equals("Y")){
								this.Hand.add(game.discardGreen.takeTop());
								picked = true;
								break;
							}
							else break;
						case "Y":
							if (game.discardYellow.isEmpty()){
								System.out.println("Empty");
								break;
							}
							System.out.println("Top Card: "+game.discardYellow.peekAtTop().getSuit()+" "+game.discardYellow.peekAtTop().getRank()+"\nDraw This Card? ('Y' or 'N')");
							pick2 = keyboard.next().toUpperCase();
							if (pick2.equals("Y")){
								this.Hand.add(game.discardYellow.takeTop());
								picked = true;
								break;
							}
							else break;
						case "W":
							if (game.discardWhite.isEmpty()){
								System.out.println("Empty");
								break;
							}
							System.out.println("Top Card: "+game.discardWhite.peekAtTop().getSuit()+" "+game.discardWhite.peekAtTop().getRank()+"\nDraw This Card? ('Y' or 'N')");
							pick2 = keyboard.next().toUpperCase();
							if (pick2.equals("Y")){
								this.Hand.add(game.discardWhite.takeTop());
								picked = true;
								break;
							}
							else break;	
					}
				if (picked) break;
				else continue;
				}
				if (pick.equals("X")) continue;
			}
		if (picked) break;
		}
		System.out.println("Drawing Card...\nDrew: "+this.Hand.get(7).getSuit()+" "+this.Hand.get(7).getRank()+"\n\nEnd of Turn\n");
		//keyboard.close();
	}
	
}
