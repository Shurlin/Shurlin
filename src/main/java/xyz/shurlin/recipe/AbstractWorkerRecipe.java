package xyz.shurlin.recipe;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import xyz.shurlin.util.ShurlinLevel;
import xyz.shurlin.util.Utils;

public abstract class AbstractWorkerRecipe implements Recipe<Inventory> {
    protected final RecipeType<?> type;
    protected final Identifier id;
    protected final String group;
    protected final Ingredient input;
    protected final ItemStack output;
    protected final int workTime;
    protected final ShurlinLevel shurlinLevel;

    public AbstractWorkerRecipe(RecipeType<?> type, Identifier id, String group, Ingredient input, ItemStack output, int workTime, ShurlinLevel shurlinLevel) {
        this.type = type;
        this.id = id;
        this.group = group;
        this.input = input;
        this.output = output;
        this.workTime = workTime;
        this.shurlinLevel = shurlinLevel;
    }

    @Override
    public boolean matches(Inventory inv, World world) {
        return this.input.test(inv.getStack(0)) && (!(inv instanceof ShurlinLevel) || Utils.canDo(inv, this.shurlinLevel));
    }

    @Override
    public ItemStack craft(Inventory inv) {
        return this.output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return this.output;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeType<?> getType() {
        return this.type;
    }

    public int getWorkTime(){
        return this.workTime;
    }
}
