package com.gokuGman7345.Plugin1.svenlisteners;

import com.gokuGman7345.Plugin1.mobs.WolfAlpha;
import net.minecraft.server.v1_16_R2.WorldServer;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.entity.Animals;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class SpawnEntity implements Listener {


    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        if (!(event.getEntity() instanceof Animals))
            return;
        if (event.getLocation().getBlock().isLiquid())
            return;
        if ((int) (Math.random() * 10) == 9) { // 0-9 10% chance to spawn (SUPER high)
            event.setCancelled(true);

            WolfAlpha pack = new WolfAlpha(event.getLocation());

            WorldServer world = ((CraftWorld)event.getLocation().getWorld()).getHandle();
                    world.addEntity(pack);

        }
    }
}