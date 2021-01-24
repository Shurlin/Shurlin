package xyz.shurlin.util;

import net.minecraft.item.Item;
import net.minecraft.tag.Tag;

public class ItemOrTag {

    private final Object value;
    private final boolean isItem;

    public ItemOrTag(Item item) {
        this.value = item;
        this.isItem = true;
    }

    public ItemOrTag(Tag<Item> itemTag) {
        this.value = itemTag;
        this.isItem = false;
    }

    public boolean isItem() {
        return isItem;
    }

    public Item getItem() {
        return isItem ? (Item) value : null;
    }

    public Tag<Item> getTag() {
        return !isItem ? (Tag<Item>) value : null;
    }

    public boolean contains(Item item) {
        return isItem() ? this.value.equals(item) : ((Tag<Item>) this.value).contains(item);
    }
}