package game;

import java.util.Vector;

public class GuildManager {

	private Vector<Guild> guilds = new Vector<>();
	
	
	
	public void addGuild(Guild guild) {
		guilds.add(guild);
	}
	
	public Guild findGuildByCode(int code) {
		Guild target = null;
		
		for(Guild guild : guilds)
			if(guild.getCode() == code)
				target = guild;
		
		return target;
	}
}
