package com.hungeronrespawn;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class HungerOnRespawnPlugin extends JavaPlugin implements Listener {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        // Save default config if not exists
        saveDefaultConfig();
        config = getConfig();

        // Register event listener
        getServer().getPluginManager().registerEvents(this, this);

        // Register commands
        this.getCommand("hungeronrespawn").setExecutor(new HungerOnRespawnCommandExecutor(this));
        this.getCommand("hungeronrespawn").setTabCompleter(new HungerOnRespawnTabCompleter());
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        if (!event.getPlayer().hasPermission("hungeronrespawn.bypass")) {
            int hungerLevel = config.getInt("hunger-level", 20);
            event.getPlayer().setFoodLevel(hungerLevel);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void reloadPluginConfig() {
        reloadConfig();
        config = getConfig();
    }
}
