package xyz.shurlin.world.biome;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import xyz.shurlin.Shurlin;

public class BiomeKeys {
    public static final RegistryKey<Biome> PEAR_FOREST_KEY = register("pear_forest");
    public static final RegistryKey<Biome> PARASOL_ANCIENT_FOREST_KEY = register("parasol_ancient_forest");
    public static final RegistryKey<Biome> FIRE_LAND_KEY = register("fire_land");

    private static RegistryKey<Biome> register(String registryName){
        return RegistryKey.of(Registry.BIOME_KEY, new Identifier(Shurlin.MODID, registryName));
    }

}
