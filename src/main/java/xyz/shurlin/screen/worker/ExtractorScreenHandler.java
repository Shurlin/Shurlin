package xyz.shurlin.screen.worker;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.world.World;
import xyz.shurlin.inventory.WorkerInventory;
import xyz.shurlin.screen.ScreenHandlerTypes;
import xyz.shurlin.screen.slot.ExtractantSlot;
import xyz.shurlin.screen.slot.WorkerInputSlot;
import xyz.shurlin.screen.slot.WorkerOutputSlot;
import xyz.shurlin.util.ShurlinLevel;

public class ExtractorScreenHandler extends AbstractWorkerScreenHandler {

    public ExtractorScreenHandler(int syncId, Inventory inventory, PlayerInventory playerInventory, PropertyDelegate propertyDelegate, World world, ShurlinLevel shurlinLevel) {
        super(ScreenHandlerTypes.EXTRACTOR_SCREEN_HANDLER_TYPE, syncId, inventory, playerInventory,propertyDelegate,world, shurlinLevel);
        this.addSlot(new WorkerInputSlot(inventory, 0, 44,42, shurlinLevel));
        this.addSlot(new ExtractantSlot(inventory, 1, 30,18));
        this.addSlot(new WorkerOutputSlot(inventory, playerInventory.player,2,118,42));
        this.addPlayerInventorySlots();
    }

    public ExtractorScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, new WorkerInventory(3, null), playerInventory, new ArrayPropertyDelegate(4), playerInventory.player.world, null);
    }

    public String getName(){
        return "extractor";
    }

    @Override
    public int getCraftingResultSlotIndex() {
        return 2;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public int getCraftingSlotCount() {
        return 3;
    }

    public int getExtractant(){
        return propertyDelegate.get(2);
    }
}
