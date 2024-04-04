package game;

public class Player extends Unit{
	private int code;
	
	private int money;
	
	public static Inventory inven  = new Inventory();
	public static Guild guild = new Guild();
	
	public Player() {
		
	}
	
	public Player(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
}
