package xyz.shurlin.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.shurlin.util.Utils;

import java.util.ArrayList;

public class ChainMinerItem extends PickaxeItem {
    private World world;
    private final BlockPos[] poses = Utils.poses_of_all_directions;
    private final ArrayList<BlockPos> poses1 = new ArrayList<>();

    public ChainMinerItem() {
        super(ToolMaterials.PLANT_JADE, 1, 5f, new Settings().group(ItemGroups.SHURLIN));
    }

    private int mine_deep(BlockPos pos, BlockState state) {
        int cnt = 0;
        world.breakBlock(pos, true);
        for (BlockPos p : poses) {
            BlockPos p1 = pos.add(p);
            if (world.getBlockState(p1) == state)
                cnt += mine_deep(p1, state);
        }
        return ++cnt;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        int r = 4;
        Utils.breakBlocks(world, user.getBlockPos().up(r), r);
        return TypedActionResult.success(stack);
    }

    private void mine_wide(BlockPos pos_o, BlockState state) {
        poses1.add(pos_o);
        for (BlockPos pos : poses1) {
            world.breakBlock(pos, true);
            for (BlockPos p : poses) {
                BlockPos p1 = pos.add(p);
                if (world.getBlockState(p1) == state)
                    poses1.add(p1);
            }
        }
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        this.world = world;
        if (state.getBlock() instanceof OreBlock) {
            stack.damage(mine_deep(pos, state), miner, e ->
                    e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
////            mine_wide(pos, state);
        }
//        ItemEntity itemEntity =  new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), state.getDroppedStacks());
        return super.postMine(stack, world, state, pos, miner);
    }
}
