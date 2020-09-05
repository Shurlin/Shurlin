package xyz.shurlin.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.shurlin.entity.projectile.LightningArrowEntity;


public class ShurlinPowerfulAxeItem extends Item {
    private static float miningSpeed = (float) 1e8;

    ShurlinPowerfulAxeItem() {
        super(new Item.Settings().group(ItemGroups.SHURLIN).maxCount(1).fireproof());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target instanceof PlayerEntity)
            ((PlayerEntity) target).abilities.invulnerable = false;
        target.kill();
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        return true;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        LightningArrowEntity entity = new LightningArrowEntity(world, user);
        entity.setProperties(user, user.pitch, user.yaw, 0.0f, 3.0f, 1.0f);

    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 144000;
    }

    @Override
    public boolean isEffectiveOn(BlockState state) {
        return true;
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return miningSpeed;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entity;
            int time = 240;
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, time, 255));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, time));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, time, 255));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, time, 255));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, time, 255));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, time, 2));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, time));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, time, 255));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, time, 255));
        }
    }
}
