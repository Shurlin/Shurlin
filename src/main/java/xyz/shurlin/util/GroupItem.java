package xyz.shurlin.util;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.Arrays;

public enum GroupItem {
    BREAKABLE(Items.ACACIA_LEAVES,Items.BIRCH_LEAVES,Items.DARK_OAK_LEAVES,Items.JUNGLE_LEAVES,Items.OAK_LEAVES, Items.SPRUCE_LEAVES

    );

    private ArrayList<Item> itemList = new ArrayList<>();
//    private ArrayList<Tag> tagList = new ArrayList<>();

    GroupItem(Item... items){
        itemList.addAll(Arrays.asList(items));
    };

    public static boolean canInsert(GroupItem groupItem, Item item, ShurlinLevel level){
        return item instanceof ShurlinLevel ?
                (groupItem.itemList.contains(item) && Utils.canDo(level, (ShurlinLevel) item)) :
                groupItem.itemList.contains(item);
    }

}
