package game;

public class MWolf extends Monster{
	public MWolf() {
		
	}
	
	
	@Override
	public void skill() {
		System.out.println("적 전체에 절반의 파워로 공격");
	}
	
	@Override
	public void skill(Unit unit) {
		if(unit.getIsDead())
			return;
		
		//출력
		int hp = unit.getCurHp() - this.getPower()/2;
		
		if(hp <= 0) {
			hp = 0;
			unit.isDead();
		}
		
		unit.setCurHp(hp);
	}
}
