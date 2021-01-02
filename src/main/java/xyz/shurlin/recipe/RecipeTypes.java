package xyz.shurlin.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;

public class RecipeTypes {
    public static final RecipeType<BreakerRecipe> BREAKING = register("breaking");
    public static final RecipeType<CollectorRecipe> COLLECTING = register("collecting");
    public static final RecipeType<ConcentratorRecipe> CONCENTRATING = register("concentrating");
    public static final RecipeType<ExtractorRecipe> EXTRACTING = register("extracting");
    public static final RecipeType<HMPRecipe> ALCHEMY = register("alchemy");
//    public static final RecipeType<WorkerRecipe> PURIFYING = register("purifying");
//    public static final RecipeType<WorkerRecipe> SPIRIT_RAISING = register("spirit_raising");

    private static <T extends Recipe<?>> RecipeType<T> register(final String string) {
        return Registry.register(Registry.RECIPE_TYPE, new Identifier(Shurlin.MODID, string), new RecipeType<T>() {
            public String toString() {
                return string;
            }
        });
    }
}
