package game;

public class MOrc extends Monster{
	public MOrc() {
		this.name = "오크";
	}
		
	@Override
	public void skill() {
		System.out.println("적 한 명에게 2배 공격 + 기절");
	}
	
	@Override
	public void skill(Unit unit) {
		if(unit.getIsDead())
			return;
		
		//출력
		int power = this.getPower() * 2;
		int hp = unit.getCurHp() - power;
		
		if(hp <= 0) {
			hp = 0;
			unit.isDead();
		}
		
		unit.setCurHp(hp);
	}
}
