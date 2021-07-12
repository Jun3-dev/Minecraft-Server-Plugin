package com.gokuGman7345.Plugin1.selectionscreenevents;

import com.gokuGman7345.Plugin1.inventories.SelectionScreen;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) { return; }
        if (e.getClickedInventory().getHolder() instanceof SelectionScreen) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) { return; }
            if (e.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                player.sendMessage(ChatColor.GREEN + "Thank you for agreeing to the server rules. Have fun!");
                player.closeInventory();

            }
            else if (e.getSlot() == 4) {
                player.sendMessage(ChatColor.AQUA + "Please make a selection!");
            }
            else if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                player.sendMessage(ChatColor.RED + "You Agree to the Rules to play on this server! Get out!");
                player.closeInventory();
                player.kickPlayer("You must follow the rules to play");
            }
        }
    }
}
