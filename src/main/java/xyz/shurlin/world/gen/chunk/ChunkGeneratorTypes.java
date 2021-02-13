package xyz.shurlin.world.gen.chunk;

import com.mojang.serialization.Codec;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;

public class ChunkGeneratorTypes {
    public static final Codec<HolyFarmerChunkGenerator> HOLY_PEAR_CHUNK_GENERATOR = register("holy_pear", HolyFarmerChunkGenerator.CODEC);

    private static Codec<HolyFarmerChunkGenerator> register(String registryName, Codec<HolyFarmerChunkGenerator> entry) {
        return Registry.register(Registry.CHUNK_GENERATOR, new Identifier(Shurlin.MODID, registryName), entry);
    }

    public static void load() {
    }
}
