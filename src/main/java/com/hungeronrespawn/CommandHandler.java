package com.hungeronrespawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class CommandHandler implements CommandExecutor {
    private final HungerOnRespawn plugin;

    public CommandHandler(HungerOnRespawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("reload")) {
            if (sender.hasPermission("hungeronrespawn.reload")) {
                plugin.reloadConfiguration();
                sender.sendMessage(ChatColor.GREEN + "HungerOnRespawn configuration reloaded.");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return true;
            }
        } else if (label.equalsIgnoreCase("help")) {
            if (sender.hasPermission("hungeronrespawn.help")) {
                sender.sendMessage(ChatColor.GOLD + "HungerOnRespawn Commands:");
                sender.sendMessage(ChatColor.YELLOW + "/reload - Reloads the plugin configuration.");
                sender.sendMessage(ChatColor.YELLOW + "/help - Displays this help message.");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return true;
            }
        }
        return false;
    }
}
