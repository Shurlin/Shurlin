package xyz.shurlin;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import xyz.shurlin.block.Blocks;
import xyz.shurlin.client.gui.screen.HandledScreens;
import xyz.shurlin.item.Items;

public class ShurlinClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                Blocks.SMALL_BUD,
                Blocks.PEAR_SAPLING,
                Blocks.PHOENIX_SAPLING,
                Blocks.PLATYCODON_GRANDIFLORUS,
                Blocks.PEAR_DOOR,
                Blocks.LEAVE_CORAL,
                Blocks.DEAD_LEAVE_CORAL,
                Blocks.LEAVE_CORAL_FAN,
                Blocks.DEAD_LEAVE_CORAL_FAN,
                Blocks.LEAVE_CORAL_WALL_FAN,
                Blocks.DEAD_LEAVE_CORAL_WALL_FAN);
//        BlockRenderLayerMap.INSTANCE.putItem(Items.TENUOUS_WOOD_SPIRIT, RenderLayer.());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.HOLY_FARMER_PORTAL, RenderLayer.getTranslucent());
        new HandledScreens();
    }
}
