package xyz.shurlin.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import xyz.shurlin.util.ShurlinLevel;

public class HMPRecipe extends AbstractWorkerRecipe {

    public HMPRecipe(Identifier id, String group, Ingredient input, ItemStack output, int workTime, ShurlinLevel shurlinLevel) {
        super(RecipeTypes.ALCHEMY, id, group, input, output, workTime, shurlinLevel);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializers.ALCHEMY;
    }
}
