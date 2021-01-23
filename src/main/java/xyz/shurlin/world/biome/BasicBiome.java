package xyz.shurlin.world.biome;

import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;

public class BasicBiome extends Biome {
     public <SC extends SurfaceConfig> BasicBiome(SurfaceBuilder<SC> surfaceBuilder, SC config, Precipitation precipitation, Biome.Category category, float depth, float scale, float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, BiomeMoodSound sound) {
        super(new Settings()
                .configureSurfaceBuilder(surfaceBuilder, config)
                .precipitation(precipitation)
                .category(category)
                .depth(depth)
                .scale(scale)
                .temperature(temperature)
                .downfall(downfall)
                .effects(new BiomeEffects.Builder()
                        .waterColor(waterColor)
                        .waterFogColor(waterFogColor)
                        .fogColor(fogColor)
                        .moodSound(sound)
                        .build())
                .parent(null));
    }

    public BasicBiome(Biome.Category category, float depth, float scale, float temperature, float downfall) {
        this(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG, Precipitation.RAIN, category, depth, scale, temperature, downfall, 4159204, 329011, 12638463, BiomeMoodSound.CAVE);
    }
}
