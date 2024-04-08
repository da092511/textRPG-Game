package game;

public abstract class Unit {
	public static String name;
	
	private int maxHp;
	private int curHp;
	private int power;
	int level; // 레벨
	int hp;
	
	int def; // 방어
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
		this.power = power;
	}
	
	 public Unit(String name, int level, int hp, int att, int def, int exp) {
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.power = att;
		this.def = def;
		this.exp = exp;
		weapon = null;
		armor = null;
		ring = null;
	}
	
	public void attack(Unit target) {
		if(target.getIsDead())
			return;
		
		int hp = target.getCurHp() - this.power;
		target.setCurHp(hp);
	}
	
	public String getName() {
		return this.name;
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
	
	public void skill(Unit unit) {
		
	}
	
	public void init(int hp, int power) {
		this.curHp = hp;
		this.maxHp = hp;
		this.power = power;
	}
	
	@Override
	public String toString() {
		String info = String.format("[%s] : [%4d / %4d]", this.name, this.curHp, this.maxHp);
		
		return info;
	}
	
}
