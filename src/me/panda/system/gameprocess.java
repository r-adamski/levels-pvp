package me.panda.system;

import java.util.ArrayList;
import java.util.List;

import me.confuser.barapi.BarAPI;
import me.panda.levelspvp.main;

import org.bukkit.Bukkit;
import me.panda.methods.clear;
import me.panda.methods.load;
import me.panda.methods.scoreboard;
import me.panda.objects.Game;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class gameprocess {

	@SuppressWarnings("deprecation")
	public static void startGame(final String name){
		 Bukkit.getScheduler().runTask(main.plugin, new Runnable(){
	         @Override
	         public void run() {
			Location loc = main.map_join.get(name);
			
			Sign sign = (Sign)Bukkit.getServer().getWorld(loc.getWorld().getName()).getBlockAt(loc).getState();
			String w = ChatColor.stripColor(sign.getLine(1));
			if(w.equalsIgnoreCase(name)){
				sign.setLine(3, ChatColor.BOLD + "" + ChatColor.DARK_RED + "|W TRAKCIE|");
				sign.update();
			}
			
		
		
		//tp na 1 poziom
		
		final List<String> red = main.map_game.get(name).getTeamRed();
		final List<String> blue = main.map_game.get(name).getTeamBlue();
		final List<String> green = main.map_game.get(name).getTeamGreen();
		final List<String> purple = main.map_game.get(name).getTeamPurple();
		final List<String> noteam = main.map_game.get(name).getNoTeam();

		for(String s : red){
			Player p = Bukkit.getPlayer(s);
			clear.clearPlayer(p);
			Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc1Red());
			Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpoczeta!");
			main.lobby.remove(s);
			
			if(main.config.getBoolean("czasowe") == true){
				BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom1"), main.config.getInt("timeshow")/1000);
			}
			else{
				BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom1"));
			}
		}
		for(String s : blue){
			Player p = Bukkit.getPlayer(s);
			clear.clearPlayer(p);
			Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc1Blue());
			Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpoczeta!");
			main.lobby.remove(s);
			if(main.config.getBoolean("czasowe") == true){
				BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom1"), main.config.getInt("timeshow")/1000);
			}
			else{
				BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom1"));
			}
		}
		for(String s : green){
			Player p = Bukkit.getPlayer(s);
			clear.clearPlayer(p);
			Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc1Green());
			Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpoczeta!");
			main.lobby.remove(s);
			if(main.config.getBoolean("czasowe") == true){
				BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom1"), main.config.getInt("timeshow")/1000);
			}
			else{
				BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom1"));
			}
		}
		for(String s : purple){
			Player p = Bukkit.getPlayer(s);
			clear.clearPlayer(p);
			Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc1Purple());
			Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpoczeta!");
			main.lobby.remove(s);
			if(main.config.getBoolean("czasowe") == true){
				BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom1"), main.config.getInt("timeshow")/1000);
			}
			else{
				BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom1"));
			}
		}
		
		main.map_game.remove(name);
		main.map_game.put(name, new Game(name, red, blue, green, purple, noteam, 1, true));
	         }});
		
	Thread t = new Thread(new Runnable(){																						
		@Override
	    public void run() {
	    	try{
	    		for(int i = main.map_arena.get(name).getTime1() ; i > 0 ; i--){
	    			if(Thread.currentThread().isInterrupted() == false){
	    			if(main.map_game.get(name) != null){
	    				scoreboard.reloadTime(name, i);

					final List<String> red = main.map_game.get(name).getTeamRed();
					final List<String> blue = main.map_game.get(name).getTeamBlue();
					final List<String> green = main.map_game.get(name).getTeamGreen();
					final List<String> purple = main.map_game.get(name).getTeamPurple();
					List<String> noteam = main.map_game.get(name).getNoTeam();
					
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
				    
	    			Thread.sleep(1000);

				    
	    						
					if(i == 60){
						for(String s : all){
							if(Bukkit.getPlayer(s) != null){
							Bukkit.getPlayer(s).sendMessage(main.pref + " Nastepny poziom za " + ChatColor.GOLD + " 60 " + ChatColor.GRAY + " sekund");
						}
						}
					}
					else if(i == 10){
						for(String s : all){
							if(Bukkit.getPlayer(s) != null){

							Bukkit.getPlayer(s).sendMessage(main.pref + " Nastepny poziom za " + ChatColor.GOLD + " 10 " + ChatColor.GRAY + " sekund");
						}
						}
					}
	    			
									
					if(i == 1){
	    					for(String s : all){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).sendMessage(main.pref + " Zostales przeniesiony na nastepny poziom !");
	    						
	    						if(main.config.getBoolean("czasowe") == true){
	    							BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom2"), main.config.getInt("timeshow")/1000);
	    						}
	    						else{
	    							BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom2"));
	    						}
	    						}
	    					}
	    					
    						main.map_game.remove(name);
    						main.map_game.put(name, new Game(name, red, blue, green, purple, noteam, 2, true));
	    					
	    					 Bukkit.getScheduler().runTask(main.plugin, new Runnable(){
	    				         @Override
	    				         public void run() {
	    					for(String s : red){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc2Red());
	    					}
	    					}
	    					for(String s : blue){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc2Blue());
	    					}
	    					}
	    					for(String s : green){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc2Green());
	    					}
	    					}
	    					for(String s : purple){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc2Purple());
	    					}
	    					}
	    				         }});
					}
	    			}
	    			else{
						Thread.currentThread().interrupt();
	    			}
	    			}
	    		}
	    		//2 poziom
	    		for(int i = main.map_arena.get(name).getTime2() ; i > 0 ; i--){
	    			if(Thread.currentThread().isInterrupted() == false){
	    			if(main.map_game.get(name) != null){
	    				scoreboard.reloadTime(name, i);

					final List<String> red = main.map_game.get(name).getTeamRed();
					final List<String> blue = main.map_game.get(name).getTeamBlue();
					final List<String> green = main.map_game.get(name).getTeamGreen();
					final List<String> purple = main.map_game.get(name).getTeamPurple();
					List<String> noteam = main.map_game.get(name).getNoTeam();
					
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
				    
				    
	    			Thread.sleep(1000);

				    
	    						
					if(i == 60){
						for(String s : all){
							if(Bukkit.getPlayer(s) != null){

							Bukkit.getPlayer(s).sendMessage(main.pref + " Nastepny poziom za " + ChatColor.GOLD + " 60 " + ChatColor.GRAY + " sekund");
						}
						}
					}
					else if(i == 10){
						for(String s : all){
							if(Bukkit.getPlayer(s) != null){

							Bukkit.getPlayer(s).sendMessage(main.pref + " Nastepny poziom za " + ChatColor.GOLD + " 10 " + ChatColor.GRAY + " sekund");
						}
						}
					}
	    			
									
					if(i == 1){
	    					for(String s : all){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).sendMessage(main.pref + " Zostales przeniesiony na nastepny poziom!");
	    						
	    						
	    						if(main.config.getBoolean("czasowe") == true){
	    							BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom3"), main.config.getInt("timeshow")/1000);
	    						}
	    						else{
	    							BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom3"));
	    						}
	    						}
	    					}
	    					
	 						main.map_game.remove(name);
    						main.map_game.put(name, new Game(name, red, blue, green, purple, noteam, 3, true));
	    					
	    					 Bukkit.getScheduler().runTask(main.plugin, new Runnable(){
	    				         @Override
	    				         public void run() {
	    					for(String s : red){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc3Red());
	    					}
	    					}
	    					for(String s : blue){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc3Blue());
	    					}
	    					}
	    					for(String s : green){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc3Green());
	    					}
	    					}
	    					for(String s : purple){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc3Purple());
	    					}
	    					}
	    				         }});
					}
	    			}
	    			else{
						Thread.currentThread().interrupt();
	    			}
	    			}
	    		}
	    		//3 poziom
	    		for(int i = main.map_arena.get(name).getTime3() ; i > 0 ; i--){
	    			if(Thread.currentThread().isInterrupted() == false){
	    			if(main.map_game.get(name) != null){
	    				scoreboard.reloadTime(name, i);

					final List<String> red = main.map_game.get(name).getTeamRed();
					final List<String> blue = main.map_game.get(name).getTeamBlue();
					final List<String> green = main.map_game.get(name).getTeamGreen();
					final List<String> purple = main.map_game.get(name).getTeamPurple();
					List<String> noteam = main.map_game.get(name).getNoTeam();
					
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
				    
				    
	    			Thread.sleep(1000);

				    	    						
					if(i == 60){
						for(String s : all){
							if(Bukkit.getPlayer(s) != null){

							Bukkit.getPlayer(s).sendMessage(main.pref + " Nastepny poziom za " + ChatColor.GOLD + " 60 " + ChatColor.GRAY + " sekund");
						}
						}
					}
					else if(i == 10){
						for(String s : all){
							if(Bukkit.getPlayer(s) != null){

							Bukkit.getPlayer(s).sendMessage(main.pref + " Nastepny poziom za " + ChatColor.GOLD + " 10 " + ChatColor.GRAY + " sekund");
						}
						}
					}
	    			
									
					if(i == 1){
	    					for(String s : all){
	    						if(Bukkit.getPlayer(s) != null){

	    						if(main.config.getBoolean("czasowe") == true){
	    							BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom4"), main.config.getInt("timeshow")/1000);
	    						}
	    						else{
	    							BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom4"));
	    						}
	    						
	    						Bukkit.getPlayer(s).sendMessage(main.pref + " Zostales przeniesiony na nastepny poziom !");
	    						
	    						}
	    					}
    						main.map_game.remove(name);
    						main.map_game.put(name, new Game(name, red, blue, green, purple, noteam, 4, true));
	    					 Bukkit.getScheduler().runTask(main.plugin, new Runnable(){
	    				         @Override
	    				         public void run() {
	    					for(String s : red){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc4Red());
	    					}
	    					}
	    					for(String s : blue){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc4Blue());
	    					}
	    					}
	    					for(String s : green){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc4Green());
	    					}
	    					}
	    					for(String s : purple){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc4Purple());
	    						}
	    					}
	    				         }});
					}
	    			}
	    			else{
						Thread.currentThread().interrupt();
	    			}
	    			}
	    		}
	    		
	//5 poziom
	    		
	    		
	    		for(int i = main.map_arena.get(name).getTime4() ; i > 0 ; i--){
	    			if(Thread.currentThread().isInterrupted() == false){
	    			if(main.map_game.get(name) != null){
	    				scoreboard.reloadTime(name, i);

					final List<String> red = main.map_game.get(name).getTeamRed();
					final List<String> blue = main.map_game.get(name).getTeamBlue();
					final List<String> green = main.map_game.get(name).getTeamGreen();
					final List<String> purple = main.map_game.get(name).getTeamPurple();
					List<String> noteam = main.map_game.get(name).getNoTeam();
					
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
				    
				    
	    			Thread.sleep(1000);

				    
	    						
					if(i == 60){
						for(String s : all){
    						if(Bukkit.getPlayer(s) != null){

							Bukkit.getPlayer(s).sendMessage(main.pref + " Ostatni poziom za " + ChatColor.GOLD + " 60 " + ChatColor.GRAY + " sekund");
						}
						}
					}
					else if(i == 10){
						for(String s : all){
    						if(Bukkit.getPlayer(s) != null){

							Bukkit.getPlayer(s).sendMessage(main.pref + " Ostatni poziom za " + ChatColor.GOLD + " 10 " + ChatColor.GRAY + " sekund");
						}
						}
					}
	    			
									
					if(i == 1){
	    					for(String s : all){
	    						if(Bukkit.getPlayer(s) != null){

	    						if(main.config.getBoolean("czasowe") == true){
	    							BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom5"), main.config.getInt("timeshow")/1000);
	    						}
	    						else{
	    							BarAPI.setMessage(Bukkit.getPlayer(s), main.config.getString("poziom5"));
	    						}
	    						
	    						Bukkit.getPlayer(s).sendMessage(main.pref + " Zostales przeniesiony na poziom walki !");
	    						}}
	    						main.map_game.remove(name);
	    						main.map_game.put(name, new Game(name, red, blue, green, purple, noteam, 5, true));
	    						
	    					
	    					 Bukkit.getScheduler().runTask(main.plugin, new Runnable(){
	    				         @Override
	    				         public void run() {
	    					for(String s : red){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc5Red());
	    					}
	    					}
	    					for(String s : blue){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc5Blue());
	    						}
	    					}
	    					for(String s : green){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc5Green());
	    						}
	    					}
	    					for(String s : purple){
	    						if(Bukkit.getPlayer(s) != null){

	    						Bukkit.getPlayer(s).teleport(main.map_arena.get(name).getLoc5Purple());
	    						}
	    					}
	    				         }});
					}
	    			}
	    			else{
						Thread.currentThread().interrupt();
	    			}
	    			}
	    		}
	    		
	    		//walka
	    		
	    		for(int i = main.map_arena.get(name).getTime5() ; i > 0 ; i--){
	    			if(Thread.currentThread().isInterrupted() == false){
	    			if(main.map_game.get(name) != null){
	    				scoreboard.reloadTime(name, i);

					List<String> red = main.map_game.get(name).getTeamRed();
					List<String> blue = main.map_game.get(name).getTeamBlue();
					List<String> green = main.map_game.get(name).getTeamGreen();
					List<String> purple = main.map_game.get(name).getTeamPurple();
					
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
				    
				    
	    			Thread.sleep(1000);

				    	    						
					if(i == 60){
						for(String s : all){
    						if(Bukkit.getPlayer(s) != null){

							Bukkit.getPlayer(s).sendMessage(main.pref + " Pozostaly czas : " + ChatColor.GOLD + " 60 " + ChatColor.GRAY + " sekund");
						}
						}
					}
					else if(i == 10){
						for(String s : all){
    						if(Bukkit.getPlayer(s) != null){

							Bukkit.getPlayer(s).sendMessage(main.pref + " Pozostaly czas : " + ChatColor.GOLD + " 10 " + ChatColor.GRAY + " sekund");
						}
						}
					}
	    			
									
					if(i == 1){
	    					for(final String s : all){																							//end game
	    						BarAPI.removeBar(Bukkit.getPlayer(s));
	    						
	    						final Player p = Bukkit.getPlayer(s);
	    						scoreboard.removePlayerFromArena(p, name);
	    						scoreboard.removeGame(name);
	    						 Bukkit.getScheduler().runTask(main.plugin, new Runnable(){
	                                 @Override
	                                 public void run() {
	    						scoreboard.removeSB(p);
	                                 }});
	    						
	    						/*int rounds = main.map_game.get(name).getRound();
	    						if(green.contains(s)){
	    						green.remove(s);
	    						}
	    						else if(red.contains(s)){
	    							red.remove(s);
	    						}
	    						else if(blue.contains(s)){
	    							blue.remove(s);
	    						}
	    						else if(purple.contains(s)){
	    							purple.remove(s);
	    						}
	    						
	    						main.map_game.remove(name);
	    						main.map_game.put(name, new Game(name, red, blue, green, purple, noteam, rounds, false));*/
	    						
	    						final World w = Bukkit.getWorld(main.config.getString("spawn.world"));
	    						final int x = main.config.getInt("spawn.x");
	    						final int y = main.config.getInt("spawn.y");
	    						final int z = main.config.getInt("spawn.z");
	    						
	    						 Bukkit.getScheduler().runTask(main.plugin, new Runnable(){
	                                 @Override
	                                 public void run() {
	                                	 
	                                	 
	             						Player p = Bukkit.getPlayer(s);

	                                	 
	             						Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));

	             						clear.clearPlayer(p);
	                                 }});    						
	    						Bukkit.getPlayer(s).sendMessage(main.pref + " Walka zostala zakonczona");
	    						    						
	    						
	    						//Coins.addCoins(s, 25);
	    						Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "25 " + ChatColor.GRAY + "coins!");

	    						
	    					}
	    					
							main.map_game.remove(name);
						
							Location loc = main.map_join.get(name);
							
							Sign sign = (Sign)Bukkit.getServer().getWorld(loc.getWorld().getName()).getBlockAt(loc).getState();
							
							sign.setLine(3, ChatColor.DARK_RED + " |RESTART| " );
							sign.update();
							
							Thread.sleep(6000);
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv load " + name); 

							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restartworld " + name); 
							load.reloadArena(name);

							Thread.sleep(2000);
		    			  	sign.setLine(3, ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "|DOLACZ|");
		    			  	sign.setLine(2, ChatColor.BOLD + "" + ChatColor.RED + "0" + ChatColor.RESET + "/" + ChatColor.BOLD + "" + ChatColor.RED + Integer.parseInt(main.config.getString("ilosc")));
		    			  	sign.update();
							
					}	
	    		}
	    			else{
						Thread.currentThread().interrupt();
	    			}
	    			}
	    		}
	    		
	    		
	    		
	    	} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }});
	t.start();
	}
	
}
