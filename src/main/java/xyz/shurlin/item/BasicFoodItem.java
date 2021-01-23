package xyz.shurlin.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import xyz.shurlin.Shurlin;

public class BasicFoodItem extends Item {
    public BasicFoodItem(FoodComponent component) {
        super(new Item.Settings().group(ItemGroups.SHURLIN).food(component));
    }
}
