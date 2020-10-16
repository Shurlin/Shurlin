package xyz.shurlin.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import xyz.shurlin.block.entity.CultivationCrystalBlockEntity;
import xyz.shurlin.spirit.CultivationManager;
import xyz.shurlin.spirit.CultivationRealm;

public class CultivationCrystalBlock extends BlockWithEntity {
    private static CultivationManager manager = CultivationManager.INSTANCE;
    private static final VoxelShape SHAPE = Block.createCuboidShape(4, 4, 4, 12,12, 12);


    protected CultivationCrystalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new CultivationCrystalBlockEntity();
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        CultivationRealm realm = manager.getCultivationRealmByEntity(player);
        if(realm==null){
            realm = manager.appendCultivationEntity(player);
        }
        player.sendMessage(new TranslatableText("realm.shurlin." + realm.getRealm().getName() + ".rank", realm.getRank()), false);
        return ActionResult.FAIL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        return stateFrom.isOf(this) || super.isSideInvisible(state, stateFrom, direction);
    }
}
