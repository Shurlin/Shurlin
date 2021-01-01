package xyz.shurlin.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;

public class RecipeSerializers {
    public static final WorkerRecipeSerializer<BreakerRecipe> BREAKING = new WorkerRecipeSerializer<>(BreakerRecipe::new);
    public static final WorkerRecipeSerializer<CollectorRecipe> COLLECTING = new WorkerRecipeSerializer<>(CollectorRecipe::new);
    public static final ConcentratorRecipe.ConcentratorRecipeSerializer CONCENTRATING = new ConcentratorRecipe.ConcentratorRecipeSerializer(ConcentratorRecipe::new);
    public static final WorkerRecipeSerializer<ExtractorRecipe> EXTRACTING = new WorkerRecipeSerializer<>(ExtractorRecipe::new);

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> void register(String registryName, S serializer) {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Shurlin.MODID, registryName), serializer);
    }

    public static void registerAll() {
        register("breaking", BREAKING);
        register("collecting", COLLECTING);
        register("concentrating", CONCENTRATING);
        register("extracting", EXTRACTING);
    }
}
