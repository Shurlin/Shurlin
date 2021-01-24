package xyz.shurlin.screen.worker;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.world.World;
import xyz.shurlin.inventory.WorkerInventory;
import xyz.shurlin.screen.ScreenHandlerTypes;
import xyz.shurlin.screen.slot.WorkerInputSlot;
import xyz.shurlin.screen.slot.WorkerOutputSlot;
import xyz.shurlin.util.ShurlinLevel;

public class BreakerScreenHandler extends AbstractWorkerScreenHandler {

    public BreakerScreenHandler(int syncId, Inventory inventory, PlayerInventory playerInventory, PropertyDelegate propertyDelegate, World world, ShurlinLevel shurlinLevel) {
        super(ScreenHandlerTypes.BREAKER_SCREEN_HANDLER_TYPE, syncId, inventory, playerInventory,propertyDelegate,world, shurlinLevel);
        this.addSlot(new WorkerInputSlot(inventory, 0, 56,35, shurlinLevel));
        this.addSlot(new WorkerOutputSlot(inventory,playerInventory.player,1,116,35));
        this.addPlayerInventorySlots();
    }

    public BreakerScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, new WorkerInventory(2, null), playerInventory, new ArrayPropertyDelegate(2), playerInventory.player.world, null);
    }

    public String getName(){
        return "breaker";
    }

    @Override
    public int getCraftingResultSlotIndex() {
        return 1;
    }

    @Override
    public int getCraftingSlotCount() {
        return 2;
    }
}
