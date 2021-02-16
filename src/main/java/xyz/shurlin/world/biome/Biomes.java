package xyz.shurlin.world.biome;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class Biomes {
    public static final Biome PEAR_FOREST;
    public static final Biome PARASOL_ANCIENT_FOREST;
    public static final Biome FIRE_LAND;

    private static Biome register(Identifier id, Biome biome){
        return Registry.register(BuiltinRegistries.BIOME, id, biome);
    }

    public static void load() {
        OverworldBiomes.addContinentalBiome(BiomeKeys.PEAR_FOREST_KEY, OverworldClimate.TEMPERATE, 1.2D);
        OverworldBiomes.addContinentalBiome(BiomeKeys.FIRE_LAND_KEY, OverworldClimate.TEMPERATE, 0.6D);
//        OverworldBiomes.setRiverBiome(Biomes.PEAR_FOREST, net.minecraft.world.biome.Biomes.RIVER);
        OverworldBiomes.addContinentalBiome(BiomeKeys.PARASOL_ANCIENT_FOREST_KEY, OverworldClimate.TEMPERATE, 0.6D);
//        OverworldBiomes.setRiverBiome(Biomes.PARASOL_ANCIENT_FOREST, net.minecraft.world.biome.Biomes.RIVER);

    }

    static {
        PEAR_FOREST = register(BiomeKeys.PEAR_FOREST_KEY.getValue(), ShurlinBiomeCreator.createPearForest());
        PARASOL_ANCIENT_FOREST = register(BiomeKeys.PARASOL_ANCIENT_FOREST_KEY.getValue(), ShurlinBiomeCreator.createParasolAncientForest());
        FIRE_LAND = register(BiomeKeys.FIRE_LAND_KEY.getValue(), ShurlinBiomeCreator.createFireLand());
    }
}
