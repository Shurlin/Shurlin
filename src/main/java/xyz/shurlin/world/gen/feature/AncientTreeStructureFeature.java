package xyz.shurlin.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import xyz.shurlin.Shurlin;
import xyz.shurlin.structure.AncientTreeData;
import xyz.shurlin.structure.AncientTreePiece;

public class AncientTreeStructureFeature extends StructureFeature<DefaultFeatureConfig> {
    private final AncientTreeData data;

    AncientTreeStructureFeature(Codec<DefaultFeatureConfig> codec, AncientTreeData data) {
        super(codec);
        this.data = data;
    }

    @Override
    public GenerationStep.Feature method_28663() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

    @Override
    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long l, ChunkRandom chunkRandom, int i, int j, Biome biome, ChunkPos chunkPos, DefaultFeatureConfig featureConfig) {
        return chunkRandom.nextInt(100) == 0;
    }

    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return AncientTreeStructureFeature.Start::new;
    }

    public class Start extends StructureStart<DefaultFeatureConfig>{

        Start(StructureFeature<DefaultFeatureConfig> feature, int chunkX, int chunkZ, BlockBox box, int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        @Override
        public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int x, int z, Biome biome, DefaultFeatureConfig DefaultFeatureConfig) {
            int i = x * 16;
            int j = z * 16;
            BlockPos blockPos = new BlockPos(i, 0, j);
            AncientTreePiece.addPieces(structureManager, blockPos, this.children, AncientTreeStructureFeature.this.data);
            this.setBoundingBoxFromChildren();
        }
    }
}
