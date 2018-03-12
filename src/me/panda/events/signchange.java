package me.panda.events;

import java.sql.ResultSet;
import java.sql.SQLException;

import me.panda.levelspvp.main;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class signchange implements Listener{

	@EventHandler
	public void Signit(SignChangeEvent sign){
	      Player p = sign.getPlayer();
	      if(sign.getLine(0).contains("levelspvp")){
	    	  if(p.hasPermission("lpvp.admin") || p.isOp()){
	    	  if(sign.getLine(1) != null){
	    		  String name = sign.getLine(1);
	    		  int isarena = 0;
	    			String select = "SELECT * FROM LevelsPvPArena WHERE name ='" + name + "'";
	    			ResultSet rs = main.mysql.query(select);
	    			try {
	    				if(rs.next()){
	    					isarena = 1;
	    				}
	    			} catch (SQLException e1) {
	    				e1.printStackTrace();
	    			}
	    		  if(isarena == 1){
		    			String select1 = "SELECT * FROM LevelsPvPJoin WHERE name ='" + name + "'";
		    			ResultSet rs1 = main.mysql.query(select1);
		    			try{
		    				if(!(rs1.next())){
		    					sign.setLine(0, ChatColor.DARK_RED + "" + ChatColor.BOLD + "LevelsPvP");
			    			  	sign.setLine(1, ChatColor.DARK_BLUE  + "" + ChatColor.BOLD + name);
			    			  	sign.setLine(2, ChatColor.BOLD + "" + ChatColor.RED + "0" + ChatColor.RESET + "/" + ChatColor.BOLD + "" + ChatColor.RED + Integer.parseInt(main.config.getString("ilosc")));
			    			  	sign.setLine(3, ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "|DOLACZ|");
			    			  	
			    			  	Location loc = sign.getBlock().getLocation();
			    			  	
			    			  	String insert = "INSERT INTO LevelsPvPJoin (`name`, `world`, `x`, `y`, `z`) VALUES ('" + name + "', '" + loc.getWorld().getName() +"', '" + loc.getBlockX() + "', '" + loc.getBlockY() + "', '" + loc.getBlockZ() + "')";
		    					main.mysql.query(insert);
			    			  	
			    			  	p.sendMessage(main.pref + " Tabliczka poprawnie stworzona!");
			    			  	me.panda.methods.load.loadJoinSigns();
		    				}
		    				else{
		    					sign.setCancelled(true);
		    					p.sendMessage(main.pref + " Tabliczka do tej areny juz istnieje");
		    				}
		    			
		    			} catch (SQLException e1) {
		    				e1.printStackTrace();
		    			}
	    		  }
	    		  else{
	    			  p.sendMessage(main.pref + " Arena o takiej nazwie nie istnieje");
	    			  sign.setCancelled(true);
	    		  }
	          
	    	  }
	    	  }
	      }
	}
	
}
