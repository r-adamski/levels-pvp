package me.panda.commands;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import me.confuser.barapi.BarAPI;
import me.panda.levelspvp.main;
import me.panda.methods.clear;
import me.panda.methods.give;
import me.panda.methods.load;
import me.panda.methods.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class create implements CommandExecutor {
	
	//komendy do tworzenia aren
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			//stop
			
			if(args.length == 2 && args[0].equalsIgnoreCase("stop")){
				if(sender.hasPermission("lpvp.admin")){

					final String name = args[1];
					
					 World w = Bukkit.getWorld(main.config.getString("spawn.world"));
					 int x = Integer.parseInt(main.config.getString("spawn.x"));
					 int y = Integer.parseInt(main.config.getString("spawn.y"));
					 int z = Integer.parseInt(main.config.getString("spawn.z"));
					
					if(main.map_game.containsKey(name)){	
					 
							 scoreboard.removeGame(name);
							List<String> red = main.map_game.get(name).getTeamRed();
							List<String> blue = main.map_game.get(name).getTeamBlue();
							List<String> green = main.map_game.get(name).getTeamGreen();
							List<String> purple = main.map_game.get(name).getTeamPurple();
							List<String> noteam = main.map_game.get(name).getNoTeam();
							
							for(String s : red){
								Bukkit.getPlayer(s).sendMessage(main.pref + " Gra zostala zatrzymana przez admina = " + ChatColor.DARK_AQUA + sender.getName());
								main.lobby.remove(s);

								BarAPI.removeBar(Bukkit.getPlayer(s));

								Player p = Bukkit.getPlayer(s);
								
								scoreboard.removePlayerFromArena(p, name);
								scoreboard.removeGame(name);
								scoreboard.removeSB(p);
								give.giveItems(p);
								clear.clearPlayer(p);
					    		
								Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
								//Coins.addCoins(s, 20);
								Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "20 " + ChatColor.GRAY + "coins!");

								
							}
							for(String s : blue){
								Bukkit.getPlayer(s).sendMessage(main.pref + " Gra zostala zatrzymana przez admina = " + ChatColor.DARK_AQUA + sender.getName());
								main.lobby.remove(s);

								BarAPI.removeBar(Bukkit.getPlayer(s));

								Player p = Bukkit.getPlayer(s);
								scoreboard.removePlayerFromArena(p, name);
								scoreboard.removeGame(name);
								scoreboard.removeSB(p);
								clear.clearPlayer(p);
								give.giveItems(p);

								Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));

								//Coins.addCoins(s, 20);
								Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "20 " + ChatColor.GRAY + "coins!");

								
							}
							for(String s : green){
								Bukkit.getPlayer(s).sendMessage(main.pref + " Gra zostala zatrzymana przez admina = " + ChatColor.DARK_AQUA + sender.getName());
								main.lobby.remove(s);

								BarAPI.removeBar(Bukkit.getPlayer(s));

								Player p = Bukkit.getPlayer(s);
								scoreboard.removePlayerFromArena(p, name);
								scoreboard.removeGame(name);
								scoreboard.removeSB(p);
								clear.clearPlayer(p);
								give.giveItems(p);

								Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
								//Coins.addCoins(s, 20);
								Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "20 " + ChatColor.GRAY + "coins!");

								
							}
							for(String s : purple){
								Bukkit.getPlayer(s).sendMessage(main.pref + " Gra zostala zatrzymana przez admina = " + ChatColor.DARK_AQUA + sender.getName());
								main.lobby.remove(s);

								BarAPI.removeBar(Bukkit.getPlayer(s));

								Player p = Bukkit.getPlayer(s);
								scoreboard.removePlayerFromArena(p, name);
								scoreboard.removeGame(name);
								scoreboard.removeSB(p);
								clear.clearPlayer(p);
								give.giveItems(p);

								Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
								//Coins.addCoins(s, 20);
								Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "20 " + ChatColor.GRAY + "coins!");

								
							}
							for(String s : noteam){
								Bukkit.getPlayer(s).sendMessage(main.pref + " Gra zostala zatrzymana przez admina = " + ChatColor.DARK_AQUA + sender.getName());
								main.lobby.remove(s);
								BarAPI.removeBar(Bukkit.getPlayer(s));

								Player p = Bukkit.getPlayer(s);
								scoreboard.removePlayerFromArena(p, name);
								scoreboard.removeGame(name);
								scoreboard.removeSB(p);
								clear.clearPlayer(p);
					    		
								Bukkit.getPlayer(s).teleport(new Location(w, x, y, z));
								//Coins.addCoins(s, 20);
								Bukkit.getPlayer(s).sendMessage(main.pref + " + " + ChatColor.GOLD + "20 " + ChatColor.GRAY + "coins!");

								
							}
							
							main.map_game.remove(name);
							
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
							

					
				sender.sendMessage(main.pref + " Arena poprawnie zatrzymana!");
				
				
					}
					else{
						sender.sendMessage(main.pref + " Gra na tej arenie nie istnieje.");
					}
				}
				else{
					sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien.");
				}
			}
			
			
			//reload
			
			if (cmd.getName().equalsIgnoreCase("lpvp")){
				
				
				if(args.length == 1 && args[0].equalsIgnoreCase("reload")){
					if(sender.hasPermission("smav.admin") || sender.isOp()){
					load.loadArena();
					load.loadJoinSigns();
					sender.sendMessage(main.pref + " Plugin poprawnie zaladowany");
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//tworzenie areny
				
				if(args.length == 2 && args[0].equalsIgnoreCase("create")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.name == null){
					int cancreate = 0;
					String name = args[1];
					//sprawdzanie czy arena o nazwie juz istnieje
					String select = "SELECT * FROM LevelsPvPArena WHERE name = '" + name + "'";
					ResultSet rs = main.mysql.query(select);
					try {
						if(rs.next()){
							sender.sendMessage(main.pref + " Arena o tej nazwie juz istnieje");
						}
						else{
							cancreate = 1;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					//nastepny etap
					if(cancreate == 1){
					main.name = args[1];
					main.nickC = sender.getName();
					sender.sendMessage(main.pref + " Rozpoczales tworzenie areny, wpisz /lpvp setspawn <radius> aby ustawic miejsce spawnu.");
					}
					
						}
						else{
							sender.sendMessage(main.pref + " Arena jest juz tworzona, nie mozna tworzyc 2 aren w tym samym czasie. Jesli to blad wpisz /lpvp stopcreate i sprobuj ponownie");
						}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp setspawn
				if(sender instanceof Player){
				if(args.length == 2 && args[0].equalsIgnoreCase("setspawn")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){
						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						int radius = Integer.parseInt(args[1]);
						
						main.map_int.put("spawnX", radius);
						main.map_string.put("spawnLoc", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu");
						sender.sendMessage(main.pref + " Ustaw teraz czas i radius dotyczacy 1 poziomu, wpisujac /lpvp level1 <czas w sekundach> <radius wyspy>");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp level1
				
				if(args.length == 3 && args[0].equalsIgnoreCase("level1")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						int time = Integer.parseInt(args[1]);
						int radius = Integer.parseInt(args[2]);
						
						main.map_int.put("time1", time);
						main.map_int.put("X", radius);
						
						sender.sendMessage(main.pref + " Ustawiono czas trwania 1 poziomu i radius wysp");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp redspawn1 aby ustawic miejsce spawnu druzyny czerwonej");
												
						/*String insert = "INSERT INTO Arena (`name`, `minX`, `maxX`, `minZ`, `maxZ`, `spawnX`, `spawnZ`, `spawnY`, `EndGameHigh`) VALUES ('" + main.name + "', '" + main.map_create.get("minX") + "', '" + main.map_create.get("maxX") + "', '" + main.map_create.get("minZ") + "', '" + main.map_create.get("maxZ") + "', '" + main.map_create.get("spawnX") + "', '" + main.map_create.get("spawnZ") + "', '" + main.map_create.get("spawnY") + "', '" + main.map_create.get("endY") + "')";
						main.mysql.query(insert);*/
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp redspawn1
				
				if(args.length == 1 && args[0].equalsIgnoreCase("redspawn1")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc1Red", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny czerwonej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp bluespawn1 aby ustawic miejsce spawnu druzyny niebieskiej");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp bluespawn
				
				if(args.length == 1 && args[0].equalsIgnoreCase("bluespawn1")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc1Blue", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny niebieskiej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp greenspawn1 aby ustawic miejsce spawnu druzyny niebieskiej");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp greenspawn
				
				if(args.length == 1 && args[0].equalsIgnoreCase("greenspawn1")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc1Green", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny zielonej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp purplespawn1 aby ustawic miejsce spawnu druzyny niebieskiej");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp purplespawn1
				
				if(args.length == 1 && args[0].equalsIgnoreCase("purplespawn1")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc1Purple", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny fioletowej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp redspawn2 <czas_2_rundy> aby ustawic miejsce spawnu druzyny czerwonej na 2 wyspie oraz czas");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp redspawn2 <time>
				
				if(args.length == 2 && args[0].equalsIgnoreCase("redspawn2")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc2Red", msg);
						
						int time = Integer.parseInt(args[1]);
						
						main.map_int.put("time2", time);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny czerwonej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp bluespawn2 aby ustawic miejsce spawnu druzyny niebieskiej na 2 poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp bluespawn2
				
				if(args.length == 1 && args[0].equalsIgnoreCase("bluespawn2")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc2Blue", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny niebieskiej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp greenspawn2 aby ustawic miejsce spawnu druzyny zielonej na 2 poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp greenspawn2
				
				if(args.length == 1 && args[0].equalsIgnoreCase("greenspawn2")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc2Green", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny zielonej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp purplespawn2 aby ustawic miejsce spawnu druzyny fioletowej na 2 poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp purplespawn2
				
				if(args.length == 1 && args[0].equalsIgnoreCase("purplespawn2")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc2Purple", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny fioletowej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp redspawn3 <czas_3_rundy> aby ustawic miejsce spawnu druzyny czerwonej na 3 poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp redspawn3
				
				if(args.length == 2 && args[0].equalsIgnoreCase("redspawn3")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc3Red", msg);
						
						int time = Integer.parseInt(args[1]);
						
						main.map_int.put("time3", time);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny czerwonej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp bluespawn3 aby ustawic miejsce spawnu druzyny niebieskiej na 3 poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp bluespawn3
				
				if(args.length == 1 && args[0].equalsIgnoreCase("bluespawn3")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc3Blue", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny niebieskiej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp greenspawn3 aby ustawic miejsce spawnu druzyny zielonej na 3 poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp greenspawn3
				
				if(args.length == 1 && args[0].equalsIgnoreCase("greenspawn3")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc3Green", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny zielonej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp purplespawn3 aby ustawic miejsce spawnu druzyny fioletowej na 3 poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp purplespawn3
				
				if(args.length == 1 && args[0].equalsIgnoreCase("purplespawn3")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc3Purple", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny fioletowej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp redspawn4 <czas_4_rundy> aby ustawic miejsce spawnu druzyny czerwonej na 4 poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp redspawn4 <time>
				
				if(args.length == 2 && args[0].equalsIgnoreCase("redspawn4")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc4Red", msg);
						
						int time = Integer.parseInt(args[1]);
						
						main.map_int.put("time4", time);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny czerwonej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp bluespawn4 aby ustawic miejsce spawnu druzyny niebieskiej na 4 poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp bluespawn4
				
				if(args.length == 1 && args[0].equalsIgnoreCase("bluespawn4")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc4Blue", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny niebieskiej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp greenspawn4 aby ustawic miejsce spawnu druzyny zielonej na 4 poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp greenspawn4
				
				if(args.length == 1 && args[0].equalsIgnoreCase("greenspawn4")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc4Green", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny zielonej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp purplespawn4 aby ustawic miejsce spawnu druzyny fioletowej na 4 poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp purplespawn4
				
				if(args.length == 1 && args[0].equalsIgnoreCase("purplespawn4")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc4Purple", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny fioletowej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp redspawn5 <czas_ostatniej_rundy> <radius> aby ustawic miejsce spawnu druzyny czerwonej na ostatnim poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp redspawn5 <time> <radius>
				
				if(args.length == 3 && args[0].equalsIgnoreCase("redspawn5")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc5Red", msg);
						
						int time = Integer.parseInt(args[1]);
						int radius = Integer.parseInt(args[2]);
						
						main.map_int.put("time5", time);
						main.map_int.put("X5", radius);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny czerwonej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp bluespawn5 aby ustawic miejsce spawnu druzyny niebieskiej na ostatnim poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp bluespawn5
				
				if(args.length == 1 && args[0].equalsIgnoreCase("bluespawn5")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc5Blue", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny niebieskiej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp greenspawn5 aby ustawic miejsce spawnu druzyny zielonej na ostatnim poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp greenspawn4
				
				if(args.length == 1 && args[0].equalsIgnoreCase("greenspawn5")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc5Green", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny zielonej");
						sender.sendMessage(main.pref + " Wpisz teraz /lpvp purplespawn5 aby ustawic miejsce spawnu druzyny fioletowej na ostatnim poziomie");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				
				//lpvp purplespawn4
				
				if(args.length == 1 && args[0].equalsIgnoreCase("purplespawn5")){
					if(sender.hasPermission("lpvp.admin")){
						if(main.nickC.equalsIgnoreCase(sender.getName())){

						Location loc = ((Player) sender).getLocation();
						String world = loc.getWorld().getName();
						int x = (int) loc.getX();
						int z = (int) loc.getZ();
						int y = (int) loc.getY();
						
						StringBuilder sb = new StringBuilder();
						  sb.append(world).append(":");
						  sb.append(x).append(":");
						  sb.append(z).append(":");
						  sb.append(y).append(":");

						String msg = sb.toString();
						
						main.map_string.put("loc5Purple", msg);
						
						sender.sendMessage(main.pref + " Ustawiono miejsce spawnu druzyny fioletowej");
						
						//dodawanie do mysql
						
					     String name = main.name;
					     String spawnLoc = main.map_string.get("spawnLoc");
					     int spawnX = main.map_int.get("spawnX");
					     String loc1Red = main.map_string.get("loc1Red");
					     String loc1Blue = main.map_string.get("loc1Blue");
					     String loc1Green = main.map_string.get("loc1Green");
					     String loc1Purple = main.map_string.get("loc1Purple");
					     int time1 = main.map_int.get("time1");
					     int X1 = main.map_int.get("X");
					     String loc2Red = main.map_string.get("loc2Red");
					     String loc2Blue = main.map_string.get("loc2Blue");
					     String loc2Green = main.map_string.get("loc2Green");
						 String loc2Purple = main.map_string.get("loc2Purple");
						 int time2 = main.map_int.get("time2");
						 String loc3Red = main.map_string.get("loc3Red");
						 String loc3Blue = main.map_string.get("loc3Blue");
						 String loc3Green = main.map_string.get("loc3Green");
						 String loc3Purple = main.map_string.get("loc3Purple");
						 int time3 = main.map_int.get("time3");
						 String loc4Red = main.map_string.get("loc4Red");
						 String loc4Blue = main.map_string.get("loc4Blue");
						 String loc4Green = main.map_string.get("loc4Green");
						 String loc4Purple = main.map_string.get("loc4Purple");
						 int time4 = main.map_int.get("time4");
						 String loc5Red = main.map_string.get("loc5Red");
						 String loc5Blue = main.map_string.get("loc5Blue");
						 String loc5Green = main.map_string.get("loc5Green");
						 String loc5Purple = main.map_string.get("loc5Purple");
						 int time5 = main.map_int.get("time5");
						 int X5 = main.map_int.get("X5");
						 
						String insert = "INSERT INTO LevelsPvPArena (`name`, `spawnLoc`, `spawnX`, `loc1Red`, `loc1Blue`, `loc1Green`, `loc1Purple`, " +
								"`time1`, `X1`, `loc2Red`, `loc2Blue`, `loc2Green`, `loc2Purple`, `time2`, `loc3Red`, `loc3Blue`, `loc3Green`, `loc3Purple`, `time3`, " +
								"`loc4Red`, `loc4Blue`, `loc4Green`, `loc4Purple`, `time4`, `X5`, `time5`, `loc5Red`, `loc5Blue`, `loc5Green`, `loc5Purple`) VALUES" +
								" ('" + name + "', '" + spawnLoc +"', '" + spawnX + "', '" + loc1Red + "', '" + loc1Blue +"', '" + loc1Green + "', '" + loc1Purple + "', '" + time1 +"', '" + X1 + "'" +
										", '" + loc2Red + "', '" + loc2Blue +"', '" + loc2Green + "', '" + loc2Purple + "', '" + time2 +"', '" + loc3Red + "', '" + loc3Blue + "', '" + loc3Green +"', '" + loc3Purple + "'" +
									", '" + time3 + "', '" + loc4Red +"', '" + loc4Blue + "', '" + loc4Green + "', '" + loc4Purple +"', '" + time4 + "', '" + X5 + "', '" + time5 +"', '" + loc5Red + "', '" + loc5Blue + "', '" + loc5Green +"', '" + loc5Purple + "')";
	    				main.mysql.query(insert);
						
	    				main.name = null;
	    				main.map_int.clear();
	    				main.map_string.clear();
	    				main.nickC = null;
	    				
						sender.sendMessage(main.pref + " Tworzenie areny zakonczone !");
					}
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
				if(args.length == 1 && args[0].equalsIgnoreCase("stopcreate")){
					if(sender.hasPermission("lpvp.admin")){
						main.name = null;
						main.nickC = null;
						main.map_int.clear();
						main.map_string.clear();
						sender.sendMessage(main.pref + " Wszystkie dane tworzenia areny usuniete z pamieci");
					}
					else{
						sender.sendMessage(main.pref + " Nie posiadasz do tego uprawnien");
					}
				}
			}
		}
		return false;
	}
}
