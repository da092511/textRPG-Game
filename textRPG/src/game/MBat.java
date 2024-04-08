package game;

public class MBat extends Monster{
	
	public MBat() {
		
	}
	
	@Override
	public void skill() {
		System.out.println("적 한 명 기절");
	}
	
	@Override
	public void skill(Unit unit) {
		if(unit.getIsDead())
			return;
		//출력
		unit.isFaint(1);
		
	}
}
