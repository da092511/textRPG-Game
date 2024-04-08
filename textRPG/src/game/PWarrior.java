package game;

public class PWarrior extends Player{
	public PWarrior(){
		this.type = "전사";
	}
	
	@Override
	public void skill() {
		System.out.println("[스킬 발동] 3턴 기절시키기");
	}
	
	@Override
	public void skill(Unit unit) {
		if(unit.getIsDead())
			return;
		
		unit.isFaint(3);
	}
}	
