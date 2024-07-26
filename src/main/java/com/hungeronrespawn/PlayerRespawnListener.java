package com.hungeronrespawn;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.entity.Player;

public class PlayerRespawnListener implements Listener {
    private final HungerOnRespawn plugin;

    public PlayerRespawnListener(HungerOnRespawn plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("hungeronrespawn.bypass")) {
            return;
        }
        int hungerLevel = plugin.getHungerLevel();
        player.setFoodLevel(hungerLevel);
    }
}
