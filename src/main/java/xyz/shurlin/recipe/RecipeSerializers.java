package xyz.shurlin.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;

public class RecipeSerializers {
    public static final WorkerRecipeSerializer<BreakerRecipe> BREAKING = register("breaking", new WorkerRecipeSerializer<>(BreakerRecipe::new));
    public static final WorkerRecipeSerializer<CollectorRecipe> COLLECTING = register("collecting", new WorkerRecipeSerializer<>(CollectorRecipe::new));
    public static final ConcentratorRecipe.ConcentratorRecipeSerializer CONCENTRATING = register("concentrating", new ConcentratorRecipe.ConcentratorRecipeSerializer(ConcentratorRecipe::new));
    public static final WorkerRecipeSerializer<ExtractorRecipe> EXTRACTING = register("extracting", new WorkerRecipeSerializer<>(ExtractorRecipe::new));
    public static final WorkerRecipeSerializer<HMPRecipe> ALCHEMY = new WorkerRecipeSerializer<>(HMPRecipe::new);

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String registryName, S serializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Shurlin.MODID, registryName), serializer);
    }

    public static void load() {
    }
}
