package xyz.shurlin.screen.worker;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.RecipeInputProvider;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import xyz.shurlin.util.ShurlinLevel;

public abstract class AbstractWorkerScreenHandler extends AbstractRecipeScreenHandler<Inventory> {
    private final Inventory inventory;
    private final PlayerInventory playerInventory;
    final PropertyDelegate propertyDelegate;
    protected final World world;
    private int size;

    AbstractWorkerScreenHandler(ScreenHandlerType<?> screenHandlerType, int syncId, Inventory inventory, PlayerInventory playerInventory, PropertyDelegate propertyDelegate, World world, ShurlinLevel shurlinLevel) {//TODO
        super(screenHandlerType, syncId);
        this.inventory = inventory;
        this.playerInventory = playerInventory;
        this.size = this.inventory.size();
        this.propertyDelegate = propertyDelegate;
        this.addProperties(propertyDelegate);
        this.world = world;
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void populateRecipeFinder(RecipeFinder finder) {
        if(this.inventory instanceof RecipeInputProvider){
            ((RecipeInputProvider) this.inventory).provideRecipeInputs(finder);
        }
    }

    @Override
    public void clearCraftingSlots() {
        this.inventory.clear();
    }

    @Override
    public boolean matches(Recipe<? super Inventory> recipe) {
        return recipe.matches(this.inventory, this.world);
    }

    @Override
    public int getCraftingWidth() {
        return 1;
    }

    @Override
    public int getCraftingHeight() {
        return 1;
    }

    private void addPlayerInventorySlots(int x, int y){
        for (int i=0;i<3;i++){
            for(int j=0;j<9;j++){
                this.addPlayerInventorySlot(i * 9 + j + 9, x + j * 18, y + i * 18);
            }
        }
        for (int i=0;i<9;i++){
            this.addPlayerInventorySlot(i, x + i * 18, y + 58);
        }
    }

    void addPlayerInventorySlots(){
        addPlayerInventorySlots(8, 84);
    }

    private void addSlot(int index, int x, int y){
        this.addSlot(new Slot(this.inventory, index, x, y));
    }

    private void addPlayerInventorySlot(int index, int x, int y){
        this.addSlot(new Slot(this.playerInventory, index, x, y));
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2.copy();
            if (index < this.size) {
                if (!this.insertItem(itemStack2, this.size, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 0, this.size, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return itemStack;
    }

    @Environment(EnvType.CLIENT)
    public float getWorkProgress(){
        return this.propertyDelegate.get(0) / (float) (this.propertyDelegate.get(1) == 0 ? 20 : this.propertyDelegate.get(1));
    }
}

