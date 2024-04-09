package game;

public class PWitch extends Player{
	
	public PWitch() {
		super.type = "마녀";
	}
	
	@Override
	public void skill() {
		System.out.println("적 전체 2턴 기절");
	}
	
	@Override
	public void skill(Unit unit, int power) {
		if(unit.getIsDead())
			return;
		
		System.out.println("["+this.getName()+"]이 ["+ unit.getName()+"]에게 스킬 사용!");
		
		unit.isFaint(2);
	}

}
