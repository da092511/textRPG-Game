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
	
	@Override
	public String toString() {
		String survive = super.getIsDead() ? "사망" : "생존";
		String faint = super.getLeftFaint() > 0 ? "기절O"+super.getLeftFaint()+"턴": "기절X";
 		
		String info = String.format("[%s](%s): [%4d / %4d][%s/%s]", 
				super.getName(),this.type,super.getCurHp(), super.getMaxHp(),survive, faint);
		
		return info;
	}

}
