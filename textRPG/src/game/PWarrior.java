package game;

public class PWarrior extends Player{
	public PWarrior(){
		this.type = "전사";
	}
	
	@Override
	public void skill() {
		System.out.println("[스킬 발동] 적 전체 공격!");
	}
	
	@Override
	public void skill(Unit unit, int power) {
		if(unit.getIsDead())
			return;
		
		int hit = power + super.getPower();
		
		System.out.println("["+this.getName()+"]이 ["+ unit.getName()+"]에게 스킬 사용! +"+hit+"데미지");
		
		int hp = unit.getCurHp() - hit;
		
		if(hp <= 0) {
			hp = 0;
			unit.isDead();
			System.err.println("["+unit.getName()+"]가 사망하였습니다.");
		}
		
		unit.setCurHp(hp);;
	}
	
	@Override
	public String toString() {
		String info = String.format("[%s](%s): [%4d / %4d]", super.getName(),this.type,super.getCurHp(), super.getMaxHp());
		return info;
	}
}	
