package game;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	private Random ran  = new Random();
	
	private static UnitManager instance = new UnitManager();
	
	public static Vector<Player> playerList = new Vector<>();
	public static Vector<Monster> monsterList = new Vector<>();
	
	Player player = new Player();
	
	private int maxMonster;
	
	String path = "game.";
	String[] monster = {"MOrc", "MWolf", "MBat"};
	
	int hpLimit;
	int powLimt;
	
	public void init() {
		player.init();
	}
	
	public void setMonster(int size) {
		for(int i=0;i<size;i++) {
			addMonster();
		}
	}
	
	private void addMonster() {
		int rIdx = ran.nextInt(3);
		
		String name = "";
		
		if(rIdx == 0)
			name += "오크";
		else if(rIdx == 1)
			name += "늑대";
		else if(rIdx == 2)
			name += "박쥐";
		
		int hp = ran.nextInt(5)+6;
		hp = hp * 10;
		int power = ran.nextInt(6)+1;
		power = power *5;
		
		try {
			Class<?> clazz = Class.forName(path + monster[rIdx]);
			Object obj = clazz.getConstructor().newInstance();
			Monster mon = (Monster) obj;
			
			mon.init(name,hp,power);
			monsterList.add(mon);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static UnitManager getInstance () {
		return instance;
	}
	
	
	
}
