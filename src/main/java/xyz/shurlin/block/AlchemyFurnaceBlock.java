package xyz.shurlin.block;

import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import xyz.shurlin.block.entity.AlchemyFurnaceBlockEntity;

public class AlchemyFurnaceBlock extends BlockWithEntity {

    AlchemyFurnaceBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new AlchemyFurnaceBlockEntity();
    }
}
