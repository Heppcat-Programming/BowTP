package com.heppcat;

import com.heppcat.items.TPBowItem;
import org.bukkit.plugin.java.JavaPlugin;


public class BowTP extends JavaPlugin {
    @Override
    public void onEnable() {
        TPBowItem.Init();
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getCommand("bowtp").setExecutor(new MainCommand());
        getCommand("bowtp").setTabCompleter(new MainCommand());
    }
}
