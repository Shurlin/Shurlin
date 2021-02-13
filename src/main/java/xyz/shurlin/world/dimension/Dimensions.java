package xyz.shurlin.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import xyz.shurlin.Shurlin;

public class Dimensions {
    public static final RegistryKey<World> HOLY_FARMER;
//    public static final RegistryKey<World> SHURLIN_;

    private static RegistryKey<World> register(String name){
        return RegistryKey.of(Registry.DIMENSION, new Identifier(Shurlin.MODID, name));
    }

    public static void load() {
//        FabricDimensions.registerDefaultPlacer(HOLY_FARMER, HolyFarmerChunkGenerator::placeEntityInVoid);

    }

    static {
        HOLY_FARMER = register("holy_farmer");
//        SHURLIN_ = register("shurlin");
    }
}
