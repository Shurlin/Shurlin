package xyz.shurlin.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import xyz.shurlin.block.Blocks;

import java.util.OptionalInt;

public class ShurlinBiomeFeatures {
    public static final BlockState PEAR_LOG;
    public static final BlockState PEAR_LEAVES;
    public static final BlockState PEAR_RIPE_LEAVES;
    public static final BlockState PHOENIX_LOG;
    public static final BlockState PHOENIX_LEAVES;
    public static final BlockState SMALL_BUD;
    public static final BlockState PLATYCODON_GRANDIFLORUS;
    public static final WeightedBlockStateProvider PEAR_LEAVES_PROVIDER;
    public static final RandomPatchFeatureConfig SMALL_BUD_CONFIG;
    public static final RandomPatchFeatureConfig PLATYCODON_GRANDIFLORUS_CONFIG;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> PEAR_TREE_CONFIG;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> PHOENIX_TREE_CONFIG;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_OAK_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_BIRCH_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_DARK_OAK_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_ACACIA_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_SPRUCE_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_JUNGLE_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_PEAR_TREE;

    public static void addPearTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, PEAR_TREE_CONFIG.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))));
    }

    public static void addMysteriousStonePillar(Biome biome){
        biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES,
                Features.MYSTERIOUS_STONE_PILLAR_FEATURE
                        .configure(new DefaultFeatureConfig())
                        .createDecoratedFeature(Decorator.CHANCE_HEIGHTMAP.configure(new ChanceDecoratorConfig(100)))
        );
    }

    public static void addPlantObsidianHeap(Biome biome){
        biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES,
                Features.PLANT_OBSIDIAN_HEAP
                        .configure(new DefaultFeatureConfig())
                        .createDecoratedFeature(Decorator.CHANCE_HEIGHTMAP.configure(new ChanceDecoratorConfig(150)))
        );
    }

    public static void addPhoenixTrees(Biome biome){
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, PHOENIX_TREE_CONFIG.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(8, 0.1F, 1))));
    }

    public static void addSmallBud(Biome biome){
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.configure(SMALL_BUD_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
    }

    public static void addPlatycodonGrandiflorus(Biome biome){
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.configure(PLATYCODON_GRANDIFLORUS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
    }



    public static void addBlock(Biome biome, Block block, int count){
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.configure(getConfig(block.getDefaultState(), 1)).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(count))));
    }

    private static RandomPatchFeatureConfig getConfig(BlockState state, int tries){
        return (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(state), SimpleBlockPlacer.field_24871)).tries(tries).build();
    }

    static {
        PEAR_LOG = Blocks.PEAR_LOG.getDefaultState();
        PEAR_LEAVES = Blocks.PEAR_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true);
        PEAR_RIPE_LEAVES = Blocks.PEAR_RIPE_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true);
        PHOENIX_LOG = Blocks.PHOENIX_LOG.getDefaultState();
        PHOENIX_LEAVES = Blocks.PHOENIX_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true);
        SMALL_BUD = Blocks.SMALL_BUD.getDefaultState();
        PLATYCODON_GRANDIFLORUS = Blocks.PLATYCODON_GRANDIFLORUS.getDefaultState();
        PEAR_LEAVES_PROVIDER = new WeightedBlockStateProvider().addState(PEAR_LEAVES, 9).addState(PEAR_RIPE_LEAVES, 1);
        SMALL_BUD_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(SMALL_BUD), SimpleBlockPlacer.field_24871)).tries(32).build();
        PLATYCODON_GRANDIFLORUS_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(PLATYCODON_GRANDIFLORUS), SimpleBlockPlacer.field_24871)).tries(4).build();
        PEAR_TREE_CONFIG =  Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PEAR_LOG), PEAR_LEAVES_PROVIDER, new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(5, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).build());
        PHOENIX_TREE_CONFIG =  Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PHOENIX_LOG), new SimpleBlockStateProvider(PHOENIX_LEAVES), new DarkOakFoliagePlacer(0, 0, 0, 0), new DarkOakTrunkPlacer(6, 2, 1), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))).ignoreVines().build());
        ANCIENT_OAK_TREE = StructureFeatures.ANCIENT_OAK_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_BIRCH_TREE = StructureFeatures.ANCIENT_BIRCH_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_DARK_OAK_TREE = StructureFeatures.ANCIENT_DARK_OAK_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_ACACIA_TREE = StructureFeatures.ANCIENT_ACACIA_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_SPRUCE_TREE = StructureFeatures.ANCIENT_SPRUCE_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_JUNGLE_TREE = StructureFeatures.ANCIENT_JUNGLE_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_PEAR_TREE = StructureFeatures.ANCIENT_PEAR_TREE.configure(DefaultFeatureConfig.INSTANCE);
    }
}
