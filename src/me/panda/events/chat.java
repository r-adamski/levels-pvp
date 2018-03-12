package me.panda.events;

import java.util.ArrayList;
import java.util.List;

import me.panda.levelspvp.main;
import me.panda.methods.IsIn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chat implements Listener{

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		String nick = p.getName();
		if(IsIn.IsInGame(p) == true){
			e.setCancelled(true);
			String first = String.valueOf(e.getMessage().charAt(0));
			if(first.equalsIgnoreCase("@")){
				
				List<String> list = new ArrayList<String>(); 
				String[] mes = e.getMessage().split("");
				for(String w : mes){
					list.add(w);
				}
				list.remove(0);
				
	    		StringBuilder sb = new StringBuilder();
				for(String s : list){
				  sb.append(s).append("");
				}
				String message = sb.toString();
				
				for(String i : main.map_game.keySet()){
					
					List<String> red = main.map_game.get(i).getTeamRed();
					List<String> blue = main.map_game.get(i).getTeamBlue();
					List<String> green = main.map_game.get(i).getTeamGreen();
					List<String> purple = main.map_game.get(i).getTeamPurple();
					
					if(red.contains(nick)){
						for(String s : red){
							Bukkit.getPlayer(s).sendMessage(ChatColor.GRAY + "[" + ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "TeamChat" + ChatColor.RESET + ChatColor.GRAY + "] " + ChatColor.GRAY + nick + " " + ChatColor.WHITE + message);
						}
					}
					if(blue.contains(nick)){
						for(String s : blue){
							Bukkit.getPlayer(s).sendMessage(ChatColor.GRAY + "[" + ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "TeamChat" + ChatColor.RESET + ChatColor.GRAY + "] "  + ChatColor.GRAY + nick + " " +ChatColor.WHITE + message);
						}
					}
					if(green.contains(nick)){
						for(String s : green){
							Bukkit.getPlayer(s).sendMessage(ChatColor.GRAY + "[" + ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "TeamChat" + ChatColor.RESET + ChatColor.GRAY + "] "  + ChatColor.GRAY + nick + " " + ChatColor.WHITE + message);
						}
					}
					if(purple.contains(nick)){
						for(String s : purple){
							Bukkit.getPlayer(s).sendMessage(ChatColor.GRAY + "[" + ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "TeamChat" + ChatColor.RESET + ChatColor.GRAY + "] "  + ChatColor.GRAY + nick + " " + ChatColor.WHITE + message);
						}
					}
				}
				
			}
			else{
				for(String i : main.map_game.keySet()){
					
					List<String> red = main.map_game.get(i).getTeamRed();
					List<String> blue = main.map_game.get(i).getTeamBlue();
					List<String> green = main.map_game.get(i).getTeamGreen();
					List<String> purple = main.map_game.get(i).getTeamPurple();
					List<String> noteam = main.map_game.get(i).getNoTeam();

					List<String> all = new ArrayList<String>();
					all.clear();
					for(String s : red){ all.add(s); }
					for(String s : blue){ all.add(s); }
					for(String s : green){ all.add(s); }
					for(String s : purple){ all.add(s); }
					for(String s : noteam){ all.add(s); }
					
					if(all.contains(nick)){
						if(red.contains(nick)){
						for(String s : all){
							Bukkit.getPlayer(s).sendMessage(ChatColor.DARK_RED + nick + ChatColor.DARK_GRAY + " : " + ChatColor.GRAY + e.getMessage());
						}
						}
						if(blue.contains(nick)){
						for(String s : all){
							Bukkit.getPlayer(s).sendMessage(ChatColor.BLUE + nick + ChatColor.DARK_GRAY + " : " + ChatColor.GRAY + e.getMessage());
						}
						}
						if(green.contains(nick)){
						for(String s : all){
							Bukkit.getPlayer(s).sendMessage(ChatColor.DARK_GREEN + nick + ChatColor.DARK_GRAY + " : " + ChatColor.GRAY + e.getMessage());
						}
						}
						if(purple.contains(nick)){
						for(String s : all){
							Bukkit.getPlayer(s).sendMessage(ChatColor.DARK_PURPLE + nick + ChatColor.DARK_GRAY + " : " + ChatColor.GRAY + e.getMessage());
						}
						}
						if(noteam.contains(nick)){
						for(String s : all){
							Bukkit.getPlayer(s).sendMessage(ChatColor.DARK_GRAY + nick + ChatColor.DARK_GRAY + " : " + ChatColor.GRAY + e.getMessage());
						}
						}
					}
				}
			}
		}
	}
	
}
