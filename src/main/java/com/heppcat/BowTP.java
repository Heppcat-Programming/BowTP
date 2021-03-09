package com.heppcat;

import org.bukkit.plugin.java.JavaPlugin;


public class BowTP extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        this.getCommand("arrows").setExecutor(new GiveArrows());
        this.getCommand("bow").setExecutor(new GiveBow());
    }
}
