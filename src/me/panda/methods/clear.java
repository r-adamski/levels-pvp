package me.panda.methods;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;

public class clear {

	public static void clearPlayer(Player p){
		
		Inventory inv = p.getInventory();
		inv.clear();
		p.getInventory().setBoots(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setHelmet(null);
		
		for(PotionEffect e : p.getActivePotionEffects()){
			p.removePotionEffect(e.getType());
		}
		
		p.setExp(0);
		
	}
	
}
