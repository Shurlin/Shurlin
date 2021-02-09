package xyz.shurlin.entity.passive;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class RoamingSpiritEntity extends PassiveEntity {
//    private SpiritPropertyType type;

    public RoamingSpiritEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
//        this.type = type;
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

//    public static DefaultAttributeContainer.Builder createAttributes() {
//        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D);
//    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new EscapeDangerGoal(this, 2.0D));
    }


}
