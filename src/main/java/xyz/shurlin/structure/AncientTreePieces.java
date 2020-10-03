package xyz.shurlin.structure;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.math.BlockPos;

import java.util.List;

class AncientTreePieces {
    static class OakPieces extends AncientTreePiece{
        OakPieces(StructureManager manager, CompoundTag tag) {
            super(StructurePieceTypes.ANCIENT_OAK_TREE, manager, tag);
        }
    }

    static class BirchPieces extends AncientTreePiece{
        BirchPieces(StructureManager manager, CompoundTag tag) {
            super(StructurePieceTypes.ANCIENT_BIRCH_TREE, manager, tag);
        }
    }

    static class DarkOakPieces extends AncientTreePiece{
        DarkOakPieces(StructureManager manager, CompoundTag tag) {
            super(StructurePieceTypes.ANCIENT_DARK_OAK_TREE, manager, tag);
        }
    }

    static class AcaciaPieces extends AncientTreePiece{
        AcaciaPieces(StructureManager manager, CompoundTag tag) {
            super(StructurePieceTypes.ANCIENT_ACACIA_TREE, manager, tag);
        }
    }

    static class SprucePieces extends AncientTreePiece{
        SprucePieces(StructureManager manager, CompoundTag tag) {
            super(StructurePieceTypes.ANCIENT_SPRUCE_TREE, manager, tag);
        }
    }

    static class JunglePieces extends AncientTreePiece{
        JunglePieces(StructureManager manager, CompoundTag tag) {
            super(StructurePieceTypes.ANCIENT_JUNGLE_TREE, manager, tag);
        }
    }

    static class PearPieces extends AncientTreePiece{
        PearPieces(StructureManager manager, CompoundTag tag) {
            super(StructurePieceTypes.ANCIENT_PEAR_TREE, manager, tag);
        }
    }

}
