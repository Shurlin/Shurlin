package xyz.shurlin.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import xyz.shurlin.cultivation.CultivationManager;
import xyz.shurlin.cultivation.CultivationRealm;
import xyz.shurlin.cultivation.SpiritPropertyType;

public class SpiritItem extends BasicItem{
    private final SpiritPropertyType spiritPropertyType;
    private final double spiritConsistence;

    public SpiritItem(SpiritPropertyType spiritPropertyType, double spiritConsistence) {
        this.spiritPropertyType = spiritPropertyType;
        this.spiritConsistence = spiritConsistence;
    }

    public SpiritPropertyType getSpiritPropertyType() {
        return spiritPropertyType;
    }

    public double getSpiritConsistence() {
        return spiritConsistence;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        super.usageTick(world, user, stack, remainingUseTicks);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        CultivationRealm realm = CultivationManager.INSTANCE.getCultivationRealmByEntity(user);
        if(realm!=null){
            realm.upgrade();
        }
        return TypedActionResult.success(stack);
    }
}
