package xyz.shurlin.entity.projectile;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import xyz.shurlin.util.Utils;

public class LightningArrowEntity extends ArrowEntity {

    public LightningArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    @Override
    public void tick() {
        Utils.createLightning(world, this.getBlockPos());
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        this.remove();
    }
}
