package xyz.shurlin.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
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
    private final ConcentrationIngredientVector concentrationIngredients;

    ConcentratorRecipe(Identifier id, String group, ConcentrationIngredientVector concentrationIngredients, ItemStack output, int workTime, ShurlinLevel shurlinLevel) {
        super(RecipeTypes.CONCENTRATING, id, group, null, output, workTime, shurlinLevel);
        this.concentrationIngredients = concentrationIngredients;
    }

    @Override
    public boolean matches(Inventory inv, World world) {
        for(int i=0;i<concentrationIngredients.size();i++){
            ConcentrationIngredient concentrationIngredient = concentrationIngredients.elementAt(i);
            ItemStack stack = inv.getStack(i);
            boolean b = concentrationIngredient.itemOrTag.contains(stack.getItem()) && stack.getCount() >= concentrationIngredient.count;
            if(!b)
                return false;
        }
        return !(inv instanceof ShurlinLevel) || Utils.canDo(inv, this.shurlinLevel);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializers.CONCENTRATING;
    }

    public ConcentrationIngredientVector getConcentrationIngredients() {
        return concentrationIngredients;
    }

    public static class ConcentratorRecipeSerializer implements RecipeSerializer<ConcentratorRecipe> {
        private final ConcentratorRecipeSerializer.RecipeFactory<ConcentratorRecipe> recipeFactory;

        ConcentratorRecipeSerializer(RecipeFactory<ConcentratorRecipe> recipeFactory) {
            this.recipeFactory = recipeFactory;
        }

        @Override
        public ConcentratorRecipe read(Identifier id, JsonObject jsonObject) {
            String group = JsonHelper.getString(jsonObject, "group", "");
            JsonArray jsonArray = JsonHelper.getArray(jsonObject, "ingredients");
            ConcentrationIngredientVector concentrationIngredients = new ConcentrationIngredientVector();
            for(JsonElement jsonElement:jsonArray){
                concentrationIngredients.add(new ConcentrationIngredient(jsonElement.getAsJsonObject()));
            }
            String result = JsonHelper.getString(jsonObject, "result");
            Identifier result_id = new Identifier(result);
            int count = JsonHelper.getInt(jsonObject, "count",1);
            ItemStack output = new ItemStack(Registry.ITEM.getOrEmpty(result_id).orElseThrow(() ->
                    new IllegalStateException("Item: " + result + " does not exist")), count);
            int workingTime = JsonHelper.getInt(jsonObject, "workingTime");
            int shurlinLevel = JsonHelper.getInt(jsonObject, "shurlinLevel", 0);
            return this.recipeFactory.create(id, group, concentrationIngredients, output, workingTime, () -> shurlinLevel);
        }

        @Override
        public ConcentratorRecipe read(Identifier id, PacketByteBuf buf) {
            String group = buf.readString(32767);
            ConcentrationIngredientVector concentrationIngredients = ConcentrationIngredientVector.fromPacket(buf);
            ItemStack output = buf.readItemStack();
            int workingTime = buf.readVarInt();
            int shurlinLevel = buf.readVarInt();
            return this.recipeFactory.create(id, group, concentrationIngredients, output, workingTime, () -> shurlinLevel);
        }

        @Override
        public void write(PacketByteBuf buf, ConcentratorRecipe recipe) {
            buf.writeString(recipe.group);
            recipe.concentrationIngredients.write(buf);
            buf.writeItemStack(recipe.output);
            buf.writeVarInt(recipe.workTime);
        }

        interface RecipeFactory<ConcentratorRecipe>{
            ConcentratorRecipe create(Identifier id, String group, ConcentrationIngredientVector concentrationIngredientVector, ItemStack output, int cookTime, ShurlinLevel shurlinLevel);
        }

    }

    public static class ConcentrationIngredientVector extends Vector<ConcentrationIngredient>{
        private void write(PacketByteBuf buf){
            buf.writeVarInt(this.size());
            CompoundTag tags = new CompoundTag();
            int index = 0;
            for(ConcentrationIngredient ingredient : this){
                CompoundTag tag = new CompoundTag();
                ItemOrTag itemOrTag = ingredient.itemOrTag;
                boolean b = itemOrTag.isItem();
                String id = b?itemOrTag.getItem().getTranslationKey():TagContainers.instance().items().checkId(itemOrTag.getTag()).toString();
                tag.putBoolean("isItem", b);
                tag.putString("id", id);
                tag.putInt("count", ingredient.count);
                tags.put("tag" + ++index, tag);
            }
            buf.writeCompoundTag(tags);
        }

        private static ConcentrationIngredientVector fromPacket(PacketByteBuf buf){
            int size = buf.readVarInt();
            CompoundTag tags = buf.readCompoundTag();
            ConcentrationIngredientVector concentrationIngredients = new ConcentrationIngredientVector();
            for(int i=1;i<=size;i++){
                if (tags != null) {
                    CompoundTag tag = tags.getCompound("tag"+i);
                    boolean b = tag.getBoolean("isItem");
                    Identifier id = new Identifier(tag.getString("id"));
                    ItemOrTag itemOrTag;
                    if(b)
                        itemOrTag = new ItemOrTag(Registry.ITEM.get(id));
                    else
                        itemOrTag = new ItemOrTag(TagContainers.instance().items().get(id));
                    int count = tag.getInt("count");
                    ConcentrationIngredient concentrationIngredient = new ConcentrationIngredient(itemOrTag, count);
                    concentrationIngredients.add(concentrationIngredient);

                }
            }
            return concentrationIngredients;
        }
    }

    public static class ConcentrationIngredient {
        ItemOrTag itemOrTag;
        int count;

        public int getCount() {
            return count;
        }

        ConcentrationIngredient(ItemOrTag itemOrTag, int count) {
            this.itemOrTag = itemOrTag;
            this.count = count;
        }

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
