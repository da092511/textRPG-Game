package game;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage{
	private Random ran = new Random();
	
	private UnitManager um ;
	
	private final int PLAYER = 1;
	private final int MONSTER = 2;
	
	Vector<Player> party;
	Vector<Monster> monsterList;
	
	private int pIdx;
	private int pDead;
	
	private int mDead;
	private int mIdx;
	
	private int round;
	
	public StageBattle() {
		um = UnitManager.getInstance();
	}
	
	private void playerSkill(Unit unit) {
		if(unit instanceof PWarrior) {
			PWarrior w = (PWarrior) unit;
			for(Monster mon : monsterList)
				w.skill(mon);
			
		}else if(unit instanceof PWitch) {
			PWitch w = (PWitch) unit;
			for(Monster mon : monsterList)
				w.skill(mon);
			
		}else if(unit instanceof PHiller) {
			PHiller h = (PHiller) unit;
			for(Player p : party)
				h.skill(p);
		}
	}
	
	private boolean playerAttack(Unit unit) {
		if(unit.getCurHp() == 0)
			return false;
		
		if(unit.getLeftFaint() > 0) {
			System.err.println("기절한 상태입니다.");
			return true;
		}
		
		printBattle();
		while(true) {
			System.out.print(party.get(pIdx).getName() + " ");
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
			int rIdx = ran.nextInt(3);
			
			MOrc orc = (MOrc) unit;
			orc.skill(party.get(rIdx));
		}
		else if(unit instanceof MWolf) {
			MWolf wolf = (MWolf) unit;
			for(Player p : party)
				wolf.skill(p);
		}
		else if(unit instanceof MBat) {
			int rIdx = ran.nextInt(3);
			
			MBat bat = (MBat) unit;
			bat.skill(party.get(rIdx));
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
			if(unit.getCurHp() <= 0)
				cnt--;
		}
		pDead = cnt;
		
		cnt = monsterList.size();
		for(Unit unit : monsterList) {
			if(unit.getCurHp() <= 0)
				cnt--;
		}
		mDead = cnt;
	}
	
	private void printBattle() {
		System.out.println("===============[BATTLE]===============");
		for(Player player : party) {
			System.out.println(player);
		}
		System.out.println("======================================");
		for(Monster monster : monsterList) {
			System.out.println(monster);
		}
			
	}
	
	private void printParty() {
		for(Player player : party)
			System.out.println(player);
	}
	
	@Override
	public boolean update() {
		if(party.size() == 0) {
			GameManager.nextStage  = "Lobby";
			return false;
		}
		
		checkPlayer();
		
		if(pDead == 0) {
			return false;
		}
		
		boolean run = true;
		boolean turn = true;
		
		String message = "===============["+ round + "ROUND" + "]=============== ";
		System.out.println(message);
		
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
			if(mDead == 0) {
				um.player.addMoney(10000);
				System.out.println("승리~~!!");
			}else if(pDead == 0) {
				um.player.addMoney(-5000);
				System.out.println("아군이 전멸하였습니다.");
			}
			
			if(pDead <= 0 || mDead <= 0)
				run = false;
		}
		
		GameManager.nextStage = "Lobby";
		return false;
	}
	
	@Override
	public void init() {
		um.monsterList.clear();
		um.setMonster(4);
		monsterList = um.monsterList;
		
		party = um.player.guild.partyList;
	   
	    mDead = monsterList.size();
	    pDead = um.player.getGuildSize();
		
		round ++;
	}
}
