package game;

public class Main {

	public static void main(String[] args) {
		GameManager game = new GameManager();
		
		while(true) {
			boolean run = game.update();
			
			if(!run)
				break;
		}
		
		System.err.println("GAME OVER");
	}

}
