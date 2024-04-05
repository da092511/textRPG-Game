package game;

public class PWitch extends Player{
	private String name;
	
	private int maxHp;
	private int curHp;
	
	private int power;
	
	public PWitch(String name, int hp, int power) {
		super(name,hp,power);
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
