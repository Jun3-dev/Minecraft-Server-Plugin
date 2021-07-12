package com.gokuGman7345.Plugin1.commands1;

import com.gokuGman7345.Plugin1.Items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class customitemcommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Only Players can use this!");
            return  true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("givewand")) {
            player.getInventory().addItem(ItemManager.wand);
        }


        if (cmd.getName().equalsIgnoreCase("giveaxe")) {
            player.getInventory().addItem(ItemManager.axe);
        }

        //if (cmd.getName().equalsIgnoreCase("giveradiant")) {
            //player.getInventory().addItem(ItemManager.Radiant);
        //}
        return false;
    }
}
