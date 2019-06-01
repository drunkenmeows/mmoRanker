package me.drunkenmeows.mmoranker;

import java.util.HashMap;
import java.util.logging.Logger;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class MmoRanker extends JavaPlugin {
	public HashMap<String,Integer> ranks = new HashMap<String,Integer>();
	public Permission permission = null;
	public final Logger logger = Logger.getLogger("Minecraft");
	public String prefix = "[mmoranker] ";
	
	@Override
	public void onDisable() {
	    getServer().getPluginManager().disablePlugin(this);
	}

	@Override
	public void onEnable() {
	
		this.setupPermissions();
		
		ranks.put("wayfarer", 50);
		ranks.put("pioneer", 250);
		ranks.put("settler", 1250);
		ranks.put("citizen", 5000);
		ranks.put("noble", 10000);

		getServer().getPluginManager().registerEvents(new PowerListener(this), this);
		
		this.logger.info(prefix+"Auto ranking for MCMMO Powerlevel enabled.");
	}
	
	public void onReload() {
	    getServer().getPluginManager().disablePlugin(this);
	    getServer().getPluginManager().enablePlugin(this);
	}
		
	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		this.permission = ((Permission)rsp.getProvider());
			
		return this.permission != null;
	}

}
