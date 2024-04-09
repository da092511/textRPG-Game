package game;

import java.awt.event.ItemListener;
import java.util.Vector;

public class Shop {
	private Player p ;
	private Vector <Item> itemList = new Vector<>();
	
	public Shop() {
		int kind = Item.WEAPON;
		String name = "나무검";
		int power = 3;
		int price = 1000;
		Item temp = new Item(kind,name,power,price);
		itemList.add(temp);

	    kind = Item.WEAPON;
	    name = "철검";
	    power = 5;
	    price = 2000;
	    temp = new Item(kind,name,power,price);
	    itemList.add(temp);
	    
	    kind = Item.WEAPON;
	    name = "레이피어";
	    power = 7;
	    price = 2500;
	    temp = new Item(kind,name,power,price);
	    itemList.add(temp);

	    kind = Item.ARMOR;
	    name = "티셔츠";
	    power = 1;
	    price = 300;
	    temp = new Item(kind,name,power,price);
	    itemList.add(temp);

	    kind = Item.ARMOR;
	    name = "가죽갑옷";
	    power = 4;
	    price = 800;
	    temp = new Item(kind,name,power,price);
	    itemList.add(temp);

	    kind = Item.ARMOR;
	    name = "강철갑옷";
	    power = 7;
	    price = 1500;
	    temp = new Item(kind,name,power,price);
	    itemList.add(temp);

	    kind = Item.RING;
	    name = "은반지";
	    power = 7;
	    price = 3000;
	    temp = new Item(kind,name,power,price);
	    itemList.add(temp);
	    
	    kind = Item.RING;
	    name = "금반지";
	    power = 17;
	    price = 6000;
	    temp = new Item(kind,name,power,price);
	    itemList.add(temp);

	    kind = Item.RING;
	    name = "다이아반지[💍]";
	    power = 35;
	    price = 20000;
	    temp = new Item(kind,name,power,price);
	    itemList.add(temp);
	}
	
	public void printItem(int type) {
		int n = 1;
		System.out.println("======================================");
		for(Item item : itemList)
			if(item.getKind() == type) {
				System.out.println(n + ". " +item);
				System.out.println("--------------------------------------");
				n++;
			}
	}
	
	private void buyItem(int type) {
		System.out.println("현재 골드: "+ p.getMoney()+"G");
		System.out.println("구입할 상품번호 : ");
		int select = GameManager.inputNumber()-1;
		
		Item target = null;
		
		int n = 0;
		for(int i=0;i<itemList.size();i++) {
			Item item = itemList.get(i);
			if(item.getKind() == type) {
				if(n == select) {
					target = item;
					break;
				}
				n++;
			}
		}
		
		if(target == null)
			return;
		
		int price = target.getPrice();
		
		if(p.getMoney() < price) {
			System.err.println("돈이 부족합니다.");
			return;
		}
		System.out.println("======================================");
		System.out.println(target.getName()+" 구입");
		p.addMoney(-price);
		p.inven.getItem(target);
	}
	
	public void run() {
		while(true) {
			p = UnitManager.getInstance().player;
			System.out.println("======================================");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
			int option = GameManager.inputNumber();
			
			if(option == 0)
				break;
			
			printItem(option);
			buyItem(option);
			System.out.println("현재 골드: "+ p.getMoney()+"G");
		}
	}
}

