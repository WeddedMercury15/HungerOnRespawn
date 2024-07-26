package com.hungeronrespawn;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class HungerOnRespawnPlugin extends JavaPlugin {

    private int hungerLevel;

    @Override
    public void onEnable() {
        saveDefaultConfig(); // 复制默认配置文件到插件目录
        loadConfig(); // 加载配置

        // Register commands
        this.getCommand("hungeronrespawn").setExecutor(new HungerOnRespawnCommandExecutor(this));
        this.getCommand("hungeronrespawn").setTabCompleter(new HungerOnRespawnTabCompleter());
        
        // Register events
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadConfig() {
        FileConfiguration config = getConfig();
        hungerLevel = config.getInt("hunger-level", 20); // 默认饱食度为20
    }

    public int getHungerLevel() {
        return hungerLevel;
    }
}
