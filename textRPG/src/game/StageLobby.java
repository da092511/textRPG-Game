package game;

import java.util.Scanner;

public class StageLobby extends Stage{
	public StageLobby() {
		
	}
	
	@Override
	public void init() {
		UnitManager.getInstance().init();
	}
	
	@Override
	public boolean update() {
		System.out.println("======================================");
		System.out.println("[1. 전투] [2. 설정] [0. 종료]");
		System.out.print("menu <<< ");
		int option = inputNumber();
		
		if(option == 1)
			GameManager.nextStage = "Battle";
		else if(option == 2)
			GameManager.nextStage = "Setting";
		else if(option == 0)
			GameManager.nextStage = "";
		
		return false;
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
}
