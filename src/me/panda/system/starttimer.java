package me.panda.system;

import java.util.ArrayList;
import java.util.List;

import me.panda.levelspvp.main;
import me.panda.methods.scoreboard;
import me.panda.objects.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class starttimer {

	static boolean cd = false;

public static void StartTimer(final String name){																			
	List<String> red = main.map_game.get(name).getTeamRed();
	List<String> blue = main.map_game.get(name).getTeamBlue();
	List<String> green = main.map_game.get(name).getTeamGreen();
	List<String> purple = main.map_game.get(name).getTeamPurple();
	List<String> noteam = main.map_game.get(name).getNoTeam();
	
	main.map_game.remove(name);
	main.map_game.put(name, new Game(name, red, blue, green, purple, noteam, 0, true));
	
Thread t = new Thread(new Runnable(){
    @SuppressWarnings("deprecation")
	@Override
    public void run() {
    	for(int i = 100 ; i > 0 ; i--){
			
			
			
			List<String> red = main.map_game.get(name).getTeamRed();
			List<String> blue = main.map_game.get(name).getTeamBlue();
			List<String> green = main.map_game.get(name).getTeamGreen();
			List<String> purple = main.map_game.get(name).getTeamPurple();
			List<String> noteam = main.map_game.get(name).getNoTeam();
			
			ArrayList<String> all = new ArrayList<String>();
			all.clear();
		    for(String s : red){
		    	all.add(s);
		    }
		    for(String s : blue){
		    	all.add(s);
		    }
		    for(String s : green){
		    	all.add(s);
		    }
		    for(String s : purple){
		    	all.add(s);
		    }
		    for(String s : noteam){
		    	all.add(s);
		    }
			
			if(all.size() < Integer.parseInt(main.config.getString("ilosc")) / 2){
				Thread.currentThread().interrupt();
				scoreboard.reloadTime(name, 100);
				if(cd == false){
				cd = true;
				for(String s : all){
					if(Bukkit.getPlayer(s) != null){
					Bukkit.getPlayer(s).sendMessage(main.pref + " Odliczanie zostalo zatrzymane z powodu zbyt malej ilosci graczy.");
					
					}}
				}

					main.map_game.remove(name);
					main.map_game.put(name, new Game(name, red, blue, green, purple, noteam, 0, false));

			}
			else if(all.size() >= Integer.parseInt(main.config.getString("ilosc")) / 2 && all.size() <= Integer.parseInt(main.config.getString("ilosc")) / (1 + 1 / 4)){
				try {
					Thread.sleep(1400);
					scoreboard.reloadTime(name, i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(i == 42){
					for(String s : all){
						if(Bukkit.getPlayer(s) != null){

						Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpocznie sie za " + ChatColor.GOLD + " 60 Pando" + ChatColor.GRAY + "-sekund");
					}
					}
				}
				else if(i == 7){
					for(String s : all){
						if(Bukkit.getPlayer(s) != null){

						Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpocznie sie za " + ChatColor.GOLD + " 10 Pando" + ChatColor.GRAY + "-sekund");
					}
					}
				}
			}
			else if(all.size() > Integer.parseInt(main.config.getString("ilosc")) / (1 + 1 / 4) && all.size() <= Integer.parseInt(main.config.getString("ilosc")) / (1 + 1 / 2)){
			try {
				Thread.sleep(1000);
				scoreboard.reloadTime(name, i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i == 60){
				for(String s : all){
					if(Bukkit.getPlayer(s) != null){

					Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpocznie sie za " + ChatColor.GOLD + " 60 Pando" + ChatColor.GRAY + "-sekund");
				}
				}
			}
			else if(i == 10){
				for(String s : all){
					if(Bukkit.getPlayer(s) != null){

					Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpocznie sie za " + ChatColor.GOLD + " 10 Pando" + ChatColor.GRAY + "-sekund");
				}
				}
			}
			
			}
			else if(all.size() >= Integer.parseInt(main.config.getString("ilosc")) / (1 + 1 / 2) && all.size() <= Integer.parseInt(main.config.getString("ilosc"))){

				try {
					Thread.sleep(800);
					scoreboard.reloadTime(name, i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(i == 75){
					for(String s : all){
						if(Bukkit.getPlayer(s) != null){

						Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpocznie sie za " + ChatColor.GOLD + " 60 Pando" + ChatColor.GRAY + "-sekund");
					}
					}
				}
				else if(i == 12){
					for(String s : all){
						if(Bukkit.getPlayer(s) != null){

						Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpocznie sie za " + ChatColor.GOLD + " 10 Pando" + ChatColor.GRAY + "-sekund");
					}
					}
				}
				
			}
			else if(all.size() > Integer.parseInt(main.config.getString("ilosc"))){
				try {
					Thread.sleep(400);
					scoreboard.reloadTime(name, i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(i == 50){
					for(String s : all){
						if(Bukkit.getPlayer(s) != null){

						Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpocznie sie za " + ChatColor.GOLD + " 20 Pando" + ChatColor.GRAY + "-sekund");
					}
					}
				}
				else if(i == 25){
					for(String s : all){
						if(Bukkit.getPlayer(s) != null){

						Bukkit.getPlayer(s).sendMessage(main.pref + " Gra rozpocznie sie za " + ChatColor.GOLD + " 10 Pando" + ChatColor.GRAY + "-sekund");
					}
					}
				}
			}
							
			if(i == 1){
				if(!(all.size() < Integer.parseInt(main.config.getString("ilosc")) / 2)){
					
					
					
					//balans teamow tu !!!
					
					for(String s : all){
						if(Bukkit.getPlayer(s) != null){

						Bukkit.getPlayer(s).sendMessage(main.pref + " Wyrownywanie druzyn..");
					}
					}
					
					int size = Integer.parseInt(main.config.getString("ilosc"))/4;
					
					for(int z = 0 ; z < noteam.size() ; z++){
						String nick = noteam.get(z);
						Player p = Bukkit.getPlayer(nick);

						if(red.size() < size){
							red.add(nick);
							noteam.remove(nick);
							z--;
							scoreboard.addPlayerToTeamRed(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
						else if(blue.size() < size){
							blue.add(nick);
							noteam.remove(nick);
							z--;
							scoreboard.addPlayerToTeamBlue(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
						else if(green.size() < size){
							green.add(nick);
							noteam.remove(nick);
							z--;
							scoreboard.addPlayerToTeamGreen(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
						else if(purple.size() < size){
							purple.add(nick);
							noteam.remove(nick);
							z--;
							scoreboard.addPlayerToTeamPurple(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
						else if(Bukkit.getPlayer(nick).hasPermission("smav.vip")){ 
							blue.add(nick);
							noteam.remove(nick);
							z--;
							scoreboard.addPlayerToTeamBlue(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
					}
					
					for(int g = 0 ; g < all.size() ; g++){
						//balans red i blue
						if(red.size()-1 > blue.size()){
							String nick = red.get(red.size()-1);
							red.remove(nick);
							blue.add(nick);
							Player p = Bukkit.getPlayer(nick);
							scoreboard.addPlayerToTeamBlue(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
						else if(red.size() < blue.size()-1){
							String nick = blue.get(blue.size()-1);
							blue.remove(nick);
							red.add(nick);
							Player p = Bukkit.getPlayer(nick);
							scoreboard.addPlayerToTeamRed(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
						//balans green i purple
						if(green.size()-1 > purple.size()){
							String nick = green.get(green.size()-1);
							green.remove(nick);
							purple.add(nick);
							Player p = Bukkit.getPlayer(nick);
							scoreboard.addPlayerToTeamPurple(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
						else if(purple.size()-1 > green.size()){
							String nick = purple.get(purple.size()-1);
							purple.remove(nick);
							green.add(nick);
							Player p = Bukkit.getPlayer(nick);
							scoreboard.addPlayerToTeamGreen(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
						//balans red i green
						if(green.size()-1 > red.size()){
							String nick = green.get(green.size()-1);
							green.remove(nick);
							red.add(nick);
							Player p = Bukkit.getPlayer(nick);
							scoreboard.addPlayerToTeamRed(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
						else if(red.size()-1 > green.size()){
							String nick = red.get(red.size()-1);
							red.remove(nick);
							green.add(nick);
							Player p = Bukkit.getPlayer(nick);
							scoreboard.addPlayerToTeamGreen(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
						//balans blue i purple
						if(blue.size()-1 > purple.size()){
							String nick = blue.get(blue.size()-1);
							blue.remove(nick);
							purple.add(nick);
							Player p = Bukkit.getPlayer(nick);
							scoreboard.addPlayerToTeamPurple(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
						else if(purple.size()-1 > blue.size()){
							String nick = purple.get(purple.size()-1);
							purple.remove(nick);
							blue.add(nick);
							Player p = Bukkit.getPlayer(nick);
							scoreboard.addPlayerToTeamBlue(p);
							scoreboard.reloadTeamSb();
							scoreboard.reloadTeamSize(name);
						}
					}
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					for(String s : all){
						if(Bukkit.getPlayer(s) != null){

						Bukkit.getPlayer(s).sendMessage(main.pref + " Wyrownywanie druzyn zakonczone!");
					}
					}
					
					main.map_game.remove(name);
					main.map_game.put(name, new Game(name, red, blue, green, purple, noteam, 0, true));
					
				gameprocess.startGame(name);
				}
				if(cd == true){
					cd = false;
				}
			}	
		}
    }});
t.start();
}
	
}
