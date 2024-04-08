package game;

import java.util.Scanner;

public class StageSetting extends Stage{
	private Scanner scan;
	
	private UnitManager um = null; 
	private Player p;

	private Shop shop;
	
	public StageSetting() {
		
	}
	
	@Override
	public boolean update() {
		while(true) {
			System.out.println("[1. 길드관리] [2. 상점] [3. 인벤토리]");
			System.out.println("[4. 저장] [5. 로드] [0. 뒤로가기]");
			int option = -1;
			
			try {
				option = GameManager.scan.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(option == 1)
				um.player.guild.run();
			else if(option == 2) 
				shop.run();
			else if(option == 3) 
				Inventory.run();
			else if(option == 4)
				FileManager.save();
			else if(option == 5)
				FileManager.load();
			else if(option == 0) {
				GameManager.nextStage = "Lobby";
				break;
			}
		}
		
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

	@Override
	public void init() {
		um = UnitManager.getInstance();
		shop = new Shop();
	}
	
}
