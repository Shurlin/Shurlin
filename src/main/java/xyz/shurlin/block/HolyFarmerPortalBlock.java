package xyz.shurlin.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import xyz.shurlin.util.Utils;
import xyz.shurlin.world.dimension.Dimensions;

public class HolyFarmerPortalBlock extends BasicBlock {
    private static final VoxelShape SHAPE;

    public HolyFarmerPortalBlock(Settings settings) {
        super(settings);
//        NetherPortalBlock
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public static void createPortal(World world, BlockPos pos){
        if(world.getRegistryKey() == Dimensions.HOLY_FARMER || world.getRegistryKey() == World.OVERWORLD) {
            Block block = world.getBlockState(pos).getBlock();
            if(block == Blocks.HOLY_FARMER_PORTAL || block == Blocks.PLANT_OBSIDIAN)
                return ;
            world.setBlockState(pos, Blocks.HOLY_FARMER_PORTAL.getDefaultState(), 3);
            if(block == Blocks.PHOENIX_LEAVES){
                for(BlockPos dir: Utils.poses_of_horizontal){
                    createPortal(world, pos.add(dir));
                }
            }
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if(!entity.hasVehicle() && !entity.hasPassengers() && entity.canUsePortals() && world instanceof ServerWorld)
            Utils.joinHolyFarmerDimension((ServerWorld) world, entity);
    }

//    @Override
//    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack stack) {
//        for(BlockPos pos1 : Utils.poses_of_horizontal){
//            BlockPos pos2 = pos.add(pos1);
//            if(world.getBlockState(pos2).isOf(Blocks.HOLY_FARMER_PORTAL)){
//                world.breakBlock(pos2, false);
//            }
//        }
//    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        for(BlockPos pos1 : Utils.poses_of_horizontal){
            BlockPos pos2 = pos.add(pos1);
            if(world.getBlockState(pos2).isOf(Blocks.HOLY_FARMER_PORTAL)){
                world.breakBlock(pos2, false);
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        return stateFrom.isOf(this) || super.isSideInvisible(state, stateFrom, direction);
    }

    static {
        SHAPE = Block.createCuboidShape(0.0D, 6.0D, 0.0D, 16.0D, 10.0D, 16.0D);
    }
}
