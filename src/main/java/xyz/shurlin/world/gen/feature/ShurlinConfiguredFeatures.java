package xyz.shurlin.world.gen.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
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

public class ShurlinConfiguredFeatures {
    public static final ConfiguredFeature<TreeFeatureConfig, ?> PEAR_TREE;
    public static final ConfiguredFeature<TreeFeatureConfig, ?> PHOENIX_TREE;
    public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> SMALL_BUD;
    public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> PLATYCODON_GRANDIFLORUS;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_OAK_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_BIRCH_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_DARK_OAK_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_ACACIA_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_SPRUCE_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_JUNGLE_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_PEAR_TREE;
    public static final ConfiguredFeature<?,?> ORE_PLANT_IRON;
    public static final ConfiguredFeature<?,?> ORE_PLANT_GOLD;

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, configuredFeature);
    }

    private static ConfiguredFeature<?, ?> createOre(RuleTest ruleTest, BlockState state, int size, int numPerChunk, int maxy) {
        return Feature.ORE.configure(new OreFeatureConfig(ruleTest, state, size)) // vein size
                        .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                                0, // bottom offset
                                0, // min y level
                                maxy))) // max y level
                        .repeat(numPerChunk); // number of veins per chunk
    }

    static {
        PEAR_TREE = Feature.TREE.configure(Configs.PEAR_TREE_CONFIG);
        PHOENIX_TREE = Feature.TREE.configure(Configs.PHOENIX_TREE_CONFIG);
        SMALL_BUD = Feature.RANDOM_PATCH.configure(Configs.SMALL_BUD_CONFIG);
        PLATYCODON_GRANDIFLORUS = Feature.RANDOM_PATCH.configure(Configs.PLATYCODON_GRANDIFLORUS_CONFIG);
        ANCIENT_OAK_TREE = StructureFeatures.ANCIENT_OAK_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_BIRCH_TREE = StructureFeatures.ANCIENT_BIRCH_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_DARK_OAK_TREE = StructureFeatures.ANCIENT_DARK_OAK_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_ACACIA_TREE = StructureFeatures.ANCIENT_ACACIA_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_SPRUCE_TREE = StructureFeatures.ANCIENT_SPRUCE_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_JUNGLE_TREE = StructureFeatures.ANCIENT_JUNGLE_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ANCIENT_PEAR_TREE = StructureFeatures.ANCIENT_PEAR_TREE.configure(DefaultFeatureConfig.INSTANCE);
        ORE_PLANT_IRON = createOre(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, States.PLANT_IRON_ORE_BLOCK,6, 6, 32);
        ORE_PLANT_GOLD = createOre(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, States.PLANT_IRON_ORE_BLOCK,6, 6, 32);
    }

    private static final class Configs{
        private static final TreeFeatureConfig PEAR_TREE_CONFIG;
        private static final TreeFeatureConfig PHOENIX_TREE_CONFIG;
        private static final RandomPatchFeatureConfig SMALL_BUD_CONFIG;
        private static final RandomPatchFeatureConfig PLATYCODON_GRANDIFLORUS_CONFIG;

        static {
            PEAR_TREE_CONFIG = new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(States.PEAR_LOG),
                    new WeightedBlockStateProvider().addState(States.PEAR_LEAVES, 9).addState(States.PEAR_RIPE_LEAVES, 1),
                    new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3),
                    new StraightTrunkPlacer(5, 2, 0),
                    new TwoLayersFeatureSize(1, 0, 1)).build();
            PHOENIX_TREE_CONFIG =  new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(States.PHOENIX_LOG),
                    new SimpleBlockStateProvider(States.PHOENIX_LEAVES),
                    new DarkOakFoliagePlacer(UniformIntDistribution.of(0), UniformIntDistribution.of(0)),
                    new DarkOakTrunkPlacer(6, 2, 1),
                    new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).build();
            SMALL_BUD_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(States.SMALL_BUD), SimpleBlockPlacer.INSTANCE)).tries(32).build();
            PLATYCODON_GRANDIFLORUS_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(States.PLATYCODON_GRANDIFLORUS), SimpleBlockPlacer.INSTANCE)).tries(4).build();
        }
    }

    private static final class States{
        private static final BlockState PEAR_LOG;
        private static final BlockState PEAR_LEAVES;
        private static final BlockState PEAR_RIPE_LEAVES;
        private static final BlockState PHOENIX_LOG;
        private static final BlockState PHOENIX_LEAVES;
        private static final BlockState SMALL_BUD;
        private static final BlockState PLATYCODON_GRANDIFLORUS;
        private static final BlockState PLANT_IRON_ORE_BLOCK;
        private static final BlockState PLANT_GOLD_ORE_BLOCK;
        private static final BlockState PLANT_JADE_ORE_BLOCK;
        private static final BlockState TENUOUS_METAL_SPIRIT_ORE_BLOCK;
        private static final BlockState TENUOUS_WOOD_SPIRIT_ORE_BLOCK;
        private static final BlockState TENUOUS_WATER_SPIRIT_ORE_BLOCK;
        private static final BlockState TENUOUS_FIRE_SPIRIT_ORE_BLOCK;
        private static final BlockState TENUOUS_EARTH_SPIRIT_ORE_BLOCK;
        private static final BlockState TENUOUS_WIND_SPIRIT_ORE_BLOCK;
        private static final BlockState TENUOUS_LIGHT_SPIRIT_ORE_BLOCK;
        private static final BlockState TENUOUS_DARKNESS_SPIRIT_ORE_BLOCK;
        private static final BlockState TENUOUS_POISON_SPIRIT_ORE_BLOCK;
        private static final BlockState TENUOUS_LIGHTNING_SPIRIT_ORE_BLOCK;
        private static final BlockState TENUOUS_ICE_SPIRIT_ORE_BLOCK;
        private static final BlockState TENUOUS_TIME_SPACE_SPIRIT_ORE_BLOCK;

        static {
            PEAR_LOG = Blocks.PEAR_LOG.getDefaultState();
            PEAR_LEAVES = Blocks.PEAR_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true);
            PEAR_RIPE_LEAVES = Blocks.PEAR_RIPE_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true);
            PHOENIX_LOG = Blocks.PHOENIX_LOG.getDefaultState();
            PHOENIX_LEAVES = Blocks.PHOENIX_LEAVES.getDefaultState().with(LeavesBlock.PERSISTENT, true);
            SMALL_BUD = Blocks.SMALL_BUD.getDefaultState();
            PLATYCODON_GRANDIFLORUS = Blocks.PLATYCODON_GRANDIFLORUS.getDefaultState();
            PLANT_IRON_ORE_BLOCK = Blocks.PLANT_IRON_ORE_BLOCK.getDefaultState();
            PLANT_GOLD_ORE_BLOCK = Blocks.PLANT_GOLD_ORE_BLOCK.getDefaultState();
            PLANT_JADE_ORE_BLOCK = Blocks.PLANT_JADE_ORE_BLOCK.getDefaultState();
            TENUOUS_METAL_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_METAL_SPIRIT_ORE_BLOCK.getDefaultState();
            TENUOUS_WOOD_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_WOOD_SPIRIT_ORE_BLOCK.getDefaultState();
            TENUOUS_WATER_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_WATER_SPIRIT_ORE_BLOCK.getDefaultState();
            TENUOUS_FIRE_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_FIRE_SPIRIT_ORE_BLOCK.getDefaultState();
            TENUOUS_EARTH_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_EARTH_SPIRIT_ORE_BLOCK.getDefaultState();
            TENUOUS_WIND_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_WIND_SPIRIT_ORE_BLOCK.getDefaultState();
            TENUOUS_LIGHT_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_LIGHT_SPIRIT_ORE_BLOCK.getDefaultState();
            TENUOUS_DARKNESS_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_DARKNESS_SPIRIT_ORE_BLOCK.getDefaultState();
            TENUOUS_POISON_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_POISON_SPIRIT_ORE_BLOCK.getDefaultState();
            TENUOUS_LIGHTNING_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_LIGHTNING_SPIRIT_ORE_BLOCK.getDefaultState();
            TENUOUS_ICE_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_ICE_SPIRIT_ORE_BLOCK.getDefaultState();
            TENUOUS_TIME_SPACE_SPIRIT_ORE_BLOCK = Blocks.TENUOUS_TIME_SPACE_SPIRIT_ORE_BLOCK.getDefaultState();
        }
    }

    public static class OreGenerators{

    }
}
