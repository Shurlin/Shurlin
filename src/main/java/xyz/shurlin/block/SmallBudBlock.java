package xyz.shurlin.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FernBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.shurlin.Shurlin;
import xyz.shurlin.item.Items;
import xyz.shurlin.util.Utils;

class SmallBudBlock extends FernBlock {
    SmallBudBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(player.inventory.contains(new ItemStack(Items.SHURLIN_INGOT))){
            Utils.spawnItem(world, pos, Items.PLANT_ESSENCE_PARTICLE, Shurlin.random.nextInt(3));
        }else{
            player.sendMessage(new TranslatableText("message.shurlin.small_bud"),false);
            player.kill();
        }
    }
}
