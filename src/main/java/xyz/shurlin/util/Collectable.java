package xyz.shurlin.util;

import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public interface Collectable {
    int getConsistence(World world, Vec3i pos);//100

    int getTime();
}
