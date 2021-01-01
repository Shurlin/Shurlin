package xyz.shurlin.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import xyz.shurlin.entity.projectile.BeanEntity;

public class HolyPearWandItem extends BasicItem {

    HolyPearWandItem() {
        super(new Settings().group(ItemGroups.SHURLIN).maxDamage(2000));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        for(int i=0;i<8;i++){
            BeanEntity beanEntity = new BeanEntity(user, world);
//            ArrowEntity arrowEntity = new ArrowEntity(world, user);
            beanEntity.setProperties(user, user.pitch, user.yaw, 0.5f, 3f, 1.0f);
//            FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(world, stack, user);
            world.spawnEntity(beanEntity);
        }
        return TypedActionResult.success(stack);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return 1.0f;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.getItem().equals(Items.HOLY_PEAR);
    }

//    @Override
//    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
//        if (entity instanceof PlayerEntity) {
//            ((PlayerEntity) entity).abilities.allowFlying = (selected && ((PlayerEntity) entity).inventory.getSlotWithStack(new ItemStack(Items.HOLY_PEAR))>0)
//                    || ((PlayerEntity) entity).isCreative();
//
//            ((PlayerEntity) entity).abilities.invulnerable = selected && ((PlayerEntity) entity).inventory.getSlotWithStack(new ItemStack(Items.HOLY_PEAR))>0;
//
//            if(((PlayerEntity) entity).abilities.flying && !((PlayerEntity) entity).isCreative())
//                if(entity.world.random.nextFloat() < 0.05)
//                    stack.damage(1, (PlayerEntity) entity, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
//
//            if(!selected && ((PlayerEntity) entity).abilities.flying && !((PlayerEntity) entity).isCreative())
//                ((PlayerEntity) entity).abilities.flying = false;
//        }
//    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.kill();
        stack.damage(1, attacker, entity -> entity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return 66;
    }
}
