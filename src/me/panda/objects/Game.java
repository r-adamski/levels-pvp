package me.panda.objects;

import java.util.List;


public class Game {

    public String name;
    public List<String> red;
    public List<String> blue;
    public List<String> green;
    public List<String> purple;
    public List<String> noteam;
    public int round;
    public boolean countdown;
	
	
	
	
	public Game(String name, List<String> red, List<String> blue, List<String> green, List<String> purple, List<String> noteam, int round, boolean countdown
			){
		this.name = name;
		this.red = red;
		this.blue = blue;
		this.green = green;
		this.purple = purple;
		this.noteam = noteam;
		this.round = round;
		this.countdown = countdown;
    }
	public String getName(){ return this.name; }
	public List<String> getTeamRed(){ return this.red; }
	public List<String> getTeamBlue(){ return this.blue; }
	public List<String> getTeamGreen(){ return this.green; }
	public List<String> getTeamPurple(){ return this.purple; }
	public List<String> getNoTeam(){ return this.noteam; }
	public int getRound(){ return this.round; }
	public boolean getcountdown(){ return this.countdown; }
}
