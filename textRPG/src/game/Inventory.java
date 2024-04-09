package game;

import java.util.Vector;

public class Inventory {
	Vector <Item> wearItems = new Vector<>();
	Vector <Item> allItems = new Vector<>();
	
	public void getItem(Item item) {
		allItems.add(item);
	}
	
	public int getPower() {
		int power = 0;
		
		for(Item item : wearItems) {
			if(item.getKind() == item.WEAPON)
				power += item.getPower();
			else if(item.getKind() == item.RING)
				power += item.getPower();
		}
		
		return power;
	}
	
	public int getShield() {
		int shield = 0;
		
		for(Item item : wearItems) {
			if(item.getKind() == item.ARMOR)
				shield += item.getPower();
		}
		
		return shield;
	}
	
	private void printMenu() {
		System.out.println("======================================");
		System.out.println("[1.아이템 착용]\t[2.아이템 빼기]");
		System.out.println("[0.뒤로가기]");
	}
	private void printItem(){
		int n = 1;
		for(Item item : allItems) {
			System.out.println("--------------------------------------");
			System.out.println(n+". "+item);
			System.out.println("착용여부 : [" + (item.getWearing() ? "O" : "X" )+ "]");
			
			
			n++;
		}
	}
	
	private void wearItem() {
		printItem();
		System.out.println("======================================");
		System.out.print("착용할 아이템 번호 : ");
		int select = GameManager.inputNumber()-1;
		
		if(select < 0 || select >= allItems.size())
			return;
		
		Item target = allItems.get(select);
		
		System.out.println(target);
		
		if(target.getWearing())
			return;
		
		int type = target.getKind();
		
		for(Item item : wearItems) {
			if(target.getKind() == item.getKind())
				return;
		}
		
		System.out.println("--------------------------------------");
		target.setWearing();
		wearItems.add(target);
		System.out.println("착용완료");
	}

	private void takeAway() {
		int n = 1;
		for(Item item : wearItems) {
			System.out.println(n+". "+item);
			System.out.println("착용여부 : [" + (item.getWearing() ? "O" : "X" )+ "]");
			System.out.println("--------------------------------------");
		}
		
		System.out.print("제거할 아이템 번호 : ");
		int select = GameManager.inputNumber()-1;
		
		if(select < 0 || select >= allItems.size())
			return;
		
		Item target = allItems.get(select);
		
		System.out.println(target);
		
		int type = target.getKind();
		
		target.setWearing();
		wearItems.add(target);
		System.out.println("제거완료");
			
	}
	
	public void run() {
		while(true) {
			printMenu();
			int option = GameManager.inputNumber();
			System.out.println("======================================");
			if(option == 1) {
				wearItem();
			}else if(option == 2) {
				takeAway();
			}else if(option == 0)
				break;
		}
	}
	
	private void setWearItems() {
		wearItems.clear();
		
		for(Item item : allItems) {
			if(item.getWearing())
				wearItems.add(item);
		}
	}
	
	public String getData() {
		String data = "";
		// itemSize/itemKind/name/power/price/wearing....
		for(Item item : allItems) {
			int kind = item.getKind();
			String name = item.getName();
			int power = item.getPower();
			int price = item.getPrice();
			String wearing = item.getWearing() ? "true" : "false";
			
			data += "/"+kind +"/"+name+"/"+power+"/"+price+"/"+wearing;
		}
		
		return data;
	}
	
	public void putItem(Vector<Item> allItems) {
		this.allItems = allItems;
		setWearItems();
	}
	
	public void intit() {
		setWearItems();
	}
	
}
