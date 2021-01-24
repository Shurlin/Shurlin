package xyz.shurlin.world.gen.chunk;

import com.mojang.serialization.Codec;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;

public class ChunkGeneratorTypes {
    public static final Codec<HolyFarmerChunkGenerator> HOLY_PEAR_CHUNK_GENERATOR = HolyFarmerChunkGenerator.CODEC;

    private static void register(String registryName, Codec<HolyFarmerChunkGenerator> entry){
        Registry.register(Registry.CHUNK_GENERATOR, new Identifier(Shurlin.MODID, registryName), entry);
    }

    public static void registerAll() {
        register("holy_pear", HOLY_PEAR_CHUNK_GENERATOR);
    }
}
