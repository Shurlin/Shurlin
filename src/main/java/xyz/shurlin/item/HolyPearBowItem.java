package xyz.shurlin.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class HolyPearBowItem extends BowItem {
    private static final Predicate<ItemStack> PEARS = (stack) -> stack.getItem() == Items.HOLY_PEAR;

    public HolyPearBowItem() {
        super(new Item.Settings().group(ItemGroups.SHURLIN).maxDamage(1000));
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return PEARS;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.getItem().equals(Items.HOLY_PEAR);
    }


    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        int i = this.getMaxUseTime(stack) - remainingUseTicks;
        float f = getPullProgress(i);
        if (!world.isClient && user instanceof PlayerEntity) {
            boolean destroy = ((PlayerEntity) user).inventory.getStack(23).getItem() == (net.minecraft.item.Items.GUNPOWDER);
            HolyPearArrowItem holyPearArrow = new HolyPearArrowItem();
            ProjectileEntity projectileEntity = holyPearArrow.createArrow(world, user, 0, destroy);
            projectileEntity.setProperties(user, user.pitch, user.yaw, 0.0F, f * 10.0F, 1.0F);
            world.spawnEntity(projectileEntity);
            stack.damage(1, user, e->e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
    }
}
