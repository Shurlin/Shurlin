package xyz.shurlin.block.worker;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import xyz.shurlin.block.worker.entity.CollectorBlockEntity;
import xyz.shurlin.util.Stats;

public class CollectorBlock extends AbstractWorkerBlock {
    public CollectorBlock(Settings settings) {
        super(settings);
    }

    @Override
    void openScreen(World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof CollectorBlockEntity) {
            player.openHandledScreen((CollectorBlockEntity) blockEntity);
            player.incrementStat(Stats.USE_WORKER);
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new CollectorBlockEntity(level);
    }
}
