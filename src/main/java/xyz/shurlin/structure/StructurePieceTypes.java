package xyz.shurlin.structure;

import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.registry.Registry;

import java.util.Locale;

public class StructurePieceTypes {
    public static final StructurePieceType ANCIENT_OAK_TREE;
    public static final StructurePieceType ANCIENT_PEAR_TREE;

    private static StructurePieceType register(String id, StructurePieceType piece){
        return Registry.register(Registry.STRUCTURE_PIECE, id.toLowerCase(Locale.ROOT), piece);
    }

    static {
        ANCIENT_OAK_TREE = register("ancient_oak_tree", AncientOakTreeGenerator.Piece::new);
        ANCIENT_PEAR_TREE = register("ancient_pear_tree", AncientPearTreeGenerator.Piece::new);
    }
}
