import java.util.Scanner;

public class InteractiveBattleShip {
	static Scanner in = new Scanner(System.in);
	static Board b1p1;
	static Board b1p2;
	static Board b2p1;
	static Board b2p2;
	static Boolean hit;
	public static void main(String[] args) {
		System.out.println("Welcome to the interactive console BattleShip! "
				+ "Type \"Help\" to learn more, note case sensitivity. "
				+ "When ready, press Enter in the console to begin.");
		String help = in.nextLine();
		if (help.equals("Help")) {
			printInstructions();
		}
		System.out.println("Enter the name of the first player");
		String playerOne = in.nextLine();
		System.out.println("Now enter the name of the second player");
		String playerTwo = in.nextLine();
		b1p1 = new Board();
		b2p2 = new Board();
		b1p2 = new Board();
		b2p1 = new Board();
		System.out.printf("%s, time to place your ships!\n", playerOne);
		placeShips(b1p1);
		System.out.printf("Thank you %s; now it's your turn %s!\n", playerOne, playerTwo);
		placeShips(b2p2);
		System.out.printf("Let the game begin! %s has the first move \n", playerOne);
		while (!b1p1.checkDefeat() || !b2p2.checkDefeat()) {
			System.out.printf("Your move, %s \n", playerOne);
			System.out.println("Your opponent's board:");
			b2p1.printBoard();
			System.out.println("Your board:");
			b1p1.printBoard();
			String p1Move = in.nextLine();
			hit = b2p2.checkShot(p1Move);
			b2p1.updateOtherBoard(p1Move, hit);
			if (b2p2.checkDefeat()) break;
			System.out.printf("Your move, %s \n", playerTwo);
			System.out.println("Your opponent's board:");
			b1p2.printBoard();
			System.out.println("Your board:");
			b2p2.printBoard();
			String p2Move = in.nextLine();
			hit = b1p1.checkShot(p2Move);
			b1p2.updateOtherBoard(p2Move, hit);
		}
		if (b1p1.checkDefeat()) System.out.printf("%s you win! "
				+ "Congratulations!", playerTwo);
		else System.out.printf("s you win! Congratulations!", playerOne);
	}

	private static void placeShips(Board boardOne) {
		boardOne.printBoard();
		System.out.println("Where and how would you like to add your Carrier?");
		String carrierLoc = in.nextLine();
		String[] carrierInfo = carrierLoc.split(" ");
		boardOne.addCarrier(carrierInfo[0], carrierInfo[1]);
		boardOne.printBoard();
		System.out.println("Now the location and orientation of your Battleship.");
		String battleshipLoc = in.nextLine();
		String[] battleshipInfo = battleshipLoc.split(" ");
		boardOne.addBattleship(battleshipInfo[0], battleshipInfo[1]);
		boardOne.printBoard();
		System.out.println("How about your Cruiser?");
		String cruiserLoc = in.nextLine();
		String[] cruiserInfo = cruiserLoc.split(" ");
		boardOne.addCruiser(cruiserInfo[0], cruiserInfo[1]);
		boardOne.printBoard();
		System.out.println("Let's not forget about your submarine, "
				+ "where and how should that go?");
		String submarineLoc = in.nextLine();
		String[] submarineInfo = submarineLoc.split(" ");
		boardOne.addSubmarine(submarineInfo[0], submarineInfo[1]);
		boardOne.printBoard();
		System.out.println("And now finally your Destroyer, commander.");
		String destroyerLoc = in.nextLine();
		String[] destroyerInfo = destroyerLoc.split(" ");
		boardOne.addDestroyer(destroyerInfo[0], destroyerInfo[1]);
		boardOne.printBoard();
	}

	private static void printInstructions() {
		System.out.println("Welcome to the interactive console BattleShip! "
				+ "The game will play out like regular BattleShip, except shots are"
				+ "printed immediately in the console. When entering coordinates, type"
				+ "the column letter followed by the row number to enter exact coordinates."
				+ "Note that it is case sensitive, and you must type exactly as follows"
				+ "to register the location \"E five\": \"E5\". When placing ships, you will"
				+ "record the coordinates for the bow of the ship (front) along with "
				+ "whether you will be placing vertically or horizontally. For example, to"
				+ "place a Submarine (3 holes) horizontally from E2-E4, enter into the console"
				+ " \"E2 Horizontal\". Remember it is case sensitive! Finally, an \"O\" marks"
				+ "a ship hole, an \"X\" marks a missed shot, and an \"H\" marks an already"
				+ "hit ship hole. Good luck! Now type the name of the first player to begin.");
	}
}
