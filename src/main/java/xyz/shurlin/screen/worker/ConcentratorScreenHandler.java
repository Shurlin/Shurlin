package xyz.shurlin.screen.worker;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import xyz.shurlin.inventory.BreakerInventory;
import xyz.shurlin.screen.ScreenHandlerTypes;
import xyz.shurlin.screen.slot.WorkerInputSlot;
import xyz.shurlin.screen.slot.WorkerOutputSlot;
import xyz.shurlin.util.ShurlinLevel;

public class ConcentratorScreenHandler extends AbstractWorkerScreenHandler {


    public ConcentratorScreenHandler(int syncId, Inventory inventory, PlayerInventory playerInventory, PropertyDelegate propertyDelegate, World world, ShurlinLevel shurlinLevel) {
        super(ScreenHandlerTypes.CONCENTRATOR_SCREEN_HANDLER_TYPE, syncId, inventory, playerInventory,propertyDelegate,world, shurlinLevel);
        this.addSlot(new Slot(inventory, 0, 15,39));
        this.addSlot(new Slot(inventory, 0, 33,39));
        this.addSlot(new Slot(inventory, 0, 51,39));
        this.addSlot(new WorkerInputSlot(inventory, 0, 73,35, shurlinLevel));
        this.addSlot(new WorkerOutputSlot(inventory,playerInventory.player,1,134,35));
        this.addPlayerInventorySlots();
    }

    public ConcentratorScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, new BreakerInventory(null), playerInventory, new ArrayPropertyDelegate(2), playerInventory.player.world, null);
    }

    public String getName(){
        return "concentrator";
    }

    @Override
    public int getCraftingResultSlotIndex() {
        return 4;
    }

    @Override
    public int getCraftingSlotCount() {
        return 5;
    }
}