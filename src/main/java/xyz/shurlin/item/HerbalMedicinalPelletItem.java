package xyz.shurlin.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HerbalMedicinalPelletItem extends Item {

    HerbalMedicinalPelletItem(FoodComponent component) {
        super(new Item.Settings().maxCount(16).food(component));
    }

    HerbalMedicinalPelletItem(){
        super(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(1).snack().saturationModifier(0.0f).build()));
    }


}
