package com.gokuGman7345.Plugin1.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SelectionScreen implements InventoryHolder {

    private Inventory inv;

    public SelectionScreen() {
        inv = Bukkit.createInventory(this, 9,  "Selection Screen"); //54 max size
        init();

    }

    private void init() {
        ItemStack item;
        // left
        for (int i = 0; i < 4; i++) {
            item = createItem("§a§lI Agree to the Server Rules", Material.LIME_STAINED_GLASS_PANE, Collections.singletonList("§7Click me if you agree to the server rules"));
            inv.setItem(i, item);

        }

        //Center
        List<String> lore = new ArrayList<>();
        lore.add("§7Please select Green if you agree");
        lore.add("§7To the server rules");
        lore.add("§7or Red if you disagree");
        item = createItem("§b§lMake a Selection", Material.BOOK, lore);
        inv.setItem(inv.firstEmpty(), item);

        //Right
        for (int i = 5; i < 9; i++) {
            item = createItem("§c§lI do not agree to the server Rules", Material.RED_STAINED_GLASS_PANE, Collections.singletonList("§7Click me if you do nto agree to the server rules"));
            inv.setItem(i, item);

        }

    }


    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }


    @Override
    public Inventory getInventory() {
        return inv;
    }
}
