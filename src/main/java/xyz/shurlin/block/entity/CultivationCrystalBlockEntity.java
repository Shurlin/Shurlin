package xyz.shurlin.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import xyz.shurlin.cultivation.CultivationManager;

public class CultivationCrystalBlockEntity extends BlockEntity {
    public static CultivationManager manager = CultivationManager.INSTANCE;

    public CultivationCrystalBlockEntity() {
        super(BlockEntityTypes.CULTIVATION_CRYSTAL_BLOCK_ENTITY);
    }

}
