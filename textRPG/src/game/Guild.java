package game;

import java.util.Random;
import java.util.Vector;

public class Guild {
	private Random ran = new Random();
	
	public static final int PARTY_SIZE = 3;
	private Vector<Player> guildList = new Vector<>();
	
	public static Vector<Player> partyList = new Vector<>();
	
	private String path = "game.";
	private String[] type = {"Warrior", "Witch", "Hiller"};
	
	public Guild() {
		
	}
	
	public void guildMenu() {
		 System.out.println("=============== [길드관리] ================");
	     System.out.println("[1.길드 목록]\t\t[2.길드원 추가]\t\t[3.길드원 삭제]");
	     System.out.println("[4.파티원 교체]\t\t[5.정렬]\t\t\t[0.뒤로가기]");
	}
	
	public void setGuild() {
		if(guildList == null || guildList.size() < 3) {
			System.out.println("길드원을 추가하세요");
			return;
		}
		
		// 파티 참여 여부
		for (int i = 0; i < PARTY_SIZE; i++) {
			guildList.get(i).party = true;
		}

		// 길드원의 파티 참가 유무가 참이면 파티 추가
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).party == true) {
		        partyList.add(guildList.get(i));
		    }
		}
	}
	
	public int getGuildSize() {
		return guildList.size();
	}
	
	public void buyUnit() {
		String[] name1 = {"김","박","정","강","이","박","나","전","차","유","장"};
		String[] name2 = {"민","윤","동","정","강","서","남","도","은","하","소"};
		String[] name3 = {"준","연","선","현","훈","희","하","진","윤","석","정"};
		
		String name = "";
		
		int rIdx = ran.nextInt(11);
		name += name1[rIdx];
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
			Player p = (Player) obj;
			p = new Player(name, level, maxHp, power, def, exp);
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
	
	private void changeParty() {
		
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
			else if(option == 0)
				break;
			
		}
	}
	
}
