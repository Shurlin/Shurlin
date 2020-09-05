package xyz.shurlin.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import xyz.shurlin.item.Items;

class PlatycodonGrandiflorusBlock extends FlowerBlock {
    PlatycodonGrandiflorusBlock(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        if(stack.getItem().equals(Items.PLANT_ESSENCE) && stack.getCount() >= 3 && hit.getSide() == Direction.SOUTH){
            stack.decrement(3);
            world.breakBlock(pos, false);
            player.inventory.insertStack(new ItemStack(Items.LIFE_AMULET));
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
}
