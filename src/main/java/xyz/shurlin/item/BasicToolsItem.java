package xyz.shurlin.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import xyz.shurlin.Shurlin;
import xyz.shurlin.util.ShurlinLevel;


import static xyz.shurlin.item.ItemGroups.SHURLIN;


public class BasicToolsItem {
    private ToolMaterial material;
    public SwordItem sword;
    public PickaxeItem pickaxe;
    public AxeItem axe;
    public ShovelItem shovel;
    public HoeItem hoe;

    public BasicToolsItem(ToolMaterial material, String registryName, float shurlinLevel) {
        this.material = material;
        sword = (SwordItem)register(registryName+"_sword",new SwordItem(shurlinLevel));
        pickaxe = (PickaxeItem)register(registryName+"_pickaxe",new PickaxeItem());
        axe = (AxeItem)register(registryName+"_axe",new AxeItem());
        shovel = (ShovelItem)register(registryName+"_shovel",new ShovelItem());
        hoe = (HoeItem)register(registryName+"_hoe",new HoeItem());
    }

    private static Item register(String registryName, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Shurlin.MODID,registryName),item);
    }

    private class SwordItem extends net.minecraft.item.SwordItem implements ShurlinLevel {
        private float shurlinLevel;

        SwordItem(float shurlinLevel) {
            super(material, 3, -2.4f, new Item.Settings().group(SHURLIN));
            this.shurlinLevel = shurlinLevel;
        }

        @Override
        public float getShurlinLevel() {
            return this.shurlinLevel;
        }
    }

    private class PickaxeItem extends net.minecraft.item.PickaxeItem {
        @Override
        public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
            return super.postMine(stack, world, state, pos, miner);
        }

        PickaxeItem() {
            super(material, 1, -2.8f, new Item.Settings().group(SHURLIN));
        }
    }

    private class AxeItem extends net.minecraft.item.AxeItem {
        AxeItem() {
            super(material, 6, -3.0f, new Item.Settings().group(SHURLIN));
        }
    }

    private class ShovelItem extends net.minecraft.item.ShovelItem {
        ShovelItem() {
            super(material, 1.5f, -3.0f, new Item.Settings().group(SHURLIN));
        }
    }

    private class HoeItem extends net.minecraft.item.HoeItem {
        HoeItem() {
            super(material, (int)(0-material.getAttackDamage()), material.getAttackDamage()-3, new Item.Settings().group(SHURLIN));
        }
    }
}
