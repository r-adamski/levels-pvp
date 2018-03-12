package me.panda.events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import me.confuser.barapi.BarAPI;
import me.panda.levelspvp.main;
import me.panda.methods.IsIn;
import me.panda.methods.clear;
import me.panda.methods.load;
import me.panda.methods.scoreboard;
import me.panda.methods.sign;
import me.panda.objects.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class death implements Listener{

	@SuppressWarnings("deprecation")
	@EventHandler 
	public static void onDeath(PlayerDeathEvent e){
		String nick = e.getEntity().getName();
		if(IsIn.IsInGame(Bukkit.getPlayer(nick)) == true){
			BarAPI.removeBar(Bukkit.getPlayer(nick));
			if(main.lobby.contains(nick)){
				main.lobby.remove(nick);
			}
	    	Iterator<Entry<String, Game>> it = main.map_game.entrySet().iterator();
			while(it.hasNext())
			{
				Entry<String, Game> e1 = it.next();
				final String name = e1.getKey();
			List<String> red = main.map_game.get(name).getTeamRed();
			List<String> blue = main.map_game.get(name).getTeamBlue();
			List<String> green = main.map_game.get(name).getTeamGreen();
			List<String> purple = main.map_game.get(name).getTeamPurple();
			int rounds = main.map_game.get(name).getRound();
			
			List<String> noteam = main.map_game.get(name).getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){
			if(rounds == 1){
				//Coins.addCoins(nick, 2);
				Bukkit.getPlayer(nick).sendMessage(main.pref + " + " + ChatColor.GOLD + "2 " + ChatColor.GRAY + "coins!");
			}
			else if(rounds == 2){
				//Coins.addCoins(nick, 5);
				Bukkit.getPlayer(nick).sendMessage(main.pref + " + " + ChatColor.GOLD + "5 " + ChatColor.GRAY + "coins!");

			}
			else if(rounds == 3){
				//Coins.addCoins(nick, 10);
				Bukkit.getPlayer(nick).sendMessage(main.pref + " + " + ChatColor.GOLD + "10 " + ChatColor.GRAY + "coins!");

			}
			else if(rounds == 4){
				//Coins.addCoins(nick, 16);
				Bukkit.getPlayer(nick).sendMessage(main.pref + " + " + ChatColor.GOLD + "16 " + ChatColor.GRAY + "coins!");

			}
			else if(rounds == 5){
				//Coins.addCoins(nick, 22);
				Bukkit.getPlayer(nick).sendMessage(main.pref + " + " + ChatColor.GOLD + "22 " + ChatColor.GRAY + "coins!");

			}
			
			if(e.getEntity().getKiller() instanceof Player){
			String killer = e.getEntity().getKiller().getName();
			
		     for(String s : red){
		    	 Bukkit.getPlayer(s).sendMessage(ChatColor.GOLD + nick + ChatColor.GRAY + " zostal zabity przez " + ChatColor.GOLD + killer);
		     }
		     for(String s : blue){
		    	 Bukkit.getPlayer(s).sendMessage(ChatColor.GOLD + nick + ChatColor.GRAY + " zostal zabity przez " + ChatColor.GOLD + killer);
		     }
		     for(String s : green){
		    	 Bukkit.getPlayer(s).sendMessage(ChatColor.GOLD + nick + ChatColor.GRAY + " zostal zabity przez " + ChatColor.GOLD + killer);
		     }
		     for(String s : purple){
		    	 Bukkit.getPlayer(s).sendMessage(ChatColor.GOLD + nick + ChatColor.GRAY + " zostal zabity przez " + ChatColor.GOLD + killer);
		     }
			
			//Coins.addCoins(killer, 15);
			Bukkit.getPlayer(killer).sendMessage(main.pref + " + " + ChatColor.GOLD + "15 " + ChatColor.GRAY + "coins!");
			}
			else{
				
			     for(String s : red){
			    	 Bukkit.getPlayer(s).sendMessage(ChatColor.GOLD + nick + ChatColor.GRAY + " zginal!");
			     }
			     for(String s : blue){
			    	 Bukkit.getPlayer(s).sendMessage(ChatColor.GOLD + nick + ChatColor.GRAY + " zginal!");
			     }
			     for(String s : green){
			    	 Bukkit.getPlayer(s).sendMessage(ChatColor.GOLD + nick + ChatColor.GRAY + " zginal!");
			     }
			     for(String s : purple){
			    	 Bukkit.getPlayer(s).sendMessage(ChatColor.GOLD + nick + ChatColor.GRAY + " zginal!");
			     }
			}
			

			
			ArrayList<String> all = new ArrayList<String>();
			
		    for(String s : red){
		    	all.add(s);
		    }
		    for(String s : blue){
		    	all.add(s);
		    }
		    for(String s : green){
		    	all.add(s);
		    }
		    for(String s : purple){
		    	all.add(s);
		    }
		    		    
		    
			if(red.contains(nick)){
				red.remove(nick);
				
				
				e1.setValue(new Game(name, red, blue, green, purple, noteam, rounds, false));

				
				
				main.tp_check.add(nick);
				Bukkit.getPlayer(nick).sendMessage(main.pref + " Zginales !");
				Player p = Bukkit.getPlayer(nick);
				scoreboard.removePlayerFromArena(p, name);
				scoreboard.reloadTeamSb();
				scoreboard.reloadTeamSize(name);
				scoreboard.removeSB(p);
				sign.reloadSign(name);
				
			}
			else if(blue.contains(nick)){
				blue.remove(nick);
				
				
				e1.setValue(new Game(name, red, blue, green, purple, noteam, rounds, false));

								
				
				main.tp_check.add(nick);

				Bukkit.getPlayer(nick).sendMessage(main.pref + " Zginales !");
				Player p = Bukkit.getPlayer(nick);
				scoreboard.removePlayerFromArena(p, name);
				scoreboard.reloadTeamSb();
				scoreboard.reloadTeamSize(name);
				scoreboard.removeSB(p);
				sign.reloadSign(name);

			}
			else if(green.contains(nick)){
				green.remove(nick);
				
				
				e1.setValue(new Game(name, red, blue, green, purple, noteam, rounds, false));
			
				
				main.tp_check.add(nick);

				Bukkit.getPlayer(nick).sendMessage(main.pref + " Zginales !");
				Player p = Bukkit.getPlayer(nick);
				scoreboard.removePlayerFromArena(p, name);
				scoreboard.reloadTeamSb();
				scoreboard.reloadTeamSize(name);
				scoreboard.removeSB(p);
				sign.reloadSign(name);

			}
			else if(purple.contains(nick)){
				purple.remove(nick);
				
				
				e1.setValue(new Game(name, red, blue, green, purple, noteam, rounds, false));

								
				
				main.tp_check.add(nick);

				Bukkit.getPlayer(nick).sendMessage(main.pref + " Zginales !");
				Player p = Bukkit.getPlayer(nick);
				scoreboard.removePlayerFromArena(p, name);
				scoreboard.reloadTeamSb();
				scoreboard.reloadTeamSize(name);
				scoreboard.removeSB(p);
				sign.reloadSign(name);
																													
			}
			
			 World w = Bukkit.getWorld(main.config.getString("spawn.world"));
			 int x = Integer.parseInt(main.config.getString("spawn.x"));
			 int y = Integer.parseInt(main.config.getString("spawn.y"));
			 int z = Integer.parseInt(main.config.getString("spawn.z"));
			
			//red win
		    if(purple.size() == 0 && blue.size() == 0 && green.size() == 0){
		    	
		    	
				List<String> pseudo_red = new ArrayList<String>();
				e1.setValue(new Game(name, pseudo_red, blue, green, purple, noteam, rounds, false));
		    	
		    	for(String s : red){		    		
					BarAPI.removeBar(Bukkit.getPlayer(s));

					Player p = Bukkit.getPlayer(s);
					scoreboard.removePlayerFromArena(p, name);
					scoreboard.removeGame(name);
					scoreboard.removeSB(p);
					clear.clearPlayer(p);
		    		
		    		Bukkit.getPlayer(s).sendMessage(main.pref + " Zwyciestwo!");
					Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
					//Coins.addCoins(s, 35);
					Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "35 " + ChatColor.GRAY + "coins!");
					if(main.lobby.contains(nick)){
						main.lobby.remove(nick);
					}

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
		    //blue win
		    else if(red.size() == 0 && green.size() == 0 && purple.size() == 0){
				List<String> pseudo_blue = new ArrayList<String>();
				e1.setValue(new Game(name, red, pseudo_blue, green, purple, noteam, rounds, false));
		    	
		    	for(String s : blue){		    		
		    		
					Player p = Bukkit.getPlayer(s);
					BarAPI.removeBar(Bukkit.getPlayer(s));
					scoreboard.removePlayerFromArena(p, name);
					scoreboard.removeGame(name);
					scoreboard.removeSB(p);

					clear.clearPlayer(p);
		    		
		    		Bukkit.getPlayer(s).sendMessage(main.pref + " Zwyciestwo!");
					Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
					//Coins.addCoins(s, 35);
					Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "35 " + ChatColor.GRAY + "coins!");
					if(main.lobby.contains(nick)){
						main.lobby.remove(nick);
					}

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
		    //green win
		    else if(red.size() == 0 && blue.size() == 0 && purple.size() == 0){
		    	
				List<String> pseudo_green = new ArrayList<String>();
				e1.setValue(new Game(name, red, blue, pseudo_green, purple, noteam, rounds, false));
		    	
		    	for(String s : green){		    		
					BarAPI.removeBar(Bukkit.getPlayer(s));

					Player p = Bukkit.getPlayer(s);
					BarAPI.removeBar(Bukkit.getPlayer(s));
					scoreboard.removePlayerFromArena(p, name);
					scoreboard.removeGame(name);
					scoreboard.removeSB(p);

					clear.clearPlayer(p);
					
		    		Bukkit.getPlayer(s).sendMessage(main.pref + " Zwyciestwo!");
					Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
					//Coins.addCoins(s, 35);
					Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "35 " + ChatColor.GRAY + "coins!");
					if(main.lobby.contains(nick)){
						main.lobby.remove(nick);
					}

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
				e1.setValue(new Game(name, red, blue, green, pseudo_purple, noteam, rounds, false));
		    	
		    	for(String s : purple){		    	
		    		
		    		
					Player p = Bukkit.getPlayer(s);
					BarAPI.removeBar(Bukkit.getPlayer(s));
					scoreboard.removePlayerFromArena(p, name);
					scoreboard.removeGame(name);
					scoreboard.removeSB(p);

					clear.clearPlayer(p);
		    		
		    		Bukkit.getPlayer(s).sendMessage(main.pref + " Zwyciestwo!");
					Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
					//Coins.addCoins(s, 35);
					Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "35 " + ChatColor.GRAY + "coins!");
					if(main.lobby.contains(nick)){
						main.lobby.remove(nick);
					}

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
