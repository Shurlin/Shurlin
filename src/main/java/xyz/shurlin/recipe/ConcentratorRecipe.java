package xyz.shurlin.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagContainers;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import xyz.shurlin.util.ItemOrTag;
import xyz.shurlin.util.ShurlinLevel;
import xyz.shurlin.util.Utils;

import java.util.Vector;


public class ConcentratorRecipe extends AbstractWorkerRecipe {
    private final Vector<ConcentrationIngredient> concentrationIngredients;

    ConcentratorRecipe(Identifier id, String group, Vector<ConcentrationIngredient> concentrationIngredients, ItemStack output, int workTime, ShurlinLevel shurlinLevel) {
        super(RecipeTypes.CONCENTRATING, id, group, null, output, workTime, shurlinLevel);
        this.concentrationIngredients = concentrationIngredients;
    }

    @Override
    public boolean matches(Inventory inv, World world) {
        for(int i=0;i<concentrationIngredients.size();i++){
            ConcentrationIngredient concentrationIngredient = concentrationIngredients.elementAt(i);
            ItemStack stack = inv.getStack(i);
            boolean b = concentrationIngredient.itemOrTag.contains(stack.getItem()) && stack.getCount() == concentrationIngredient.count;
            if(!b)
                return false;
        }
        return !(inv instanceof ShurlinLevel) || Utils.canDo(inv, this.shurlinLevel);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializers.CONCENTRATING;
    }

    public static class ConcentratorRecipeSerializer extends WorkerRecipeSerializer<ConcentratorRecipe> {

        ConcentratorRecipeSerializer(RecipeFactory<ConcentratorRecipe> recipeFactory) {
            super(recipeFactory);
        }

        @Override
        public ConcentratorRecipe read(Identifier id, JsonObject jsonObject) {
            String group = JsonHelper.getString(jsonObject, "group", "");
            JsonArray jsonArray = JsonHelper.getArray(jsonObject, "ingredients");
            Vector<ConcentrationIngredient> concentrationIngredients = new Vector<>();
            for(JsonElement jsonElement:jsonArray){
                concentrationIngredients.add(new ConcentrationIngredient(jsonElement.getAsJsonObject()));
            }
            String result = JsonHelper.getString(jsonObject, "result");
            Identifier result_id = new Identifier(result);
            ItemStack output = new ItemStack(Registry.ITEM.getOrEmpty(result_id).orElseThrow(() ->
                    new IllegalStateException("Item: " + result + " does not exist")));
            int workingTime = JsonHelper.getInt(jsonObject, "workingTime", this.workingTime);
            int shurlinLevel = JsonHelper.getInt(jsonObject, "shurlinLevel", 0);
            return new ConcentratorRecipe(id, group, concentrationIngredients, output, workingTime, () -> shurlinLevel);
        }


    }

    public static class ConcentrationIngredient {
        ItemOrTag itemOrTag;
        int count;

        ConcentrationIngredient(JsonObject object) {
            Identifier identifier;
            if(object.has("item")){
                identifier = new Identifier(JsonHelper.getString(object, "item"));
                Item item = Registry.ITEM.getOrEmpty(identifier).orElseThrow(() -> new JsonSyntaxException("Unknown item '" + identifier + "'"));
                itemOrTag = new ItemOrTag(item);
            }else if(object.has("tag")){
                identifier = new Identifier(JsonHelper.getString(object, "tag"));
                Tag<Item> tag = TagContainers.instance().items().get(identifier);
                if (tag == null) {
                    throw new JsonSyntaxException("Unknown item tag '" + identifier + "'");
                }
                itemOrTag = new ItemOrTag(tag);
            }
            count = JsonHelper.getInt(object, "count", 1);
        }
    }
}
