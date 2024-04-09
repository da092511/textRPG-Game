package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

public class FileManager {
	private String fileName = "TXTRPG";
	private UnitManager um = UnitManager.getInstance();

	private String path = "game.";
	private String[] type = {"PWarrior", "PWitch", "PHiller"};
	
	private File file = new File(fileName);
	
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	public FileManager() {

	}
	
	private String getData() {
		//player
		// money,round
		String data = "";
		Player p = um.player;
		
		//  money/round\n
		data += p.getMoney() +"/";
		data +=  p.getRound() + "\n";
		
		// guildSize/name/level/curHp/MaxHp/power/exp/type/party ...
		data += p.getGuildSize();
		
		if(p.getGuildSize() != 0) {
			data += p.guild.getData();
		}
		
		data +="\n";
		
		//item
		Inventory inven = p.inven;
		
		// itemSize/itemKind/name/power/price/wearing....
		data += inven.allItems.size();
		if(inven.allItems.size() > 0) {
			data += inven.getData();
		}
		
		return data;
	}
	
	public void save() {
		String data = getData();
		
		try {
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
			System.out.println("[저장 완료]");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("[저장 실패]");
		}
		
	}
	
	private void setPlayer(String info) {
		String[] playerData = info.split("/");
		
		int money = Integer.parseInt(playerData[0]);
		int round = Integer.parseInt(playerData[1]);
		
		um.player.addMoney(money - um.player.getMoney());
		um.player.setRound(round);
	}
	
	private void setGuild(String info) {
		String[] data  = info.split("/");
		
		if(data[0].equals("0")) {
			um.player.guild = new Guild();
			return;
		}
		
		Vector<Player> guildList = new Vector<>();
		
		//name/level/curHp/MaxHp/power/exp/type/party
		for(int i=1;i<data.length;i++) {
			String name = data[i];
			int level = Integer.parseInt(data[i+1]);
			int curHp = Integer.parseInt(data[i+2]);
			int maxHp = Integer.parseInt(data[i+3]);
			int power = Integer.parseInt(data[i+4]);
			int exp = Integer.parseInt(data[i+5]);
			String type = data[i+6];
			boolean party = data[i+7].equals("true") ? true : false;
			
			int index  = -1;
			
			if(type.equals("전사"))
				index = 0;
			else if(type.equals("마녀"))
				index = 1;
			else if(type.equals("힐러"))
				index = 2;
			
			try {
				Class<?> clazz = Class.forName(this.path+this.type[index]);
				Object obj = clazz.getConstructor().newInstance();
				Player p = (Player) obj;
				
				p.init(name,level,curHp,maxHp,power,exp,type,party);
				
				guildList.add(p);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			i += 7;
		}
		
		um.player.guild.putGuild(guildList);
	}
	
	
	public void setItem(String info) {
		String[] data  = info.split("/");
		
		if(data[0].equals("0")) {
			um.player.inven = new Inventory();
			return;
		}
		
		Vector<Item> allItems = new Vector<>();
		// itemKind/name/power/price/wearing
		for(int i=1;i<data.length;i++) {
			int kind = Integer.parseInt(data[i]);
			String name = data[i+1];
			int power = Integer.parseInt(data[i+2]);
			int price = Integer.parseInt(data[i+3]);
			boolean wearing = data[i+4].equals("true") ? true : false;
			
			Item item = new Item(kind,name,power,price);
			
			if(wearing)
				item.setWearing();
			
			allItems.add(item);
			
			i += 4;
		}
		
		um.player.inven.putItem(allItems);
	}

	public void load() {
		if(file.exists()) {
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String info = br.readLine();
				setPlayer(info);
				
				info = br.readLine();
				setGuild(info);
				
				info = br.readLine();
				setItem(info);
				
				fr.close();
				br.close();
				System.out.println("로드 완료");
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("[로드 실패]");
			}
		}
	}
}
