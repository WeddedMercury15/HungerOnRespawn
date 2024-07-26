package com.hungeronrespawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class HungerOnRespawnTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            if (sender.hasPermission("hungeronrespawn.reload")) {
                completions.add("reload");
            }
            if (sender.hasPermission("hungeronrespawn.help")) {
                completions.add("help");
            }
        }

        return completions;
    }
}
