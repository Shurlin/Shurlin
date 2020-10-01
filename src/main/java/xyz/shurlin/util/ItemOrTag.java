package xyz.shurlin.util;

import net.minecraft.item.Item;
import net.minecraft.tag.Tag;

public class ItemOrTag {
    private Item item = null;
    private Tag<Item> tag = null;

    public ItemOrTag(Item item) {
        this.item = item;
    }

    public ItemOrTag(Tag<Item> tag) {
        this.tag = tag;
    }

    public boolean isItem(){
        return item != null;
    }

    public Item getItem() {
        return item;
    }

    public Tag<Item> getTag() {
        return tag;
    }

    public boolean contains(Item item){
        return isItem()? this.item.equals(item) : this.tag.contains(item);
    }
}
