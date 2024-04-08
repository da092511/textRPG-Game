package game;

import java.util.Scanner;

public class StageTitle extends Stage{
	@Override
	public void init() {
	}
	
	@Override
	public boolean update() {
		String frame = "";
		frame += "==============[TEXT RPG]=============\n";
		frame += "  +++              (*^^*  )          \n";
		frame += " +++++      ++                       \n";
		frame += " +++++     ++++          ^^     O    \n";
		frame += " +++++     ++++                d+b   \n";
		frame += "  |||       ||   옷 옷 옷   *++   ^   \n";
		frame += "-------------------------------------\n";
		frame += "\n";
		frame +="[시작] [종료] 입력 <<< ";
		
		System.out.print(frame);
		
		String answer = GameManager.scan.next();
		
		if(answer.equals("시작"))
			GameManager.nextStage = "Lobby";
		else if(answer.equals("종료"))
			GameManager.nextStage = "";
		
		return false;
	}
}
