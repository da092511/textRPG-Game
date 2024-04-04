package game;

public class UnitManager {
	public static UnitManager instance = new UnitManager();
	
	String path = "game.";
	String[] monster = {"MonsterOrc", "MonsterWolf", "MonsterBat"};
	
	int hpLimit;
	int powLimt;
	
	public static UnitManager getInstance () {
		return instance;
	}
	
	
	
	
}
