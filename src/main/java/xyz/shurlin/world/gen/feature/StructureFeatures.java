package xyz.shurlin.world.gen.feature;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.Locale;

import static net.minecraft.world.gen.feature.StructureFeature.STRUCTURES;

public class StructureFeatures {
    public static final StructureFeature<DefaultFeatureConfig> ANCIENT_OAK_TREE;
    public static final StructureFeature<DefaultFeatureConfig> ANCIENT_PEAR_TREE;

    private static <F extends StructureFeature<?>> F register(String name, F structureFeature) {
        return Registry.register(Registry.STRUCTURE_FEATURE, name.toLowerCase(Locale.ROOT), structureFeature);
    }

    static {
        ANCIENT_OAK_TREE = register("ancient_oak_tree", new AncientOakTreeStructureFeature(DefaultFeatureConfig.CODEC));
        ANCIENT_PEAR_TREE = register("ancient_pear_tree", new AncientPearTreeStructureFeature(DefaultFeatureConfig.CODEC));
    }
}
