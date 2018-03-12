package me.panda.events;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.panda.levelspvp.main;
import me.panda.methods.IsIn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class blockbreak implements Listener{

	@EventHandler
	public void BlockBreak(BlockBreakEvent e){
		if(e.getBlock().getType() == Material.SIGN || e.getBlock().getType() == Material.SIGN_POST || e.getBlock().getType() == Material.WALL_SIGN){
			Location loc = e.getBlock().getLocation();
			Sign sign = (Sign) Bukkit.getServer().getWorld(loc.getWorld().getName()).getBlockAt(loc).getState();
			if(sign.getLine(0).contains("LevelsPvP") && e.getPlayer().hasPermission("lpvp.admin")){
				
				String[] str = ChatColor.stripColor(sign.getLine(2)).split("/");
				List<String> list = new ArrayList<String>();
				for(String i : str){
					list.add(i);
				}
							
				int value = Integer.parseInt(list.get(0));
				list.clear();
				
				if(sign.getLine(3).contains("DOLACZ") && value == 0 || sign.getLine(3).contains("RESTART")){
				String name = ChatColor.stripColor(sign.getLine(1));
				String world = loc.getWorld().getName();
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String select = "SELECT * FROM LevelsPvPJoin WHERE name='" + name + "' AND world='" + world + "' AND x='" + x + "' AND y='" + y + "' AND z='" + z + "'";
				ResultSet rs = main.mysql.query(select);
				try {
					if(rs.next()){
						String delete1 = "DELETE FROM LevelsPvPJoin WHERE name='" + name + "' AND world='" + world + "' AND x='" + x + "' AND y='" + y + "' AND z='" + z + "'";
						main.mysql.query(delete1);
						e.getPlayer().sendMessage(main.pref + " Tabliczka usunieta !");
					}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else{
					e.getPlayer().sendMessage(main.pref + " Nie mozna zniszczyc tabliczki podczas trwajacej gry");
					e.setCancelled(true);
				}
			}
		}
		//tutaj zeby lobby noby nie niszczyly
		if(IsIn.IsInLobby(e.getPlayer()) == true){
			if(!(e.getPlayer().hasPermission("lpvp.admin"))){
				e.setCancelled(true);
			}
		}
		Player p = e.getPlayer();
		if(IsIn.IsInGame(p) == true){
			if(e.getBlock().getType() == Material.STONE){
		if(IsIn.IsIn1Blue(p) == true || IsIn.IsIn1Green(p) == true || IsIn.IsIn1Purple(p) == true || IsIn.IsIn1Red(p) == true || IsIn.IsIn2Blue(p) == true || IsIn.IsIn2Green(p) == true || IsIn.IsIn2Purple(p) == true || IsIn.IsIn2Red(p) == true || IsIn.IsIn3Blue(p) == true || IsIn.IsIn3Green(p) == true || IsIn.IsIn3Purple(p) == true || IsIn.IsIn3Red(p) == true || IsIn.IsIn4Blue(p) == true || IsIn.IsIn4Green(p) == true || IsIn.IsIn4Purple(p) == true || IsIn.IsIn4Red(p) == true){
			e.setExpToDrop(Integer.parseInt(main.config.getString("exp")));
		}
			}
			
			if(e.getBlock().getType() == Material.ENCHANTMENT_TABLE || e.getBlock().getType() == Material.BOOKSHELF || e.getBlock().getType() == Material.BREWING_STAND){
		if(IsIn.IsIn1Blue(p) == true || IsIn.IsIn1Green(p) == true || IsIn.IsIn1Purple(p) == true || IsIn.IsIn1Red(p) == true || IsIn.IsIn2Blue(p) == true || IsIn.IsIn2Green(p) == true || IsIn.IsIn2Purple(p) == true || IsIn.IsIn2Red(p) == true || IsIn.IsIn3Blue(p) == true || IsIn.IsIn3Green(p) == true || IsIn.IsIn3Purple(p) == true || IsIn.IsIn3Red(p) == true || IsIn.IsIn4Blue(p) == true || IsIn.IsIn4Green(p) == true || IsIn.IsIn4Purple(p) == true || IsIn.IsIn4Red(p) == true){
			e.setCancelled(true);
			p.sendMessage(main.pref + " Nie mozesz tego zniszczyc!");
		}
			}
		}
		
		if(e.getBlock().getType() == Material.STONE){
			if(IsIn.IsInGame(p)){
				
				// 2 poziom - zelazo i wongiel
				if(IsIn.IsIn2Blue(p) || IsIn.IsIn2Green(p) || IsIn.IsIn2Purple(p) || IsIn.IsIn2Red(p)){
					
					Random rand = new Random();
					int procentIron = 7;     //procent na zelazo
					int procentCoal = 4;     //procent na wongiel
					
					if(rand.nextInt(100) <= procentIron){
						p.sendMessage(main.pref + " Gratulacje! Natrafiles na " + ChatColor.DARK_PURPLE + " zelazo!");
						p.getInventory().addItem(new ItemStack(Material.IRON_ORE, 1));
					}
					
					if(rand.nextInt(100) <= procentCoal){
						p.sendMessage(main.pref + " Gratulacje! Natrafiles na " + ChatColor.DARK_GREEN + " wegiel!");
						p.getInventory().addItem(new ItemStack(Material.COAL, 1));
					}
					
				}
				//3 poziom - diamenty i zloto
				if(IsIn.IsIn3Blue(p) || IsIn.IsIn3Green(p) || IsIn.IsIn3Purple(p) || IsIn.IsIn3Red(p)){
					
					Random rand = new Random();
					int procentDiamond = 3;     //procent na diamenty
					int procentGold = 4;     //procent na zloto
					
					if(rand.nextInt(100) <= procentDiamond){
						p.sendMessage(main.pref + " Gratulacje! Natrafiles na " + ChatColor.AQUA + " diament!");
						p.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
					}
					
					if(rand.nextInt(100) <= procentGold){
						p.sendMessage(main.pref + " Gratulacje! Natrafiles na " + ChatColor.GOLD + " zloto!");
						p.getInventory().addItem(new ItemStack(Material.GOLD_ORE, 1));
					}
					
				}
			}
		}
		
	}
	
}
