package xyz.shurlin.screen.slot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class WorkerOutputSlot extends Slot {
    private final PlayerEntity player;
    private int amount;

    public WorkerOutputSlot(Inventory inventory, PlayerEntity player, int index, int x, int y) {
        super(inventory, index, x, y);
        this.player = player;
    }

    public boolean canInsert(ItemStack stack) {
        return false;
    }

    public ItemStack takeStack(int amount) {
        if (this.hasStack()) {
            this.amount += Math.min(amount, this.getStack().getCount());
        }

        return super.takeStack(amount);
    }

    public ItemStack onTakeItem(PlayerEntity player, ItemStack stack) {
        this.onCrafted(stack);
        super.onTakeItem(player, stack);
        return stack;
    }

    protected void onCrafted(ItemStack stack, int amount) {
        this.amount += amount;
        this.onCrafted(stack);
    }

    protected void onCrafted(ItemStack stack) {
        stack.onCraft(this.player.world, this.player, this.amount);
//        if (!this.player.world.isClient && this.inventory instanceof AbstractWorkerBlockEntity) {
//            ((AbstractWorkerBlockEntity)this.inventory).dropExperience(this.player);
//        }

        this.amount = 0;
    }
}
