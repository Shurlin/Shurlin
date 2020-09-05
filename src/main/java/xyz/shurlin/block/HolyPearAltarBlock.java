package xyz.shurlin.block;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import xyz.shurlin.Shurlin;
import xyz.shurlin.client.options.KeyBindings;
import xyz.shurlin.item.Items;
import xyz.shurlin.util.Utils;

import java.util.concurrent.TimeUnit;

public class HolyPearAltarBlock extends Block {
    private PlayerEntity owner;

    HolyPearAltarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack mainStack = player.getStackInHand(Hand.MAIN_HAND);
        ItemStack offStack = player.getStackInHand(Hand.OFF_HAND);
        if(!mainStack.getItem().equals(Items.PEAR) || !offStack.getItem().equals(Items.PLANT_ESSENCE))
            return ActionResult.FAIL;
        int cnt = Math.min(mainStack.getCount(), offStack.getCount());
        mainStack.decrement(cnt);
        offStack.decrement(cnt);
        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < cnt; i++) {
                    if (!player.isAlive())
                        break;
                    player.inventory.insertStack(new ItemStack(Items.HOLY_PEAR));
                    Utils.createLightning(world, player.getBlockPos());
                    TimeUnit.SECONDS.sleep(Shurlin.random.nextInt(3) + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        if(entity instanceof PlayerEntity){
            ((PlayerEntity) entity).addExperience(1);
            if(!((PlayerEntity) entity).abilities.creativeMode)
                if(Shurlin.random.nextFloat() < 0.1)
                    entity.setFireTicks(200);
            if(world.isClient){
                if(KeyBindings.keyBinding_j.isPressed()){
                    PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
                    passedData.writeBlockPos(pos);
                    ClientSidePacketRegistry.INSTANCE.sendToServer(Utils.PACKET_ID_1, passedData);
                    ((PlayerEntity) entity).sendMessage(new TranslatableText("message.shurlin.holy_pear_altar.bound_success"), false);
                }
            }
        }
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        if (entity instanceof ItemEntity && this.owner != null) {
            ItemStack stack = ((ItemEntity) entity).getStack();
            Item item = stack.getItem();
            int flag = item.equals(Items.PLANT_IRON_INGOT) ? 1 : (item.equals(Items.PLANT_GOLD_INGOT) ? 2 : (item.equals(Items.PLANT_JADE) ? 8 : 0));
            if (flag > 0) {
                int cnt = stack.getCount();
                if (Shurlin.random.nextInt(64 / flag) < cnt)
                    this.owner.inventory.insertStack(new ItemStack(Items.SHURLIN_INGOT));
                entity.remove();
            }
        }
    }

    public void setOwner(PlayerEntity owner) {
        this.owner = owner;
    }
}
