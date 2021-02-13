package xyz.shurlin.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;
import xyz.shurlin.util.ShurlinLevel;

import static xyz.shurlin.item.ItemGroups.SHURLIN;


public class BasicToolsItem {
    private final ToolMaterial material;
    public final ShurlinSwordItem sword;
    public final ShurlinPickaxeItem pickaxe;
    public final ShurlinAxeItem axe;
    public final ShurlinShovelItem shovel;
    public final ShurlinHoeItem hoe;

    public BasicToolsItem(ToolMaterial material, String registryName, float shurlinLevel) {
        this.material = material;
        sword = (ShurlinSwordItem)register(registryName+"_sword",new ShurlinSwordItem(shurlinLevel));
        pickaxe = (ShurlinPickaxeItem)register(registryName+"_pickaxe",new ShurlinPickaxeItem(shurlinLevel));
        axe = (ShurlinAxeItem)register(registryName+"_axe",new ShurlinAxeItem(shurlinLevel));
        shovel = (ShurlinShovelItem)register(registryName+"_shovel",new ShurlinShovelItem(shurlinLevel));
        hoe = (ShurlinHoeItem)register(registryName+"_hoe",new ShurlinHoeItem(shurlinLevel));
    }

    private static Item register(String registryName, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Shurlin.MODID,registryName),item);
    }

    protected class ShurlinSwordItem extends net.minecraft.item.SwordItem implements ShurlinLevel {
        private final float shurlinLevel;

        ShurlinSwordItem(float shurlinLevel) {
            super(material, 3, -2.4f, new Item.Settings().group(SHURLIN));
            this.shurlinLevel = shurlinLevel;
        }

        @Override
        public float getShurlinLevel() {
            return this.shurlinLevel;
        }
    }

    protected class ShurlinPickaxeItem extends net.minecraft.item.PickaxeItem implements ShurlinLevel {
        private final float shurlinLevel;

        ShurlinPickaxeItem(float shurlinLevel) {
            super(material, 1, -2.8f, new Item.Settings().group(SHURLIN));
            this.shurlinLevel = shurlinLevel;
        }

        @Override
        public float getShurlinLevel() {
            return shurlinLevel;
        }
    }

    protected class ShurlinAxeItem extends net.minecraft.item.AxeItem implements ShurlinLevel {
        private final float shurlinLevel;
        ShurlinAxeItem(float shurlinLevel) {
            super(material, 6, -3.0f, new Item.Settings().group(SHURLIN));
            this.shurlinLevel = shurlinLevel;
        }

        @Override
        public float getShurlinLevel() {
            return shurlinLevel;
        }
    }

    protected class ShurlinShovelItem extends net.minecraft.item.ShovelItem implements ShurlinLevel {
        private final float shurlinLevel;
        ShurlinShovelItem(float shurlinLevel) {
            super(material, 1.5f, -3.0f, new Item.Settings().group(SHURLIN));
            this.shurlinLevel = shurlinLevel;
        }

        @Override
        public float getShurlinLevel() {
            return shurlinLevel;
        }
    }

    protected class ShurlinHoeItem extends net.minecraft.item.HoeItem implements ShurlinLevel {
        private final float shurlinLevel;
        ShurlinHoeItem(float shurlinLevel) {
            super(material, (int)(0-material.getAttackDamage()), material.getAttackDamage()-3, new Item.Settings().group(SHURLIN));
            this.shurlinLevel = shurlinLevel;
        }

        @Override
        public float getShurlinLevel() {
            return shurlinLevel;
        }
    }

    public ToolMaterial getMaterial() {
        return material;
    }
}
