package xyz.shurlin.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.shurlin.block.Blocks;
import xyz.shurlin.block.HolyFarmerPortalBlock;
import xyz.shurlin.util.Utils;

import java.util.Vector;

public class PlantWandItem extends Item {
    public PlantWandItem() {
        super(new Settings().maxDamage(256).group(ItemGroups.SHURLIN));
    }

//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        ItemStack stack = user.getStackInHand(hand);
//        for (Identifier id : Registry.RECIPE_SERIALIZER.getIds()) {
//            System.out.println(id);
//        }
//        return TypedActionResult.success(stack);
//    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        Block block = world.getBlockState(pos).getBlock();
        PlayerEntity player = context.getPlayer();
        if(player != null) {
            PlayerInventory inventory = player.inventory;
            ItemStack stack = new ItemStack(Items.MYSTERIOUS_SPIRIT_OF_PLANT);
            if(block.equals(Blocks.PHOENIX_LEAVES) && inventory.contains(stack)){
                Vector<BlockPos> vector = new Vector<>();
                if(Utils.isSealed(world, pos, Utils.poses_of_horizontal,
                        Blocks.PHOENIX_LEAVES, Blocks.PLANT_OBSIDIAN, vector)){
                    HolyFarmerPortalBlock.createPortal(world, pos);
                    stack.decrement(1);
                }
            }
        }
        return ActionResult.SUCCESS;
    }
}
