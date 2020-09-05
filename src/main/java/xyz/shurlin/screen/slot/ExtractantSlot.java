package xyz.shurlin.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import xyz.shurlin.item.ExtractantItem;

public class ExtractantSlot extends Slot {
    public ExtractantSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() instanceof ExtractantItem;
    }
}
