package xyz.shurlin.block;

import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class MicroCraterBlock extends BasicBlock {
    private boolean working;

    MicroCraterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(random.nextInt(200)==0){
            working=true;
            erupt(world);
        }
    }
    private void erupt(ServerWorld world){
//        world.addFireworkParticle();
    }
}
