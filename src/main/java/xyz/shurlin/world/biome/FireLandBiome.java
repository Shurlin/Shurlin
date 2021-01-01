package xyz.shurlin.world.biome;

import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import xyz.shurlin.world.gen.feature.ShurlinBiomeFeatures;
import xyz.shurlin.world.gen.surfacebuilder.ShurlinSurfaceBuilder;

class FireLandBiome extends BasicBiome {
    FireLandBiome() {
        super(SurfaceBuilder.DEFAULT, ShurlinSurfaceBuilder.FIRE_LAND_CONFIG, Precipitation.NONE,Category.PLAINS, 0.1f, 0.1f, 2.0f, 0f, 4159204, 329011, 12638463, BiomeMoodSound.CAVE);
        DefaultBiomeFeatures.addLandCarvers(this);//TODO
        ShurlinBiomeFeatures.addHotSprings(this);
    }
}
