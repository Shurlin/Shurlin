package xyz.shurlin.world.biome;

import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import xyz.shurlin.Shurlin;

public class Biomes {
    public static final Biome PEAR_FOREST;
    public static final Biome PARASOL_ANCIENT_FOREST;
    public static final Biome FIRE_LAND;

    private static Biome register(String registryName, Biome biome){
        return Registry.register(Registry.BIOME, new Identifier(Shurlin.MODID, registryName), biome);
    }

    public Biomes() {
        OverworldBiomes.addContinentalBiome(Biomes.PEAR_FOREST, OverworldClimate.TEMPERATE, 1D);
        OverworldBiomes.setRiverBiome(Biomes.PEAR_FOREST, net.minecraft.world.biome.Biomes.RIVER);
        OverworldBiomes.addContinentalBiome(Biomes.PARASOL_ANCIENT_FOREST, OverworldClimate.TEMPERATE, 0.6D);
        OverworldBiomes.setRiverBiome(Biomes.PARASOL_ANCIENT_FOREST, net.minecraft.world.biome.Biomes.RIVER);
        FabricBiomes.addSpawnBiome(Biomes.PEAR_FOREST);
        FabricBiomes.addSpawnBiome(Biomes.PARASOL_ANCIENT_FOREST);
    }

    static {
        PEAR_FOREST = register("pear_forest", new PearForestBiome());
        PARASOL_ANCIENT_FOREST = register("parasol_ancient_forest", new ParasolAncientForestBiome());
        FIRE_LAND = register("fire_land", new FireLandBiome());
    }
}
