package game;

public class StageSetting extends Stage{
	
	@Override
	public void init() {
	}
	
	@Override
	public boolean update() {
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
