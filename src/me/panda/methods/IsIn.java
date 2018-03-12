package me.panda.methods;

import java.util.List;
import java.util.Map.Entry;

import me.panda.levelspvp.main;
import me.panda.objects.Game;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class IsIn {

	
		//miliard metod typu IsIn
	//sprawdzaja czy gracz jest np. w grze lub w danym obszarze
		
		//is in game
		
		public static boolean IsInGame(Player p){
			if(p == null){
				return false;
			}
			String nick = p.getName();
			
			for(Entry<String, Game> entry : main.map_game.entrySet()){
				
				List<String> red = entry.getValue().getTeamRed();
				List<String> blue = entry.getValue().getTeamBlue();
				List<String> green = entry.getValue().getTeamGreen();
				List<String> purple = entry.getValue().getTeamPurple();
				List<String> noteam = entry.getValue().getNoTeam();
				
				if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){
					return true;
				}
				
			}
			return false;
		}
		
		//is in lobby
		
		public static boolean IsInLobby(Player p){
			String nick = p.getName();
			
			for(Entry<String, Game> entry : main.map_game.entrySet()){
				
				List<String> red = entry.getValue().getTeamRed();
				List<String> blue = entry.getValue().getTeamBlue();
				List<String> green = entry.getValue().getTeamGreen();
				List<String> purple = entry.getValue().getTeamPurple();
				List<String> noteam = entry.getValue().getNoTeam();
				
				if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){
					
					Location loc = main.map_arena.get(entry.getKey()).spawnLoc;
					int radius = main.map_arena.get(entry.getKey()).spawnX;
					
					int x = loc.getBlockX();
					int y = loc.getBlockY();
					int z = loc.getBlockZ();
					String world = loc.getWorld().getName();
					
					Location lo = p.getLocation();
					int maxY = y + radius;
					int minY = y - radius;
					int minX = x - radius;
					int maxX = x + radius;
					int minZ = z - radius;
					int maxZ = z + radius;
					
					if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
						return true;
					}
				}
				
			}
			return false;
		}
		
		
		//is in 1Red
		
		public static boolean IsIn1Red(Player p){
			String nick = p.getName();
			
			for(Entry<String, Game> entry : main.map_game.entrySet()){
				
				List<String> red = entry.getValue().getTeamRed();
				List<String> blue = entry.getValue().getTeamBlue();
				List<String> green = entry.getValue().getTeamGreen();
				List<String> purple = entry.getValue().getTeamPurple();
				List<String> noteam = entry.getValue().getNoTeam();
				
				if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
					
					
					Location loc = main.map_arena.get(entry.getKey()).getLoc1Red();
					int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
					
					Location lo = p.getLocation();
					
					int x = loc.getBlockX();
					int y = loc.getBlockY();
					int z = loc.getBlockZ();
					String world = loc.getWorld().getName();
					
					int maxY = y + radius;
					int minY = y - radius;
					int minX = x - radius;
					int maxX = x + radius;
					int minZ = z - radius;
					int maxZ = z + radius;
					
					
					if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
						return true;
					}		
					
				}
				
			}
			return false;
		}
		
		
		//is in 2red
		
		public static boolean IsIn2Red(Player p){
			String nick = p.getName();
			
			for(Entry<String, Game> entry : main.map_game.entrySet()){
				
				List<String> red = entry.getValue().getTeamRed();
				List<String> blue = entry.getValue().getTeamBlue();
				List<String> green = entry.getValue().getTeamGreen();
				List<String> purple = entry.getValue().getTeamPurple();
				List<String> noteam = entry.getValue().getNoTeam();
				
				if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
					
					
					Location loc = main.map_arena.get(entry.getKey()).getLoc2Red();
					int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
					
					Location lo = p.getLocation();
					
					int x = loc.getBlockX();
					int y = loc.getBlockY();
					int z = loc.getBlockZ();
					String world = loc.getWorld().getName();
					
					int maxY = y + radius;
					int minY = y - radius;
					int minX = x - radius;
					int maxX = x + radius;
					int minZ = z - radius;
					int maxZ = z + radius;
					
					
					if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
						return true;
					}		
					
				}
				
			}
			return false;
		}
		
		
		public static boolean IsIn3Red(Player p){
			String nick = p.getName();
			
			for(Entry<String, Game> entry : main.map_game.entrySet()){
				
				List<String> red = entry.getValue().getTeamRed();
				List<String> blue = entry.getValue().getTeamBlue();
				List<String> green = entry.getValue().getTeamGreen();
				List<String> purple = entry.getValue().getTeamPurple();
				List<String> noteam = entry.getValue().getNoTeam();
				
				if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
					
					
					Location loc = main.map_arena.get(entry.getKey()).getLoc3Red();
					int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
					
					Location lo = p.getLocation();
					
					int x = loc.getBlockX();
					int y = loc.getBlockY();
					int z = loc.getBlockZ();
					String world = loc.getWorld().getName();
					
					int maxY = y + radius;
					int minY = y - radius;
					int minX = x - radius;
					int maxX = x + radius;
					int minZ = z - radius;
					int maxZ = z + radius;
					
					
					if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
						return true;
					}		
					
				}
				
			}
			return false;
		}
		
		public static boolean IsIn4Red(Player p){
			String nick = p.getName();
			
			for(Entry<String, Game> entry : main.map_game.entrySet()){
				
				List<String> red = entry.getValue().getTeamRed();
				List<String> blue = entry.getValue().getTeamBlue();
				List<String> green = entry.getValue().getTeamGreen();
				List<String> purple = entry.getValue().getTeamPurple();
				List<String> noteam = entry.getValue().getNoTeam();
				
				if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
					
					
					Location loc = main.map_arena.get(entry.getKey()).getLoc4Red();
					int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
					
					Location lo = p.getLocation();
					
					int x = loc.getBlockX();
					int y = loc.getBlockY();
					int z = loc.getBlockZ();
					String world = loc.getWorld().getName();
					
					int maxY = y + radius;
					int minY = y - radius;
					int minX = x - radius;
					int maxX = x + radius;
					int minZ = z - radius;
					int maxZ = z + radius;
					
					
					if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
						return true;
					}		
					
				}
				
			}
			return false;
		}
		
		
		public static boolean IsIn1Blue(Player p){
			String nick = p.getName();
			
			for(Entry<String, Game> entry : main.map_game.entrySet()){
				
				List<String> red = entry.getValue().getTeamRed();
				List<String> blue = entry.getValue().getTeamBlue();
				List<String> green = entry.getValue().getTeamGreen();
				List<String> purple = entry.getValue().getTeamPurple();
				List<String> noteam = entry.getValue().getNoTeam();
				
				if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
					
					
					Location loc = main.map_arena.get(entry.getKey()).getLoc1Blue();
					int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
					
					Location lo = p.getLocation();
					
					int x = loc.getBlockX();
					int y = loc.getBlockY();
					int z = loc.getBlockZ();
					String world = loc.getWorld().getName();
					
					int maxY = y + radius;
					int minY = y - radius;
					int minX = x - radius;
					int maxX = x + radius;
					int minZ = z - radius;
					int maxZ = z + radius;
					
					
					if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
						return true;
					}		
					
				}
				
			}
			return false;
		}
		


	public static boolean IsIn2Blue(Player p){
		String nick = p.getName();
		
		for(Entry<String, Game> entry : main.map_game.entrySet()){
			
			List<String> red = entry.getValue().getTeamRed();
			List<String> blue = entry.getValue().getTeamBlue();
			List<String> green = entry.getValue().getTeamGreen();
			List<String> purple = entry.getValue().getTeamPurple();
			List<String> noteam = entry.getValue().getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
				
				
				Location loc = main.map_arena.get(entry.getKey()).getLoc2Blue();
				int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
				
				Location lo = p.getLocation();
				
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String world = loc.getWorld().getName();
				
				int maxY = y + radius;
				int minY = y - radius;
				int minX = x - radius;
				int maxX = x + radius;
				int minZ = z - radius;
				int maxZ = z + radius;
				
				
				if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
					return true;
				}		
				
			}
			
		}
		return false;
	}



	public static boolean IsIn3Blue(Player p){
		String nick = p.getName();
		
		for(Entry<String, Game> entry : main.map_game.entrySet()){
			
			List<String> red = entry.getValue().getTeamRed();
			List<String> blue = entry.getValue().getTeamBlue();
			List<String> green = entry.getValue().getTeamGreen();
			List<String> purple = entry.getValue().getTeamPurple();
			List<String> noteam = entry.getValue().getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
				
				
				Location loc = main.map_arena.get(entry.getKey()).getLoc3Blue();
				int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
				
				Location lo = p.getLocation();
				
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String world = loc.getWorld().getName();
				
				int maxY = y + radius;
				int minY = y - radius;
				int minX = x - radius;
				int maxX = x + radius;
				int minZ = z - radius;
				int maxZ = z + radius;
				
				
				if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
					return true;
				}		
				
			}
			
		}
		return false;
	}



	public static boolean IsIn4Blue(Player p){
		String nick = p.getName();
		
		for(Entry<String, Game> entry : main.map_game.entrySet()){
			
			List<String> red = entry.getValue().getTeamRed();
			List<String> blue = entry.getValue().getTeamBlue();
			List<String> green = entry.getValue().getTeamGreen();
			List<String> purple = entry.getValue().getTeamPurple();
			List<String> noteam = entry.getValue().getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
				
				
				Location loc = main.map_arena.get(entry.getKey()).getLoc4Blue();
				int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
				
				Location lo = p.getLocation();
				
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String world = loc.getWorld().getName();
				
				int maxY = y + radius;
				int minY = y - radius;
				int minX = x - radius;
				int maxX = x + radius;
				int minZ = z - radius;
				int maxZ = z + radius;
				
				
				if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
					return true;
				}		
				
			}
			
		}
		return false;
	}



	public static boolean IsIn1Green(Player p){
		String nick = p.getName();
		
		
		for(Entry<String, Game> entry : main.map_game.entrySet()){
			
			List<String> red = entry.getValue().getTeamRed();
			List<String> blue = entry.getValue().getTeamBlue();
			List<String> green = entry.getValue().getTeamGreen();
			List<String> purple = entry.getValue().getTeamPurple();
			List<String> noteam = entry.getValue().getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
				
				
				Location loc = main.map_arena.get(entry.getKey()).getLoc1Green();
				int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
				
				Location lo = p.getLocation();
				
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String world = loc.getWorld().getName();
				
				int maxY = y + radius;
				int minY = y - radius;
				int minX = x - radius;
				int maxX = x + radius;
				int minZ = z - radius;
				int maxZ = z + radius;
				
				
				if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
					return true;
				}		
				
			}
			
		}
		return false;
	}

	public static boolean IsIn2Green(Player p){
		String nick = p.getName();
		
		
		for(Entry<String, Game> entry : main.map_game.entrySet()){
			
			List<String> red = entry.getValue().getTeamRed();
			List<String> blue = entry.getValue().getTeamBlue();
			List<String> green = entry.getValue().getTeamGreen();
			List<String> purple = entry.getValue().getTeamPurple();
			List<String> noteam = entry.getValue().getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
				
				
				Location loc = main.map_arena.get(entry.getKey()).getLoc2Green();
				int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
				
				Location lo = p.getLocation();
				
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String world = loc.getWorld().getName();
				
				int maxY = y + radius;
				int minY = y - radius;
				int minX = x - radius;
				int maxX = x + radius;
				int minZ = z - radius;
				int maxZ = z + radius;
				
				
				if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
					return true;
				}		
				
			}
			
		}
		return false;
	}


	public static boolean IsIn3Green(Player p){
		String nick = p.getName();
		
		
		for(Entry<String, Game> entry : main.map_game.entrySet()){
			
			List<String> red = entry.getValue().getTeamRed();
			List<String> blue = entry.getValue().getTeamBlue();
			List<String> green = entry.getValue().getTeamGreen();
			List<String> purple = entry.getValue().getTeamPurple();
			List<String> noteam = entry.getValue().getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
				
				
				Location loc = main.map_arena.get(entry.getKey()).getLoc3Green();
				int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
				
				Location lo = p.getLocation();
				
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String world = loc.getWorld().getName();
				
				int maxY = y + radius;
				int minY = y - radius;
				int minX = x - radius;
				int maxX = x + radius;
				int minZ = z - radius;
				int maxZ = z + radius;
				
				
				if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
					return true;
				}		
				
			}
			
		}
		return false;
	}

	public static boolean IsIn4Green(Player p){
		String nick = p.getName();
		
		
		for(Entry<String, Game> entry : main.map_game.entrySet()){
			
			List<String> red = entry.getValue().getTeamRed();
			List<String> blue = entry.getValue().getTeamBlue();
			List<String> green = entry.getValue().getTeamGreen();
			List<String> purple = entry.getValue().getTeamPurple();
			List<String> noteam = entry.getValue().getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
				
				
				Location loc = main.map_arena.get(entry.getKey()).getLoc4Green();
				int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
				
				Location lo = p.getLocation();
				
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String world = loc.getWorld().getName();
				
				int maxY = y + radius;
				int minY = y - radius;
				int minX = x - radius;
				int maxX = x + radius;
				int minZ = z - radius;
				int maxZ = z + radius;
				
				
				if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
					return true;
				}		
				
			}
			
		}
		return false;
	}

	public static boolean IsIn1Purple(Player p){
		String nick = p.getName();
		
		
		for(Entry<String, Game> entry : main.map_game.entrySet()){
			
			List<String> red = entry.getValue().getTeamRed();
			List<String> blue = entry.getValue().getTeamBlue();
			List<String> green = entry.getValue().getTeamGreen();
			List<String> purple = entry.getValue().getTeamPurple();
			List<String> noteam = entry.getValue().getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
				
				
				Location loc = main.map_arena.get(entry.getKey()).getLoc1Purple();
				int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
				
				Location lo = p.getLocation();
				
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String world = loc.getWorld().getName();
				
				int maxY = y + radius;
				int minY = y - radius;
				int minX = x - radius;
				int maxX = x + radius;
				int minZ = z - radius;
				int maxZ = z + radius;
				
				
				if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
					return true;
				}		
				
			}
			
		}
		return false;
	}

	public static boolean IsIn2Purple(Player p){
		String nick = p.getName();
		
		
		for(Entry<String, Game> entry : main.map_game.entrySet()){
			
			List<String> red = entry.getValue().getTeamRed();
			List<String> blue = entry.getValue().getTeamBlue();
			List<String> green = entry.getValue().getTeamGreen();
			List<String> purple = entry.getValue().getTeamPurple();
			List<String> noteam = entry.getValue().getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
				
				
				Location loc = main.map_arena.get(entry.getKey()).getLoc2Purple();
				int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
				
				Location lo = p.getLocation();
				
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String world = loc.getWorld().getName();
				
				int maxY = y + radius;
				int minY = y - radius;
				int minX = x - radius;
				int maxX = x + radius;
				int minZ = z - radius;
				int maxZ = z + radius;
				
				
				if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
					return true;
				}		
				
			}
			
		}
		return false;
	}

	public static boolean IsIn3Purple(Player p){
		String nick = p.getName();
		

		for(Entry<String, Game> entry : main.map_game.entrySet()){
			
			List<String> red = entry.getValue().getTeamRed();
			List<String> blue = entry.getValue().getTeamBlue();
			List<String> green = entry.getValue().getTeamGreen();
			List<String> purple = entry.getValue().getTeamPurple();
			List<String> noteam = entry.getValue().getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
				
				
				Location loc = main.map_arena.get(entry.getKey()).getLoc3Purple();
				int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
				
				Location lo = p.getLocation();
				
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String world = loc.getWorld().getName();
				
				int maxY = y + radius;
				int minY = y - radius;
				int minX = x - radius;
				int maxX = x + radius;
				int minZ = z - radius;
				int maxZ = z + radius;
				
				
				if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
					return true;
				}		
				
			}
			
		}
		return false;
	}

	public static boolean IsIn4Purple(Player p){
		String nick = p.getName();
		
		for(Entry<String, Game> entry : main.map_game.entrySet()){
			
			List<String> red = entry.getValue().getTeamRed();
			List<String> blue = entry.getValue().getTeamBlue();
			List<String> green = entry.getValue().getTeamGreen();
			List<String> purple = entry.getValue().getTeamPurple();
			List<String> noteam = entry.getValue().getNoTeam();
			
			if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick) || noteam.contains(nick)){			
				
				
				Location loc = main.map_arena.get(entry.getKey()).getLoc4Purple();
				int radius = main.map_arena.get(entry.getKey()).getLevelsRadius();
				
				Location lo = p.getLocation();
				
				int x = loc.getBlockX();
				int y = loc.getBlockY();
				int z = loc.getBlockZ();
				String world = loc.getWorld().getName();
				
				int maxY = y + radius;
				int minY = y - radius;
				int minX = x - radius;
				int maxX = x + radius;
				int minZ = z - radius;
				int maxZ = z + radius;
				
				
				if(world.equalsIgnoreCase(lo.getWorld().getName()) && maxY > lo.getY() && minY < lo.getY() && minX < lo.getX() && maxX > lo.getX() && minZ < lo.getZ() && maxZ > lo.getZ()){
					return true;
				}		
				
			}
			
		}
		return false;
	}
	
}
