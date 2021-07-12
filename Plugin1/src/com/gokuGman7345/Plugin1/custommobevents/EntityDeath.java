package com.gokuGman7345.Plugin1.custommobevents;

import com.gokuGman7345.Plugin1.Plugin1;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityDeath implements Listener {

    private Plugin1 plugin;
    public EntityDeath(Plugin1 plugin) {
        this.plugin = plugin;
    }

    private ItemStack[] goldsack = {
            new ItemStack(Material.GOLD_NUGGET, 64),
            new ItemStack(Material.GOLD_BLOCK, 10),
            new ItemStack(Material.GOLDEN_AXE, 1),
            new ItemStack(Material.DIAMOND, 16),
            new ItemStack(Material.DIAMOND_LEGGINGS, 1),
            new ItemStack(Material.ENDER_PEARL, 16),
            new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 2),

    };


    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if(!(event.getEntity() instanceof Villager))
            return;
        if (event.getEntity().getCustomName() == null)
            return;
        if(!event.getEntity().getCustomName().contains("Mugger"))
            return;

        Random r = new Random();
        event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), goldsack[r.nextInt(goldsack.length + 0) - 0]);


    }
}
