package xyz.shurlin.world.gen.feature;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import xyz.shurlin.structure.AncientTreeFeatureConfig;
import xyz.shurlin.structure.StructureKeys;

import static xyz.shurlin.structure.AncientTreeFeatureConfig.TreeKind;

public class ShurlinConfiguredStructureFeatures {
    public static final ConfiguredStructureFeature<AncientTreeFeatureConfig, ? extends StructureFeature<AncientTreeFeatureConfig>> ANCIENT_OAK_TREE;
    public static final ConfiguredStructureFeature<AncientTreeFeatureConfig, ? extends StructureFeature<AncientTreeFeatureConfig>> ANCIENT_BIRCH_TREE;
    public static final ConfiguredStructureFeature<AncientTreeFeatureConfig, ? extends StructureFeature<AncientTreeFeatureConfig>> ANCIENT_DARK_OAK_TREE;
    public static final ConfiguredStructureFeature<AncientTreeFeatureConfig, ? extends StructureFeature<AncientTreeFeatureConfig>> ANCIENT_ACACIA_TREE;
    public static final ConfiguredStructureFeature<AncientTreeFeatureConfig, ? extends StructureFeature<AncientTreeFeatureConfig>> ANCIENT_SPRUCE_TREE;
    public static final ConfiguredStructureFeature<AncientTreeFeatureConfig, ? extends StructureFeature<AncientTreeFeatureConfig>> ANCIENT_JUNGLE_TREE;
    public static final ConfiguredStructureFeature<AncientTreeFeatureConfig, ? extends StructureFeature<AncientTreeFeatureConfig>> ANCIENT_PEAR_TREE;

    private static <FC extends FeatureConfig, F extends StructureFeature<FC>> ConfiguredStructureFeature<FC, F> register(Identifier id, ConfiguredStructureFeature<FC, F> configuredStructureFeature) {
        return BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, id, configuredStructureFeature);
    }

    static {
        ANCIENT_OAK_TREE = register(StructureKeys.ANCIENT_OAK_TREE.getValue(), StructureFeatures.ANCIENT_TREE.configure(new AncientTreeFeatureConfig(TreeKind.OAK)));
        ANCIENT_BIRCH_TREE = register(StructureKeys.ANCIENT_BIRCH_TREE.getValue(), StructureFeatures.ANCIENT_TREE.configure(new AncientTreeFeatureConfig(TreeKind.BIRCH)));
        ANCIENT_DARK_OAK_TREE = register(StructureKeys.ANCIENT_DARK_OAK_TREE.getValue(), StructureFeatures.ANCIENT_TREE.configure(new AncientTreeFeatureConfig(TreeKind.DARK_OAK)));
        ANCIENT_ACACIA_TREE = register(StructureKeys.ANCIENT_ACACIA_TREE.getValue(), StructureFeatures.ANCIENT_TREE.configure(new AncientTreeFeatureConfig(TreeKind.ACACIA)));
        ANCIENT_SPRUCE_TREE = register(StructureKeys.ANCIENT_SPRUCE_TREE.getValue(), StructureFeatures.ANCIENT_TREE.configure(new AncientTreeFeatureConfig(TreeKind.SPRUCE)));
        ANCIENT_JUNGLE_TREE = register(StructureKeys.ANCIENT_JUNGLE_TREE.getValue(), StructureFeatures.ANCIENT_TREE.configure(new AncientTreeFeatureConfig(TreeKind.JUNGLE)));
        ANCIENT_PEAR_TREE = register(StructureKeys.ANCIENT_PEAR_TREE.getValue(), StructureFeatures.ANCIENT_TREE.configure(new AncientTreeFeatureConfig(TreeKind.PEAR)));
    }
}
