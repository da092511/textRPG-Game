package game;

public class PHiller extends Player{
	
	public PHiller() {
		
	}
	
	@Override
	public void skill() {
		System.out.println("[스킬 발동] 아군의 체력 +50HP");
	}
	
	@Override
	public void skill(Unit unit, int power) {
		if(unit.getIsDead())
			return;
		
		//출력
		int hp = unit.getCurHp() + 50;
		int maxHp = unit.getMaxHp();
		
		if(hp > maxHp) {
			hp = maxHp;
		}
		
		unit.setCurHp(hp);
	}
	
	@Override
	public String toString() {
		String survive = super.getIsDead() ? "사망" : "생존";
		String faint = super.getLeftFaint() > 0 ? "기절O"+super.getLeftFaint(): "기절X";
 		
		String info = String.format("[%s](%s): [%4d / %4d][%s/%s]", 
				super.getName(),this.type,super.getCurHp(), super.getMaxHp(),survive, faint);
		
		return info;
	}
}
