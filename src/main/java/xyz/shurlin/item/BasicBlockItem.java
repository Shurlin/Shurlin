package xyz.shurlin.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BasicBlockItem extends BlockItem {
    public BasicBlockItem(Block block) {
        this(block, new Settings().group(ItemGroups.SHURLIN));
    }

    public BasicBlockItem(Block block, Settings settings) {
        super(block, settings);
    }
}
