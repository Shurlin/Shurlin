package xyz.shurlin.item;

import net.minecraft.item.Item;

public class BasicItem extends Item {
    public BasicItem() {
        super(new Item.Settings().group(ItemGroups.SHURLIN));
    }

    public BasicItem(Settings settings) {
        super(settings);
    }
}
