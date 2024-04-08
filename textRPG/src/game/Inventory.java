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
	private void printItem(){
		int n = 1;
		for(Item item : allItems) {
			System.out.println("======================================");
			System.out.println(n+". \t"+item);
			System.out.println("\t착용여부 : [" + (item.getWearing() ? "O" : "X" )+ "]");
			
			if(item.getWearing()) {
				if(item.getKind() == 1) 
					weapon = true;
				else if(item.getKind() == 2)
					armor = true;
				else if(item.getKind() == 3)
					ring = true;
			}
			
			n++;
		}
	}
	
	
	
}
