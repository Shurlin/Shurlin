package xyz.shurlin.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import xyz.shurlin.entity.projectile.HolyPearArrowEntity;

public class HolyPearArrowItem extends Item{

    public HolyPearArrowItem() {
        super(new Item.Settings().group(ItemGroups.SHURLIN));
    }

    protected ProjectileEntity createArrow(World world, LivingEntity shooter, int level, boolean destroy) {
        return new HolyPearArrowEntity(shooter, world, level, destroy);
    }

}
