package me.panda.methods;

import java.util.List;
import me.panda.levelspvp.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Sign;

public class sign {

	//update graczy online na arenie na tabliczkach do jojnowania
	public static void reloadSign(String name){
			Location loc = main.map_join.get(name);
			Sign sign = (Sign)Bukkit.getServer().getWorld(loc.getWorld().getName()).getBlockAt(loc).getState();
			
				if(main.map_game.containsKey(name)){
					
					List<String> red = main.map_game.get(name).getTeamRed();
					List<String> blue = main.map_game.get(name).getTeamBlue();
					List<String> green = main.map_game.get(name).getTeamGreen();
					List<String> purple = main.map_game.get(name).getTeamPurple();
					List<String> noteam = main.map_game.get(name).getNoTeam();
					
					int size = red.size() + blue.size() + green.size() + purple.size() + noteam.size();
					sign.setLine(2, ChatColor.BOLD + "" + ChatColor.RED + size + ChatColor.RESET + "/" + ChatColor.BOLD + "" + ChatColor.RED + Integer.parseInt(main.config.getString("ilosc")));
					sign.update();	
					
				}
				else{
					
					sign.setLine(2, ChatColor.BOLD + "" + ChatColor.RED + "0" + ChatColor.RESET + "/" + ChatColor.BOLD + "" + ChatColor.RED + Integer.parseInt(main.config.getString("ilosc")));
					sign.update();	
					
				}
	}
	
}
