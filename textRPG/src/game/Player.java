package game;

public class Player extends Unit{
	public String type;
	public static int money;
	
	private boolean party;
	
	public static Inventory inven  = new Inventory();
	public static Guild guild = new Guild();
	
	
	public Player() {
		
	}
	
	public Player(String name, int maxHp, int att) {
		super(name, maxHp, att);
	}
	
	public void init(String name, int level, int maxHp, int att, int def, int exp) {
	    super.init(name, level, maxHp, att, def, exp);
	}
	
	public int getGuildSize() {
		return guild.getGuildSize();
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void addMoney(int money) {
		this.money += money; 
	}
	
	public void setParty() {
		this.party = !party;
	}
	
	public boolean getParty() {
		return this.party;
	}
	
	public void init() {
		money = 200000;
	}
	
}
