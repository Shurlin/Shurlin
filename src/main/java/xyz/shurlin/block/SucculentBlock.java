package xyz.shurlin.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlimeBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import xyz.shurlin.Shurlin;

public class SucculentBlock extends SlimeBlock {
    public static final BooleanProperty SHINING = BooleanProperty.of("shining");

    public SucculentBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(SHINING, Shurlin.random.nextFloat()<0.05));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SHINING);
    }
}
