package me.panda.system;

import java.util.ArrayList;
import java.util.List;

import me.panda.levelspvp.main;
import me.panda.methods.clear;
import me.panda.methods.scoreboard;
import me.panda.objects.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class joingame {

	@SuppressWarnings("deprecation")
	public static void joinGame(Player p, Sign sign){
		String name = ChatColor.stripColor(sign.getLine(1));		
		p.teleport(main.map_arena.get(name).getSpawnLoc());//tu blad
		p.sendMessage(main.map_arena.get(name).getSpawnLoc().getWorld().getName());
		p.sendMessage(main.map_arena.size() + "");
		p.sendMessage(main.map_game.size() + "");
		
		clear.clearPlayer(p);
		
		if(!(main.lobby.contains(p.getName()))){
		main.lobby.add(p.getName());
		}
		
		if(main.map_game.get(name) == null){
			 
		     ArrayList<String> red = new ArrayList<String>();
		     ArrayList<String> blue = new ArrayList<String>();
		     ArrayList<String> green = new ArrayList<String>();
		     ArrayList<String> purple = new ArrayList<String>();
		     ArrayList<String> noteam = new ArrayList<String>();
		     
		     noteam.add(p.getName());
		     
			 
		     for(String s : red){
		    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + p.getName() + ChatColor.GRAY + " dolaczyl do gry! " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + (red.size() + blue.size() + green.size() + purple.size() + noteam.size()) + ChatColor.GRAY + " / " + ChatColor.GOLD + Integer.parseInt(main.config.getString("ilosc")) + ChatColor.DARK_GRAY + "]");
		     }
		     for(String s : blue){
		    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + p.getName() + ChatColor.GRAY + " dolaczyl do gry! " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + (red.size() + blue.size() + green.size() + purple.size() + noteam.size()) + ChatColor.GRAY + " / " + ChatColor.GOLD + Integer.parseInt(main.config.getString("ilosc")) + ChatColor.DARK_GRAY + "]");
		     }
		     for(String s : green){
		    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + p.getName() + ChatColor.GRAY + " dolaczyl do gry! " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + (red.size() + blue.size() + green.size() + purple.size() + noteam.size()) + ChatColor.GRAY + " / " + ChatColor.GOLD + Integer.parseInt(main.config.getString("ilosc")) + ChatColor.DARK_GRAY + "]");
		     }
		     for(String s : purple){
		    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + p.getName() + ChatColor.GRAY + " dolaczyl do gry! " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + (red.size() + blue.size() + green.size() + purple.size() + noteam.size()) + ChatColor.GRAY + " / " + ChatColor.GOLD + Integer.parseInt(main.config.getString("ilosc")) + ChatColor.DARK_GRAY + "]");
		     }
		     for(String s : noteam){
		    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + p.getName() + ChatColor.GRAY + " dolaczyl do gry! " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + (red.size() + blue.size() + green.size() + purple.size() + noteam.size()) + ChatColor.GRAY + " / " + ChatColor.GOLD + Integer.parseInt(main.config.getString("ilosc")) + ChatColor.DARK_GRAY + "]");
		     }
		     
			main.map_game.put(name, new Game(name, red, blue, green, purple, noteam, 0, false));
			me.panda.methods.sign.reloadSign(name);
			scoreboard.addPlayerToGameSb(p, name);
			scoreboard.reloadTeamSize(name);
			main.addLog("TWORZY GRE - " + name);
		}
		else{
			List<String> red = main.map_game.get(name).getTeamRed();
			List<String> blue = main.map_game.get(name).getTeamBlue();
			List<String> green = main.map_game.get(name).getTeamGreen();
			List<String> purple = main.map_game.get(name).getTeamPurple();
			List<String> noteam = main.map_game.get(name).getNoTeam();
			boolean countdown = main.map_game.get(name).getcountdown();

			
			noteam.add(p.getName());
			
		     for(String s : red){
		    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + p.getName() + ChatColor.GRAY + " dolaczyl do gry! " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + (red.size() + blue.size() + green.size() + purple.size() + noteam.size()) + ChatColor.GRAY + " / " + ChatColor.GOLD + Integer.parseInt(main.config.getString("ilosc")) + ChatColor.DARK_GRAY + "]");
		     }
		     for(String s : blue){
		    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + p.getName() + ChatColor.GRAY + " dolaczyl do gry! " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + (red.size() + blue.size() + green.size() + purple.size() + noteam.size()) + ChatColor.GRAY + " / " + ChatColor.GOLD + Integer.parseInt(main.config.getString("ilosc")) + ChatColor.DARK_GRAY + "]");
		     }
		     for(String s : green){
		    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + p.getName() + ChatColor.GRAY + " dolaczyl do gry! " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + (red.size() + blue.size() + green.size() + purple.size() + noteam.size()) + ChatColor.GRAY + " / " + ChatColor.GOLD + Integer.parseInt(main.config.getString("ilosc")) + ChatColor.DARK_GRAY + "]");
		     }
		     for(String s : purple){
		    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + p.getName() + ChatColor.GRAY + " dolaczyl do gry! " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + (red.size() + blue.size() + green.size() + purple.size() + noteam.size()) + ChatColor.GRAY + " / " + ChatColor.GOLD + Integer.parseInt(main.config.getString("ilosc")) + ChatColor.DARK_GRAY + "]");
		     }
		     for(String s : noteam){
		    	 Bukkit.getPlayer(s).sendMessage(main.pref + ChatColor.GOLD + p.getName() + ChatColor.GRAY + " dolaczyl do gry! " + ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + (red.size() + blue.size() + green.size() + purple.size() + noteam.size()) + ChatColor.GRAY + " / " + ChatColor.GOLD + Integer.parseInt(main.config.getString("ilosc")) + ChatColor.DARK_GRAY + "]");
		     }
			
			main.map_game.remove(name);
			main.map_game.put(name, new Game(name, red, blue, green, purple, noteam, 0, countdown));
			me.panda.methods.sign.reloadSign(name);
			scoreboard.addPlayerToGameSb(p, name);
			scoreboard.reloadTeamSize(name);
			scoreboard.reloadTeamSb();
			scoreboard.reloadTeamSize(name);
		}
		
	}
	
}
