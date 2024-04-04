package game;

public abstract class Unit {
	private String name;
	
	private int maxHp;
	private int curHp;
	private int power;
	
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
	
	public void isFaint(int faintTurn) {
		this.faintTurn = faintTurn;
	}
	
	public int getLeftFaint() {
		return this.faintTurn;
	}
	
	public void setFaintTurn() {
		this.faintTurn --;
	}
	
	public int getSkilInterval() {
		return skillInterval;
	}
	
	public void setSkillInterval() {
		this.skillInterval --;
	}
	
	public abstract void skill(Unit unit);
	
	
}
