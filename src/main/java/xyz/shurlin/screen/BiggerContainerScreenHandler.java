package xyz.shurlin.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import xyz.shurlin.screen.slot.LockableSlot;

public class BiggerContainerScreenHandler extends BasicScreenHandler<Inventory> {
    public int slot;

    public BiggerContainerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, int slot) {
        super(ScreenHandlerTypes.BIGGER_CONTAINER_SCREEN_HANDLER_TYPE, syncId,  inventory, playerInventory,104);
        this.slot = slot;
        this.addSlots(12, 18, 8, 13);
        this.addPlayerInventorySlots(48, 174);
    }

    BiggerContainerScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(104), 0);
    }

    @Override
    protected void addPlayerInventorySlot(int index, int x, int y) {
        this.addSlot(new LockableSlot<>(this.playerInventory, index, x, y, this));
    }
}
