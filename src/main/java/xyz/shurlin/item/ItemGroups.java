package xyz.shurlin.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroups {
    static final ItemGroup SHURLIN = new ItemGroup(ItemGroup.GROUPS.length - 1, "shurlin"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.PLANT_ESSENCE);
        }
    };
}
