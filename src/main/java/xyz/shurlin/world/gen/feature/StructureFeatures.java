package xyz.shurlin.world.gen.feature;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import xyz.shurlin.structure.AncientTreeData;

import java.util.Locale;

public class StructureFeatures {
    public static final StructureFeature<DefaultFeatureConfig> ANCIENT_OAK_TREE;
    public static final StructureFeature<DefaultFeatureConfig> ANCIENT_BIRCH_TREE;
    public static final StructureFeature<DefaultFeatureConfig> ANCIENT_DARK_OAK_TREE;
    public static final StructureFeature<DefaultFeatureConfig> ANCIENT_ACACIA_TREE;
    public static final StructureFeature<DefaultFeatureConfig> ANCIENT_SPRUCE_TREE;
    public static final StructureFeature<DefaultFeatureConfig> ANCIENT_JUNGLE_TREE;
    public static final StructureFeature<DefaultFeatureConfig> ANCIENT_PEAR_TREE;

    private static <F extends StructureFeature<?>> F register(Identifier id, F structureFeature) {
        return Registry.register(Registry.STRUCTURE_FEATURE, id, structureFeature);
    }

    static {
        ANCIENT_OAK_TREE = register(FeatureKeys.ANCIENT_OAK_TREE_KEY.getValue(), new AncientTreeStructureFeature(DefaultFeatureConfig.CODEC, AncientTreeData.OAK));
        ANCIENT_BIRCH_TREE = register(FeatureKeys.ANCIENT_BIRCH_TREE_KEY.getValue(), new AncientTreeStructureFeature(DefaultFeatureConfig.CODEC, AncientTreeData.BIRCH));
        ANCIENT_DARK_OAK_TREE = register(FeatureKeys.ANCIENT_DARK_OAK_TREE_KEY.getValue(), new AncientTreeStructureFeature(DefaultFeatureConfig.CODEC, AncientTreeData.DARK_OAK));
        ANCIENT_ACACIA_TREE = register(FeatureKeys.ANCIENT_ACACIA_TREE_KEY.getValue(), new AncientTreeStructureFeature(DefaultFeatureConfig.CODEC, AncientTreeData.ACACIA));
        ANCIENT_SPRUCE_TREE = register(FeatureKeys.ANCIENT_SPRUCE_TREE_KEY.getValue(), new AncientTreeStructureFeature(DefaultFeatureConfig.CODEC, AncientTreeData.SPRUCE));
        ANCIENT_JUNGLE_TREE = register(FeatureKeys.ANCIENT_JUNGLE_TREE_KEY.getValue(), new AncientTreeStructureFeature(DefaultFeatureConfig.CODEC, AncientTreeData.JUNGLE));
        ANCIENT_PEAR_TREE = register(FeatureKeys.ANCIENT_PEAR_TREE_KEY.getValue(), new AncientTreeStructureFeature(DefaultFeatureConfig.CODEC, AncientTreeData.PEAR));
    }
}
