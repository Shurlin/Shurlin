package xyz.shurlin.world.gen.feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import xyz.shurlin.Shurlin;

import java.util.function.Predicate;

public class ShurlinOreFeatures {
    public static void load() {
    }

    public static final ConfiguredFeature<?, ?> ORE_PLANT_IRON;
    public static final ConfiguredFeature<?, ?> ORE_PLANT_GOLD;
    public static final ConfiguredFeature<?, ?> ORE_PLANT_JADE;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_METAL_SPIRIT;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_WOOD_SPIRIT;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_WATER_SPIRIT;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_FIRE_SPIRIT;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_EARTH_SPIRIT;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_WIND_SPIRIT;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_LIGHT_SPIRIT;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_DARKNESS_SPIRIT;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_POISON_SPIRIT;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_LIGHTNING_SPIRIT;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_ICE_SPIRIT;
    public static final ConfiguredFeature<?, ?> ORE_TENUOUS_TIME_SPACE_SPIRIT;

    private static ConfiguredFeature<?, ?> createOre(String registryName, BlockState state, int size, int numPerChunk, int maxy) {
        return createOre(registryName, OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, state, size, numPerChunk, maxy, BiomeSelectors.foundInOverworld());
    }

    private static ConfiguredFeature<?, ?> createOre(String registryName, BlockState state, int size, int numPerChunk, int maxy, RegistryKey<Biome> biomeKey) {
        return createOre(registryName, OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, state, size, numPerChunk, maxy, BiomeSelectors.includeByKey(biomeKey));
    }

    private static ConfiguredFeature<?, ?> createOre(String registryName, BlockState state, int size, int numPerChunk, int maxy, Biome.Category... categories) {
        return createOre(registryName, OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, state, size, numPerChunk, maxy, BiomeSelectors.categories(categories));
    }

    private static ConfiguredFeature<?, ?> createOre(String registryName, RuleTest ruleTest, BlockState state, int size, int numPerChunk, int maxy, Predicate<BiomeSelectionContext> selectors) {
        return createOre(registryName, ruleTest, state, size, numPerChunk, 0, maxy, selectors);
    }

    private static ConfiguredFeature<?, ?> createOre(String registryName, RuleTest ruleTest, BlockState state, int size, int numPerChunk, int topOffset, int maxy, Predicate<BiomeSelectionContext> selectors) {
        RegistryKey key = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(Shurlin.MODID, registryName));
        ConfiguredFeature<?, ?> ore = Feature.ORE.configure(new OreFeatureConfig(ruleTest, state, size)) // vein size
                .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                        0, // bottom offset
                        topOffset, // min y level
                        maxy))) // max y level
                .repeat(numPerChunk); // number of veins per chunk
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), ore);
        BiomeModifications.addFeature(selectors, GenerationStep.Feature.UNDERGROUND_ORES, key);
        return ore;
    }

    static {
        ORE_PLANT_IRON = createOre("ore_plant_iron", ShurlinConfiguredFeatures.States.PLANT_IRON_ORE_BLOCK, 6, 6, 48);
        ORE_PLANT_GOLD = createOre("ore_plant_gold", ShurlinConfiguredFeatures.States.PLANT_GOLD_ORE_BLOCK, 6, 4, 32);
        ORE_PLANT_JADE = createOre("ore_plant_jade", ShurlinConfiguredFeatures.States.PLANT_JADE_ORE_BLOCK, 4, 2, 16);
        ORE_TENUOUS_METAL_SPIRIT = createOre("ore_tenuous_metal_spirit", OreFeatureConfig.Rules.NETHERRACK, ShurlinConfiguredFeatures.States.TENUOUS_METAL_SPIRIT_ORE_BLOCK, 2, 2, 64, BiomeSelectors.foundInTheNether());
        ORE_TENUOUS_WOOD_SPIRIT = createOre("ore_tenuous_wood_spirit", ShurlinConfiguredFeatures.States.TENUOUS_WOOD_SPIRIT_ORE_BLOCK, 4, 4, 16, BiomeKeys.JUNGLE);
        ORE_TENUOUS_WATER_SPIRIT = createOre("ore_tenuous_water_spirit", ShurlinConfiguredFeatures.States.TENUOUS_WATER_SPIRIT_ORE_BLOCK, 2, 3, 16, BiomeKeys.WARM_OCEAN);
        ORE_TENUOUS_FIRE_SPIRIT = createOre("ore_tenuous_fire_spirit", OreFeatureConfig.Rules.NETHERRACK, ShurlinConfiguredFeatures.States.TENUOUS_FIRE_SPIRIT_ORE_BLOCK, 2, 2, 16, BiomeSelectors.foundInTheNether());
        ORE_TENUOUS_EARTH_SPIRIT = createOre("ore_tenuous_earth_spirit", ShurlinConfiguredFeatures.States.TENUOUS_EARTH_SPIRIT_ORE_BLOCK, 4, 2, 16, Biome.Category.EXTREME_HILLS);
        ORE_TENUOUS_WIND_SPIRIT = createOre("ore_tenuous_wind_spirit", ShurlinConfiguredFeatures.States.TENUOUS_WIND_SPIRIT_ORE_BLOCK, 2, 2, 16, Biome.Category.PLAINS);
        ORE_TENUOUS_LIGHT_SPIRIT = createOre("ore_tenuous_light_spirit", Rules.SAND, ShurlinConfiguredFeatures.States.TENUOUS_LIGHT_SPIRIT_ORE_BLOCK, 4, 2, 56, 72, BiomeSelectors.includeByKey(BiomeKeys.DESERT));
        ORE_TENUOUS_DARKNESS_SPIRIT = createOre("ore_tenuous_darkness_spirit", Rules.THEEND, ShurlinConfiguredFeatures.States.TENUOUS_DARKNESS_SPIRIT_ORE_BLOCK, 4, 4, 48, 80, BiomeSelectors.foundInTheEnd());
        ORE_TENUOUS_POISON_SPIRIT = createOre("ore_tenuous_poison_spirit", ShurlinConfiguredFeatures.States.TENUOUS_POISON_SPIRIT_ORE_BLOCK, 4, 2, 16, BiomeKeys.SWAMP);
        ORE_TENUOUS_LIGHTNING_SPIRIT = createOre("ore_tenuous_lightning_spirit", ShurlinConfiguredFeatures.States.TENUOUS_LIGHTNING_SPIRIT_ORE_BLOCK, 4, 2, 16, BiomeKeys.SNOWY_MOUNTAINS);
        ORE_TENUOUS_ICE_SPIRIT = createOre("ore_tenuous_ice_spirit", Rules.ICE, ShurlinConfiguredFeatures.States.TENUOUS_ICE_SPIRIT_ORE_BLOCK, 2, 3, 48, 64, BiomeSelectors.categories(Biome.Category.ICY));
        ORE_TENUOUS_TIME_SPACE_SPIRIT = createOre("ore_tenuous_time_space_spirit", Rules.THEEND, ShurlinConfiguredFeatures.States.TENUOUS_TIME_SPACE_SPIRIT_ORE_BLOCK, 4, 4, 48, 80, BiomeSelectors.foundInTheEnd());
    }

    private static final class Rules {
        private static final RuleTest THEEND;
        private static final RuleTest ICE;
        private static final RuleTest SAND;

        static {
            THEEND = new BlockMatchRuleTest(Blocks.END_STONE);
            ICE = new TagMatchRuleTest(BlockTags.ICE);
            SAND = new BlockMatchRuleTest(Blocks.SAND);
        }
    }
}
