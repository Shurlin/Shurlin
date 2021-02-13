package xyz.shurlin.structure;

import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;

public class StructurePieceTypes {
    public static final StructurePieceType ANCIENT_OAK_TREE;
    public static final StructurePieceType ANCIENT_BIRCH_TREE;
    public static final StructurePieceType ANCIENT_DARK_OAK_TREE;
    public static final StructurePieceType ANCIENT_ACACIA_TREE;
    public static final StructurePieceType ANCIENT_SPRUCE_TREE;
    public static final StructurePieceType ANCIENT_JUNGLE_TREE;
    public static final StructurePieceType ANCIENT_PEAR_TREE;

    private static StructurePieceType register(String id, StructurePieceType piece){
        return Registry.register(Registry.STRUCTURE_PIECE, new Identifier(Shurlin.MODID, id), piece);
    }

    static {
        ANCIENT_OAK_TREE = register("ancient_oak_tree", AncientTreePieces.OakPieces::new);
        ANCIENT_BIRCH_TREE = register("ancient_birch_tree", AncientTreePieces.BirchPieces::new);
        ANCIENT_DARK_OAK_TREE = register("ancient_dark_oak_tree", AncientTreePieces.DarkOakPieces::new);
        ANCIENT_ACACIA_TREE = register("ancient_acacia_tree", AncientTreePieces.AcaciaPieces::new);
        ANCIENT_SPRUCE_TREE = register("ancient_spruce_tree", AncientTreePieces.SprucePieces::new);
        ANCIENT_JUNGLE_TREE = register("ancient_jungle_tree", AncientTreePieces.JunglePieces::new);
        ANCIENT_PEAR_TREE = register("ancient_pear_tree", AncientTreePieces.PearPieces::new);
    }
}
