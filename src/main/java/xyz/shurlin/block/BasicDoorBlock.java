package xyz.shurlin.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class BasicDoorBlock extends DoorBlock {
    public BasicDoorBlock() {
        this(FabricBlockSettings.of(Material.WOOD).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque());
    }

    private BasicDoorBlock(Settings settings) {
        super(settings);
    }
}
