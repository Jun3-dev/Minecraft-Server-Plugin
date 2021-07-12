package com.gokuGman7345.Plugin1.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Plugin1Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Only PLayers can use that command!");
            return true; }
        Player player = (Player) sender;


        if(cmd.getName().equalsIgnoreCase( "heal")) {
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.sendMessage("§e§l(!) §eYou Have Been Healed!");

        }

        if (cmd.getName().equalsIgnoreCase("feed")) {
            player.setFoodLevel(20);
            player.sendMessage("§e§l(!) §eYou Have been Fed");
        }

        if (cmd.getName().equalsIgnoreCase("fly")) {
            player.setAllowFlight(true);
            player.sendMessage("§e§l(!) §eYou feel like you can Fly!");
        }

        return true;
    }
}
