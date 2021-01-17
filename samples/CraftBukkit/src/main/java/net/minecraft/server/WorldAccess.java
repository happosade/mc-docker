package net.minecraft.server;

public interface WorldAccess extends GeneratorAccess {

    WorldServer getMinecraftWorld();

    default void addAllEntities(Entity entity) {
        // CraftBukkit start
        this.addAllEntities(entity, org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason.DEFAULT);
    }

    default void addAllEntities(Entity entity, org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason reason) {
        entity.recursiveStream().forEach((e) -> this.addEntity(e, reason));
    }
    // CraftBukkit end
}
