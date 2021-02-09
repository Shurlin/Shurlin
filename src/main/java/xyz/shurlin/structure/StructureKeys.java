package xyz.shurlin.structure;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import xyz.shurlin.Shurlin;

public class StructureKeys {
    public static final RegistryKey<ConfiguredStructureFeature<?, ?>> ANCIENT_OAK_TREE = register("ancient_oak_tree");
    public static final RegistryKey<ConfiguredStructureFeature<?, ?>> ANCIENT_BIRCH_TREE = register("ancient_birch_tree");
    public static final RegistryKey<ConfiguredStructureFeature<?, ?>> ANCIENT_DARK_OAK_TREE = register("ancient_dark_oak_tree");
    public static final RegistryKey<ConfiguredStructureFeature<?, ?>> ANCIENT_ACACIA_TREE = register("ancient_acacia_tree");
    public static final RegistryKey<ConfiguredStructureFeature<?, ?>> ANCIENT_SPRUCE_TREE = register("ancient_spruce_tree");
    public static final RegistryKey<ConfiguredStructureFeature<?, ?>> ANCIENT_JUNGLE_TREE = register("ancient_jungle_tree");
    public static final RegistryKey<ConfiguredStructureFeature<?, ?>> ANCIENT_PEAR_TREE = register("ancient_pear_tree");

    public static void registerAll(){
//        FabricStructureBuilder.create(new Identifier(Shurlin.MODID, "ancient_oak_tree"), StructureFeatures.ANCIENT_OAK_TREE)
//                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
//                .defaultConfig(32, 8, 12345)
//                .adjustsSurface()
//                .register();
//        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ANCIENT_OAK_TREE.getValue(), ShurlinConfiguredFeatures.ANCIENT_OAK_TREE);
//        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ANCIENT_BIRCH_TREE.getValue(), ShurlinConfiguredFeatures.ANCIENT_BIRCH_TREE);
//        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ANCIENT_DARK_OAK_TREE.getValue(), ShurlinConfiguredFeatures.ANCIENT_DARK_OAK_TREE);
//        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ANCIENT_ACACIA_TREE.getValue(), ShurlinConfiguredFeatures.ANCIENT_ACACIA_TREE);
//        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ANCIENT_SPRUCE_TREE.getValue(), ShurlinConfiguredFeatures.ANCIENT_SPRUCE_TREE);
//        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ANCIENT_JUNGLE_TREE.getValue(), ShurlinConfiguredFeatures.ANCIENT_JUNGLE_TREE);
//        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ANCIENT_PEAR_TREE.getValue(), ShurlinConfiguredFeatures.ANCIENT_PEAR_TREE);

    }

    private static RegistryKey<ConfiguredStructureFeature<?, ?>> register(String registryName){
        return RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN, new Identifier(Shurlin.MODID, registryName));
    }

//    private static void create()
}
