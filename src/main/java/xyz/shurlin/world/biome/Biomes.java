package xyz.shurlin.world.biome;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import xyz.shurlin.Shurlin;

public class Biomes {
    public static final Biome PEAR_FOREST;
    public static final Biome PARASOL_ANCIENT_FOREST;
    public static final Biome FIRE_LAND;

    private static Biome register(Identifier id, Biome biome){
        return Registry.register(BuiltinRegistries.BIOME, id, biome);
    }

    public static void registerAll() {
//        OverworldBiomes.addContinentalBiome(Biomes.PEAR_FOREST, OverworldClimate.TEMPERATE, 1D);
//        OverworldBiomes.setRiverBiome(Biomes.PEAR_FOREST, net.minecraft.world.biome.Biomes.RIVER);
//        OverworldBiomes.addContinentalBiome(Biomes.PARASOL_ANCIENT_FOREST, OverworldClimate.TEMPERATE, 0.6D);
//        OverworldBiomes.setRiverBiome(Biomes.PARASOL_ANCIENT_FOREST, net.minecraft.world.biome.Biomes.RIVER);

    }

    static {
        PEAR_FOREST = register(BiomeKeys.PEAR_FOREST_KEY.getValue(), ShurlinBiomeCreator.createPearForest());
        PARASOL_ANCIENT_FOREST = register(BiomeKeys.PARASOL_ANCIENT_FOREST_KEY.getValue(), ShurlinBiomeCreator.createParasolAncientForest());
        FIRE_LAND = register(BiomeKeys.FIRE_LAND_KEY.getValue(), ShurlinBiomeCreator.createFireLand());
    }
}
