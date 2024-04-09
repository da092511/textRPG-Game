package game;

public class MBat extends Monster{
	
	public MBat() {
		
	}
	
	@Override
	public void skill() {
		System.out.println("[스킬발동] 적 한 명 기절");
	}
	
	@Override
	public void skill(Unit unit, int shield) {
		if(unit.getIsDead())
			return;
		
		System.out.println("["+this.getName()+"]가 ["+ unit.getName()+"]에게 스킬 사용!");
		
		unit.isFaint(1);
		
	}
}
