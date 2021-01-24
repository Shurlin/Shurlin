package xyz.shurlin.structure;

import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import xyz.shurlin.Shurlin;
import xyz.shurlin.loot.LootTables;

public class AncientTreeData {
    public static final AncientTreeData OAK = new AncientTreeData(StructurePieceTypes.ANCIENT_OAK_TREE, "oak", LootTables.ANCIENT_OAK_TREE_LEAVES_CHEST, LootTables.ANCIENT_OAK_TREE_ROOT_CHEST);
    public static final AncientTreeData BIRCH = new AncientTreeData(StructurePieceTypes.ANCIENT_BIRCH_TREE, "birch", LootTables.ANCIENT_BIRCH_TREE_LEAVES_CHEST, LootTables.ANCIENT_BIRCH_TREE_ROOT_CHEST);
    public static final AncientTreeData DARK_OAK = new AncientTreeData(StructurePieceTypes.ANCIENT_DARK_OAK_TREE, "dark_oak", LootTables.ANCIENT_DARK_OAK_TREE_LEAVES_CHEST, LootTables.ANCIENT_DARK_OAK_TREE_ROOT_CHEST);
    public static final AncientTreeData ACACIA = new AncientTreeData(StructurePieceTypes.ANCIENT_ACACIA_TREE, "acacia", LootTables.ANCIENT_ACACIA_TREE_LEAVES_CHEST, LootTables.ANCIENT_ACACIA_TREE_ROOT_CHEST);
    public static final AncientTreeData SPRUCE = new AncientTreeData(StructurePieceTypes.ANCIENT_SPRUCE_TREE, "spruce", LootTables.ANCIENT_SPRUCE_TREE_LEAVES_CHEST, LootTables.ANCIENT_SPRUCE_TREE_ROOT_CHEST);
    public static final AncientTreeData JUNGLE = new AncientTreeData(StructurePieceTypes.ANCIENT_JUNGLE_TREE, "jungle", LootTables.ANCIENT_JUNGLE_TREE_LEAVES_CHEST, LootTables.ANCIENT_JUNGLE_TREE_ROOT_CHEST);
    public static final AncientTreeData PEAR = new AncientTreeData(StructurePieceTypes.ANCIENT_PEAR_TREE, "pear", LootTables.ANCIENT_PEAR_TREE_LEAVES_CHEST, LootTables.ANCIENT_PEAR_TREE_ROOT_CHEST);

    private final StructurePieceType type;
    private final String name;
    private final Identifier template;
    private final Identifier leavesChest;
    private final Identifier rootChest;

    private AncientTreeData(StructurePieceType type, String name, Identifier leavesChest, Identifier rootChest) {
        this.type = type;
        this.name = name;
        this.template = new Identifier(Shurlin.MODID, "ancient_trees/ancient_" + name + "_tree");
        this.leavesChest = leavesChest;
        this.rootChest = rootChest;
    }

    public String getName() {
        return name;
    }

    static AncientTreeData findData(String name){
        switch (name){
            case "oak":
                return OAK;
            case "birch":
                return BIRCH;
            case "dark_oak":
                return DARK_OAK;
            case "acacia":
                return ACACIA;
            case "spruce":
                return SPRUCE;
            case "jungle":
                return JUNGLE;
            case "pear":
                return PEAR;
            default:
                return null;
        }
    }

    public StructurePieceType getType() {
        return type;
    }

    public Identifier getTemplate() {
        return template;
    }

    public Identifier getLeavesChest() {
        return leavesChest;
    }

    public Identifier getRootChest() {
        return rootChest;
    }
}
