package game;

public abstract class Unit {
	private String name;
	
	private int maxHp;
	private int curHp;
	private int power;
	
	private boolean isDead;
	
	private boolean isFaint;
	private int faintTurn ;
	
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
	
	public abstract void skill(Unit unit);
	
	
}
