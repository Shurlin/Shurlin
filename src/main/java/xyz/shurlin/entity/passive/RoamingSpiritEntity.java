package xyz.shurlin.entity.passive;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xyz.shurlin.cultivation.SpiritPropertyType;
import xyz.shurlin.entity.EntityTypes;

public class RoamingSpiritEntity extends PassiveEntity {
//    private SpiritPropertyType type;

    public RoamingSpiritEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
//        this.type = type;
    }

    public static DefaultAttributeContainer.Builder createCowAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new EscapeDangerGoal(this, 2.0D));
    }

    @Override
    public @Nullable PassiveEntity createChild(PassiveEntity mate) {
        return null;
    }
}
