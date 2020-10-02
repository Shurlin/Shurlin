package xyz.shurlin.structure;

import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.registry.Registry;

import java.util.Locale;

public class StructurePieceTypes {
    public static final StructurePieceType ANCIENT_OAK_TREE;
    public static final StructurePieceType ANCIENT_BIRCH_TREE;
    public static final StructurePieceType ANCIENT_DARK_OAK_TREE;
    public static final StructurePieceType ANCIENT_ACACIA_TREE;
    public static final StructurePieceType ANCIENT_SPRUCE_TREE;
    public static final StructurePieceType ANCIENT_JUNGLE_TREE;
    public static final StructurePieceType ANCIENT_PEAR_TREE;

    private static StructurePieceType register(String id, StructurePieceType piece){
        return Registry.register(Registry.STRUCTURE_PIECE, id.toLowerCase(Locale.ROOT), piece);
    }

    private static StructurePieceType registerAncientTree(String id, AncientTreeData data){
        return register(id, (manager, tag)->new AncientTreeGenerator.Piece(manager, tag, data));
    }

    static {
        ANCIENT_OAK_TREE = registerAncientTree("ancient_oak_tree", AncientTreeData.OAK);
        ANCIENT_BIRCH_TREE = registerAncientTree("ancient_birch_tree", AncientTreeData.BIRCH);
        ANCIENT_DARK_OAK_TREE = registerAncientTree("ancient_dark_oak_tree", AncientTreeData.DARK_OAK);
        ANCIENT_ACACIA_TREE = registerAncientTree("ancient_acacia_tree", AncientTreeData.ACACIA);
        ANCIENT_SPRUCE_TREE = registerAncientTree("ancient_spruce_tree", AncientTreeData.SPRUCE);
        ANCIENT_JUNGLE_TREE = registerAncientTree("ancient_jungle_tree", AncientTreeData.JUNGLE);
        ANCIENT_PEAR_TREE = registerAncientTree("ancient_oak_tree", AncientTreeData.PEAR);
    }
}
