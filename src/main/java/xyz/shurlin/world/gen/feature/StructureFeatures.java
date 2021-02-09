package xyz.shurlin.world.gen.feature;

import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import xyz.shurlin.structure.AncientTreeFeatureConfig;

public class StructureFeatures {
    public static final StructureFeature<AncientTreeFeatureConfig> ANCIENT_TREE;

    private static <FC extends FeatureConfig, S extends StructureFeature<FC>> S register(Identifier id, S structureFeature) {
//        STRUCTURES.put(id.getPath(), structureFeature);
//        Registry.register(Registry.STRUCTURE_FEATURE, id, structureFeature);
        return FabricStructureBuilder.create(id, structureFeature)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 12345)
                .adjustsSurface()
                .register();
//        return structureFeature;
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
