package com.hungeronrespawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HungerOnRespawnCommandExecutor implements CommandExecutor {

    private final HungerOnRespawnPlugin plugin;

    public HungerOnRespawnCommandExecutor(HungerOnRespawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false; // Show usage
        }

        String subCommand = args[0];
        
        switch (subCommand.toLowerCase()) {
            case "reload":
                return handleReload(sender);
            case "help":
                return handleHelp(sender);
            default:
                return false; // Show usage
        }
    }

    private boolean handleReload(CommandSender sender) {
        if (sender.hasPermission("hungeronrespawn.reload")) {
            plugin.reloadPluginConfig();
            sender.sendMessage("Config reloaded.");
            return true;
        } else {
            sender.sendMessage("You do not have permission to reload.");
            return true;
        }
    }

    private boolean handleHelp(CommandSender sender) {
        sender.sendMessage("/hungeronrespawn reload - Reloads the plugin configuration.");
        sender.sendMessage("/hungeronrespawn help - Shows this help message.");
        return true;
    }
}
