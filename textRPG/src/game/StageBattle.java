package game;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage{
	private Random ran = new Random();
	
	private final int PLAYER = 1;
	private final int MONSTER = 2;
	
	Vector<Player> party;
	Vector<Monster> monsterList;
	
	private int pIdx;
	private int pDead;
	
	private int mDead;
	private int mIdx;
	
	private void playerSkill(Unit unit) {
		if(unit instanceof PWarrior) {
			PWarrior w = (PWarrior) unit;
			
		}else if(unit instanceof PWitch) {
			PWitch w = (PWitch) unit;
			
		}else if(unit instanceof PHiller) {
			PHiller h = (PHiller) unit;
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
			
			if(option == 1 || option == 2 && unit.getSkilInterval() > 0) {
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
	
	private void monsterSkill(Unit unit) {
		if(unit instanceof MOrc) {
			
		}
		else if(unit instanceof MWolf) {
			
		}
		else if(unit instanceof MBat) {
			
		}
	}
	
	private void monsterAttack(Unit unit) {
		int attack = ran.nextInt(20);
		
		if(attack != 1 || attack == 1 && unit.getSkilInterval() > 0) {
			int index = ran.nextInt(party.size());
			
			unit.attack(party.get(index));
		}
		else if(attack == 1) {
		//	monsterSkill(unit);
		}
		
	}
	
	private void setCount(int type) {
		if(type == PLAYER) {
			for(Player player : party) {
				player.setFaintTurn();
				player.setSkillInterval();
			}
		}
		else if(type == MONSTER) {
			for(Monster monster : monsterList) {
				monster.setFaintTurn();
				monster.setSkillInterval();
			}
		}
	}
	
	private void checkPlayer() {
		int cnt = party.size();
		
		for(Unit unit : party) {
			if(unit.getCurHp() == 0)
				cnt--;
		}
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
				
				turn = !turn;
			}
			else {
				Monster m = monsterList.get(mIdx);
				
				mIdx ++;
				
				monsterAttack(m);
				
				if(mIdx == monsterList.size()) {
					turn = !turn;
					mIdx = 0;
				}
			}
			
			if(pDead == 0)
				GameManager.nextStage = "";
			
			checkPlayer();
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
