package xyz.shurlin.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BasicBlockItem extends BlockItem {
    public BasicBlockItem(Block block) {
        this(block, new Item.Settings().group(ItemGroups.SHURLIN));
    }

    public BasicBlockItem(Block block, Settings settings) {
        super(block, settings);
    }
}
