package game;

public class StageLobby extends Stage{
	@Override
	public void init() {
	}
	@Override
	public boolean update() {
		System.out.println("[1. 전투] [2. 설정] [0. 종료]");
		int option = inputNumber();
		
		if(option == 1)
			GameManager.nextStage = "StageBattle";
		else if(option == 2)
			GameManager.nextStage = "StageSetting";
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
