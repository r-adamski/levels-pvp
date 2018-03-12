package me.panda.methods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.panda.levelspvp.main;
import me.panda.objects.Arena;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class load {
	
	//naprawianie magicznego kurwa bledu
	
	public static void reloadArena(String name){
	
		main.map_arena.remove(name);
		
		String select = "SELECT * FROM LevelsPvPArena WHERE name='" + name + "'";
		ResultSet rs = main.mysql.query(select);
		try {
			if(rs.next()){
			     String spawnLoc = rs.getString("spawnLoc");
			     int spawnX = rs.getInt("spawnX");
			     String loc1Red = rs.getString("loc1Red");
			     String loc1Blue = rs.getString("loc1Blue");
			     String loc1Green = rs.getString("loc1Green");
			     String loc1Purple = rs.getString("loc1Purple");
			     int time1 = rs.getInt("time1");
			     int X1 = rs.getInt("X1");
			     String loc2Red = rs.getString("loc2Red");
			     String loc2Blue = rs.getString("loc2Blue");
			     String loc2Green = rs.getString("loc2Green");
				 String loc2Purple = rs.getString("loc2Purple");
				 int time2 = rs.getInt("time2");
				 String loc3Red = rs.getString("loc3Red");
				 String loc3Blue = rs.getString("loc3Blue");
				 String loc3Green = rs.getString("loc3Green");
				 String loc3Purple = rs.getString("loc3Purple");
				 int time3 = rs.getInt("time3");
				 String loc4Red = rs.getString("loc4Red");
				 String loc4Blue = rs.getString("loc4Blue");
				 String loc4Green = rs.getString("loc4Green");
				 String loc4Purple = rs.getString("loc4Purple");
				 int time4 = rs.getInt("time4");
				 String loc5Red = rs.getString("loc5Red");
				 String loc5Blue = rs.getString("loc5Blue");
				 String loc5Green = rs.getString("loc5Green");
				 String loc5Purple = rs.getString("loc5Purple");
				 int time5 = rs.getInt("time5");
				 int X5 = rs.getInt("X5");


				 //tu dodac splitowanie lokatjonuf
					String[] str = spawnLoc.split(":");
					List<String> list = new ArrayList<String>();
					for(String i : str){
						list.add(i);
					}
					World w = Bukkit.getWorld(list.get(0));
					int x = Integer.parseInt(list.get(1));
					int z = Integer.parseInt(list.get(2));
					int y = Integer.parseInt(list.get(3));
					
					Location SPAWNLOC = new Location(w, x, y, z);
					list.clear();
					
					String[] str1 = loc1Red.split(":");
					for(String i : str1){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC1RED = new Location(w, x, y, z);
					list.clear();
					
					String[] str2 = loc2Red.split(":");
					for(String i : str2){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC2RED = new Location(w, x, y, z);
					list.clear();
					
					String[] str3 = loc3Red.split(":");
					for(String i : str3){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC3RED = new Location(w, x, y, z);
					list.clear();
					
					String[] str4 = loc4Red.split(":");
					for(String i : str4){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC4RED = new Location(w, x, y, z);
					list.clear();
					
					String[] str5 = loc5Red.split(":");
					for(String i : str5){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC5RED = new Location(w, x, y, z);
					list.clear();
					
					String[] str6 = loc1Blue.split(":");
					for(String i : str6){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC1BLUE = new Location(w, x, y, z);
					list.clear();
					
					String[] str7 = loc2Blue.split(":");
					for(String i : str7){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC2BLUE = new Location(w, x, y, z);
					list.clear();
					
					String[] str8 = loc3Blue.split(":");
					for(String i : str8){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC3BLUE = new Location(w, x, y, z);
					list.clear();
					
					String[] str9 = loc4Blue.split(":");
					for(String i : str9){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC4BLUE = new Location(w, x, y, z);
					list.clear();
					
					String[] str10 = loc5Blue.split(":");
					for(String i : str10){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC5BLUE = new Location(w, x, y, z);
					list.clear();
					
					String[] str11 = loc1Green.split(":");
					for(String i : str11){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC1GREEN = new Location(w, x, y, z);
					list.clear();
					
					String[] str12 = loc2Green.split(":");
					for(String i : str12){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC2GREEN = new Location(w, x, y, z);
					list.clear();
					
					String[] str13 = loc3Green.split(":");
					for(String i : str13){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC3GREEN = new Location(w, x, y, z);
					list.clear();
					
					String[] str14 = loc4Green.split(":");
					for(String i : str14){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC4GREEN = new Location(w, x, y, z);
					list.clear();
					
					String[] str15 = loc5Green.split(":");
					for(String i : str15){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC5GREEN = new Location(w, x, y, z);
					list.clear();
					
					String[] str16 = loc1Purple.split(":");
					for(String i : str16){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC1PURPLE = new Location(w, x, y, z);
					list.clear();
					
					String[] str17 = loc2Purple.split(":");
					for(String i : str17){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC2PURPLE = new Location(w, x, y, z);
					list.clear();
					
					String[] str18 = loc3Purple.split(":");
					for(String i : str18){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC3PURPLE = new Location(w, x, y, z);
					list.clear();
					
					
					String[] str19 = loc4Purple.split(":");
					for(String i : str19){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC4PURPLE = new Location(w, x, y, z);
					list.clear();
					
					String[] str20 = loc5Purple.split(":");
					for(String i : str20){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC5PURPLE = new Location(w, x, y, z);
					list.clear();
					
					
					 main.map_arena.put(name, new Arena(name, SPAWNLOC, spawnX, LOC1RED, LOC1BLUE, LOC1GREEN, LOC1PURPLE, time1, X1, LOC2RED, LOC2BLUE, LOC2GREEN, LOC2PURPLE, 
							 time2, LOC3RED, LOC3BLUE, LOC3GREEN, LOC3PURPLE, time3, LOC4RED, LOC4BLUE, LOC4GREEN, LOC4PURPLE, time4, LOC5RED, LOC5BLUE, LOC5GREEN, LOC5PURPLE, 
							 time5, X5));				 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//ladowanie danych aren z mysql do mapki
	public static void loadArena(){
		main.map_arena.clear();
		String select = "SELECT * FROM LevelsPvPArena";
		ResultSet rs = main.mysql.query(select);
		try {
			while(rs.next()){
				
			     String name = rs.getString("name");
			     String spawnLoc = rs.getString("spawnLoc");
			     int spawnX = rs.getInt("spawnX");
			     String loc1Red = rs.getString("loc1Red");
			     String loc1Blue = rs.getString("loc1Blue");
			     String loc1Green = rs.getString("loc1Green");
			     String loc1Purple = rs.getString("loc1Purple");
			     int time1 = rs.getInt("time1");
			     int X1 = rs.getInt("X1");
			     String loc2Red = rs.getString("loc2Red");
			     String loc2Blue = rs.getString("loc2Blue");
			     String loc2Green = rs.getString("loc2Green");
				 String loc2Purple = rs.getString("loc2Purple");
				 int time2 = rs.getInt("time2");
				 String loc3Red = rs.getString("loc3Red");
				 String loc3Blue = rs.getString("loc3Blue");
				 String loc3Green = rs.getString("loc3Green");
				 String loc3Purple = rs.getString("loc3Purple");
				 int time3 = rs.getInt("time3");
				 String loc4Red = rs.getString("loc4Red");
				 String loc4Blue = rs.getString("loc4Blue");
				 String loc4Green = rs.getString("loc4Green");
				 String loc4Purple = rs.getString("loc4Purple");
				 int time4 = rs.getInt("time4");
				 String loc5Red = rs.getString("loc5Red");
				 String loc5Blue = rs.getString("loc5Blue");
				 String loc5Green = rs.getString("loc5Green");
				 String loc5Purple = rs.getString("loc5Purple");
				 int time5 = rs.getInt("time5");
				 int X5 = rs.getInt("X5");


				 //tu dodac splitowanie lokatjonuf
					String[] str = spawnLoc.split(":");
					List<String> list = new ArrayList<String>();
					for(String i : str){
						list.add(i);
					}
					World w = Bukkit.getWorld(list.get(0));
					int x = Integer.parseInt(list.get(1));
					int z = Integer.parseInt(list.get(2));
					int y = Integer.parseInt(list.get(3));
					
					Location SPAWNLOC = new Location(w, x, y, z);
					list.clear();
					
					String[] str1 = loc1Red.split(":");
					for(String i : str1){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC1RED = new Location(w, x, y, z);
					list.clear();
					
					String[] str2 = loc2Red.split(":");
					for(String i : str2){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC2RED = new Location(w, x, y, z);
					list.clear();
					
					String[] str3 = loc3Red.split(":");
					for(String i : str3){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC3RED = new Location(w, x, y, z);
					list.clear();
					
					String[] str4 = loc4Red.split(":");
					for(String i : str4){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC4RED = new Location(w, x, y, z);
					list.clear();
					
					String[] str5 = loc5Red.split(":");
					for(String i : str5){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC5RED = new Location(w, x, y, z);
					list.clear();
					
					String[] str6 = loc1Blue.split(":");
					for(String i : str6){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC1BLUE = new Location(w, x, y, z);
					list.clear();
					
					String[] str7 = loc2Blue.split(":");
					for(String i : str7){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC2BLUE = new Location(w, x, y, z);
					list.clear();
					
					String[] str8 = loc3Blue.split(":");
					for(String i : str8){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC3BLUE = new Location(w, x, y, z);
					list.clear();
					
					String[] str9 = loc4Blue.split(":");
					for(String i : str9){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC4BLUE = new Location(w, x, y, z);
					list.clear();
					
					String[] str10 = loc5Blue.split(":");
					for(String i : str10){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC5BLUE = new Location(w, x, y, z);
					list.clear();
					
					String[] str11 = loc1Green.split(":");
					for(String i : str11){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC1GREEN = new Location(w, x, y, z);
					list.clear();
					
					String[] str12 = loc2Green.split(":");
					for(String i : str12){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC2GREEN = new Location(w, x, y, z);
					list.clear();
					
					String[] str13 = loc3Green.split(":");
					for(String i : str13){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC3GREEN = new Location(w, x, y, z);
					list.clear();
					
					String[] str14 = loc4Green.split(":");
					for(String i : str14){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC4GREEN = new Location(w, x, y, z);
					list.clear();
					
					String[] str15 = loc5Green.split(":");
					for(String i : str15){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC5GREEN = new Location(w, x, y, z);
					list.clear();
					
					String[] str16 = loc1Purple.split(":");
					for(String i : str16){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC1PURPLE = new Location(w, x, y, z);
					list.clear();
					
					String[] str17 = loc2Purple.split(":");
					for(String i : str17){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC2PURPLE = new Location(w, x, y, z);
					list.clear();
					
					String[] str18 = loc3Purple.split(":");
					for(String i : str18){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC3PURPLE = new Location(w, x, y, z);
					list.clear();
					
					
					String[] str19 = loc4Purple.split(":");
					for(String i : str19){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC4PURPLE = new Location(w, x, y, z);
					list.clear();
					
					String[] str20 = loc5Purple.split(":");
					for(String i : str20){
						list.add(i);
					}
					 w = Bukkit.getWorld(list.get(0));
					 x = Integer.parseInt(list.get(1));
					 z = Integer.parseInt(list.get(2));
					 y = Integer.parseInt(list.get(3));
					
					Location LOC5PURPLE = new Location(w, x, y, z);
					list.clear();
					
					
					 main.map_arena.put(name, new Arena(name, SPAWNLOC, spawnX, LOC1RED, LOC1BLUE, LOC1GREEN, LOC1PURPLE, time1, X1, LOC2RED, LOC2BLUE, LOC2GREEN, LOC2PURPLE, 
							 time2, LOC3RED, LOC3BLUE, LOC3GREEN, LOC3PURPLE, time3, LOC4RED, LOC4BLUE, LOC4GREEN, LOC4PURPLE, time4, LOC5RED, LOC5BLUE, LOC5GREEN, LOC5PURPLE, 
							 time5, X5));				 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//ladowanie tabliczek z mysql do mapki
	public static void loadJoinSigns(){
		main.map_join.clear();
		String select = "SELECT * FROM LevelsPvPJoin";
		ResultSet rs = main.mysql.query(select);
		try {
			while(rs.next()){
				String name = rs.getString("name");
				World world = Bukkit.getWorld(rs.getString("world"));
				int x = rs.getInt("x");
				int y = rs.getInt("y");
				int z = rs.getInt("z");
				
				Location loc = new Location(world, x, y, z);
								
				main.map_join.put(name, loc);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
