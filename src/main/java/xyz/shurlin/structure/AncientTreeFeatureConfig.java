package xyz.shurlin.structure;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.world.gen.feature.FeatureConfig;
import xyz.shurlin.Shurlin;
import xyz.shurlin.loot.LootTables;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class AncientTreeFeatureConfig implements FeatureConfig {
    public static final Codec<AncientTreeFeatureConfig> CODEC = TreeKind.CODEC.fieldOf("tree_kind")
            .xmap((AncientTreeFeatureConfig::new), (ancientTreeFeatureConfig) -> ancientTreeFeatureConfig.treeKind).codec();
    public TreeKind treeKind;

    public AncientTreeFeatureConfig(TreeKind treeKind) {
        this.treeKind = treeKind;
    }

    public static enum TreeKind implements StringIdentifiable {
        OAK(StructurePieceTypes.ANCIENT_OAK_TREE, "oak", LootTables.ANCIENT_OAK_TREE_LEAVES_CHEST, LootTables.ANCIENT_OAK_TREE_ROOT_CHEST),
        BIRCH(StructurePieceTypes.ANCIENT_BIRCH_TREE, "birch", LootTables.ANCIENT_BIRCH_TREE_LEAVES_CHEST, LootTables.ANCIENT_BIRCH_TREE_ROOT_CHEST),
        DARK_OAK(StructurePieceTypes.ANCIENT_DARK_OAK_TREE, "dark_oak", LootTables.ANCIENT_DARK_OAK_TREE_LEAVES_CHEST, LootTables.ANCIENT_DARK_OAK_TREE_ROOT_CHEST),
        ACACIA(StructurePieceTypes.ANCIENT_ACACIA_TREE, "acacia", LootTables.ANCIENT_ACACIA_TREE_LEAVES_CHEST, LootTables.ANCIENT_ACACIA_TREE_ROOT_CHEST),
        SPRUCE(StructurePieceTypes.ANCIENT_SPRUCE_TREE, "spruce", LootTables.ANCIENT_SPRUCE_TREE_LEAVES_CHEST, LootTables.ANCIENT_SPRUCE_TREE_ROOT_CHEST),
        JUNGLE(StructurePieceTypes.ANCIENT_JUNGLE_TREE, "jungle", LootTables.ANCIENT_JUNGLE_TREE_LEAVES_CHEST, LootTables.ANCIENT_JUNGLE_TREE_ROOT_CHEST),
        PEAR(StructurePieceTypes.ANCIENT_PEAR_TREE, "pear", LootTables.ANCIENT_PEAR_TREE_LEAVES_CHEST, LootTables.ANCIENT_PEAR_TREE_ROOT_CHEST);

        public static final Codec<TreeKind> CODEC = StringIdentifiable.createCodec(TreeKind::values, TreeKind::findData);
        private static final Map<String, TreeKind> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(TreeKind::getName, (type) -> type));

        private final StructurePieceType type;
        private final String name;
        private final Identifier template;
        private final Identifier leavesChest;
        private final Identifier rootChest;

        private TreeKind(StructurePieceType type, String name, Identifier leavesChest, Identifier rootChest) {
            this.type = type;
            this.name = name;
            this.template = new Identifier(Shurlin.MODID, "ancient_trees/ancient_" + name + "_tree");
            this.leavesChest = leavesChest;
            this.rootChest = rootChest;
        }

        public String getName() {
            return name;
        }

        static TreeKind findData(String name) {
            return BY_NAME.get(name);
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

        @Override
        public String asString() {
            return this.name;
        }
    }

}
