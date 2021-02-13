package xyz.shurlin.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import xyz.shurlin.item.Items;
import xyz.shurlin.util.Utils;

public class HolyPearArrowEntity extends ArrowEntity {
    private static final int[] powers = new int[]{2,8,30};
    private int power;
    private boolean destroy;

    public HolyPearArrowEntity(EntityType<HolyPearArrowEntity> entityType, World world) {
        super(entityType, world);
    }

//    @Override
//    public void tick() {
//        super.tick();
//        if(this.world.isClient){
//            this.world.addParticle(ParticleTypes.ENTITY_EFFECT, this.getParticleX(0.2d), this.getRandomBodyY(), this.getParticleZ(0.2d), 0, 255, 0);
//        }
//    }

    @Override
    public void tick() {
        super.tick();
        world.addParticle(ParticleTypes.ENTITY_EFFECT,this.getParticleX(0.5D), this.getRandomBodyY(), this.getParticleZ(0.5D),0,255, 0);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Vec3d v = entityHitResult.getPos();
        world.createExplosion(this, v.x, v.y, v.z, power, destroy ? Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE);
        Utils.createLightning(world, entityHitResult.getEntity().getBlockPos());
        this.remove();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        Vec3d v = blockHitResult.getPos();
        world.createExplosion(this, v.x, v.y, v.z, power, destroy ? Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE);
        Utils.createLightning(world, blockHitResult.getBlockPos());
        this.remove();
    }

    public HolyPearArrowEntity(LivingEntity owner, World world, int level, boolean destroy) {
        super(world, owner);
        this.power = powers[level];
        this.destroy = destroy;
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Items.HOLY_PEAR);
    }

}
