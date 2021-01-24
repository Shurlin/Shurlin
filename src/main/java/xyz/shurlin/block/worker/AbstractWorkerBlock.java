package xyz.shurlin.block.worker;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.shurlin.block.worker.entity.AbstractWorkerBlockEntity;

abstract class AbstractWorkerBlock extends BlockWithEntity {
    int level;

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient){
            return ActionResult.SUCCESS;
        }else {
            this.openScreen(world, pos, player);
                return ActionResult.CONSUME;
        }
    }

    private AbstractWorkerBlock(Settings settings, int level) {
        super(settings);
        this.level = level;
    }

    AbstractWorkerBlock(Settings settings) {
        this(settings, 1);
    }

    abstract void openScreen(World world, BlockPos pos, PlayerEntity player);

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AbstractWorkerBlockEntity) {
                ((AbstractWorkerBlockEntity)blockEntity).setCustomName(itemStack.getName());
            }
        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AbstractWorkerBlockEntity) {
                ItemScatterer.spawn(world, pos, (AbstractWorkerBlockEntity)blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
}
