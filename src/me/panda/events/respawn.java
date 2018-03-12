package me.panda.events;

import me.panda.levelspvp.main;
import me.panda.methods.give;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class respawn implements Listener{

	//event od respawnu graczy
	@EventHandler
	public void onRespawn(final PlayerRespawnEvent e){
		final String nick = e.getPlayer().getName();
		if(main.tp_check.contains(nick)){
			final World w = Bukkit.getWorld(main.config.getString("spawn.world"));
			final int x = main.config.getInt("spawn.x");
			final int y = main.config.getInt("spawn.y");
			final int z = main.config.getInt("spawn.z");
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
				@SuppressWarnings("deprecation")
				@Override
				public void run() {
					
					Bukkit.getPlayer(nick).teleport(new Location(w, x, y, z));
					give.giveItems(e.getPlayer());
					
				}
				}, 1);
			
			for(int i = 0 ; i < main.tp_check.size() ; i++){
				if(main.tp_check.get(i).equalsIgnoreCase(nick)){
					i--;
					main.tp_check.remove(nick);
				}
			}
		}
	}
	
}
