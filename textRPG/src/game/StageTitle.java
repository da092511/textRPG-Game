package game;

import java.util.Scanner;

public class StageTitle extends Stage{
	@Override
	public void init() {
	}
	
	@Override
	public boolean update() {
		System.out.println("[시작] [종료]");
		System.out.print(": ");
		String answer = GameManager.scan.next();
		
		if(answer.equals("시작"))
			GameManager.nextStage = "Lobby";
		else if(answer.equals("종료"))
			GameManager.nextStage = "";
		
		return false;
	}
}
