package game;

import java.util.Vector;

public class Shop {
	
	Vector <Item> itemList = new Vector<>();
	
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
	    name = "다이아반지";
	    power = 35;
	    price = 20000;
	    temp = new Item(kind,name,power,price);
	    itemList.add(temp);
	}
	
	public static void run() {
		
	}

}

