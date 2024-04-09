package game;

public class MWolf extends Monster{
	public MWolf() {
		
	}
	
	
	@Override
	public void skill() {
		System.out.println("[스킬발동] 적 전체에 절반의 파워로 공격");
	}
	
	@Override
	public void skill(Unit unit, int shield) {
		if(unit.getIsDead())
			return;
		
		System.out.println("["+this.getName()+"]가 ["+ unit.getName()+"]에게 스킬 사용!");
		
		if(super.getPower()<= shield) {
			System.out.println("방어 성공!");
			return;
		}
		
		int hp = unit.getCurHp() - this.getPower()/2 + shield;
		
		if(hp <= 0) {
			hp = 0;
			unit.isDead();
			System.err.println("["+unit.getName()+"]가 사망하였습니다.");
		}
		
		unit.setCurHp(hp);
	}
}
