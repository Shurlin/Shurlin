package xyz.shurlin.util;

import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import xyz.shurlin.block.HolyPearAltarBlock;
import xyz.shurlin.cultivation.CultivationManager;
import xyz.shurlin.cultivation.screen.CultivationUI;
import xyz.shurlin.screen.ScreenHandlerTypes;

public class ServerReceiver {
    public ServerReceiver() {
        ServerSidePacketRegistry.INSTANCE.register(Utils.PACKET_ID_1, (packetContext, packetByteBuf) -> {
            BlockPos pos = packetByteBuf.readBlockPos();
            Block block  = packetContext.getPlayer().world.getBlockState(pos).getBlock();
            if(block instanceof HolyPearAltarBlock){
                ((HolyPearAltarBlock) block).setOwner(packetContext.getPlayer());
            }
        });
        ServerSidePacketRegistry.INSTANCE.register(Utils.OPEN_CUL, (packetContext, packetByteBuf) -> {
            PlayerEntity player = packetContext.getPlayer();
            if(CultivationManager.INSTANCE.isCultivated(player))
                player.openHandledScreen(new CultivationUI());
        });
    }
}
