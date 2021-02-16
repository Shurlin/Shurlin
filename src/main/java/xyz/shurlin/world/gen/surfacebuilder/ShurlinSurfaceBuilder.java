package xyz.shurlin.world.gen.surfacebuilder;

import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import xyz.shurlin.Shurlin;
import xyz.shurlin.block.Blocks;

public class ShurlinSurfaceBuilder {
    public static final BlockState HOT_FIRE_DIRT;
    public static final BlockState HOT_FIRE_STONE;
    public static final TernarySurfaceConfig FIRE_LAND_CONFIG;

    private static <C extends SurfaceConfig, F extends SurfaceBuilder<C>> F register(String id, F surfaceBuilder) {
        return Registry.register(Registry.SURFACE_BUILDER, new Identifier(Shurlin.MODID, id), surfaceBuilder);
    }

    static {
        HOT_FIRE_DIRT = Blocks.HOT_FIRE_DIRT.getDefaultState();
        HOT_FIRE_STONE = Blocks.HOT_FIRE_STONE.getDefaultState();
        FIRE_LAND_CONFIG = new TernarySurfaceConfig(HOT_FIRE_DIRT, HOT_FIRE_STONE, HOT_FIRE_STONE);
    }

}
