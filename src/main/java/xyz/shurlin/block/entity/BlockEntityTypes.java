package xyz.shurlin.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;
import xyz.shurlin.block.Blocks;
import xyz.shurlin.block.worker.entity.BreakerBlockEntity;
import xyz.shurlin.block.worker.entity.CollectorBlockEntity;
import xyz.shurlin.block.worker.entity.ConcentratorBlockEntity;
import xyz.shurlin.block.worker.entity.ExtractorBlockEntity;

import static net.minecraft.block.entity.BlockEntityType.Builder.create;

public class BlockEntityTypes {
    public static final BlockEntityType<CultivationCrystalBlockEntity> CULTIVATION_CRYSTAL_BLOCK_ENTITY = create(CultivationCrystalBlockEntity::new, Blocks.CULTIVATION_CRYSTAL).build(null);

    public static final BlockEntityType<BreakerBlockEntity> BREAKER_BLOCK_ENTITY = create(BreakerBlockEntity::new, Blocks.BREAKER_BLOCK).build(null);

    public static final BlockEntityType<CollectorBlockEntity> COLLECTOR_BLOCK_ENTITY = create(CollectorBlockEntity::new, Blocks.COLLECTOR_BLOCK).build(null);

    public static final BlockEntityType<ConcentratorBlockEntity> CONCENTRATOR_BLOCK_ENTITY = create(ConcentratorBlockEntity::new, Blocks.CONCENTRATOR_BLOCK).build(null);

    public static final BlockEntityType<ExtractorBlockEntity> EXTRACTOR_BLOCK_ENTITY = create(ExtractorBlockEntity::new, Blocks.EXTRACTOR_BLOCK).build(null);

    private static void register(String registryName, BlockEntityType<?> entry){
        Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Shurlin.MODID, registryName),
                entry);
    }

    public static void registerAll() {
        register("cultivation_crystal", CULTIVATION_CRYSTAL_BLOCK_ENTITY);
        register("breaker_block_entity", BREAKER_BLOCK_ENTITY);
        register("collector_block_entity", COLLECTOR_BLOCK_ENTITY);
        register("concentrator_block_entity", CONCENTRATOR_BLOCK_ENTITY);
        register("extractor_block_entity", EXTRACTOR_BLOCK_ENTITY);
    }
}
