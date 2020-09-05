package xyz.shurlin.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import xyz.shurlin.util.ShurlinLevel;

public class BasicScreenHandler<I extends Inventory> extends ScreenHandler {
    private int size;
    protected I inventory;
    protected PlayerInventory playerInventory;
    private ShurlinLevel shurlinLevel;

    BasicScreenHandler(ScreenHandlerType<?> type, int syncId, I inventory, PlayerInventory playerInventory, int size) {
        this(type, syncId, inventory, playerInventory, size, null);
    }

    BasicScreenHandler(ScreenHandlerType<?> type, int syncId, I inventory, PlayerInventory playerInventory, int size, ShurlinLevel shurlinLevel) {
        super(type, syncId);
        this.size = size;
        this.inventory = inventory;
        this.playerInventory = playerInventory;
        this.shurlinLevel = shurlinLevel;
        checkSize(inventory, size);
        inventory.onOpen(playerInventory.player);
    }

    BasicScreenHandler(ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    void addPlayerInventorySlots(int x, int y){
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

    protected void addPlayerInventorySlot(int index, int x, int y){
        this.addSlot(new Slot(this.playerInventory, index, x, y));
    }


    void addSlots(int x, int y, int r, int c){
        checkSize(this.inventory, r * c);
        int cnt = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                addSlot(cnt++, x + j * 18, y + i * 18);
            }
        }
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

    @Override
    public void close(PlayerEntity player) {
        super.close(player);
        this.inventory.onClose(player);
    }

}
