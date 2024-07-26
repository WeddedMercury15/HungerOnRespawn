package com.hungeronrespawn;

import org.bukkit.plugin.java.JavaPlugin;

public class HungerOnRespawn extends JavaPlugin {
    private int hungerLevel;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        hungerLevel = getConfig().getInt("hunger-level", 20);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(this), this);
        getCommand("reload").setExecutor(new CommandHandler(this));
        getCommand("help").setExecutor(new CommandHandler(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void reloadConfiguration() {
        reloadConfig();
        hungerLevel = getConfig().getInt("hunger-level", 20);
    }

    public int getHungerLevel() {
        return hungerLevel;
    }
}
