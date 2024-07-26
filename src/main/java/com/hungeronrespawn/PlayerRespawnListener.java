package com.hungeronrespawn;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.entity.Player;

public class PlayerRespawnListener implements Listener {

    private final HungerOnRespawnPlugin plugin;

    public PlayerRespawnListener(HungerOnRespawnPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        if (player.hasPermission("hungeronrespawn.bypass")) {
            return; // 如果玩家有 bypass 权限，则跳过饱食度设置
        }

        int hungerLevel = plugin.getHungerLevel();
        player.setFoodLevel(hungerLevel);
    }
}
