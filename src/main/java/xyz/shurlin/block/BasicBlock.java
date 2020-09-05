package xyz.shurlin.block;


import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class BasicBlock extends Block {

    public BasicBlock(Block block) {
        this(FabricBlockSettings.copy(block));
    }

    BasicBlock(Material material) {
        this(FabricBlockSettings.of(material));
    }

    BasicBlock(Settings settings) {
        super(settings);
    }
}
