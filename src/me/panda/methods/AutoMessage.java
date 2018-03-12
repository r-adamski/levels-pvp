package me.panda.methods;


import java.util.List;

import org.bukkit.Bukkit;

import me.confuser.barapi.BarAPI;
import me.panda.levelspvp.main;


public class AutoMessage{
	 static int act = 0;

	 public static void startAutoMessage(){
		 Thread t = new Thread(new Runnable(){
             @SuppressWarnings({ "unchecked", "deprecation" })
			@Override
             public void run() {
             		try {
							Thread.sleep(main.config.getInt("time"));
							
							List<String> msg = (List<String>) main.config.getList("lista");
							
							int value = msg.size() - 1;
							float percent = 100 / value ;
							float pro = percent * act;
							
							String act_str = msg.get(act);
														
							for(String s : main.lobby){
								if(Bukkit.getPlayer(s) != null){
									if(pro != 0){
								BarAPI.setMessage(Bukkit.getPlayer(s), act_str, pro);
									}
									else{
										BarAPI.setMessage(Bukkit.getPlayer(s), act_str, 1);
									}
								}
								else{
									main.lobby.remove(s);
								}
							
							}
							
								 if(act == msg.size() - 1){
									 act = 0;
								 }
								 else{
									 act ++;
								 }
								 startAutoMessage();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
             }});
         t.start();
	 }
}
