package xyz.shurlin.world.gen.feature;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class Features {
    public static final Feature<DefaultFeatureConfig> MYSTERIOUS_STONE_PILLAR_FEATURE;
    public static final Feature<DefaultFeatureConfig> PLANT_OBSIDIAN_HEAP;

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registry.FEATURE, name, feature);
    }

    static {
        MYSTERIOUS_STONE_PILLAR_FEATURE = register("mysterious_stone_pillar", new MysteriousStonePillarFeature(DefaultFeatureConfig.CODEC));
        PLANT_OBSIDIAN_HEAP = register("plant_obsidian_heap", new PlantObsidianHeapFeature(DefaultFeatureConfig.CODEC));
    }
}
