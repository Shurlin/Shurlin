package xyz.shurlin.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;

public class BiggerInventory extends PortableInventory {

    public BiggerInventory(ItemStack itemStack) {
        super(104, itemStack);
    }
}
