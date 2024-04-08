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
	String[] monster = {"MonsterOrc", "MonsterWolf", "MonsterBat"};
	
	int hpLimit;
	int powLimt;
	
	public void init() {
		player.init();
	}
	
	public void setMonster(int size) {
		for(int i=0;i<size;i++) {
			int rIdx = ran.nextInt(3);
			try {
			Class<?> clazz = Class.forName(path + monster[rIdx]);
			Object obj = clazz.getConstructor();
			Monster mon = (Monster) obj;
			
			int hp = ran.nextInt(5)+6;
			hp = hp * 10;
			int power = ran.nextInt(6)+1;
			power = power *5;
			
			mon.init(hp,power);
			monsterList.add(mon);
			
			}catch(Exception e) {
				
			}
		}
	}
	
	public static UnitManager getInstance () {
		return instance;
	}
	
	
	
}
