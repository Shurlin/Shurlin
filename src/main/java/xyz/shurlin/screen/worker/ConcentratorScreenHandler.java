package xyz.shurlin.screen.worker;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import xyz.shurlin.inventory.WorkerInventory;
import xyz.shurlin.screen.ScreenHandlerTypes;
import xyz.shurlin.screen.slot.WorkerInputSlot;
import xyz.shurlin.screen.slot.WorkerOutputSlot;
import xyz.shurlin.util.ShurlinLevel;

public class ConcentratorScreenHandler extends AbstractWorkerScreenHandler {

    public ConcentratorScreenHandler(int syncId, Inventory inventory, PlayerInventory playerInventory, PropertyDelegate propertyDelegate, World world, ShurlinLevel shurlinLevel) {
        super(ScreenHandlerTypes.CONCENTRATOR_SCREEN_HANDLER_TYPE, syncId, inventory, playerInventory,propertyDelegate,world, shurlinLevel);
        this.addSlot(new Slot(inventory, 3, 15,39));
        this.addSlot(new Slot(inventory, 2, 33,39));
        this.addSlot(new Slot(inventory, 1, 51,39));
        this.addSlot(new WorkerInputSlot(inventory, 0, 73,35, shurlinLevel));
        this.addSlot(new WorkerOutputSlot(inventory,playerInventory.player,4,134,35));
        this.addPlayerInventorySlots();
    }

    public ConcentratorScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, new WorkerInventory(5, null), playerInventory, new ArrayPropertyDelegate(2), playerInventory.player.world, null);
    }

    public String getName(){
        return "concentrator";
    }

    @Override
    public int getCraftingResultSlotIndex() {
        return 4;
    }

    @Override
    public int getCraftingWidth() {
        return 4;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public int getCraftingSlotCount() {
        return 5;
    }
}
