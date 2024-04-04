package game;

import java.util.HashMap;
import java.util.Map;

public class GameManager {
	private Map <String, Stage> stageList = new HashMap<>();
	private String curStage;
	public String nextStage;
	
	public GameManager() {
		stageList.put("Title", new StageTitle());
		stageList.put("Lobby", new StageLobby());
		stageList.put("Battle", new StageBattle());
		
		nextStage = "Title";
	}

	public boolean update() {
		if(curStage.equals(nextStage)) {
			return true;
		}
		
		curStage = nextStage;
		
		Stage stage = stageList.get(curStage);
		stage.init(); //초기화
		
		stage.update();
		
		if(nextStage.equals(""))
			return false; 
		
		return true;
	}
}
