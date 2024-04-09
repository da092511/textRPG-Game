package game;

public class Player extends Unit{
	public String type;
	public static int money;
	
	private int round =  1;
	
	private boolean party;
	
	public static Inventory inven  = new Inventory();
	public static Guild guild = new Guild();
	
	
	public Player() {
		money = 200000;
	}
	
	public Player(String name, int maxHp, int att) {
		super(name, maxHp, att);
	}
	
	public void init(String name, int level, int maxHp, int att, int exp) {
	    super.init(name, level, maxHp, att, exp);
	}
	
	public void init(String name, int level,int curHp, int maxHp, int att, int exp, String type, boolean party) {
		this.type = type;
		this.party = party;
		
	    super.init(name, level, maxHp, att, exp);
	    super.setCurHp(curHp);
	}
	
	public void init(String name, int level, int maxHp, int att, int exp , int round) {
		this.round = round;
		this.type = type;
		
	    super.init(name, level, maxHp, att, exp);
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
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public void addExp(int exp) {
		this.exp += exp;
		levelUp();
	}
	
	public int getRound() {
		return this.round;
	}
	
	public void setRound(int round) {
		this.round = round;
	}
	
	public void addRound() {
		this.round++;
	}
	
	public void levelUp() {
		if(this.exp < 100)
			return;
		
		this.exp -= 100;
		this.level ++;
	}
	
	public void init() {
		guild.setGuild();
	}

	@Override
	public void attack(Unit target, int power) {
		if(target.getIsDead())
			return;
		
		int hit = power + super.getPower();
		System.out.println("["+super.getName()+"]가 ["+ target.getName()+"]을 공격! +"+hit+"데미지");
		
		int hp = target.getCurHp() - hit;
		
		if(hp <= 0) {
			hp = 0;
			target.isDead();
			System.err.println("["+target.getName()+"]가 사망하였습니다.");
		}
		
		target.setCurHp(hp);
	}
	@Override
	public String toString() {
		String info = String.format("[%s](%s): [%4d / %4d]", super.getName(),this.type,super.getCurHp(), super.getMaxHp());
		return info;
	}
}
