package org.bukkit.craftbukkit.entity;

import com.google.common.base.Preconditions;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EntityEnderSignal;
import net.minecraft.server.Items;
import org.bukkit.Location;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.entity.EnderSignal;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class CraftEnderSignal extends CraftEntity implements EnderSignal {
    public CraftEnderSignal(CraftServer server, EntityEnderSignal entity) {
        super(server, entity);
    }

    @Override
    public EntityEnderSignal getHandle() {
        return (EntityEnderSignal) entity;
    }

    @Override
    public String toString() {
        return "CraftEnderSignal";
    }

    @Override
    public EntityType getType() {
        return EntityType.ENDER_SIGNAL;
    }

    @Override
    public Location getTargetLocation() {
        return new Location(getWorld(), getHandle().targetX, getHandle().targetY, getHandle().targetZ, getHandle().yaw, getHandle().pitch);
    }

    @Override
    public void setTargetLocation(Location location) {
        Preconditions.checkArgument(getWorld().equals(location.getWorld()), "Cannot target EnderSignal across worlds");
        getHandle().a(new BlockPosition(location.getX(), location.getY(), location.getZ()));
    }

    @Override
    public boolean getDropItem() {
        return getHandle().shouldDropItem;
    }

    @Override
    public void setDropItem(boolean shouldDropItem) {
        getHandle().shouldDropItem = shouldDropItem;
    }

    @Override
    public ItemStack getItem() {
        return CraftItemStack.asBukkitCopy(getHandle().getItem());
    }

    @Override
    public void setItem(ItemStack item) {
        getHandle().setItem(item != null ? CraftItemStack.asNMSCopy(item) : Items.ENDER_EYE.createItemStack());
    }

    @Override
    public int getDespawnTimer() {
        return getHandle().despawnTimer;
    }

    @Override
    public void setDespawnTimer(int time) {
        getHandle().despawnTimer = time;
    }
}
