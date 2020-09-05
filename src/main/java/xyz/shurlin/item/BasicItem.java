package xyz.shurlin.item;

import net.minecraft.item.Item;

class BasicItem extends Item {
    BasicItem() {
        super(new Item.Settings().group(ItemGroups.SHURLIN));
    }

    BasicItem(Settings settings) {
        super(settings);
    }
}
