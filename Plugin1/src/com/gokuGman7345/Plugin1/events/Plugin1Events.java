package com.gokuGman7345.Plugin1.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Plugin1Events implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to The Server! Have Fun!");
        player.sendMessage(ChatColor.GREEN + "(!)Please Follow the server rules at by doing /select");
    }
}
