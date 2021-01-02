package xyz.shurlin.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import xyz.shurlin.cultivation.SimpleLevels;

import java.util.List;

public class HerbalMedicinalPelletItem extends Item {
    private SimpleLevels level;
    private String name;

    HerbalMedicinalPelletItem(FoodComponent component, String name) {
        super(new Item.Settings().maxCount(16).food(component));
        this.name = name;
    }

    HerbalMedicinalPelletItem(String name){
        this(new FoodComponent.Builder().hunger(1).snack().saturationModifier(0.0f).build(), name);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
//        tooltip.add(new TranslatableText("item.shurlin.hmp.level"));
    }
}
