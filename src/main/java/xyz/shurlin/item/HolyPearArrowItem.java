package xyz.shurlin.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.shurlin.entity.projectile.HolyPearArrowEntity;

public class HolyPearArrowItem extends Item{

    HolyPearArrowItem() {
        super(new Item.Settings().group(ItemGroups.SHURLIN));
    }

    ProjectileEntity createArrow(World world, LivingEntity shooter, int level) {
        return new HolyPearArrowEntity(shooter,world,level);
    }

}
