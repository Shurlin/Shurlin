package xyz.shurlin.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import xyz.shurlin.block.entity.CultivationCrystalBlockEntity;
import xyz.shurlin.spirit.CultivationManager;
import xyz.shurlin.spirit.CultivationRealm;

public class CultivationCrystalBlock extends BlockWithEntity {
    private static CultivationManager manager = CultivationManager.INSTANCE;

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
        player.sendMessage(new TranslatableText("realm.shurlin." + realm.getRealm().getName() + "{}", realm.getRank()), false);
        return ActionResult.FAIL;
    }
}
