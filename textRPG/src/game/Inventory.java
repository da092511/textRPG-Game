package game;

import java.util.Vector;

public class Inventory {
	Vector <Item> wearItems = new Vector<>();
	Vector <Item> allItems = new Vector<>();
	
	private boolean ring ;
	private boolean weapon;
	private boolean armor;
	
	public void getItem(Item item) {
		allItems.add(item);
	}
	
	private void printMenu() {
		System.out.println("======================================");
		System.out.println("[1.아이템 착용]\t[2.아이템 빼기]");
		System.out.println("[0.뒤로가기]");
	}
	
}
