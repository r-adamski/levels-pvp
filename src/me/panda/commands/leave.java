package me.panda.commands;

import java.util.List;
import java.util.Map.Entry;



import me.confuser.barapi.BarAPI;
import me.panda.levelspvp.main;
import me.panda.methods.IsIn;
import me.panda.methods.give;
import me.panda.methods.scoreboard;
import me.panda.objects.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class leave implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player){
			if(cmd.getName().equalsIgnoreCase("opusc")){
			if(args.length == 0){
			String nick = sender.getName();
			if(IsIn.IsInGame(((Player) sender).getPlayer())){
			
				Player p = ((Player) sender).getPlayer();
				
				if(main.lobby.contains(p.getName())){
					main.lobby.remove(p.getName());
				}
				
				BarAPI.removeBar(p);
				
				for(Entry<String, Game> e : main.map_game.entrySet()){
					String i = e.getKey();
					List<String> red = main.map_game.get(i).getTeamRed();
					List<String> blue = main.map_game.get(i).getTeamBlue();
					List<String> green = main.map_game.get(i).getTeamGreen();
					List<String> purple = main.map_game.get(i).getTeamPurple();
					List<String> noteam = main.map_game.get(i).getNoTeam();
				    int round = main.map_game.get(i).getRound();
					
					if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){
						if(round == 0){
						scoreboard.removePlayerFromArena(p, i);
						scoreboard.removeSB(p);
						scoreboard.reloadTeamSb();
						scoreboard.reloadTeamSize(i);
						give.giveItems(p);
						if(red.contains(nick)){
							scoreboard.reloadTeamSize(i);
							scoreboard.reloadTeamSb();
							red.remove(nick);
						}
						else if(blue.contains(nick)){
							scoreboard.reloadTeamSize(i);
							scoreboard.reloadTeamSb();
							blue.remove(nick);
						}
						else if(green.contains(nick)){
							scoreboard.reloadTeamSize(i);
							scoreboard.reloadTeamSb();
							green.remove(nick);
						}
						else if(purple.contains(nick)){
							scoreboard.reloadTeamSize(i);
							scoreboard.reloadTeamSb();
							purple.remove(nick);
						}
						else if(noteam.contains(nick)){
							noteam.remove(nick);
						}
						
						 World w = Bukkit.getWorld(main.config.getString("spawn.world"));
						 int x = Integer.parseInt(main.config.getString("spawn.x"));
						 int y = Integer.parseInt(main.config.getString("spawn.y"));
						 int z = Integer.parseInt(main.config.getString("spawn.z"));
						 
							((Player) sender).getPlayer().teleport(new Location(w, x, y, z));
							
							boolean countdown = main.map_game.get(i).getcountdown();
							String name = main.map_game.get(i).getName();
							e.setValue(new Game(name, red, blue, green, purple, noteam, round, countdown));
							me.panda.methods.sign.reloadSign(name);
				    
			sender.sendMessage(main.pref + " Zostales przeniesiony na spawn");
				}
					else{
						sender.sendMessage(main.pref + " Twoja druzyna Cie potrzebuje nie mozesz wyjsc teraz z gry");
					}
					}
			}
			}
		}
			else{
				sender.sendMessage(main.pref + " Chyba chciales wpisac " + ChatColor.DARK_AQUA + "/opusc");
			}
		}
	}
	return false;
	}
}
