package game;

import java.awt.event.ItemListener;
import java.util.Vector;

public class Shop {
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
	
	public void weapon() {
		int n = 1;
		for(Item item : itemList)
			if(item.getKind() == item.WEAPON) {
				System.out.println("-------------------");
				System.out.println(n + ". " +item);
				System.out.println("-------------------");
				n++;
			}
	}
	
	public void armor() {
		int n = 1;
		for(Item item : itemList)
			if(item.getKind() == item.ARMOR) {
				System.out.println("-------------------");
				System.out.println(n + ". " +item);
				System.out.println("-------------------");
				n++;
			}
	}
	
	public void ring() {
		int n = 1;
		for(Item item : itemList)
			if(item.getKind() == item.RING) {
				System.out.println("-------------------");
				System.out.println(n + ". " +item);
				System.out.println("-------------------");
				n++;
			}
	}
	
	public void run() {
		while(true) {
			System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
			int option = GameManager.inputNumber();
			
			if(option == 1) 
				weapon();
			else if(option == 2)
				armor();
			else if(option == 3)
				ring();
			else if(option == 0)
				break;
			
			
			
		}
	}
}

