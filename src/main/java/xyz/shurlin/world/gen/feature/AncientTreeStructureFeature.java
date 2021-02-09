package xyz.shurlin.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;
import xyz.shurlin.structure.AncientTreeFeatureConfig;
import xyz.shurlin.structure.AncientTreePiece;

public class AncientTreeStructureFeature extends StructureFeature<AncientTreeFeatureConfig> {

    AncientTreeStructureFeature(Codec<AncientTreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public GenerationStep.Feature getGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

//    @Override
//    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long l, ChunkRandom chunkRandom, int i, int j, Biome biome, ChunkPos chunkPos, AncientTreeFeatureConfig featureConfig) {
//        return chunkRandom.nextInt(100) == 0;
//    }

    @Override
    public StructureStartFactory<AncientTreeFeatureConfig> getStructureStartFactory() {
        return AncientTreeStructureFeature.Start::new;
    }

    public class Start extends StructureStart<AncientTreeFeatureConfig> {

        Start(StructureFeature<AncientTreeFeatureConfig> feature, int chunkX, int chunkZ, BlockBox box, int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, int chunkX, int chunkZ, Biome biome, AncientTreeFeatureConfig config) {
            int i = chunkX * 16;
            int j = chunkZ * 16;
            BlockPos blockPos = new BlockPos(i, 0, j);
            AncientTreePiece.addPieces(manager, blockPos, this.children, config.treeKind);
            this.setBoundingBoxFromChildren();
        }
    }
}
