package me.drunkenmeows.mmoranker;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.nossr50.events.experience.McMMOPlayerLevelUpEvent;
import com.gmail.nossr50.api.ExperienceAPI;

public class PowerListener implements Listener {

	private static MmoRanker plugin;
	
	public PowerListener(MmoRanker instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerLevelUp(final McMMOPlayerLevelUpEvent event) {
	      
		  Player p = event.getPlayer();
	      int powerlevel = ExperienceAPI.getPowerLevel(p);
	      String currentgroup = plugin.permission.getPrimaryGroup(p).toLowerCase();
	      
	      if(currentgroup.equalsIgnoreCase("traveler")) {
	    	  if(powerlevel >= plugin.ranks.get(currentgroup)) {
	    		  plugin.permission.playerRemoveGroup(p, currentgroup);
	    		  plugin.permission.playerAddGroup(p, "pioneer");
	    		  p.sendMessage("Congratulations! You have reached "+plugin.permission.getPrimaryGroup(p)+", with a powerlevel of "+ powerlevel+".");
	    	  }

	      } else if(currentgroup.equalsIgnoreCase("pioneer")) {
	    	  if(powerlevel >= plugin.ranks.get(currentgroup)) {
	    		  plugin.permission.playerRemoveGroup(p, currentgroup);
	    		  plugin.permission.playerAddGroup(p, "settler");
	    		  p.sendMessage("Congratulations! You have reached "+plugin.permission.getPrimaryGroup(p)+", with a powerlevel of "+ powerlevel+".");
	    	  }	    	  
	      } else if(currentgroup.equalsIgnoreCase("settler")) {
	    	  if(powerlevel >= plugin.ranks.get(currentgroup)) {
	    		  plugin.permission.playerRemoveGroup(p, currentgroup);
	    		  plugin.permission.playerAddGroup(p, "citizen");
	    		  p.sendMessage("Congratulations! You have reached "+plugin.permission.getPrimaryGroup(p)+", with a powerlevel of "+ powerlevel+".");
	    	  }
	    	  
	      } else if(currentgroup.equalsIgnoreCase("citizen")) {
	    	  if(powerlevel >= plugin.ranks.get(currentgroup)) {
	    		  plugin.permission.playerRemoveGroup(p, currentgroup);
	    		  plugin.permission.playerAddGroup(p, "noble");
	    		  p.sendMessage("Congratulations! You have reached "+plugin.permission.getPrimaryGroup(p)+", with a powerlevel of "+ powerlevel+".");
	    	  }
	    	  
	      }

	  }
}
