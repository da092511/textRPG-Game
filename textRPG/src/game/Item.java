package game;

public class Item {
	public static final int WEAPON = 1; //무기
	public static final int ARMOR = 2; //갑옷
	public static final int RING = 3; //반지
	
	private int kind;
	private String name;
	private int price;
	private int power;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(int kind, String name, int price, int power) {
		this.kind  = kind;
		this.name = name;
		this.price = price;
		this.power = power;
	}
	
	public Item clone() {
		return new Item(this.kind, this.name, this.price, this.power);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getKind() {
		return this.kind;
	}
	
	@Override
	public String toString() {
		String info = "";
				
		info += this.name + "\n";
		info +="Price:" + this.power + "G / pw:" + this.power;
		
		return info;
	}
	
}
