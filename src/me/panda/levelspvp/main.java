package me.panda.levelspvp;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;



import me.panda.commands.create;
import me.panda.commands.leave;
import me.panda.events.blockbreak;
import me.panda.events.chat;
import me.panda.events.death;
import me.panda.events.entitydmgbyentity;
import me.panda.events.interact;
import me.panda.events.left;
import me.panda.events.move;
import me.panda.events.respawn;
import me.panda.events.signchange;
import me.panda.events.tpfix;
import me.panda.methods.AutoMessage;
import me.panda.methods.MySQLDatabase;
import me.panda.methods.load;
import me.panda.objects.Arena;
import me.panda.objects.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class main extends JavaPlugin{
	public static String pref = (ChatColor.GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "LevelsPvP" + ChatColor.RESET + ChatColor.GRAY + "]");
    public static Logger log = Logger.getLogger("Minecraft");
    public static MySQLDatabase mysql;
    public static boolean MySQL = true;
    public static File configFile;
    public static FileConfiguration config;
    public static main plugin;
    
    //mapki z danymi
    public static Map<String, Arena> map_arena = new HashMap<String, Arena>();
    //info loc tabliczek do dolaczania
    public static Map<String, Location> map_join = new HashMap<String, Location>();
    //mapa z grami
    public static Map<String, Game> map_game = new HashMap<String, Game>();
    //lista osob w lobby do automessage na barapi
    public static ArrayList<String> lobby = new ArrayList<String>();
    //mapy uzywane przy tworzeniu aren
    public static Map<String, Integer> map_int = new HashMap<String, Integer>();
    public static Map<String, String> map_string = new HashMap<String, String>();
    
    //Lista osob ktore maja byc tepniete na spawn po respawnie
    public static ArrayList<String> tp_check = new ArrayList<String>();

    //to tez przy tworzeniu aren uzywane
    public static String name = null;
    public static String nickC = null;

    
    public void onEnable() {
    	plugin = this;
    	//====================================================================
    	configFile = new File(getDataFolder(), "config.yml");
    	
    	try {
            firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	
    	config = new YamlConfiguration();
    	loadYamls();
    	//===================================================================
    	
    	if (getConfig().getString("MySQL.Host") == null) {
              MySQL = false;
              addLog(pref + "MySQL-ustaw host w configu");
              System.exit(1);
            }
            if (getConfig().getString("MySQL.User") == null) {
              MySQL = false;
              addLog(pref + "MySQL-ustaw usera w configu");
              System.exit(1);            }
            if (getConfig().getString("MySQL.Password") == null) {
              MySQL = false;
              addLog(pref + "MySQL-ustaw haslo w configu");
              System.exit(1);            }
            if (getConfig().getString("MySQL.Database") == null) {
              MySQL = false;
              addLog(pref + "MySQL-ustaw nazwe bazy danych w configu");
              System.exit(1);            }
            if (getConfig().getString("MySQL.Port") == null) {
                  MySQL = false;
                  addLog(pref + "MySQL-ustaw port w configu");
                  System.exit(1);                }

            if (MySQL) {
            	main.mysql = new MySQLDatabase(this, getConfig().getString("MySQL.Host"), getConfig().getString("MySQL.User"), getConfig().getString("MySQL.Port"), getConfig().getString("MySQL.Password"), getConfig().getString("MySQL.Database"));
              addLog(pref + "MySQL-Laczenie...");
              try
              {
            	  main.mysql.open();
              } catch (Exception e) {
                addLog(pref + "MySQL-probemy z laczeniem..." + e.getMessage());
              }

              if (main.mysql.checkConnection()) {
                addLog(pref + "MySQL-pomyslnie polaczono z baza danych");

                if (!main.mysql.checkTable("LevelsPvPArena")) {
                 addLog(pref + "MySQL- Tabela 'LevelsPvPArena' nie istnieje. Tworzenie...");
                  String query = "CREATE TABLE LevelsPvPArena (name text, spawnLoc text, spawnX int, loc1Red text, loc1Blue text, loc1Green text, loc1Purple text, time1 int, X1 int, loc2Red text, loc2Blue text, loc2Green text, loc2Purple text, time2 int, loc3Red text, loc3Blue text, loc3Green text, loc3Purple text, time3 int, loc4Red text, loc4Blue text, loc4Green text, loc4Purple text, time4 int, X5 int, time5 int, loc5Red text, loc5Blue text, loc5Green text, loc5Purple text)";
                  main.mysql.createTable(query);
                }
                if (!main.mysql.checkTable("LevelsPvPJoin")) {
                    addLog(pref + "MySQL- Tabela 'LevelsPvPJoin' nie istnieje. Tworzenie...");
                     String query = "CREATE TABLE LevelsPvPJoin (name text, world text, x int, y int, z int)";
                     main.mysql.createTable(query);
                   }
              }
              else {
                addLog(pref + "MySQL-polaczenie nieudane");
              }
    	//====================================================================
              //rejestracja eventow
        Bukkit.getServer().getPluginManager().registerEvents(new blockbreak(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new chat(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new tpfix(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new death(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new entitydmgbyentity(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new interact(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new left(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new move(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new respawn(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new signchange(), this);


        //rejestracja komendy
        getCommand("lpvp").setExecutor(new create());
        //getCommand("lpvp").setExecutor(new reload()); 
       // getCommand("lpvp").setExecutor(new stopbug());  
        getCommand("opusc").setExecutor(new leave());

        //ladowanie do hashmapek z mysql danych
        load.loadArena();
        load.loadJoinSigns();
        //start threada z automessage w lobby levelsow
        AutoMessage.startAutoMessage();
        
        
        
    }
    }
	public void onDisable() {
		main.lobby.clear();
		main.map_game.clear();
    }
	
	
	//METHODS
	public static void addLog(String string){
		System.out.println(string); 
	}
	//-------------
    private void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //---------------
    public void saveYamls() {
        try {
            config.save(configFile);
        } catch (IOException e) {
        	addLog(pref + "blad przy zapisie pliku konfiguracyjnego");
            e.printStackTrace();
        }
    }
    //-----------------
    public void loadYamls() {
        try {
            config.load(configFile);
        } catch (Exception e) {
        	addLog(pref + "blad przy ladowaniu pliku konfiguracyjnego");
            e.printStackTrace();
        }
    }
    private void firstRun() throws Exception {
        if(!configFile.exists()){
        	addLog(pref + "brak pliku konfiguracyjnego. Generowanie...");
            configFile.getParentFile().mkdirs();
            copy(getResource("config.yml"), configFile);
        }  
    }
    
}