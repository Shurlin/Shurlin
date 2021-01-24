package xyz.shurlin.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;

public class PortableInventory extends SimpleInventory {
    private final ItemStack itemStack;

    public PortableInventory(int size, ItemStack itemStack){
        super(size);
        this.itemStack=itemStack;
    }

    public void readTags(ListTag tags) {
        int j;
        for(j = 0; j < this.size(); ++j) {
            this.setStack(j, ItemStack.EMPTY);
        }
        for(j = 0; j < tags.size(); ++j) {
            CompoundTag compoundTag = tags.getCompound(j);
            int k = compoundTag.getByte("Slot") & 255;
            if (k < this.size()) {
                this.setStack(k, ItemStack.fromTag(compoundTag));
            }
        }

    }

    public ListTag getTags() {
        ListTag listTag = new ListTag();
        for(int i = 0; i < this.size(); ++i) {
            ItemStack itemStack = this.getStack(i);
            if (!itemStack.isEmpty()) {
                CompoundTag compoundTag = new CompoundTag();
                compoundTag.putByte("Slot", (byte)i);
                itemStack.toTag(compoundTag);
                listTag.add(compoundTag);
            }
        }
        return listTag;
    }

    @Override
    public void onClose(PlayerEntity player) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("inventory",this.getTags());
        itemStack.setTag(compoundTag);
    }
}
