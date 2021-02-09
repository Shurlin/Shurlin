package xyz.shurlin.world.gen.feature;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.StructureFeature;
import xyz.shurlin.structure.AncientTreeFeatureConfig;

import static net.minecraft.world.gen.feature.StructureFeature.STRUCTURES;

public class StructureFeatures {
    public static final StructureFeature<AncientTreeFeatureConfig> ANCIENT_TREE;

    private static <F extends StructureFeature<?>> F register(Identifier id, F structureFeature) {
        STRUCTURES.put(id.getPath(), structureFeature);
        return Registry.register(Registry.STRUCTURE_FEATURE, id, structureFeature);
    }

//    private static <F extends StructureFeature<?>> F register(String name, F structureFeature, GenerationStep.Feature step) {
//
////        STRUCTURE_TO_GENERATION_STEP.put(structureFeature, step);
//        return Registry.register(Registry.STRUCTURE_FEATURE, name.toLowerCase(Locale.ROOT), structureFeature);
//    }

    static {
        ANCIENT_TREE = register(FeatureKeys.ANCIENT_TREE_KEY.getValue(), new AncientTreeStructureFeature(AncientTreeFeatureConfig.CODEC));
    }
}
