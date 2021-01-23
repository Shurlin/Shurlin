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

public class CollectorScreenHandler extends AbstractWorkerScreenHandler {

    public CollectorScreenHandler(int syncId, Inventory inventory, PlayerInventory playerInventory, PropertyDelegate propertyDelegate, World world, ShurlinLevel shurlinLevel) {
        super(ScreenHandlerTypes.COLLECTOR_SCREEN_HANDLER_TYPE, syncId, inventory, playerInventory,propertyDelegate,world, shurlinLevel);
        this.addSlot(new WorkerInputSlot(inventory, 0, 47,18, shurlinLevel));
        this.addSlot(new WorkerOutputSlot(inventory, playerInventory.player,1,106,35));
        this.addPlayerInventorySlots();
    }

    public CollectorScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, new WorkerInventory(3, null), playerInventory, new ArrayPropertyDelegate(3), playerInventory.player.world, null);
    }

    public String getName(){
        return "collector";
    }

    @Override
    public int getCraftingResultSlotIndex() {
        return 1;
    }

    @Override
    public int getCraftingSlotCount() {
        return 2;
    }

    public float getConsistence(){
        return this.propertyDelegate.get(2) / 100.0f;
    }
}
