package com.gokuGman7345.Plugin1.custommobevents;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityDamage implements Listener {

    private ItemStack[] goldsack = {
            new ItemStack(Material.GOLD_NUGGET, 16),
            new ItemStack(Material.GOLD_BLOCK, 2),
            new ItemStack(Material.GOLDEN_AXE, 1),
            new ItemStack(Material.IRON_INGOT, 16),
            new ItemStack(Material.IRON_HELMET, 1),
            new ItemStack(Material.ENDER_PEARL, 16),
            new ItemStack(Material.GOLDEN_APPLE, 2),

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
