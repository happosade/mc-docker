package org.bukkit.craftbukkit.tag;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.server.FluidType;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.Tags;
import org.bukkit.Fluid;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;

public class CraftFluidTag extends CraftTag<FluidType, Fluid> {

    public CraftFluidTag(Tags<FluidType> registry, MinecraftKey tag) {
        super(registry, tag);
    }

    @Override
    public boolean isTagged(Fluid fluid) {
        return getHandle().isTagged(CraftMagicNumbers.getFluid(fluid));
    }

    @Override
    public Set<Fluid> getValues() {
        return Collections.unmodifiableSet(getHandle().getTagged().stream().map(CraftMagicNumbers::getFluid).collect(Collectors.toSet()));
    }
}
