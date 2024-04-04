package game;

public class Player extends Unit{
	private int code;
	private String name ;
	
	private int money;
	
	public static Inventory inven  = new Inventory();
	public static Guild guild = new Guild();
	
	public Player() {
		
	}

	public Player(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public int getCode() {
		return this.code;
	}
	
	
}
