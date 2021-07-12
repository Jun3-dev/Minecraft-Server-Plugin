package com.gokuGman7345.Plugin1;

import com.gokuGman7345.Plugin1.Items.ItemManager;
import com.gokuGman7345.Plugin1.commands.Plugin1Commands;
import com.gokuGman7345.Plugin1.commands1.customitemcommands;
import com.gokuGman7345.Plugin1.custommobevents.BlockPlace;
import com.gokuGman7345.Plugin1.custommobevents.EntityDamage;
import com.gokuGman7345.Plugin1.custommobevents.EntityDeath;
import com.gokuGman7345.Plugin1.events.Plugin1Events;
import com.gokuGman7345.Plugin1.events1.CustomItemEvents;
import com.gokuGman7345.Plugin1.listeners.JoinEvent;
import com.gokuGman7345.Plugin1.selectionscreencommands.SelectionScreenCommands;
import com.gokuGman7345.Plugin1.selectionscreenevents.InventoryEvents;
import com.gokuGman7345.Plugin1.svenlisteners.SpawnEntity;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.Container;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.*;


public final class Plugin1 extends JavaPlugin implements Listener {

    public static Inventory kits;
    public List<ItemStack> stolenItems = new ArrayList<>();

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        Plugin1Commands commands = new Plugin1Commands();
        getServer().getPluginManager().registerEvents(new CustomItemEvents(), this);
        ItemManager.init();
        getCommand("givewand").setExecutor(new customitemcommands());
        getServer().getPluginManager().registerEvents(new Plugin1Events(), this);
        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getServer().getConsoleSender().sendMessage( ChatColor.GREEN + "[PLugin1] Plugin Enabled!");
        getCommand("select").setExecutor(new SelectionScreenCommands());
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
        //getCommand("fly").setExecutor(commands);
        //getCommand("giveradiant").setExecutor(commands);
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new EntityDamage(), this);
        pm.registerEvents(new EntityDeath(this), this); 
        pm.registerEvents(new BlockPlace(this), this);
        createInventory();
        this.getServer().getPluginManager().registerEvents(new SpawnEntity(), this);
        //in seperate plugin called "uber items"
        CustomEnchants.register();
        this.getServer().getPluginManager().registerEvents(this, this);
        ScaryHandler handler = new ScaryHandler(this);
        handler.start();
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage( ChatColor.RED + "[Plugin1] Plugin Disabled!");

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("telepathy")) {
            if (!(sender instanceof Player))
                return true;
            Player player = (Player) sender;
            ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
            item.addUnsafeEnchantment(CustomEnchants.TELEPATHY, 1);
            item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY + "Telepathy I");   
            if (meta.hasLore())
                for (String l : meta.getLore())
                    lore.add(l);
            meta.setLore(lore);
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
            return true;
        }
        return true;
    }
    @EventHandler()
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand() == null)
            return;
        if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
            return;
        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.TELEPATHY))
            return;
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE || event.getPlayer().getGameMode() == GameMode.SPECTATOR)
            return;
        if (event.getPlayer().getInventory().firstEmpty() == -1)
            return;
        if (event.getBlock().getState() instanceof Container)
            return;

        event.setDropItems(false);
        Player player = event.getPlayer();
        Block block = event.getBlock();

        Collection<ItemStack> drops = block.getDrops(player.getInventory().getItemInMainHand());
        if (drops.isEmpty())
            return;
        player.getInventory().addItem(drops.iterator().next());
    }


    private void createInventory() {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Kits");
        ItemStack item = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.RED + "Click to get the kit!");
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        inv.setItem(2, item);


        item.setType(Material.IRON_HELMET);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Scout Kit");
        meta.setDisplayName(ChatColor.GRAY + "Noob kit");
        lore.add(" ");
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        inv.setItem(3, item);

        item.setType(Material.BOW);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Archer");
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        inv.setItem(4, item);

        item.setType(Material.SPLASH_POTION);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Brewer");
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        inv.setItem(5, item);


        item.setType(Material.DIAMOND_SWORD);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Supreme Kit");
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        inv.setItem(6, item);
        kits = inv;
    }

    //public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //if (label.equalsIgnoreCase("kits")) {
            //if (!(sender instanceof Player)) {
                //sender.sendMessage("Only Player's can use this");
                //return true;
            //}
//            Player player = (Player) sender;
//            player.openInventory(kits);
//            return true;w
//        }
//        return false;
//    }
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().contains("Kits"))
            return;
        if (event.getCurrentItem() == null)
            return;
        if (event.getCurrentItem().getItemMeta() == null)
            return;

        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        if(event.getClickedInventory().getType() == InventoryType.PLAYER)
            return;

        if (event.getSlot() == 2) {
            //Noob Kit
            if (!player.hasPermission("kits.noob")) {
                player.sendMessage("You do nor have permission to open this kit");
                return;
            }
            //drop chest
            this.dropChest(player, this.getNoobKit());
            player.closeInventory();
            player.updateInventory();
            return;
        }

        //

        if (event.getSlot() == 3) {
            //scout Kit
            if (!player.hasPermission("kits.scout")) {
                player.sendMessage("You do nor have permission to open this kit");
                return;
            }
            //drop chest
            this.dropChest(player, this.getScoutKit());
            player.closeInventory();
            player.updateInventory();
            return;
        }


        if (event.getSlot() == 4) {
            //archer Kit
            if (!player.hasPermission("kits.archer")) {
                player.sendMessage("You do nor have permission to open this kit");
                return;
            }
            //drop chest
            this.dropChest(player, this.getArcherKit());
            player.closeInventory();
            player.updateInventory();
            return;
        }


        if (event.getSlot() == 5) {
            //Noob Kit
            if (!player.hasPermission("kits.brewer")) {
                player.sendMessage("You do nor have permission to open this kit");
                return;
            }
            //drop chest
            player.closeInventory();
            player.updateInventory();
            return;
        }



        if (event.getSlot() == 6) {
            //Noob Kit
            if (!player.hasPermission("kits.supreme")) {
                player.sendMessage("You do nor have permission to open this kit");
                return;
            }
            //drop chest
            player.closeInventory();
            player.updateInventory();
            return;
        }


    }

    private void dropChest(Player player, ItemStack[] items) {
        Location chest = null;
        if (player.getFacing() == BlockFace.NORTH)
            chest = player.getLocation().add(0,0,-1);

        if (player.getFacing() == BlockFace.SOUTH)
            chest = player.getLocation().add(0,0,1);

        if (player.getFacing() == BlockFace.EAST)
            chest = player.getLocation().add(1,0,0);

        if (player.getFacing() == BlockFace.WEST)
            chest = player.getLocation().add(-1,0,0);
        

        if (chest.getBlock().getType() != Material.AIR) {
            player.sendMessage(ChatColor.RED + "Cannot open kits here!");
            return;
        }

        Block block = chest.getBlock();
        block.setType(Material.CHEST);
        Chest c = (Chest) block.getState();
        c.getInventory().addItem(items);

    }

    private ItemStack[] getNoobKit() {
        ItemStack[] items = {new ItemStack(Material.COAL, 16),
                             new ItemStack(Material.STONE_AXE, 1),
                             new ItemStack(Material.STONE_PICKAXE, 1),
                             new ItemStack(Material.LEATHER_CHESTPLATE, 1),
                             new ItemStack(Material.LEATHER_LEGGINGS, 1),
                             new ItemStack(Material.COOKED_BEEF, 64),
                             };
        return items;
    }

    private ItemStack[] getScoutKit() {
        ItemStack[] items = {new ItemStack(Material.COAL, 16),
                new ItemStack(Material.IRON_AXE, 1),
                new ItemStack(Material.IRON_PICKAXE, 1),
                new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1),
                new ItemStack(Material.CHAINMAIL_LEGGINGS, 1 ),
                new ItemStack(Material.GOLDEN_BOOTS, 1),
                new ItemStack(Material.COOKED_BEEF, 64),
        };
        return items;
    }

    private ItemStack[] getArcherKit() {
        ItemStack[] items = {new ItemStack(Material.BOW, 1),
                new ItemStack(Material.IRON_AXE, 1),
                new ItemStack(Material.IRON_PICKAXE, 1),
                new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1),
                new ItemStack(Material.CHAINMAIL_LEGGINGS, 1),
                new ItemStack(Material.CHAINMAIL_BOOTS, 1),
                new ItemStack(Material.CHAINMAIL_HELMET, 1),
                new ItemStack(Material.SPECTRAL_ARROW, 64),
        };
        return items;

    }








}
