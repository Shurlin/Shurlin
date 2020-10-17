package xyz.shurlin.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;
import xyz.shurlin.block.Blocks;
import xyz.shurlin.cultivation.CultivationManager;

public class CultivationCrystalBlockEntity extends BlockEntity {
    public static CultivationManager manager = CultivationManager.INSTANCE;
    public static final BlockEntityType BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
            new Identifier(Shurlin.MODID, "cultivation_crystal"),
            BlockEntityType.Builder.create(CultivationCrystalBlockEntity::new, Blocks.CULTIVATION_CRYSTAL).build(null));

    public CultivationCrystalBlockEntity() {
        super(BLOCK_ENTITY);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        manager.fromTag(tag.getCompound("manager"));
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        tag.put("manager", manager.toTag());
        return super.toTag(tag);
    }
}
