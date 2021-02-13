package xyz.shurlin.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;
import xyz.shurlin.util.ShurlinLevel;

public class WorkerInputSlot extends Slot {
    private final ShurlinLevel shurlinLevel;

    public WorkerInputSlot(Inventory inventory, int index, int x, int y, ShurlinLevel shurlinLevel) {
        super(inventory, index, x, y);
        this.shurlinLevel = shurlinLevel;
    }

    protected ShurlinLevel getShurlinLevel() {
        return shurlinLevel;
    }

//    @Override
//    public boolean canInsert(ItemStack stack) {
//        return BreakerRecipes.contains(stack.getItem());
//    }
}
