package xyz.shurlin.item;

import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;

public class HolyPearSwordItem extends BasicItem {

    public HolyPearSwordItem() {
        super(new Item.Settings().group(ItemGroups.SHURLIN).maxDamage(2000));
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        entity.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, user.getPos());
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).dropSelectedItem(true);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        PlayerEntity player = world.getClosestPlayer(user, 16d);
        if(player == null)
            return TypedActionResult.fail(stack);
        double x = player.getX();
        double z = player.getZ();
        player.setPos(x, world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, (int) x, (int) z), z);
        return TypedActionResult.success(stack);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return stack.getItem() == Items.HOLY_PEAR;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof PlayerEntity) {
            if (((PlayerEntity) target).inventory.getStack(25).getItem() == Items.LIFE_AMULET)
                if (((PlayerEntity) attacker).inventory.getStack(25).getItem() == Items.LIFE_AMULET)
                    return false;
                else attacker.kill();
            else {
                target.kill();
            }
        } else {
            target.kill();
        }
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
