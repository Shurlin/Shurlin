package xyz.shurlin.block.entity;

import net.minecraft.block.entity.BlockEntity;
import xyz.shurlin.cultivation.CultivationManager;

public class CultivationCrystalBlockEntity extends BlockEntity {
    public static CultivationManager manager = CultivationManager.INSTANCE;

    public CultivationCrystalBlockEntity() {
        super(BlockEntityTypes.CULTIVATION_CRYSTAL_BLOCK_ENTITY);
    }

}
