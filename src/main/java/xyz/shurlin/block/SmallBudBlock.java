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
import xyz.shurlin.entity.damage.ShurlinDamageSource;
import xyz.shurlin.item.Items;
import xyz.shurlin.util.Utils;

public class SmallBudBlock extends FernBlock {
    public SmallBudBlock(Settings settings) {
        super(settings);
    }

    /**
     * <p>If player is in creative mode, it will no longer
     * damage cuz of small bud.</p><p>
     * A brand new message is shown when dying.</p>
     * @author Garay Shurlin
     * @author teddyxlandlee
     * @since 0.1.2-beta
     */
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (player.inventory.contains(new ItemStack(Items.SHURLIN_INGOT))){
            Utils.spawnItem(world, pos, Items.PLANT_ESSENCE_PARTICLE, world.random.nextInt(3));
        } else if (!player.abilities.creativeMode) {
            player.sendMessage(new TranslatableText("message.shurlin.small_bud"),false);
            player.damage(ShurlinDamageSource.SMALL_BUD, 3.4028235E38F);
        }
    }
}
