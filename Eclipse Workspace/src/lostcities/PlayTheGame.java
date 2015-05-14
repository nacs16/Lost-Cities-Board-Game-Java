package lostcities;
import java.util.*;

public class PlayTheGame {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int num_rounds;
		while(true){ //choose number of rounds
			System.out.println("Enter Number Of Rounds To Play: ");
			num_rounds = keyboard.nextInt();
			if (num_rounds <= 0) continue; //invalid
			else break;
		}
		System.out.println("Enter First Player's Name: ");
		Player player1 = new Player(keyboard.next());
		System.out.println("Enter Second Player's Name: ");
		Player player2 = new Player(keyboard.next());
		Game game = new Game(player1, player2, num_rounds);
		game.play();		
		keyboard.close();
	}

}
