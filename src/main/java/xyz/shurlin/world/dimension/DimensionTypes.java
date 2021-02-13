package xyz.shurlin.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.dimension.DimensionType;
import xyz.shurlin.Shurlin;

public class DimensionTypes {
    public static final RegistryKey<DimensionType> HOLY_FARMER;
//    public static final RegistryKey<DimensionType> SHURLIN;

    private static RegistryKey<DimensionType> register(String name){
        return RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier(Shurlin.MODID, name));
    }

    public static void load() {
    }

    static {
        HOLY_FARMER = register("holy_farmer_type");
//        SHURLIN = register("shurlin");
    }
}
