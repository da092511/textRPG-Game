package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameManager {
	public static Scanner scan = new Scanner(System.in);
	
	private Map <String, Stage> stageList = new HashMap<>();
	private String curStage;
	public static String nextStage;
	
	public GameManager() {
		stageList.put("Title", new StageTitle());
		stageList.put("Lobby", new StageLobby());
		stageList.put("Battle", new StageBattle());
		stageList.put("Setting", new StageSetting());
		
		nextStage = "Title";
	}
	
	public static int inputNumber() {
		int number = -1;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("only number");
		}
		
		return number;
	}

	public boolean update() {
		curStage = nextStage;
		
		Stage stage = stageList.get(curStage);
		stage.init(); //초기화
		
		boolean run  = true;
		while(true) {
			run = stage.update();
			if(!run)
				break;
		}
		
		if(nextStage.equals(""))
			return false; 
		
		return true;
	}
}
