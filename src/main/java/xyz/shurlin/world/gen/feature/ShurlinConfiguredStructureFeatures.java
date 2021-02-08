package xyz.shurlin.world.gen.feature;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import xyz.shurlin.structure.StructureKeys;

public class ShurlinConfiguredStructureFeatures {
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_OAK_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_BIRCH_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_DARK_OAK_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_ACACIA_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_SPRUCE_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_JUNGLE_TREE;
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> ANCIENT_PEAR_TREE;

    private static <FC extends FeatureConfig, F extends StructureFeature<FC>> ConfiguredStructureFeature<FC, F> register(Identifier id, ConfiguredStructureFeature<FC, F> configuredStructureFeature) {
        return BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, id, configuredStructureFeature);
    }

    static {
        ANCIENT_OAK_TREE = register(StructureKeys.ANCIENT_OAK_TREE.getValue(), StructureFeatures.ANCIENT_OAK_TREE.configure(DefaultFeatureConfig.INSTANCE));
        ANCIENT_BIRCH_TREE = register(StructureKeys.ANCIENT_BIRCH_TREE.getValue(), StructureFeatures.ANCIENT_BIRCH_TREE.configure(DefaultFeatureConfig.INSTANCE));
        ANCIENT_DARK_OAK_TREE = register(StructureKeys.ANCIENT_DARK_OAK_TREE.getValue(), StructureFeatures.ANCIENT_DARK_OAK_TREE.configure(DefaultFeatureConfig.INSTANCE));
        ANCIENT_ACACIA_TREE = register(StructureKeys.ANCIENT_ACACIA_TREE.getValue(), StructureFeatures.ANCIENT_ACACIA_TREE.configure(DefaultFeatureConfig.INSTANCE));
        ANCIENT_SPRUCE_TREE = register(StructureKeys.ANCIENT_SPRUCE_TREE.getValue(), StructureFeatures.ANCIENT_SPRUCE_TREE.configure(DefaultFeatureConfig.INSTANCE));
        ANCIENT_JUNGLE_TREE = register(StructureKeys.ANCIENT_JUNGLE_TREE.getValue(), StructureFeatures.ANCIENT_JUNGLE_TREE.configure(DefaultFeatureConfig.INSTANCE));
        ANCIENT_PEAR_TREE = register(StructureKeys.ANCIENT_PEAR_TREE.getValue(), StructureFeatures.ANCIENT_PEAR_TREE.configure(DefaultFeatureConfig.INSTANCE));
    }
}
