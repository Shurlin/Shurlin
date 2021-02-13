package xyz.shurlin.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class BasicFoodItem extends Item {
    public BasicFoodItem(FoodComponent component) {
        super(new Settings().group(ItemGroups.SHURLIN).food(component));
    }
}
