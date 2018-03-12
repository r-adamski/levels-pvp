package me.panda.events;

import java.util.ArrayList;
import java.util.List;

import me.panda.levelspvp.main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class interact implements Listener{

	//dolaczanie do areny
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
				
				Material block = e.getClickedBlock().getType();
			if(block == Material.SIGN || block == Material.SIGN_POST || block == Material.WALL_SIGN){
				Sign sign = (Sign) e.getClickedBlock().getState();
				if(sign.getLine(0).contains("LevelsPvP")){
					if(sign.getLine(3).contains("DOLACZ")){
				String s = ChatColor.stripColor(sign.getLine(2));
				
				String[] str = s.split("/");
				List<String> list = new ArrayList<String>();
				for(String i : str){
					list.add(i);
				}
							
				int value = Integer.parseInt(list.get(0));
				list.clear();
				
				if(value < Integer.parseInt(main.config.getString("ilosc"))){
					//normalnie jojnowanie
					me.panda.system.joingame.joinGame(p, sign);
					if(value == (Integer.parseInt(main.config.getString("ilosc"))) / 2){
						if(main.map_game.get(ChatColor.stripColor(sign.getLine(1))).getcountdown() == false){
						me.panda.system.starttimer.StartTimer(ChatColor.stripColor(sign.getLine(1)));
						}
					}
				}
				else if(value >= Integer.parseInt(main.config.getString("ilosc"))){
					if(p.hasPermission("smav.vip")){
						me.panda.system.joingame.joinGame(p, sign);
					//jojnowanie vipuf
					}
					else{
						p.sendMessage(main.pref + " Tylko vipy moga dolaczac do pelnych gier.");
						p.sendMessage(main.pref + " Zakup juz teraz konto " + ChatColor.BOLD + "" + ChatColor.GOLD + " VIP " + ChatColor.RESET + ChatColor.GRAY + " na naszej stronie ! " + ChatColor.GOLD + "http://smav.pl/");

					}
				}
				}
					else{
						p.sendMessage(main.pref + " Arena jest zajeta!");
					}
				}
			}
			}
			}
	
}
