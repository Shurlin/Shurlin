package xyz.shurlin.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import xyz.shurlin.util.Collectable;

public class LifeAmuletItem extends BasicItem implements Collectable {
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(enable(slot)){
            ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200));
        }
    }

    private boolean enable(int slot){
        return slot == 25;
    }

    @Override
    public int getConsistence(World world, Vec3i pos) {
        return 80;
    }

    @Override
    public int getTime() {
        return 80;
    }
}
