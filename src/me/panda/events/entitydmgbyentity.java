package me.panda.events;

import java.util.List;

import me.panda.levelspvp.main;
import me.panda.methods.IsIn;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class entitydmgbyentity implements Listener{

	@EventHandler
	public void onDmg(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player) {

		Player p = (Player) e.getEntity();
		String nick = p.getName();
		if(IsIn.IsInGame(p) == true){
					
			Player pd = null;
			
			EntityDamageByEntityEvent damageCause = (EntityDamageByEntityEvent)e;
            if (damageCause.getDamager() instanceof Arrow){
                 pd = (Player)((Arrow)e.getDamager()).getShooter();
            }
            else if(damageCause.getDamager() instanceof EnderPearl){
            	pd = (Player)((EnderPearl)e.getDamager()).getShooter();
            }
            else if(damageCause.getDamager() instanceof Player){
			 pd = (Player) e.getDamager();
            }
            
			
    		for(String i : main.map_game.keySet()){
			
			List<String> red = main.map_game.get(i).getTeamRed();
			List<String> blue = main.map_game.get(i).getTeamBlue();
			List<String> green = main.map_game.get(i).getTeamGreen();
			List<String> purple = main.map_game.get(i).getTeamPurple();
			

			if(pd != null){
			if(IsIn.IsInLobby(p) == true && IsIn.IsInLobby(pd) == true){
				e.setCancelled(true);
				e.setDamage(0);
			}
			if(red.contains(nick) && red.contains(pd.getName())){
				e.setCancelled(true);
				e.setDamage(0);
			}
			else if(blue.contains(nick) && blue.contains(pd.getName())){
				e.setCancelled(true);
				e.setDamage(0);
			}
			else if(green.contains(nick) && green.contains(pd.getName())){
				e.setCancelled(true);
				e.setDamage(0);
			}
			else if(purple.contains(nick) && purple.contains(pd.getName())){
				e.setCancelled(true);
				e.setDamage(0);
			}
		    
		}
		}
		}
		
		}
		
	}
	
}
