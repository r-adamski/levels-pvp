package me.panda.events;
 

import org.bukkit.event.Listener;
 
public class tpfix implements Listener {
/*private final static int TELEPORT_FIX_DELAY = 40; // <--                                  ticki

//event od refreshowania plejeruw po teleporcie zeby nie byli niewidzialni
@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
public void onPlayerTeleport(PlayerTeleportEvent event) {
 
 final Player p = event.getPlayer();
if(IsIn.IsInGame(p) == true){
	fixtp(p);					
}
}


public static void fixtp(final Player player){
	final int visibleDistance = Bukkit.getServer().getViewDistance() * 16;

	
	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
		@Override
		public void run() {
		// refresz plejerów po s¹siedzku
		final List<Player> nearby = getPlayersWithin(player, visibleDistance);
		// ukrywamy graczy
		updateEntities(nearby, false);
		// pokazujemy pobliskich
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.plugin, new Runnable() {
		@Override
		public void run() {
		updateEntities(nearby, true);
		}
		}, 1);
		}
		}, TELEPORT_FIX_DELAY);
}


private static void updateEntities(List<Player> players, boolean visible) {
for (Player observer : players) {
for (Player player : players) {
if (observer.getEntityId() != player.getEntityId()) {
if (visible == true){
observer.showPlayer(player);
}
else{
observer.hidePlayer(player);
}
}
}
}
}
private static List<Player> getPlayersWithin(Player player, int distance) {
List<Player> res = new ArrayList<Player>();
int d2 = distance * distance;
 
for (Player p : Bukkit.getServer().getOnlinePlayers()) {
if (p.getWorld() == player.getWorld()
&& p.getLocation().distanceSquared(player.getLocation()) <= d2) {
res.add(p);
}
}
 
return res;
}*/
}