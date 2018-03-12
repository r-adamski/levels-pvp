package me.panda.methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import me.panda.levelspvp.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class scoreboard {
	
	//scoreboardy i metody do ich przeladowywania

	static Map<String, List<Player>> games = new HashMap<String, List<Player>>();
    static ArrayList<Player> RedPlayers = new ArrayList<>();
    static ArrayList<Player> GreenPlayers = new ArrayList<>();
    static ArrayList<Player> BluePlayers = new ArrayList<>();
    static ArrayList<Player> PurplePlayers = new ArrayList<>();
     //usuwa gre jak sie skonczy
    public static void removeGame(String name){
    	if(games.containsKey(name)){
    		games.remove(name);
    	}
    }
    //usuwa graczowi scoreboarda
    public static void removeSB(Player p){
    	ScoreboardManager manager = Bukkit.getScoreboardManager();

    	p.setScoreboard(manager.getNewScoreboard());
    	
    }
    
    
    //dodaje gracza do skorborda
    @SuppressWarnings("deprecation")
	public static void addPlayerToGameSb(Player p, String name){
        ScoreboardManager sbm = Bukkit.getScoreboardManager();
        Scoreboard sb = sbm.getNewScoreboard();
        Team red = sb.registerNewTeam("Red");
        Team green = sb.registerNewTeam("Green");
        Team blue = sb.registerNewTeam("Blue");
        Team yellow = sb.registerNewTeam("Purple");
        red.setPrefix("§c");
        green.setPrefix("§a");
        blue.setPrefix("§b");
        yellow.setPrefix("§5");
        Objective objective = sb.registerNewObjective("info", "dummy");
        objective.setDisplayName("§l§6Czas - §3100");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore(Bukkit.getOfflinePlayer("§l§cRED : ")).setScore(0);
        objective.getScore(Bukkit.getOfflinePlayer("§l§aGREEN : ")).setScore(0);
        objective.getScore(Bukkit.getOfflinePlayer("§l§bBLUE : ")).setScore(0);
        objective.getScore(Bukkit.getOfflinePlayer("§l§5PURPLE : ")).setScore(0);
        p.setScoreboard(sb);
        
        if(!(games.containsKey(name))){
        	List<Player> list = new ArrayList<Player>();
        	games.put(name, list);
        }
        
        List<Player> players = games.get(name);
        players.add(p);
        games.remove(name);
        games.put(name, players);
    }
     //reloaduje kolory nickow
    public static void reloadTeamSb(){
        		for(List<Player> c : games.values()){
        			for(Player o : c){
            Scoreboard sb = o.getScoreboard();
            for(Player red : RedPlayers){
            	if(!(sb.getTeam("Red").hasPlayer(red))){
                sb.getTeam("Red").addPlayer(red);
            	}
            }
            for(Player green : GreenPlayers){
            	if(!(sb.getTeam("Green").hasPlayer(green))){
                sb.getTeam("Green").addPlayer(green);
            	}
            }
            for(Player blue : BluePlayers){
            	if(!(sb.getTeam("Blue").hasPlayer(blue))){
                sb.getTeam("Blue").addPlayer(blue);
            	}
            }
            for(Player purple : PurplePlayers){
            	if(!(sb.getTeam("Purple").hasPlayer(purple))){
                sb.getTeam("Purple").addPlayer(purple);
            	}
            }
        }
       	}
    }
     //reloaduje info o grze
    @SuppressWarnings("deprecation")
	public static void reloadTeamSize(String name){
    	 for(Entry<String, List<Player>> c : games.entrySet()){
         	if(c.getKey().equalsIgnoreCase(name)){
         		for(Player o : c.getValue()){
         			Objective objective = o.getScoreboard().getObjective("info");
            objective.getScore(Bukkit.getOfflinePlayer("§l§cRED : ")).setScore(main.map_game.get(name).getTeamRed().size());
            objective.getScore(Bukkit.getOfflinePlayer("§l§aGREEN : ")).setScore(main.map_game.get(name).getTeamGreen().size());
            objective.getScore(Bukkit.getOfflinePlayer("§l§bBLUE : ")).setScore(main.map_game.get(name).getTeamBlue().size());
            objective.getScore(Bukkit.getOfflinePlayer("§l§5PURPLE : ")).setScore(main.map_game.get(name).getTeamPurple().size());
        }
    	 }
    }
    }
    
    //reloaduje info o czasie
	public static void reloadTime(String name, int time){
    	 for(Entry<String, List<Player>> c : games.entrySet()){
         	if(c.getKey().equalsIgnoreCase(name)){
         		for(Player o : c.getValue()){
         			Objective objective = o.getScoreboard().getObjective("info");
         	        objective.setDisplayName("§l§6Czas - §3" + time);
        }
    	 }
    }
    }
     
    public static void addPlayerToTeamRed(Player p){
        removePlayerFromTeams(p);
        RedPlayers.add(p);
        reloadTeamSb();
    }
     
    public static void addPlayerToTeamGreen(Player p){
        removePlayerFromTeams(p);
        GreenPlayers.add(p);
        reloadTeamSb();
    }
     
    public static void addPlayerToTeamBlue(Player p){
        removePlayerFromTeams(p);
        BluePlayers.add(p);
        reloadTeamSb();
    }
     
    public static void addPlayerToTeamPurple(Player p){
        removePlayerFromTeams(p);
        PurplePlayers.add(p);
        reloadTeamSb();
    }
     
    public static void removePlayerFromTeams(Player p){
        RedPlayers.remove(p);
        GreenPlayers.remove(p);
        BluePlayers.remove(p);
        PurplePlayers.remove(p);
        reloadTeamSb();
    }
     
    public static void removePlayerFromArena(Player p, String name){
    	if(games.containsKey(name)){
    				List<Player> s = games.get(name);
    				s.remove(p);
    				games.remove(name);
    				games.put(name, s);
    	}
		removePlayerFromTeams(p);

    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*//sb1-scoreboard wyswietlajacy gameinfo
	public static Scoreboard sb1 = Bukkit.getScoreboardManager().getMainScoreboard();

	@SuppressWarnings("deprecation")
	public static void reloadSB(String name, int i) {
		int index = main.map_info.get(name);
		if(main.map_game.get(index) != null){
	    if(sb1.getObjective("info") == null ){
			Objective obj = sb1.registerNewObjective("info", "dummy");
		    obj.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Czas - " + ChatColor.AQUA + i);
		    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	    }	    
	    if(sb1.getTeam(name) == null){
	    sb1.registerNewTeam(name);
		List<String> red = main.map_game.get(index).getTeamRed();
		List<String> blue = main.map_game.get(index).getTeamBlue();
		List<String> green = main.map_game.get(index).getTeamGreen();
		List<String> purple = main.map_game.get(index).getTeamPurple();
	    
	    for(String s : red){
	    	Player p = Bukkit.getPlayer(s);
	    	if(sb1.getTeam(name).hasPlayer(p) == false){
	    sb1.getTeam(name).addPlayer(p);
	    	}
	    }
	    for(String s : blue){
	    	Player p = Bukkit.getPlayer(s);
	    	if(sb1.getTeam(name).hasPlayer(p) == false){
	    sb1.getTeam(name).addPlayer(p);
	    	}
	    }
	    for(String s : green){
	    	Player p = Bukkit.getPlayer(s);
	    	if(sb1.getTeam(name).hasPlayer(p) == false){
	    sb1.getTeam(name).addPlayer(p);
	    	}
	    }
	    for(String s : purple){
	    	Player p = Bukkit.getPlayer(s);
	    	if(sb1.getTeam(name).hasPlayer(p) == false){
	    sb1.getTeam(name).addPlayer(p);
	    	}
	    }
	    }
		Objective objective = sb1.getObjective("info");
	    
		List<String> red = main.map_game.get(index).getTeamRed();
		List<String> blue = main.map_game.get(index).getTeamBlue();
		List<String> green = main.map_game.get(index).getTeamGreen();
		List<String> purple = main.map_game.get(index).getTeamPurple();
		
	    objective.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Czas - " + ChatColor.AQUA + i);

	    Score score = objective.getScore(Bukkit.getOfflinePlayer((ChatColor.BOLD + "" + ChatColor.RED + " RED : ")));
	    score.setScore(red.size());
	    Score score1 = objective.getScore(Bukkit.getOfflinePlayer((ChatColor.BOLD + "" + ChatColor.GREEN + " GREEN : ")));
	    score1.setScore(green.size());
	    Score score2 = objective.getScore(Bukkit.getOfflinePlayer((ChatColor.BOLD + "" + ChatColor.BLUE + " BLUE : ")));
	    score2.setScore(blue.size());
	    Score score3 = objective.getScore(Bukkit.getOfflinePlayer((ChatColor.BOLD + "" + ChatColor.DARK_PURPLE + " PURPLE : ")));
	    score3.setScore(purple.size());
	    
	    /*if(main.map_game.get(index) != null && sb1.getTeam(name) != null){
			
		    for(String s : red){
		    	Player p = Bukkit.getPlayer(s);
		    	if(sb1.getTeam(name).hasPlayer(p) == false){
		    sb1.getTeam(name).addPlayer(p);
		    	}
		    }
		    for(String s : blue){
		    	Player p = Bukkit.getPlayer(s);
		    	if(sb1.getTeam(name).hasPlayer(p) == false){
		    sb1.getTeam(name).addPlayer(p);
		    	}
		    }
		    for(String s : green){
		    	Player p = Bukkit.getPlayer(s);
		    	if(sb1.getTeam(name).hasPlayer(p) == false){
		    sb1.getTeam(name).addPlayer(p);
		    	}
		    }
		    for(String s : purple){
		    	Player p = Bukkit.getPlayer(s);
		    	if(sb1.getTeam(name).hasPlayer(p) == false){
		    sb1.getTeam(name).addPlayer(p);
		    	}
		    }
	    }*/
	    
			/*if(main.map_game.get(index) == null && sb1.getTeam(name) != null){
				
			    for(String s : red){
			    	Player p = Bukkit.getPlayer(s);
			    	sb1.getTeam(name).removePlayer(p);
			    }
			    for(String s : blue){
			    	Player p = Bukkit.getPlayer(s);
			    	sb1.getTeam(name).removePlayer(p);

			    }
			    for(String s : green){
			    	Player p = Bukkit.getPlayer(s);
			    	sb1.getTeam(name).removePlayer(p);

			    }
			    for(String s : purple){
			    	Player p = Bukkit.getPlayer(s);
			    	sb1.getTeam(name).removePlayer(p);

			    }
				
				sb1.getTeam(name).unregister();
			}
		}
	}
	
	
	//scoreboard od kolorkow nickow w teamach
	
	//scoreaboard
	
		static Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();

		public static void loadSC(Player player) {
		    String nick = player.getName();
		    Boolean remove = true;
		    
			for(Integer i : main.map_game.keySet()){

				
				List<String> red = main.map_game.get(i).getTeamRed();
				List<String> blue = main.map_game.get(i).getTeamBlue();
				List<String> green = main.map_game.get(i).getTeamGreen();
				List<String> purple = main.map_game.get(i).getTeamPurple();				
				
				if(red.contains(nick) || blue.contains(nick) || green.contains(nick) || purple.contains(nick)){
					if(sb.getTeam(nick) == null){
					    sb.registerNewTeam(nick); 
					    }
					    if(sb.getTeam(nick).hasPlayer(player) == false){
					    sb.getTeam(nick).addPlayer(player);
					    }
					    
				if(red.contains(nick)){
		    sb.getTeam(nick).setPrefix(ChatColor.RED + "");
		    remove = false;
		    
				}
				
				else if(blue.contains(nick)){

					    sb.getTeam(nick).setPrefix(ChatColor.BLUE + "");
					    remove = false;

				}
				
				else if(green.contains(nick)){

				    sb.getTeam(nick).setPrefix(ChatColor.GREEN + "");
				    remove = false;

						}
				
				else if(purple.contains(nick)){

				    sb.getTeam(nick).setPrefix(ChatColor.DARK_PURPLE + "");
				    remove = false;

				}
				}
			}
			if(remove == true){
			if(sb.getTeam(nick) != null){
	    	scoreboard.sb.getTeam(nick).removePlayer(player);
	    	scoreboard.sb.getTeam(nick).unregister();
		}
			}
		    
		}
}*/
