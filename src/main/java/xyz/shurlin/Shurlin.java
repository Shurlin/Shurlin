package xyz.shurlin;

import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.DataFixerUpper;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.recipebook.RecipeBookGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.shurlin.block.entity.BlockEntityTypes;
import xyz.shurlin.recipe.RecipeSerializers;
import xyz.shurlin.recipe.WorkerRecipeSerializer;
import xyz.shurlin.screen.ScreenHandlerTypes;
import xyz.shurlin.structure.AncientTreeData;
import xyz.shurlin.structure.StructurePieceTypes;
import xyz.shurlin.util.ServerReceiver;
import xyz.shurlin.world.biome.BiomeGenerator;
import xyz.shurlin.item.Items;
import xyz.shurlin.world.biome.Biomes;
import xyz.shurlin.world.dimension.DimensionTypes;
import xyz.shurlin.world.dimension.Dimensions;
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
        new RecipeSerializers();
        new Biomes();
        new BiomeGenerator();
        new ServerReceiver();
        new ScreenHandlerTypes();
        new ChunkGeneratorTypes();
        new Dimensions();
        new DimensionTypes();
//        new DimensionTypes();
//        new DimensionOptions();
    }
}
