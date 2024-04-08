package game;

import java.util.Random;
import java.util.Vector;

public class Guild {
	private Random ran = new Random();
	
	public static final int PARTY_SIZE = 3;
	private Vector<Player> guildList = new Vector<>();
	
	public static Vector<Player> partyList = new Vector<>();
	
	private String path = "game.";
	private String[] type = {"PWarrior", "PWitch", "PHiller"};
	
	public Guild() {
		
	}
	
	public void guildMenu() {
		 System.out.println("=============== [길드관리] ================");
	     System.out.println("[1.길드 목록]\t[2.길드원 추가]\t[3.길드원 삭제]");
	     System.out.println("[4.파티원 교체]\t[5.파티추가]\t[6.파티목록]");
	     System.out.println("[0.뒤로가기]");;
	}
	
	public void setGuild() {
		if(guildList == null || guildList.size() < 3) {
			System.out.println("길드원을 추가하세요");
			return;
		}
		
		partyList.clear();
		// 길드원의 파티 참가 유무가 참이면 파티 추가
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).getParty()) {
		        partyList.add(guildList.get(i));
		    }
		}
	}
	
	public int getGuildSize() {
		return guildList.size();
	}
	
	public void buyUnit() {
		System.out.println(Player.money);
		
		if(Player.money < 500) {
			return;
		}
		
		String[] name1 = {"김","박","정","강","이","박","나","전","차","유","장"};
		String[] name2 = {"민","윤","동","정","강","서","남","도","은","하","소"};
		String[] name3 = {"준","연","선","현","훈","희","하","진","윤","석","정"};
		
		
		int rIdx = ran.nextInt(11);
		String name = name1[rIdx];
		rIdx = ran.nextInt(11);
		name += name2[rIdx];
		rIdx = ran.nextInt(11);
		name += name3[rIdx];
		
		//레벨
		int level = ran.nextInt(5)+1;
		//hp
		int maxHp = 80 * level;
		//power
		int power = 40 + 5 * level;
		
		int def = 0; //방어
		int exp = 0;
		
		rIdx = ran.nextInt(3);
		
		try {
			Class<?> clazz = Class.forName(path+type[rIdx]);
			Object obj = clazz.getConstructor().newInstance();
			Player temp = (Player) obj;
			
			temp.init(name,level,maxHp,power, def, exp);
			
			if(partyList.size() < PARTY_SIZE)
				temp.setParty();
			
			guildList.add(temp);
			printType(temp);
			System.out.println(temp);
			Player.money -= 500;
			temp = null;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void printGuild() {
		int n = 1;
		
		for(Player p : guildList) {
			System.out.print(n + ". ");
			System.out.println(p);
			n++;
		}
	}
	
	private void delectUnit() {
		printGuild();
		System.out.println("삭제할 유저 번호");
		int index = GameManager.inputNumber()-1;
		
		if(index < 0 || index >= guildList.size())
			return;
		
		guildList.remove(index);
	}
	
	private void printParty() {
		int n = 1;
		System.out.println("=============== [현재 파티] ===============");
		for(Player p : partyList) {
			System.out.println(n + ". " + p);
			n++;
		}
	}
	
	private void printType(Player p) {
		if(p instanceof PWarrior) {
			System.out.print("전사");
		}else if(p instanceof PWitch) {
			System.out.print("마녀");
		}else if(p instanceof PHiller) {
			System.out.print("힐러");
		}else
			System.out.println("빕-");
	}
	
	private void changeParty() {
		if(partyList == null)
			return;
		
		printParty();
		System.out.print("교체될 플레이어 번호 : ");
		int outIdx = GameManager.inputNumber()-1;
		
		if(outIdx < 0 || outIdx >= partyList.size())
			return;
		
		printGuild();
		System.out.print("교체할 플레이어 번호");
		int inIdx = GameManager.inputNumber()-1;
		
		if(inIdx < 0 || inIdx >= guildList.size() || guildList.get(inIdx).getParty())
			return;
		
		partyList.get(outIdx).setParty();
		guildList.get(inIdx).setParty();
		
	}
	
	private void addParty() {
		if(partyList.size() == PARTY_SIZE)
			return;
		
		printGuild();
		System.out.print("파티에 추가할 플레이어 번호");
		int index = GameManager.inputNumber()-1;
		
		if(index < 0 || index >= guildList.size() || guildList.get(index).getParty())
			return;
		
		guildList.get(index).setParty();
	}
	
	public void printPartyList() {
		int n= 1;
		for(Player p : partyList) {
			System.out.println(n+". "+p);
			n++;
		}
	}
	
	public void run() {
		while(true) {
			guildMenu();
			int option = GameManager.inputNumber();
			
			if(option == 1)
				printGuild();
			else if(option == 2)
				buyUnit();
			else if(option == 3)
				delectUnit();
			else if(option == 4)
				changeParty();
			else if(option == 5)
				addParty();
			else if(option == 6)
				printPartyList();
			else if(option == 0)
				break;
			
			setGuild();
		}
	}
	
}
