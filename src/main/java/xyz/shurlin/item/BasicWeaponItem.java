package xyz.shurlin.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import xyz.shurlin.cultivation.WeaponLevels;

import java.util.List;

public class BasicWeaponItem extends Item {
    private WeaponLevels level;

    public BasicWeaponItem(Settings settings, WeaponLevels level) {
        super(settings.group(ItemGroups.SHURLIN));
        this.level = level;
    }

    public WeaponLevels getLevel() {
        return level;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
    }
}
