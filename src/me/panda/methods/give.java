package me.panda.methods;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class give {

	@SuppressWarnings("deprecation")
	public static void giveItems(Player p){
		Inventory inv = p.getInventory();
		 ItemStack is = new ItemStack(345, 1);
         ItemMeta im = is.getItemMeta();
         im.setDisplayName("§5§lWybierz Gre");
         is.setItemMeta(im);
         inv.addItem(is);
         ItemStack is1 = new ItemStack(378, 1);
         ItemMeta im1 = is1.getItemMeta();
         im1.setDisplayName("§a§lPokaz Graczy");
         is1.setItemMeta(im1);
         inv.addItem(is1);
         ItemStack is2 = new ItemStack(Material.EMERALD);
         ItemMeta im2 = is2.getItemMeta();
         im2.setDisplayName("§6§lVIP - informacje");
         is2.setItemMeta(im2);
         inv.addItem(is2);
	}
	
}
