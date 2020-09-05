package xyz.shurlin.screen.slot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;
import xyz.shurlin.Shurlin;
import xyz.shurlin.screen.BiggerContainerScreenHandler;

public class LockableSlot<T extends BiggerContainerScreenHandler> extends Slot {
    private T handler;
    private final int index;

    public LockableSlot(Inventory inventory, int index, int x, int y, T handler) {
        super(inventory, index, x, y);
        this.handler = handler;
        this.index = index;
        Shurlin.LOGGER.debug(handler.slot);
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
        return !(handler.slot == this.index);
    }

}
