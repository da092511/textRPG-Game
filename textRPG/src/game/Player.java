package game;

public class Player extends Unit{
	private int code;
	public  String name;
	
	public static int money;
	
	public static boolean party;
	
	public static Inventory inven  = new Inventory();
	public static Guild guild = new Guild();
	
	public Player() {
		
	}
	
	public Player(String name, int level, int maxhp, int att, int def, int exp) {
	    super(name, level, maxhp, att, def, exp);
	}
	
	public Player(String name, int hp, int power) {
		super(name,hp,power);
	}
	
	public int getGuildSize() {
		return guild.getGuildSize();
	}
	
	public int getCode() {
		return this.code;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void addMoney(int money) {
		this.money += money; 
	}
	
	public void init() {
		money = 200000;
		guild.setGuild();
	}
	
}
