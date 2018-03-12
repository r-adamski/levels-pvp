package me.panda.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import me.panda.levelspvp.main;
import me.panda.methods.IsIn;
import me.panda.methods.scoreboard;
import me.panda.objects.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class move implements Listener{

	final ArrayList<String> cooldown = new ArrayList<String>();  //kuldown zeby nie spamilo

	@EventHandler
	public void onMove(PlayerMoveEvent e){
				
		Player p = e.getPlayer();
		final String nick = p.getName();
		
		if(IsIn.IsInGame(p) == true){
			
			if(IsIn.IsInLobby(p) || IsIn.IsIn1Blue(p) || IsIn.IsIn1Green(p) || IsIn.IsIn1Purple(p) || IsIn.IsIn1Red(p) ||
					IsIn.IsIn2Blue(p) || IsIn.IsIn2Green(p) || IsIn.IsIn2Purple(p) || IsIn.IsIn2Red(p) || 
					IsIn.IsIn3Blue(p) || IsIn.IsIn3Green(p) || IsIn.IsIn3Purple(p) || IsIn.IsIn3Red(p) || 
					IsIn.IsIn4Blue(p) || IsIn.IsIn4Green(p) || IsIn.IsIn4Purple(p) || IsIn.IsIn4Red(p)){
				if(p.getFoodLevel() != 20){
					p.setFoodLevel(20);
				}
				if(p.getLocation().getBlock().getType() == Material.CARPET){
					@SuppressWarnings("deprecation")
					int data = p.getLocation().getBlock().getState().getData().getData();
					for(Entry<String, Game> e1 : main.map_game.entrySet()){
						String i = e1.getKey();
						List<String> red = main.map_game.get(i).getTeamRed();
						List<String> blue = main.map_game.get(i).getTeamBlue();
						List<String> green = main.map_game.get(i).getTeamGreen();
						List<String> purple = main.map_game.get(i).getTeamPurple();
						List<String> noteam = main.map_game.get(i).getNoTeam();
					
						if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){

							String name = main.map_game.get(i).getName();
							int round = main.map_game.get(i).getRound();
							boolean countdown = main.map_game.get(i).getcountdown();
							
							
					
					if(data == 14){
						//red
						if(red.size() < Integer.parseInt(main.config.getString("ilosc"))/4){

						if(blue.contains(nick)){
							if(!(cooldown.contains(nick))){
								blue.remove(nick);
								red.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);

								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamRed(p);
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.RED + " czerwonej");
							
							}
						}
						else if(green.contains(nick)){
							if(!(cooldown.contains(nick))){
								green.remove(nick);
								red.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamRed(p);
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.RED + " czerwonej");
							}
						}
						else if(purple.contains(nick)){
							if(!(cooldown.contains(nick))){
								purple.remove(nick);
								red.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamRed(p);	
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.RED + " czerwonej");
							}
						}
						else if(noteam.contains(nick)){
							if(!(cooldown.contains(nick))){
								noteam.remove(nick);
								red.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamRed(p);
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.RED + " czerwonej");
							}
						}
					}
						else{
							if(!(cooldown.contains(nick))){
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);

								if(!(red.contains(nick))){
								p.sendMessage(main.pref + " Druzyna " + ChatColor.RED + "czerwona " + ChatColor.GRAY + "jest pelna");
								}
								
							}
						}
						
						
					}
					else if(data == 11){
						//blu
						
						if(blue.size() < Integer.parseInt(main.config.getString("ilosc"))/4){

						if(red.contains(nick)){
							if(!(cooldown.contains(nick))){
								red.remove(nick);
								blue.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamBlue(p);
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.BLUE + " niebieskiej");
							
							}
						}
						else if(green.contains(nick)){
							if(!(cooldown.contains(nick))){
								green.remove(nick);
								blue.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamBlue(p);
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.BLUE + " niebieskiej");
							}
						}
						else if(purple.contains(nick)){
							if(!(cooldown.contains(nick))){
								purple.remove(nick);
								blue.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamBlue(p);	
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.BLUE + " niebieskiej");
							}
						}
						else if(noteam.contains(nick)){
							if(!(cooldown.contains(nick))){
								noteam.remove(nick);
								blue.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamBlue(p);	
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.BLUE + " niebieskiej");
							}
						}
					}
						else{
							if(!(cooldown.contains(nick))){
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								if(!(blue.contains(nick))){
								p.sendMessage(main.pref + " Druzyna " + ChatColor.BLUE + "niebieska " + ChatColor.GRAY + "jest pelna");
								}
							}
						}
						
						
					}
					else if(data == 5){
						//grin
						
						if(green.size() < Integer.parseInt(main.config.getString("ilosc"))/4){

						if(red.contains(nick)){
							if(!(cooldown.contains(nick))){
								red.remove(nick);
								green.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamGreen(p);	
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.GREEN + " zielonej");
							
							}
						}
						if(blue.contains(nick)){
							if(!(cooldown.contains(nick))){
								blue.remove(nick);
								green.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamGreen(p);	
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.GREEN + " zielonej");
							}
						}
						if(purple.contains(nick)){
							if(!(cooldown.contains(nick))){
								purple.remove(nick);
								green.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamGreen(p);	
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.GREEN + " zielonej");
							}
						}
						if(noteam.contains(nick)){
							if(!(cooldown.contains(nick))){
								noteam.remove(nick);
								green.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamGreen(p);	
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.GREEN + " zielonej");
							}
						}
					}
						else{
							if(!(cooldown.contains(nick))){
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								if(!(green.contains(nick))){
								p.sendMessage(main.pref + " Druzyna " + ChatColor.GREEN + "zielona " + ChatColor.GRAY + "jest pelna");
								}
							}
						}
						
					}
					else if(data == 10){
						//purpel
						
						if(purple.size() < Integer.parseInt(main.config.getString("ilosc"))/4){

						if(red.contains(nick)){
							if(!(cooldown.contains(nick))){
								red.remove(nick);
								purple.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamPurple(p);
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.DARK_PURPLE + " fioletowej");
							
							}
						}
						else if(blue.contains(nick)){
							if(!(cooldown.contains(nick))){
								blue.remove(nick);
								purple.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamPurple(p);
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.DARK_PURPLE + " fioletowej");
							}
						}
						else if(green.contains(nick)){
							if(!(cooldown.contains(nick))){
								green.remove(nick);
								purple.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamPurple(p);
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.DARK_PURPLE + " fioletowej");
							}
						}
						else if(noteam.contains(nick)){
							if(!(cooldown.contains(nick))){
								noteam.remove(nick);
								purple.add(nick);
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								
								//tu updejt mapki
								
								e1.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));

								scoreboard.addPlayerToTeamPurple(p);
								scoreboard.reloadTeamSb();
								scoreboard.reloadTeamSize(name);
								p.sendMessage(main.pref + " Dolaczyles do druzyny " + ChatColor.DARK_PURPLE + " fioletowej");
							}
						}
					}
						else{
							if(!(cooldown.contains(nick))){
								cooldown.add(nick);
								
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
									@Override
									public void run() {
					        			cooldown.remove(nick);
									}
									}, 40);
								if(!(purple.contains(nick))){
								p.sendMessage(main.pref + " Druzyna " + ChatColor.DARK_PURPLE + "fioletowa " + ChatColor.GRAY + "jest pelna");
								}
							}
						}						
						
					}																								//tu pozmieniac zeby update byl tylko wtedy gdy dolacza bo tak to moze lagowac

					
						}
					
					}
				}
			}
			
			//odtad sie zaczyna blokowanie uciekania z aren
			for(Entry<String, Game> entry : main.map_game.entrySet()){
								
				List<String> red = entry.getValue().getTeamRed();
				List<String> blue = entry.getValue().getTeamBlue();
				List<String> green = entry.getValue().getTeamGreen();
				List<String> purple = entry.getValue().getTeamPurple();
				List<String> noteam = entry.getValue().getNoTeam();
				
				if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){
					int round = entry.getValue().getRound();
					String name = entry.getValue().getName();
					if(round == 0 && IsIn.IsInLobby(p) == false){
						p.teleport(main.map_arena.get(name).getSpawnLoc());
					}
						if(round == 1){
							if(red.contains(nick)){
								if(IsIn.IsIn1Red(p) == false){
									p.teleport(main.map_arena.get(name).getLoc1Red());
								}
							}
							else if(blue.contains(nick)){
								if(IsIn.IsIn1Blue(p) == false){
									p.teleport(main.map_arena.get(name).getLoc1Blue());
								}
							}
							else if(green.contains(nick)){
								if(IsIn.IsIn1Green(p) == false){
									p.teleport(main.map_arena.get(name).getLoc1Green());
								}
							}
							else if(purple.contains(nick)){
								if(IsIn.IsIn1Purple(p) == false){
									p.teleport(main.map_arena.get(name).getLoc1Purple());
								}
							}
					}
						
						else if(round == 2){
							if(red.contains(nick)){
								if(IsIn.IsIn2Red(p) == false){
									p.teleport(main.map_arena.get(name).getLoc2Red());
								}
							}
							else if(blue.contains(nick)){
								if(IsIn.IsIn2Blue(p) == false){
									p.teleport(main.map_arena.get(name).getLoc2Blue());
								}
							}
							else if(green.contains(nick)){
								if(IsIn.IsIn2Green(p) == false){
									p.teleport(main.map_arena.get(name).getLoc2Green());
								}
							}
							else if(purple.contains(nick)){
								if(IsIn.IsIn2Purple(p) == false){
									p.teleport(main.map_arena.get(name).getLoc2Purple());
								}
							}
						}
							
							else if(round == 3){
								if(red.contains(nick)){
									if(IsIn.IsIn3Red(p) == false){
										p.teleport(main.map_arena.get(name).getLoc3Red());
									}
								}
								else if(blue.contains(nick)){
									if(IsIn.IsIn3Blue(p) == false){
										p.teleport(main.map_arena.get(name).getLoc3Blue());
									}
								}
								else if(green.contains(nick)){
									if(IsIn.IsIn3Green(p) == false){
										p.teleport(main.map_arena.get(name).getLoc3Green());
									}
								}
								else if(purple.contains(nick)){
									if(IsIn.IsIn3Purple(p) == false){
										p.teleport(main.map_arena.get(name).getLoc3Purple());
									}
								}
						}
							
							else if(round == 4){
								if(red.contains(nick)){
									if(IsIn.IsIn4Red(p) == false){
										p.teleport(main.map_arena.get(name).getLoc4Red());
									}
								}
								else if(blue.contains(nick)){
									if(IsIn.IsIn4Blue(p) == false){
										p.teleport(main.map_arena.get(name).getLoc4Blue());
									}
								}
								else if(green.contains(nick)){
									if(IsIn.IsIn4Green(p) == false){
										p.teleport(main.map_arena.get(name).getLoc4Green());
									}
								}
								else if(purple.contains(nick)){
									if(IsIn.IsIn4Purple(p) == false){
										p.teleport(main.map_arena.get(name).getLoc4Purple());
									}
								}
						}
					}
			}
		}
	}
	
}
