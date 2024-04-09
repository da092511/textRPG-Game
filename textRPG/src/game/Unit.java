package game;

public abstract class Unit {
	private String name;
	public static String type;
	
	private int maxHp;
	private int curHp;
	private int power;
	int level; // 레벨
	
	int exp; // 경험치
	
	private Item weapon; // 무기
	private Item armor; // 갑옷
	private Item ring; // 장신구
	
	private boolean isDead;
	
	private int faintTurn;
	private int skillInterval;
	
	public Unit() {
		
	}
	
	public Unit(String name, int hp, int power) {
		this.name = name;
		this.curHp = hp;
		this.maxHp = hp;
		this.power = power;
	}
	
	public void init(String name, int hp, int att) {
		this.name = name;
		this.curHp = hp;
		this.maxHp = hp;
		this.power = att;
	}
	
	public void init(String name, int level, int hp, int att, int exp) {
		this.name = name;
		this.level = level;
		
		this.maxHp = hp;
		this.curHp = maxHp;
		
		this.power = att;
		this.exp = exp;
		
		weapon = null;
		armor = null;
		ring = null;
	}
	
	public void attack(Unit target, int power) {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void isDead() {
		this.isDead = true;
	}
	
	public boolean getIsDead() {
		return this.isDead;
	}
	
	public int getCurHp() {
		return this.curHp;
	}
	
	public void setCurHp(int curHp) {
		this.curHp = curHp;
	}
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public void isFaint(int faintTurn) {
		this.faintTurn = faintTurn;
	}
	
	public int getLeftFaint() {
		return this.faintTurn;
	}
	
	public void setFaintTurn() {
		if(this.faintTurn == 0)
			return;
		
		this.faintTurn --;
	}
	
	public int getSkilInterval() {
		return skillInterval;
	}
	
	public void setSkillInterval() {
		if(this.skillInterval == 0)
			return;
		
		this.skillInterval --;
	}
	
	public void skill() {}
	
	public void skill(Unit unit, int power) {
		
	}
	
	public void init(int hp, int power) {
		this.curHp = hp;
		this.maxHp = hp;
		this.power = power;
	}
	
}
