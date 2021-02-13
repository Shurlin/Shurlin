package xyz.shurlin.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.util.ShurlinLevel;

public class WorkerRecipeSerializer<T extends AbstractWorkerRecipe> implements RecipeSerializer<T> {
    protected final int workingTime;
    private final RecipeFactory<T> recipeFactory;

    public WorkerRecipeSerializer(RecipeFactory<T> recipeFactory, int workingTime) {
        this.workingTime = workingTime;
        this.recipeFactory = recipeFactory;
    }

    public WorkerRecipeSerializer(RecipeFactory<T> recipeFactory) {
        this.recipeFactory = recipeFactory;
        this.workingTime = 20;
    }

    @Override
    public T read(Identifier id, JsonObject jsonObject) {
//        id = id.getPath();
        String group = JsonHelper.getString(jsonObject, "group", "");
        JsonElement jsonElement = JsonHelper.hasArray(jsonObject, "ingredient") ?
                JsonHelper.getArray(jsonObject, "ingredient") : JsonHelper.getObject(jsonObject, "ingredient");
        Ingredient ingredient = Ingredient.fromJson(jsonElement);
        String result = JsonHelper.getString(jsonObject, "result");
        Identifier result_id = new Identifier(result);
        int count = JsonHelper.getInt(jsonObject, "count",1);
        ItemStack itemStack = new ItemStack(Registry.ITEM.getOrEmpty(result_id).orElseThrow(() ->
                new IllegalStateException("Item: " + result + " does not exist")), count);
        int workingTime = JsonHelper.getInt(jsonObject, "workingTime", this.workingTime);
        float shurlinLevel = JsonHelper.getInt(jsonObject, "shurlinLevel", 0);
        return this.recipeFactory.create(id, group, ingredient, itemStack, workingTime, ()->shurlinLevel);
    }

    @Override
    public T read(Identifier id, PacketByteBuf buf) {
        String group = buf.readString(32767);
        Ingredient ingredient = Ingredient.fromPacket(buf);
        ItemStack itemStack = buf.readItemStack();
        int workingTime = buf.readVarInt();
        float shurlinLevel = buf.readFloat();
        return this.recipeFactory.create(id, group, ingredient, itemStack, workingTime, ()->shurlinLevel);
    }

    @Override
    public void write(PacketByteBuf buf, T recipe) {
        buf.writeString(recipe.group);
        recipe.input.write(buf);
        buf.writeItemStack(recipe.output);
        buf.writeVarInt(recipe.workTime);
        buf.writeFloat(recipe.shurlinLevel.getShurlinLevel());
    }

    interface RecipeFactory<T extends AbstractWorkerRecipe> {
        T create(Identifier id, String group, Ingredient input, ItemStack output, int cookTime, ShurlinLevel shurlinLevel);
    }
}
