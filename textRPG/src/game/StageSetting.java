package game;

public class StageSetting extends Stage{
	
	@Override
	public void init() {
	}
	
	@Override
	public boolean update() {
		while(true) {
			System.out.println("[1. 길드관리] [2. 상점] [3. 인벤토리]");
			System.out.println("[4. 저장] [5. 로드] [0. 종료]");
			
			int option = inputNumber();
			
			if(option == 1)
				Guild.run();
			else if(option == 2) 
				Shop.run();
			else if(option == 3) {
				Inventory.run();
			}
			else if(option == 4)
				FileManager.save();
			else if(option == 5)
				FileManager.load();
			else if(option == 0)
				break;
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
}
