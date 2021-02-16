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
import xyz.shurlin.world.dimension.Dimensions;
import xyz.shurlin.world.gen.chunk.ChunkGeneratorTypes;
import xyz.shurlin.world.gen.feature.ShurlinOreFeatures;

import java.util.Random;

public class Shurlin implements ModInitializer {
    public static final String MODID = "shurlin";
    public static final Logger LOGGER = LogManager.getLogger();
    public static Random random = new Random();

    @Override
    public void onInitialize() {
        BlockEntityTypes.load();
        Items.load();
//        new Features();

        RecipeSerializers.load();
        ServerReceiver.load();
        ScreenHandlerTypes.load();
        ChunkGeneratorTypes.load();
        Dimensions.load();
        DimensionTypes.load();
//        KeyBindings.load();
        Commands.load();
        Biomes.load();
        BiomeGenerator.load();
        ShurlinOreFeatures.load();
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

//holy_pear_altar
