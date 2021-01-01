package xyz.shurlin.block.worker.entity;

import annotations.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.Tickable;
import xyz.shurlin.block.entity.BasicBlockEntity;
import xyz.shurlin.recipe.AbstractWorkerRecipe;
import xyz.shurlin.util.ShurlinLevel;

public abstract class AbstractWorkerBlockEntity extends BasicBlockEntity implements ShurlinLevel, Tickable {
    int workTime;
    int workTimeTotal;
    final PropertyDelegate propertyDelegate;
    int level;
    RecipeType<? extends AbstractWorkerRecipe> recipeType;

    AbstractWorkerBlockEntity(BlockEntityType<?> blockEntityType, String containerName, int level, RecipeType<? extends AbstractWorkerRecipe> recipeType) {
        super(blockEntityType, containerName);
        this.level = level;
        this.propertyDelegate = getPropertyDelegate();
        this.recipeType = recipeType;
    }

    @Override
    public float getShurlinLevel() {
        return level * 10.0f;
    }

    protected abstract PropertyDelegate getPropertyDelegate();

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.workTime = tag.getInt("WorkTime");
        this.workTimeTotal = tag.getInt("WorkTimeTotal");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putInt("WorkTime", (short)this.workTime);
        tag.putInt("WorkTimeTotal", (short)this.workTimeTotal);
        return tag;
    }

    //    boolean canAcceptRecipeOutput() {
//        BreakerRecipes.contains()
//    }
//
//    protected abstract int getOutputSlot();
//
//    void craftRecipe(Item input) {
//        if (input != null && this.canAcceptRecipeOutput(input)) {
//            ItemStack itemStack = this.inventory.get(0);
//            ItemStack itemStack2 = getOutput(input);
//            ItemStack itemStack3 = this.inventory.get(1);
//            if (itemStack3.isEmpty()) {
//                this.inventory.set(1, itemStack2.copy());
//            } else if (itemStack3.getItem() == itemStack2.getItem()) {
//                itemStack3.increment(1);
//            }
//            itemStack.decrement(1);
//        }
//    }
    void craftRecipe(@Nullable Recipe<?> recipe) {
        if (recipe != null && this.canAcceptRecipeOutput(recipe)) {
            ItemStack itemStack = this.inventory.get(0);
            ItemStack itemStack2 = recipe.getOutput();
            ItemStack itemStack3 = this.inventory.get(getOutputSlot());
            if (itemStack3.isEmpty()) {
                this.inventory.set(getOutputSlot(), itemStack2.copy());
            } else if (itemStack3.getItem() == itemStack2.getItem()) {
                itemStack3.increment(1);
            }

            itemStack.decrement(1);
        }
    }

//
//    public void provideRecipeInputs(RecipeFinder finder) {
//        for (ItemStack itemStack : this.inventory) {
//            finder.addItem(itemStack);
//        }
//    }
//
//    int getWorkTime(Item input){
//        return BreakerRecipes.getData(input).getTime();
//    }

    boolean isWorking(){
        return this.workTime > 0;
    }
//
//    private ItemStack getOutput(Item input){
//        return BreakerRecipes.getData(input).getResult();
//    }

//    boolean canAcceptRecipeOutput(Item input) {
//        if(input != null && BreakerRecipes.contains(input)){
//            ItemStack output = getOutput(input);
//            if(output.isEmpty())
//                return false;
//            else {
//                ItemStack itemStack = this.inventory.get(1);
//                if(itemStack.isEmpty())
//                    return true;
//                else if(!itemStack.isItemEqualIgnoreDamage(output))
//                    return false;
//                else if(itemStack.getCount() < this.getMaxCountPerStack() && itemStack.getCount() < itemStack.getMaxCount())
//                    return true;
//                else
//                    return itemStack.getCount() < output.getMaxCount();
//            }
//        }
//        return false;
//    }

    boolean canAcceptRecipeOutput(@Nullable Recipe<?> recipe) {
        if (!(this.inventory.get(0)).isEmpty() && recipe != null) {
            ItemStack itemStack = recipe.getOutput();
            if (itemStack.isEmpty()) {
                return false;
            } else {
                ItemStack itemStack2 = this.inventory.get(getOutputSlot());
                if (itemStack2.isEmpty()) {
                    return true;
                } else if (!itemStack2.isItemEqualIgnoreDamage(itemStack)) {
                    return false;
                } else if (itemStack2.getCount() < this.getMaxCountPerStack() && itemStack2.getCount() < itemStack2.getMaxCount()) {
                    return true;
                } else {
                    return itemStack2.getCount() < itemStack.getMaxCount();
                }
            }
        } else {
            return false;
        }
    }

    int getWorkTimeTotal() {
        return this.world.getRecipeManager().getFirstMatch(this.recipeType, this, this.world).map(AbstractWorkerRecipe::getWorkTime).orElse(200);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        super.setStack(slot, stack);
        ItemStack itemStack = this.inventory.get(slot);
        boolean bl = !stack.isEmpty() && stack.isItemEqualIgnoreDamage(itemStack) && ItemStack.areTagsEqual(stack, itemStack);
        if (slot == 0 && !bl) {
            this.workTimeTotal = this.getWorkTimeTotal();
            this.workTime = 0;
            this.markDirty();
        }
    }

    protected int getOutputSlot(){
        return 1;
    }
}
