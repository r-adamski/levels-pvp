package me.panda.events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import me.confuser.barapi.BarAPI;
import me.panda.levelspvp.main;
import me.panda.methods.IsIn;
import me.panda.methods.load;
import me.panda.methods.scoreboard;
import me.panda.objects.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class left implements Listener{

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLeft(PlayerQuitEvent e){
		final Player p = e.getPlayer();
		if(IsIn.IsInGame(p) == true){
			scoreboard.removeSB(p);
			BarAPI.removeBar(p);
			me.panda.methods.clear.clearPlayer(p);
			
			if(main.lobby.contains(p.getName())){
				main.lobby.remove(p.getName());
			}
			
			if(main.tp_check.contains(p.getName())){
				for(int i = 0 ; i < main.tp_check.size() ; i++){
					if(main.tp_check.get(i).equalsIgnoreCase(p.getName())){
						i--;
						main.tp_check.remove(p.getName());
					}
				}
			}
	    	Iterator<Entry<String, Game>> it = main.map_game.entrySet().iterator();
			while(it.hasNext())
			{
				Entry<String, Game> e1 = it.next();
				String i = e1.getKey();
				List<String> red = main.map_game.get(i).getTeamRed();
				List<String> blue = main.map_game.get(i).getTeamBlue();
				List<String> green = main.map_game.get(i).getTeamGreen();
				List<String> purple = main.map_game.get(i).getTeamPurple();
				List<String> noteam = main.map_game.get(i).getNoTeam();
				int rounds = main.map_game.get(i).getRound();
				final String name = main.map_game.get(i).getName();
				int round = main.map_game.get(i).getRound();
				boolean countdown = main.map_game.get(i).getcountdown();
				
				String nick = p.getName();
				
				if(round == 1){
					//Coins.addCoins(nick, 2);
				}
				else if(round == 2){
					//Coins.addCoins(nick, 5);
				}
				else if(round == 3){
					//Coins.addCoins(nick, 10);
				}
				else if(round == 4){
					//Coins.addCoins(nick, 16);
				}
				else if(round == 5){
					//Coins.addCoins(nick, 22);
				}

				if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){
					scoreboard.removePlayerFromArena(p, i);
				    scoreboard.reloadTeamSb();
				    scoreboard.reloadTeamSize(name);
				
			     for(String s : red){
			    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + nick + ChatColor.GRAY + " wyszedl z gry :c ");
			     }
			     for(String s : blue){
			    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + nick + ChatColor.GRAY + " wyszedl z gry :c ");
			     }
			     for(String s : green){
			    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + nick + ChatColor.GRAY + " wyszedl z gry :c ");
			     }
			     for(String s : purple){
			    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + nick + ChatColor.GRAY + " wyszedl z gry :c ");
			     }
				
				if(red.contains(nick)){
					red.remove(nick);
					e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));


					me.panda.methods.sign.reloadSign(name);
				}
				else if(blue.contains(nick)){
					blue.remove(nick);
					e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

					me.panda.methods.sign.reloadSign(name);
				}
				else if(green.contains(nick)){
					green.remove(nick);
					e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

					me.panda.methods.sign.reloadSign(name);
				}
				else if(purple.contains(nick)){
					purple.remove(nick);
					e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

					me.panda.methods.sign.reloadSign(name);
				}
				else if(noteam.contains(nick)){
					noteam.remove(nick);
					e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));


					me.panda.methods.sign.reloadSign(name);
				}
				
				
				
				 World w = Bukkit.getWorld(main.config.getString("spawn.world"));
				 int x = Integer.parseInt(main.config.getString("spawn.x"));
				 int y = Integer.parseInt(main.config.getString("spawn.y"));
				 int z = Integer.parseInt(main.config.getString("spawn.z"));
				
				 if(rounds != 0){
				//red win
			    if(purple.size() == 0 && blue.size() == 0 && green.size() == 0){
			    	
			    	
					List<String> pseudo_red = new ArrayList<String>();
					e1.setValue(new Game(name, pseudo_red, blue, green, purple, noteam, round, countdown));
			    	
			    	for(String s : red){		    		
			    		
						Player p1 = Bukkit.getPlayer(s);
						BarAPI.removeBar(Bukkit.getPlayer(s));
						scoreboard.removePlayerFromArena(p1, name);
						scoreboard.removeGame(name);
						scoreboard.removeSB(p1);
						me.panda.methods.clear.clearPlayer(p1);
			    		
			    		Bukkit.getPlayer(s).sendMessage(main.pref + " Zwyciestwo!");
						Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
						//Coins.addCoins(s, 35);
						Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "35 " + ChatColor.GRAY + "coins!");

			    	}
			    	
					
							it.remove();
					
					Location loc = main.map_join.get(name);
					final Sign sign = (Sign)Bukkit.getServer().getWorld(loc.getWorld().getName()).getBlockAt(loc).getState();
									
					sign.setLine(3, ChatColor.DARK_RED + " |RESTART| " );
					sign.update();
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
						@Override
						public void run() {

							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restartworld " + name); 
							load.reloadArena(name);
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv load " + name); 

						}
						}, 600);
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
						@Override
						public void run() {

						  	sign.setLine(3, ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "|DOLACZ|");
		    			  	sign.setLine(2, ChatColor.BOLD + "" + ChatColor.RED + "0" + ChatColor.RESET + "/" + ChatColor.BOLD + "" + ChatColor.RED + Integer.parseInt(main.config.getString("ilosc")));
						  	sign.update();
							
						}
						}, 800);			
			    	
			    	
			    	
			    }
			    //blue win
			    else if(red.size() == 0 && green.size() == 0 && purple.size() == 0){
					List<String> pseudo_blue = new ArrayList<String>();
					e1.setValue(new Game(name, red, pseudo_blue, green, purple, noteam, round, countdown));
			    	
			    	for(String s : blue){		    		
			    		
						Player p1 = Bukkit.getPlayer(s);
						BarAPI.removeBar(Bukkit.getPlayer(s));
						scoreboard.removePlayerFromArena(p1, name);
						scoreboard.removeGame(name);
						scoreboard.removeSB(p1);
						me.panda.methods.clear.clearPlayer(p1);

			    		
			    		Bukkit.getPlayer(s).sendMessage(main.pref + " Zwyciestwo!");
						Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
						//Coins.addCoins(s, 35);
						Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "35 " + ChatColor.GRAY + "coins!");

			    	}
			    	
			    	
					

							it.remove();
					
					Location loc = main.map_join.get(name);
					final Sign sign = (Sign)Bukkit.getServer().getWorld(loc.getWorld().getName()).getBlockAt(loc).getState();
									
					sign.setLine(3, ChatColor.DARK_RED + " |RESTART| " );
					sign.update();
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
						@Override
						public void run() {

							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restartworld " + name); 
							load.reloadArena(name);
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv load " + name); 

						}
						}, 600);
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
						@Override
						public void run() {

						  	sign.setLine(3, ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "|DOLACZ|");
		    			  	sign.setLine(2, ChatColor.BOLD + "" + ChatColor.RED + "0" + ChatColor.RESET + "/" + ChatColor.BOLD + "" + ChatColor.RED + Integer.parseInt(main.config.getString("ilosc")));
						  	sign.update();
							
						}
						}, 800);				
			    	
			    	
			    }
			    //green win
			    else if(red.size() == 0 && blue.size() == 0 && purple.size() == 0){
			    	
					List<String> pseudo_green = new ArrayList<String>();
					e1.setValue(new Game(name, red, blue, pseudo_green, purple, noteam, round, countdown));
			    	
			    	for(String s : green){		    		
			    		
						Player p1 = Bukkit.getPlayer(s);
						BarAPI.removeBar(Bukkit.getPlayer(s));
						scoreboard.removePlayerFromArena(p1, name);
						scoreboard.removeGame(name);
						scoreboard.removeSB(p1);
						me.panda.methods.clear.clearPlayer(p1);

			    		
			    		Bukkit.getPlayer(s).sendMessage(main.pref + " Zwyciestwo!");
						Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
						//Coins.addCoins(s, 35);
						Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "35 " + ChatColor.GRAY + "coins!");

			    	}
			    	
					

							it.remove();
					
					Location loc = main.map_join.get(name);
					final Sign sign = (Sign)Bukkit.getServer().getWorld(loc.getWorld().getName()).getBlockAt(loc).getState();
									
					sign.setLine(3, ChatColor.DARK_RED + " |RESTART| " );
					sign.update();
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
						@Override
						public void run() {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv load " + name); 

							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restartworld " + name); 
							load.reloadArena(name);

						}
						}, 600);
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
						@Override
						public void run() {

						  	sign.setLine(3, ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "|DOLACZ|");
		    			  	sign.setLine(2, ChatColor.BOLD + "" + ChatColor.RED + "0" + ChatColor.RESET + "/" + ChatColor.BOLD + "" + ChatColor.RED + Integer.parseInt(main.config.getString("ilosc")));
						  	sign.update();
							
						}
						}, 800);				
			    	
			    	
			    }
			    //purple win
			    else if(red.size() == 0 && blue.size() == 0 && green.size() == 0){
					List<String> pseudo_purple = new ArrayList<String>();
					e1.setValue(new Game(name, red, blue, green, pseudo_purple, noteam, round, countdown));
			    	
			    	for(String s : purple){		    	
			    		
			    		
						Player p1 = Bukkit.getPlayer(s);
						BarAPI.removeBar(Bukkit.getPlayer(s));
						scoreboard.removePlayerFromArena(p1, name);
						scoreboard.removeGame(name);
						scoreboard.removeSB(p1);
						me.panda.methods.clear.clearPlayer(p1);

			    		
			    		Bukkit.getPlayer(s).sendMessage(main.pref + " Zwyciestwo!");
						Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
						//Coins.addCoins(s, 35);
						Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "35 " + ChatColor.GRAY + "coins!");

			    	}
			    	
					
							it.remove();

					Location loc = main.map_join.get(name);
					final Sign sign = (Sign)Bukkit.getServer().getWorld(loc.getWorld().getName()).getBlockAt(loc).getState();
									
					sign.setLine(3, ChatColor.DARK_RED + " |RESTART| " );
					sign.update();
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
						@Override
						public void run() {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv load " + name); 
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restartworld " + name); 
							load.reloadArena(name);

						}
						}, 600);
					
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
						@Override
						public void run() {

						  	sign.setLine(3, ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "|DOLACZ|");
		    			  	sign.setLine(2, ChatColor.BOLD + "" + ChatColor.RED + "0" + ChatColor.RESET + "/" + ChatColor.BOLD + "" + ChatColor.RED + Integer.parseInt(main.config.getString("ilosc")));
						  	sign.update();
							
						}
						}, 800);					
			    	
			    	
			    }
				 }
				
			}
			}
		}
	}
	
}
