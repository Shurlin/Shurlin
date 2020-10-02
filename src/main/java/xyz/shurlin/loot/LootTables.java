package xyz.shurlin.loot;

import net.minecraft.util.Identifier;
import xyz.shurlin.Shurlin;

public class LootTables {
    public static final Identifier ANCIENT_OAK_TREE_ROOT_CHEST;
    public static final Identifier ANCIENT_OAK_TREE_LEAVES_CHEST;
    public static final Identifier ANCIENT_BIRCH_TREE_ROOT_CHEST;
    public static final Identifier ANCIENT_BIRCH_TREE_LEAVES_CHEST;
    public static final Identifier ANCIENT_DARK_OAK_TREE_ROOT_CHEST;
    public static final Identifier ANCIENT_DARK_OAK_TREE_LEAVES_CHEST;
    public static final Identifier ANCIENT_ACACIA_TREE_ROOT_CHEST;
    public static final Identifier ANCIENT_ACACIA_TREE_LEAVES_CHEST;
    public static final Identifier ANCIENT_SPRUCE_TREE_ROOT_CHEST;
    public static final Identifier ANCIENT_SPRUCE_TREE_LEAVES_CHEST;
    public static final Identifier ANCIENT_JUNGLE_TREE_ROOT_CHEST;
    public static final Identifier ANCIENT_JUNGLE_TREE_LEAVES_CHEST;
    public static final Identifier ANCIENT_PEAR_TREE_ROOT_CHEST;
    public static final Identifier ANCIENT_PEAR_TREE_LEAVES_CHEST;

    private static Identifier register(String id){
        return new Identifier(Shurlin.MODID, id);
    }

    static {
        ANCIENT_OAK_TREE_ROOT_CHEST = register("chests/ancient_trees/ancient_oak_tree_root");
        ANCIENT_OAK_TREE_LEAVES_CHEST = register("chests/ancient_trees/ancient_oak_tree_leaves");
        ANCIENT_BIRCH_TREE_ROOT_CHEST = register("chests/ancient_trees/ancient_birch_tree_root");
        ANCIENT_BIRCH_TREE_LEAVES_CHEST = register("chests/ancient_trees/ancient_birch_tree_root");
        ANCIENT_DARK_OAK_TREE_ROOT_CHEST = register("chests/ancient_trees/ancient_dark_oak_tree_root");
        ANCIENT_DARK_OAK_TREE_LEAVES_CHEST = register("chests/ancient_trees/ancient_dark_oak_tree_root");
        ANCIENT_ACACIA_TREE_ROOT_CHEST = register("chests/ancient_trees/ancient_acacia_tree_root");
        ANCIENT_ACACIA_TREE_LEAVES_CHEST = register("chests/ancient_trees/ancient_acacia_tree_root");
        ANCIENT_SPRUCE_TREE_ROOT_CHEST = register("chests/ancient_trees/ancient_spruce_tree_root");
        ANCIENT_SPRUCE_TREE_LEAVES_CHEST = register("chests/ancient_trees/ancient_spruce_tree_root");
        ANCIENT_JUNGLE_TREE_ROOT_CHEST = register("chests/ancient_trees/ancient_jungle_tree_root");
        ANCIENT_JUNGLE_TREE_LEAVES_CHEST = register("chests/ancient_trees/ancient_jungle_tree_root");
        ANCIENT_PEAR_TREE_ROOT_CHEST = register("chests/ancient_trees/ancient_pear_tree_root");
        ANCIENT_PEAR_TREE_LEAVES_CHEST = register("chests/ancient_trees/ancient_pear_tree_leaves");
    }
}
