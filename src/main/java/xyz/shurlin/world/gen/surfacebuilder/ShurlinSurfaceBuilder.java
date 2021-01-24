package xyz.shurlin.world.gen.surfacebuilder;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import xyz.shurlin.block.Blocks;

public class ShurlinSurfaceBuilder {
    public static final BlockState HOT_FIRE_DIRT;
    public static final BlockState HOT_FIRE_STONE;
    public static final TernarySurfaceConfig FIRE_LAND_CONFIG;

    static {
        HOT_FIRE_DIRT = Blocks.HOT_FIRE_DIRT.getDefaultState();
        HOT_FIRE_STONE = Blocks.HOT_FIRE_STONE.getDefaultState();
        FIRE_LAND_CONFIG = new TernarySurfaceConfig(HOT_FIRE_DIRT, HOT_FIRE_DIRT , HOT_FIRE_STONE);

    }

}
