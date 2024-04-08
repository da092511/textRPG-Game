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
			System.out.println(n+". "+item);
			System.out.println("착용여부 : [" + (item.getWearing() ? "O" : "X" )+ "]");
			
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
	
	private void wearItem() {
		printItem();
		System.out.println("======================================");
		System.out.print("착용할 아이템 번호 : ");
		int select = GameManager.inputNumber()-1;
		
		Item target = allItems.get(select);
		
		System.out.println(target);
		
		if(target.getWearing())
			return;
		
		int type = target.getKind();
		
		if(type == 1 && weapon)
			return;
		else if(type == 1) {
			weapon = !weapon;
			target.setWearing();
			wearItems.add(target);
			System.out.println("착용완료");
			return;
		}
		else if(type == 2 && armor)
			return;
		else if(type == 2) {
			armor = !armor;
			target.setWearing();
			wearItems.add(target);
			System.out.println("착용완료");
			return;
		}
		else if(type == 3 && ring)
			return;
		else if(type == 3) {
			ring = !ring;
			target.setWearing();
			wearItems.add(target);
			System.out.println("착용완료");
		}
	}

	private void takeAway() {
		int n = 1;
		for(Item item : wearItems) {
			System.out.println("======================================");
			System.out.println(n+". \t"+item);
			System.out.println("\t착용여부 : [" + (item.getWearing() ? "O" : "X" )+ "]");
		}
		System.out.println("======================================");
		System.out.print("제거할 아이템 번호 : ");
		int select = GameManager.inputNumber()-1;
		
		Item target = allItems.get(select);
		
		System.out.println(target);
		
		if(!target.getWearing())
			return;
		
		int type = target.getKind();
		
		if(type == 1 && !weapon)
			return;
		else if(type == 1) {
			weapon = !weapon;
			target.setWearing();
			wearItems.add(target);
			System.out.println("제거완료");
			return;
		}
		else if(type == 2 && !armor)
			return;
		else if(type == 2) {
			armor = !armor;
			target.setWearing();
			wearItems.add(target);
			System.out.println("제거완료");
			return;
		}
		else if(type == 3 && !ring)
			return;
		else if(type == 3) {
			ring = !ring;
			target.setWearing();
			wearItems.add(target);
			System.out.println("제거완료");
		}
			
	}
	
	public void run() {
		while(true) {
			printMenu();
			int option = GameManager.inputNumber();
			if(option == 1) {
				wearItem();
			}else if(option == 2) {
				takeAway();
			}else if(option == 0)
				break;
		}
	}
	
}
