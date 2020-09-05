package xyz.shurlin.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import xyz.shurlin.util.ShurlinLevel;

public class ConcentratorRecipe extends AbstractWorkerRecipe {
    ConcentratorRecipe(Identifier id, String group, Ingredient input, ItemStack output, int workTime, ShurlinLevel shurlinLevel) {
        super(RecipeTypes.CONCENTRATING, id, group, input, output, workTime, shurlinLevel);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializers.CONCENTRATING;
    }
}
