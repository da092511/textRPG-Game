package game;

public class PHiller extends Player{
	
	@Override
	public void skill() {
		System.out.println("[스킬 발동] 아군의 체력 +50HP");
	}
	
	@Override
	public void skill(Unit unit) {
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
}
