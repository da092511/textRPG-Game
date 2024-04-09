package game;

public class Monster extends Unit{
	
	public void init(String name, int hp, int power) {
		super.init(name,hp, power);
	}
	
	@Override
	public void attack(Unit target, int shield) {
		if(target.getIsDead())
			return;
		
		System.out.println("["+super.getName()+"]가 ["+ target.getName()+"]을 공격!");
		
		if(super.getPower() <= shield) {
			System.out.println("방어 성공!");
			return;
		}
		
		int hp = target.getCurHp() - super.getPower() + shield;
		
		if(hp <= 0) {
			hp = 0;
			target.isDead();
			System.err.println("["+target.getName()+"]가 사망하였습니다.");
		}
		
		target.setCurHp(hp);
	}
	
	@Override
	public String toString() {
		String info ="[" + super.getName()+ "]" + "["+super.getCurHp()+"/"+super.getMaxHp()+"]";
		return info;
	}
}
