package xyz.shurlin.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CoralAmuletItem extends BasicItem {
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 200));
    }
}
