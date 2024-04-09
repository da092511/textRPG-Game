package game;

public class MOrc extends Monster{
	public MOrc() {
		
	}
		
	@Override
	public void skill() {
		System.out.println("[스킬발동] 적 한 명에게 2배 공격 + 기절");
	}
	
	@Override
	public void skill(Unit unit, int shield) {
		if(unit.getIsDead())
			return;
		
		System.out.println("["+this.getName()+"]가 ["+ unit.getName()+"]에게 스킬 사용!");
		int power = this.getPower() * 2 - shield;
		int hp = unit.getCurHp() - power;
		
		if(hp <= 0) {
			hp = 0;
			unit.isDead();
			System.err.println("["+unit.getName()+"]가 사망하였습니다.");
		}
		
		unit.setCurHp(hp);
	}
}
