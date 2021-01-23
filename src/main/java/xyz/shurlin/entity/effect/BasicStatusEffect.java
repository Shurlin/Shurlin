package xyz.shurlin.entity.effect;

import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

class BasicStatusEffect extends StatusEffect {
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if(this == StatusEffects.LOVED){
            entity.setHealth(entity.getMaxHealth());
            if(entity.isDead()){
                entity.world.sendEntityStatus(entity, (byte)35);
                entity.setPose(EntityPose.STANDING);
            }
        }

    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if(this == StatusEffects.LOVED)
            return true;
        return super.canApplyUpdateEffect(duration, amplifier);
    }

    public BasicStatusEffect(StatusEffectType type, int color) {
        super(type, color);
    }
}
