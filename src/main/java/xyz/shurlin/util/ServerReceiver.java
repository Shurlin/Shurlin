package xyz.shurlin.util;

import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import xyz.shurlin.block.HolyPearAltarBlock;

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

        });
    }
}
