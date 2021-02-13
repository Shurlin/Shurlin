package xyz.shurlin.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.shurlin.item.Items;
import xyz.shurlin.util.Utils;

public class MysteriousStoneBlock extends Block {
    private static final IntProperty TIMES;

    public MysteriousStoneBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(TIMES, 0));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack inHand = player.getStackInHand(hand);
        if(!inHand.getItem().equals(Items.PLANT_JADE))
            return ActionResult.FAIL;
        world.breakBlock(pos, false);
        if (state.get(TIMES) < 9) Utils.setRandomBlock(world, pos, 4, state.with(TIMES, state.get(TIMES) + 1));
        else {
                inHand.decrement(1);
                ItemStack result = new ItemStack(Items.MYSTERIOUS_SPIRIT_OF_PLANT, world.random.nextInt(2));
                player.inventory.insertStack(result);
            }
//            ItemEntity entity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), result);
//            world.spawnEntity(entity);
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TIMES);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx);
    }

    static {
        TIMES = IntProperty.of("times", 0, 9);
    }
}

