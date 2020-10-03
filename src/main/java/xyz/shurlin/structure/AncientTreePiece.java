package xyz.shurlin.structure;

import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;

import java.util.List;
import java.util.Random;

public class AncientTreePiece extends SimpleStructurePiece {
    private final AncientTreeData data;
    private final Identifier template;
    private final BlockRotation rotation;

    private AncientTreePiece(StructurePieceType type, StructureManager manager, BlockPos pos, AncientTreeData data) {
        super(type, 0);
        this.data = data;
        this.template = data.getTemplate();
        this.rotation = BlockRotation.NONE;
        this.pos = pos;

        this.initializeStructureData(manager);
    }

    AncientTreePiece(StructurePieceType type, StructureManager manager, CompoundTag tag) {
        super(type, tag);
        this.template = new Identifier(tag.getString("Template"));
        this.rotation = BlockRotation.NONE;
        this.data = AncientTreeData.findData(tag.getString("Type"));
        this.initializeStructureData(manager);
    }

    @Override
    protected void toNbt(CompoundTag tag) {
        super.toNbt(tag);
        tag.putString("Template", this.template.toString());
        tag.putString("Rotation", this.rotation.name());
        tag.putString("Type", this.data.getName());
    }

    @Override
    public boolean generate(ServerWorldAccess serverWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
//            int yHeight = serverWorldAccess.getTopY(Heightmap.Type.WORLD_SURFACE_WG, this.pos.getX() + 8, this.pos.getZ() + 8);
//            this.pos = this.pos.add(0, yHeight - 4, 0);
        pos = serverWorldAccess.getTopPosition(Heightmap.Type.WORLD_SURFACE_WG, pos).down(4);
//            if(serverWorldAccess.getBiome(pos) == Biomes.PEAR_FOREST)
//                serverWorldAccess.setBlockState(pos.add(6,8,8), Blocks.HOLY_PEAR_ALTAR_BLOCK.getDefaultState(),3);
        return super.generate(serverWorldAccess, structureAccessor, chunkGenerator, random, boundingBox, chunkPos, blockPos);
    }

    @Override
    protected void handleMetadata(String metadata, BlockPos pos, WorldAccess world, Random random, BlockBox boundingBox) {
        if ("leaves_chest".equals(metadata)) {
            LootableContainerBlockEntity.setLootTable(world, random, pos.down(), this.data.getLeavesChest());
        }else if("root_chest".equals(metadata)) {
            LootableContainerBlockEntity.setLootTable(world, random, pos.down(), this.data.getRootChest());
        }
    }

    private void initializeStructureData(StructureManager manager) {
        Structure structure = manager.getStructureOrBlank(this.template);
        StructurePlacementData structurePlacementData = (new StructurePlacementData()).setRotation(this.rotation).setMirror(BlockMirror.NONE).setPosition(this.pos).addProcessor(BlockIgnoreStructureProcessor.IGNORE_AIR_AND_STRUCTURE_BLOCKS);
        this.setStructureData(structure, this.pos, structurePlacementData);
    }

    public static void addPieces(StructureManager manager, BlockPos pos, List<StructurePiece> pieces, AncientTreeData data){
        pieces.add(new AncientTreePiece(data.getType(), manager, pos, data));
    }
}

