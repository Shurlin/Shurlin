package xyz.shurlin.block.plant;

import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class BasicSaplingBlock extends SaplingBlock {
    public BasicSaplingBlock(ConfiguredFeature<TreeFeatureConfig, ?> treeFeatureConfig, Settings settings) {
        super(new Generator(treeFeatureConfig), settings);
    }

    static class Generator extends SaplingGenerator{
        private final ConfiguredFeature<TreeFeatureConfig, ?> treeFeatureConfig;

        Generator(ConfiguredFeature<TreeFeatureConfig, ?> treeFeatureConfig) {
            this.treeFeatureConfig = treeFeatureConfig;
        }

        @Override
        protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
            return this.treeFeatureConfig;
        }
    }
}
