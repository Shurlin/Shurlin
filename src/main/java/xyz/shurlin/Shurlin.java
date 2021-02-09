package xyz.shurlin;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.shurlin.block.entity.BlockEntityTypes;
import xyz.shurlin.command.Commands;
import xyz.shurlin.item.Items;
import xyz.shurlin.linkage.Linkage;
import xyz.shurlin.recipe.RecipeSerializers;
import xyz.shurlin.screen.ScreenHandlerTypes;
import xyz.shurlin.util.ServerReceiver;
import xyz.shurlin.world.biome.BiomeGenerator;
import xyz.shurlin.world.biome.Biomes;
import xyz.shurlin.world.dimension.DimensionTypes;
import xyz.shurlin.world.gen.chunk.ChunkGeneratorTypes;

import java.util.Random;

public class Shurlin implements ModInitializer {
    public static final String MODID = "shurlin";
    public static final Logger LOGGER = LogManager.getLogger();
    public static Random random = new Random();

    @Override
    public void onInitialize() {
        new BlockEntityTypes();
        new Items();
//        new Features();
        RecipeSerializers.registerAll();
        ServerReceiver.registerAll();
        new ScreenHandlerTypes();
        ChunkGeneratorTypes.registerAll();
//        Dimensions.registerAll();
        new DimensionTypes();
//        KeyBindings.registerAll();
        Commands.registerAll();
        Biomes.registerAll();
        BiomeGenerator.registerAll();
//        new Reflector();
//        new DimensionOptions();
//        StructureKeys.registerAll();
//        FeatureKeys.registerAll();
        Linkage.init();
    }
}

//entity
//command
//recipe(container)
//crater
