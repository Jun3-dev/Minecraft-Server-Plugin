package com.gokuGman7345.Plugin1.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack wand;

    public static ItemStack axe;

    public static ItemStack dogwand;

    //public static ItemStack Radiant;



    public static void init() {
        createWand();
        createAxe();
        //createRadiant();
        createDogWand();
    }


     //Wand Item
    private static void createWand() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Stick of Truth");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: §c+10");
        lore.add("§7Magic Power §c+225");
        lore.add("  ");
        lore.add("§6Item Ability: Explode §e§lRIGHT CLICK");
        lore.add("§7Creates a large explosion,");
        lore.add("§7damaging players nearby and");
        lore.add("§7explodes blocks");;
        lore.add("   ");
        lore.add("§6§lLEGENDARY ITEM");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        wand = item;


        //Shaped recipe
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wand"), item);
        sr.shape("B  ",
                  " S ",
                    "  S");
        sr.setIngredient('B', Material.BLAZE_POWDER);
        sr.setIngredient('S', Material.STICK);

    }

    private static void createDogWand() {
        ItemStack item = new ItemStack(Material.CARROT_ON_A_STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6PACK SPAWN WAND");
        List<String> lore = new ArrayList<>();
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        dogwand = item;


        //Shaped recipe
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("dogwand"), item);
        sr.shape("D  ",
                " D ",
                "  D");
        sr.setIngredient('D', Material.DIAMOND);

    }



    //Axe Item

    private static void createAxe() {
        ItemStack item = new ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§d§lThunderlord Axe");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: §c+20");
        lore.add("§7Magic Power §c+300");
        lore.add("  ");
        lore.add("§6Item Ability: Thunder §e§lRIGHT CLICK");
        lore.add("§7When right clicking air");
        lore.add("§7Spawns a thunderbolt");
        lore.add("§7Be Careful!");
        lore.add("§7Its very §dUnstable");
        lore.add("   ");
        lore.add("§d§k§lM §d§lMYTHIC ITEM §d§k§lY");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        axe = item;


        //Shaped recipe
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("axe"), item);
        sr.shape("GDG","NAN","GDG");
        sr.setIngredient('G', Material.GLOWSTONE_DUST);
        sr.setIngredient('A', Material.NETHERITE_AXE);
        sr.setIngredient('N', Material.NETHERITE_BLOCK);
        sr.setIngredient('D', Material.DIAMOND_BLOCK);
        Bukkit.getServer().addRecipe(sr);
    }


    //private static void createRadiant() {
        //ItemStack item = new ItemStack(Material.EMERALD, 1);
        //ItemMeta meta = item.getItemMeta();
        //meta.setDisplayName("§a§lRADIANT POWER ORB");
        //List<String> lore = new ArrayList<>();
        //lore.add("§6Item Ability: Deploy §e§lLEFT CLICK");
        //lore.add("§7Gives the player extra hearts");
        //lore.add("§7and heals you");
        //lore.add("  ");
        //lore.add("§a§lUNCOMMON HEALING ITEM");
        //meta.setLore(lore);
        //meta.addEnchant(Enchantment.LUCK, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        //item.setItemMeta(meta);
        //Radiant = item;


        //Shaped recipe
        //ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("Radiant"), item);
        //sr.shape("GGG","GEG","GGG");
        //sr.setIngredient('E', Material.EMERALD_BLOCK);
        //sr.setIngredient('G', Material.GOLDEN_APPLE);
        //Bukkit.getServer().addRecipe(sr);
    //}





}