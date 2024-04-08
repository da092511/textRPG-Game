package game;

public class PWitch extends Player{
	
	public PWitch() {
		super.name = "마녀";
	}
	
	@Override
	public void skill() {
		System.out.println("적 전체 2턴 기절");
	}
	
	@Override
	public void skill(Unit unit) {
		if(unit.getIsDead())
			return;
		
		unit.isFaint(2);
	}

}
