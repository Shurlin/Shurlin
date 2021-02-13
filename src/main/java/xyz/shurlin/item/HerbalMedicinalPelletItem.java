package xyz.shurlin.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class HerbalMedicinalPelletItem extends Item {

    HerbalMedicinalPelletItem(FoodComponent component) {
        super(new Settings().maxCount(16).food(component));
    }

    HerbalMedicinalPelletItem(){
        super(new Settings().maxCount(16).food(new FoodComponent.Builder().hunger(1).snack().saturationModifier(0.0f).build()));
    }


}
