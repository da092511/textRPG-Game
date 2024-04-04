package game;

public class Player extends Unit{
	private int code;
	private String name;
	
	private int money;
	
	public static Inventory inven  = new Inventory();
	public static Guild guild = new Guild();
	
	public Player() {
		money = 100000;
		guild.setGuild();
	}
	
	public Player(String name, int hp, int power) {
		super(name,hp,power);
	}
	
	public int getCode() {
		return this.code;
	}
	
	public void init() {
		
	}
	
	@Override
	public void skill(Unit unit) {
		if(this instanceof Warrior) { 
			Warrior w = (Warrior) this;
			w.skill(unit);
		}
		else if(this instanceof Witch) { 
			Witch w = (Witch) this;
			w.skill(unit);
		}
		else if(this instanceof Hiller) { 
			Hiller h = (Hiller) this;
			h.skill(unit);
		}
	}
	
}
