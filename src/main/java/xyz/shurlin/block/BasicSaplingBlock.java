package xyz.shurlin.block;

import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

class BasicSaplingBlock extends SaplingBlock {
    BasicSaplingBlock(ConfiguredFeature<TreeFeatureConfig, ?> treeFeatureConfig, Settings settings) {
        super(new Generator(treeFeatureConfig), settings);
    }

    private static class Generator extends SaplingGenerator{
        private ConfiguredFeature<TreeFeatureConfig, ?> treeFeatureConfig;

        Generator(ConfiguredFeature<TreeFeatureConfig, ?> treeFeatureConfig) {
            this.treeFeatureConfig = treeFeatureConfig;
        }

        @Override
        protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
            return this.treeFeatureConfig;
        }
    }
}
