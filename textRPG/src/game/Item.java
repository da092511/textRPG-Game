package game;

public class Item {
	public static final int WEAPON = 1; //무기
	public static final int ARMOR = 2; //갑옷
	public static final int RING = 3; //반지
	public static final int POTION = 4; //포션
	
	public static final int ONLY_PARCHASE = 0; //매입만 판매X 
	
	public static final int FOR_WARIIOR = 1;
	public static final int FOR_WITCH = 2;
	public static final int FOR_HILLER = 3;
	
	private int kind;
	private String name;
	private int price;
	private int power;
	
	private boolean wearing;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(int kind, String name, int power, int price) {
		this.kind  = kind;
		this.name = name;
		this.power = power;
		this.price = price;
	}
	
	public Item clone() {
		return new Item(this.kind, this.name, this.power, this.price);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getKind() {
		return this.kind;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public void setWearing() {
		this.wearing = !wearing;
	}
	
	public boolean getWearing() {
		return this.wearing;
	}
	
	@Override
	public String toString() {
		String info = "";
				
		info += this.name + "\n";
		info +="Price:" + this.price + "G / power:" + this.power;
		
		return info;
	}
	
}
