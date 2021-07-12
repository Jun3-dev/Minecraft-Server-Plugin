package com.gokuGman7345.Plugin1.custommobevents;

import com.gokuGman7345.Plugin1.Plugin1;
import com.gokuGman7345.Plugin1.mobs.Theif;
import net.minecraft.server.v1_16_R2.WorldServer;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockPlace implements Listener {

    private Plugin1 plugin;
    public BlockPlace(Plugin1 plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (!event.getBlock().getType().equals(Material.GOLD_BLOCK))
            return;


        Random r = new Random();
        if ((r.nextInt(1000 + 0) - 0) > 100)
            return;

        Theif dirtyJoe = new Theif(event.getPlayer().getLocation());
        WorldServer world = (((CraftWorld) event.getPlayer().getWorld()).getHandle());
        world.addEntity(dirtyJoe);

        event.setCancelled(true);


        for (ItemStack item : event.getPlayer().getInventory().getContents())
            plugin.stolenItems.add(item);


        event.getPlayer().getInventory().clear();
    }
}
