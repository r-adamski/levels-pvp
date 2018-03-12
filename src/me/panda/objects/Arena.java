package me.panda.objects;

import org.bukkit.Location;

public class Arena {

    public String name;
    public Location spawnLoc;
    public int spawnX;
    public Location loc1Red;
    public Location loc1Blue;
    public Location loc1Green;
    public Location loc1Purple;
    public int time1;
    public int X;
    public Location loc2Red;
    public Location loc2Blue;
	public Location loc2Green;
	public Location loc2Purple;
	public int time2;
	public Location loc3Red;
	public Location loc3Blue;
	public Location loc3Green;
	public Location loc3Purple;
	public int time3;
	public Location loc4Red;
	public Location loc4Blue;
	public Location loc4Green;
	public Location loc4Purple;
	public int time4;
	public Location loc5Red;
	public Location loc5Blue;
	public Location loc5Green;
	public Location loc5Purple;
	public int time5;
	public int X5;
	
	
	
	
	public Arena(String name, Location spawnLoc, int spawnX, Location loc1Red, Location loc1Blue, Location loc1Green, Location loc1Purple, int time1, int X, 
			Location loc2Red, Location loc2Blue, Location loc2Green, Location loc2Purple, int time2, 
			Location loc3Red, Location loc3Blue, Location loc3Green, Location loc3Purple, int time3, 
			Location loc4Red, Location loc4Blue, Location loc4Green, Location loc4Purple, int time4, 
			Location loc5Red, Location loc5Blue, Location loc5Green, Location loc5Purple, int time5, int X5
			){
		this.name = name;
		this.spawnLoc = spawnLoc;
		this.spawnX = spawnX;
		this.loc1Red = loc1Red;
		this.loc1Blue = loc1Blue;
		this.loc1Green = loc1Green;
		this.loc1Purple = loc1Purple;
		this.time1 = time1;
		this.X = X;
		this.loc2Red = loc2Red;
		this.loc2Blue = loc2Blue;
		this.loc2Green = loc2Green;
		this.loc2Purple = loc2Purple;
		this.time2 = time2;
		this.loc3Red = loc3Red;
		this.loc3Blue = loc3Blue;
		this.loc3Green = loc3Green;
		this.loc3Purple = loc3Purple;
		this.time3 = time3;
		this.loc4Red = loc4Red;
		this.loc4Blue = loc4Blue;
		this.loc4Green = loc4Green;
		this.loc4Purple = loc4Purple;
		this.time4 = time4;
		this.loc5Red = loc5Red;
		this.loc5Blue = loc5Blue;
		this.loc5Green = loc5Green;
		this.loc5Purple = loc5Purple;
		this.time5 = time5;
		this.X5 = X5;
    }
	public String getName(){ return this.name; }
	public Location getSpawnLoc(){ return this.spawnLoc; }
	public int getSpawnRadius(){ return this.spawnX; }
	public Location getLoc1Red(){ return this.loc1Red; }
	public Location getLoc1Blue(){ return this.loc1Blue; }
	public Location getLoc1Green(){ return this.loc1Green; }
	public Location getLoc1Purple(){ return this.loc1Purple; }
	public int getTime1(){ return this.time1; }
	public int getLevelsRadius(){ return this.X; }
	public Location getLoc2Red(){ return this.loc2Red; }
	public Location getLoc2Blue(){ return this.loc2Blue; }
	public Location getLoc2Green(){ return this.loc2Green; }
	public Location getLoc2Purple(){ return this.loc2Purple; }
	public int getTime2(){ return this.time2; }
	public Location getLoc3Red(){ return this.loc3Red; }
	public Location getLoc3Blue(){ return this.loc3Blue; }
	public Location getLoc3Green(){ return this.loc3Green; }
	public Location getLoc3Purple(){ return this.loc3Purple; }
	public int getTime3(){ return this.time3; }
	public Location getLoc4Red(){ return this.loc4Red; }
	public Location getLoc4Blue(){ return this.loc4Blue; }
	public Location getLoc4Green(){ return this.loc4Green; }
	public Location getLoc4Purple(){ return this.loc4Purple; }
	public int getTime4(){ return this.time4; }
	public Location getLoc5Red(){ return this.loc5Red; }
	public Location getLoc5Blue(){ return this.loc5Blue; }
	public Location getLoc5Green(){ return this.loc5Green; }
	public Location getLoc5Purple(){ return this.loc5Purple; }
	public int getTime5(){ return this.time5; }
	public int getFightLevelRadius(){ return this.X5; }
	
}
