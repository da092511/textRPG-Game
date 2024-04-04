package game;

public class Unit {
	
	private int maxHp;
	private int curHp;
	private int power;
	
	private boolean isDead;
	
	private boolean isFaint;
	private int faintTurn ;
	
	
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
	
	
}
