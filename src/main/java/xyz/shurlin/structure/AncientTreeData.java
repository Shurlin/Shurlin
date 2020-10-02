package xyz.shurlin.structure;

import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import xyz.shurlin.loot.LootTables;

public enum AncientTreeData {
    OAK(StructurePieceTypes.ANCIENT_OAK_TREE, "oak", LootTables.ANCIENT_OAK_TREE_LEAVES_CHEST, LootTables.ANCIENT_OAK_TREE_ROOT_CHEST),
    BIRCH(StructurePieceTypes.ANCIENT_BIRCH_TREE, "birch", LootTables.ANCIENT_BIRCH_TREE_LEAVES_CHEST, LootTables.ANCIENT_BIRCH_TREE_ROOT_CHEST),
    DARK_OAK(StructurePieceTypes.ANCIENT_DARK_OAK_TREE, "dark_oak", LootTables.ANCIENT_DARK_OAK_TREE_LEAVES_CHEST, LootTables.ANCIENT_DARK_OAK_TREE_ROOT_CHEST),
    ACACIA(StructurePieceTypes.ANCIENT_ACACIA_TREE, "acacia", LootTables.ANCIENT_ACACIA_TREE_LEAVES_CHEST, LootTables.ANCIENT_ACACIA_TREE_ROOT_CHEST),
    SPRUCE(StructurePieceTypes.ANCIENT_SPRUCE_TREE, "spruce", LootTables.ANCIENT_SPRUCE_TREE_LEAVES_CHEST, LootTables.ANCIENT_SPRUCE_TREE_ROOT_CHEST),
    JUNGLE(StructurePieceTypes.ANCIENT_JUNGLE_TREE, "jungle", LootTables.ANCIENT_JUNGLE_TREE_LEAVES_CHEST, LootTables.ANCIENT_JUNGLE_TREE_ROOT_CHEST),
    PEAR(StructurePieceTypes.ANCIENT_PEAR_TREE, "pear", LootTables.ANCIENT_PEAR_TREE_LEAVES_CHEST, LootTables.ANCIENT_PEAR_TREE_ROOT_CHEST);

    private StructurePieceType type;
    private String name;
    private Identifier template;
    private Identifier leavesChest;
    private Identifier rootChest;

    AncientTreeData(StructurePieceType type, String name, Identifier leavesChest, Identifier rootChest) {
        this.type = type;
        this.name = name;
        this.template = new Identifier("ancient_trees/ancient_" + name + "_tree");
        this.leavesChest = leavesChest;
        this.rootChest = rootChest;
    }

    public String getName() {
        return name;
    }

    public static AncientTreeData findData(String name){
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
