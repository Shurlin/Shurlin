package xyz.shurlin.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import xyz.shurlin.block.Blocks;

import java.util.Random;

public class MysteriousStonePillarFeature extends Feature<DefaultFeatureConfig> {
    public MysteriousStonePillarFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(StructureWorldAccess serverWorldAccess, ChunkGenerator chunkGenerator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        pos = pos.north(random.nextInt(16)).east(random.nextInt(16));
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
