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
import xyz.shurlin.block.Blocks;
import xyz.shurlin.loot.LootTables;
import xyz.shurlin.world.biome.Biomes;

import java.util.List;
import java.util.Random;

public class AncientOakTreeGenerator {
    private static final Identifier TEMPLATE = new Identifier("ancient_trees/ancient_oak_tree");

    public static void addPieces(StructureManager manager, BlockPos pos, List<StructurePiece> pieces){
        pieces.add(new AncientOakTreeGenerator.Piece(manager, TEMPLATE, pos));
    }

    public static class Piece extends SimpleStructurePiece {
        private final Identifier template;
        private final BlockRotation rotation;

        private Piece(StructureManager manager, Identifier identifier, BlockPos pos) {
            super(StructurePieceTypes.ANCIENT_OAK_TREE, 0);
            this.template = identifier;
            this.rotation = BlockRotation.NONE;
            this.pos = pos;

            this.initializeStructureData(manager);
        }

        Piece(StructureManager manager, CompoundTag tag) {
            super(StructurePieceTypes.ANCIENT_OAK_TREE, tag);
            this.template = new Identifier(tag.getString("Template"));
            this.rotation = BlockRotation.NONE;
            this.initializeStructureData(manager);
        }

        @Override
        protected void toNbt(CompoundTag tag) {
            super.toNbt(tag);
            tag.putString("Template", this.template.toString());
            tag.putString("Rotation", this.rotation.name());
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
                LootableContainerBlockEntity.setLootTable(world, random, pos.down(), LootTables.ANCIENT_OAK_TREE_LEAVES_CHEST);
            }else if("root_chest".equals(metadata)) {
                LootableContainerBlockEntity.setLootTable(world, random, pos.down(), LootTables.ANCIENT_OAK_TREE_ROOT_CHEST);
            }
        }

        private void initializeStructureData(StructureManager manager) {
            Structure structure = manager.getStructureOrBlank(this.template);
            StructurePlacementData structurePlacementData = (new StructurePlacementData()).setRotation(this.rotation).setMirror(BlockMirror.NONE).setPosition(this.pos).addProcessor(BlockIgnoreStructureProcessor.IGNORE_AIR_AND_STRUCTURE_BLOCKS);
            this.setStructureData(structure, this.pos, structurePlacementData);
        }
    }

}
