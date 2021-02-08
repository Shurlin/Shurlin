package xyz.shurlin.world.gen.surfacebuilder;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import xyz.shurlin.Shurlin;

public class ShurlinConfiguredSurfaceBuilder {
    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> FIRE_LAND;

    private static <SC extends SurfaceConfig> ConfiguredSurfaceBuilder<SC> register(String id, ConfiguredSurfaceBuilder<SC> configuredSurfaceBuilder) {
        return BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(Shurlin.MODID, id), configuredSurfaceBuilder);
    }

    static {
        FIRE_LAND = register("fire_land", SurfaceBuilder.DEFAULT.withConfig(ShurlinSurfaceBuilder.FIRE_LAND_CONFIG));
    }

}
