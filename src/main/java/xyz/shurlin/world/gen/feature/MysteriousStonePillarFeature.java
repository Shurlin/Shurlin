package xyz.shurlin.world.gen.feature;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.bytes.Byte2ObjectOpenCustomHashMap;
import net.minecraft.block.BlockState;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.StructureFeature;
import xyz.shurlin.Shurlin;
import xyz.shurlin.block.Blocks;

import java.util.Random;

public class MysteriousStonePillarFeature extends Feature<DefaultFeatureConfig> {
    public MysteriousStonePillarFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ServerWorldAccess serverWorldAccess, StructureAccessor accessor, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        pos = pos.north(Shurlin.random.nextInt(16)).east(Shurlin.random.nextInt(16));
//        int y = serverWorldAccess.getTopY(Heightmap.Type.WORLD_SURFACE_WG, pos.getX(), pos.getZ());
//        pos = pos.down(pos.getY() - y);
        pos = serverWorldAccess.getTopPosition(Heightmap.Type.WORLD_SURFACE_WG, pos);
        BlockState state = Blocks.MYSTERIOUS_STONE.getDefaultState();
        serverWorldAccess.setBlockState(pos.north(), state, 3);
        serverWorldAccess.setBlockState(pos.south(), state, 3);
        serverWorldAccess.setBlockState(pos.west(), state, 3);
        serverWorldAccess.setBlockState(pos.east(), state, 3);
        for(int i=0;i<8;i++){
            serverWorldAccess.setBlockState(pos.up(i), state, 3);
        }
//        Shurlin.LOGGER.debug(pos);
        return true;
    }
}
