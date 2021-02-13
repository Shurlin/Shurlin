package xyz.shurlin.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import xyz.shurlin.item.Items;

public class BeanEntity extends ArrowEntity {

    public BeanEntity(EntityType<BeanEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected void onHit(LivingEntity target) {
        target.damage(DamageSource.thrownProjectile(this, getOwner()), random.nextInt(3)+2);
        this.remove();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        this.remove();
    }

    public BeanEntity(LivingEntity owner, World world) {
        super(world, owner);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Items.BEAN);
    }

}
