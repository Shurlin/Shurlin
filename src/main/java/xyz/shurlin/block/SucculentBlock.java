package xyz.shurlin.block;


import net.minecraft.block.Block;
import net.minecraft.block.SlimeBlock;
import net.minecraft.state.property.BooleanProperty;

public class SucculentBlock extends SlimeBlock {
    public static final BooleanProperty SHINING = BooleanProperty.of("shining");

    public SucculentBlock(Settings settings) {
        super(settings);
    }


}
