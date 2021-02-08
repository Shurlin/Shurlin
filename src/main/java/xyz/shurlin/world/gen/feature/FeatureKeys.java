package xyz.shurlin.world.gen.feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import xyz.shurlin.Shurlin;

public class FeatureKeys {
    public static final RegistryKey<ConfiguredFeature<?,?>> ANCIENT_OAK_TREE_KEY;
    public static final RegistryKey<ConfiguredFeature<?,?>> ANCIENT_BIRCH_TREE_KEY;
    public static final RegistryKey<ConfiguredFeature<?,?>> ANCIENT_DARK_OAK_TREE_KEY;
    public static final RegistryKey<ConfiguredFeature<?,?>> ANCIENT_ACACIA_TREE_KEY;
    public static final RegistryKey<ConfiguredFeature<?,?>> ANCIENT_SPRUCE_TREE_KEY;
    public static final RegistryKey<ConfiguredFeature<?,?>> ANCIENT_JUNGLE_TREE_KEY;
    public static final RegistryKey<ConfiguredFeature<?,?>> ANCIENT_PEAR_TREE_KEY;

    private static RegistryKey<ConfiguredFeature<?,?>> register(String registryName){
        return RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(Shurlin.MODID, registryName));
    }

//    public static void registerAll(){
//        BuiltinRegistries.add(Registry.STRUCTURE_FEATURE, ANCIENT_OAK_TREE_KEY.getValue(), StructureFeatures.ANCIENT_OAK_TREE);
//        BuiltinRegistries.add(Registry.STRUCTURE_FEATURE, ANCIENT_BIRCH_TREE_KEY.getValue(), StructureFeatures.ANCIENT_BIRCH_TREE);
//        BuiltinRegistries.add(Registry.STRUCTURE_FEATURE, ANCIENT_DARK_OAK_TREE_KEY.getValue(), StructureFeatures.ANCIENT_DARK_OAK_TREE);
//        BuiltinRegistries.add(Registry.STRUCTURE_FEATURE, ANCIENT_ACACIA_TREE_KEY.getValue(), StructureFeatures.ANCIENT_ACACIA_TREE);
//        BuiltinRegistries.add(Registry.STRUCTURE_FEATURE, ANCIENT_SPRUCE_TREE_KEY.getValue(), StructureFeatures.ANCIENT_SPRUCE_TREE);
//        BuiltinRegistries.add(Registry.STRUCTURE_FEATURE, ANCIENT_JUNGLE_TREE_KEY.getValue(), StructureFeatures.ANCIENT_JUNGLE_TREE);
//        BuiltinRegistries.add(Registry.STRUCTURE_FEATURE, ANCIENT_PEAR_TREE_KEY.getValue(), StructureFeatures.ANCIENT_PEAR_TREE);
//
//    }

    static {
        ANCIENT_OAK_TREE_KEY = register("ancient_oak_tree");
        ANCIENT_BIRCH_TREE_KEY = register("ancient_birch_tree");
        ANCIENT_DARK_OAK_TREE_KEY = register("ancient_dark_oak_tree");
        ANCIENT_ACACIA_TREE_KEY = register("ancient_acacia_tree");
        ANCIENT_SPRUCE_TREE_KEY = register("ancient_spruce_tree");
        ANCIENT_JUNGLE_TREE_KEY = register("ancient_jungle_tree");
        ANCIENT_PEAR_TREE_KEY = register("ancient_pear_tree");
    }
}
