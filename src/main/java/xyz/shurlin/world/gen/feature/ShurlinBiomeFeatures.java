package xyz.shurlin.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.GenerationSettings.Builder;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class ShurlinBiomeFeatures {

    public static void addPearTrees(Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShurlinConfiguredFeatures.TREES_PEAR);
    }

    public static void addAncientPearTrees(Builder builder) {
//        builder.feature(GenerationStep.Feature.SURFACE_STRUCTURES, ShurlinConfiguredFeatures.ANCIENT_PEAR_TREE);
    }

    public static void addMysteriousStonePillar(Builder builder){
        builder.feature(GenerationStep.Feature.SURFACE_STRUCTURES,
                Features.MYSTERIOUS_STONE_PILLAR_FEATURE
                        .configure(new DefaultFeatureConfig())
                        .decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(100)))
        );
    }

    public static void addPlantObsidianHeap(Builder builder){
        builder.feature(GenerationStep.Feature.SURFACE_STRUCTURES,
                Features.PLANT_OBSIDIAN_HEAP
                        .configure(new DefaultFeatureConfig())
                        .decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(150)))
        );
    }

    public static void addPhoenixTrees(Builder builder){
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShurlinConfiguredFeatures.TREES_PHOENIX
//                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(8, 0.1F, 1)))
        );
    }

    public static void addSmallBud(Builder builder){
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShurlinConfiguredFeatures.SMALL_BUD

        );
    }

    public static void addPlatycodonGrandiflorus(Builder builder){
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ShurlinConfiguredFeatures.PLATYCODON_GRANDIFLORUS);
    }

    public static void addBlock(Builder builder, Block block, int tries) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.configure(getConfig(block.getDefaultState(), tries)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP));
    }

    private static RandomPatchFeatureConfig getConfig(BlockState state, int tries){
        return (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(state), SimpleBlockPlacer.INSTANCE)).tries(32).build();
    }

    public static void addHotSprings(Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SPRING_LAVA.decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(5))));
    }
}
