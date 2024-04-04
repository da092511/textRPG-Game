package game;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage{
	private Random ran = new Random();
	
	Vector<Player> party;
	Vector<Monster> monsterList;
	
	private int pIdx;
	private int pDead;
	
	private int mDead;
	private int mIdx;
	
	
	private void playerSkill(Unit unit) {
		if(unit instanceof Warrior) {
			Warrior w = (Warrior) unit;
			
		}else if(unit instanceof Witch) {
			Witch w = (Witch) unit;
			
		}else if(unit instanceof Hiller) {
			Hiller h = (Hiller) unit;
		}
	}
	
	private boolean playerAttack(Unit unit) {
		if(unit.getCurHp() == 0)
			return false;
		
		if(unit.getLeftFaint() > 0) {
			System.err.println("기절한 상태입니다.");
			return true;
		}
		
		while(true) {
			System.out.println("[1.공격] [2. 스킬]");
			int option = inputNumber();
			
			if(option == 1) {
				int rIdx = ran.nextInt(monsterList.size());
				
				Unit target = monsterList.get(rIdx);
				unit.attack(target);
				
			}else if(option == 2) {
				playerSkill(unit);
			}else
				continue;
			
			break;
		}
		
		return true;
	}
	
	private int inputNumber() {
		int number = -1;
		System.out.print(": ");
		
		try {
			String input = GameManager.scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
	
	@Override
	public boolean update() {
		boolean run = true;
		boolean turn = true;
		
		
		while(run) {
			
			if(turn) {
				Player player = party.get(pIdx);
				
				pIdx ++;
				
				if(pIdx == party.size())
					pIdx = 0;

				if(!playerAttack(player))
					continue;
				
				
			}
			else {
				
			}
			
			if(pDead == 0)
				GameManager.nextStage = "";
			
			if(pDead <= 0 || mDead <= 0)
				run = false;
		}
		
		GameManager.nextStage = "StrageLobby";
		return false;
	}
	
	@Override
	public void init() {
		monsterList = UnitManager.monsterList;
		
		pDead = party.size();
		mDead = monsterList.size();
		
	}
}
