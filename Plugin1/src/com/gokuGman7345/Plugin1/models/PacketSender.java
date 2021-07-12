package com.gokuGman7345.Plugin1.models;

import net.minecraft.server.v1_16_R2.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import javax.swing.text.html.parser.Entity;

public class PacketSender {

    private final Player player;

    private final EntityPlayer npc;

    public PacketSender(Player player, EntityPlayer npc) {
        this.player = player;
        this.npc = npc;
    }

    public Player getPlayer() {
        return player;
    }

    public EntityPlayer getNpc() {
        return npc;
    }

    public void send() {
        PlayerConnection connection = ((CraftPlayer)getPlayer()).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, getNpc()));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(getNpc()));
        connection.sendPacket(new PacketPlayOutEntityHeadRotation(getNpc(), (byte) (getNpc().yaw * 256 / 360)));

    }

    public void remove() {
        PlayerConnection connection = ((CraftPlayer)getPlayer()).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, getNpc()));
        connection.sendPacket(new PacketPlayOutEntityDestroy(getNpc().getId()));

    }

    public void update(Location loc) {
        PlayerConnection connection = ((CraftPlayer) getPlayer()).getHandle().playerConnection;
        loc.setDirection(loc.getDirection().multiply(-1));
        connection.sendPacket(new PacketPlayOutEntityHeadRotation(getNpc(), (byte) (loc.getYaw() * 256 / 360)));

        connection.sendPacket(new PacketPlayOutEntity.PacketPlayOutEntityLook(getNpc().getId(), (byte) (loc.getYaw() * 256 / 360), (byte) (loc.getPitch() * 256 / 360), true));
        //check

    }
    
}