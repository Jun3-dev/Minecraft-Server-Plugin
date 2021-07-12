package com.gokuGman7345.Plugin1.events1;

import com.gokuGman7345.Plugin1.Items.ItemManager;
import net.minecraft.server.v1_16_R2.WorldServer;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
public class CustomItemEvents implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getItem() != null) {   
                if(event.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.getWorld().createExplosion(player.getLocation(), 2.8f);
                    player.sendMessage("§6You Have Harnessed the Power of The Stick of Truth!");
                }
            }
        }


        else if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if(event.getItem() != null) {
                if(event.getItem().getItemMeta().equals(ItemManager.axe.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.getWorld().strikeLightning(player.getLocation());
                    player.sendMessage("§6[Insert ominous message]");
                }
            }
        }


        //else if (event.getAction() == Action.LEFT_CLICK_AIR) {
            //if(event.getItem() != null) {
                //if(event.getItem().getItemMeta().equals(ItemManager.Radiant.getItemMeta())) {
                    //Player player = event.getPlayer();a

    }
}
