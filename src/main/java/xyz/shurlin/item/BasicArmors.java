package xyz.shurlin.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;

public class BasicArmors {
    private ArmorMaterial material;
    private ArmorItem helmet;
    private ArmorItem chestplate;
    private ArmorItem leggings;
    private ArmorItem boots;

    public BasicArmors(ArmorMaterial material, String registryName) {
        this.material = material;
        helmet = (ArmorItem)register(registryName + "_helmet", new ArmorItem(this.material, EquipmentSlot.HEAD));
        chestplate = (ArmorItem)register(registryName + "_chestplate", new ArmorItem(this.material,EquipmentSlot.CHEST));
        leggings = (ArmorItem)register(registryName + "_leggings", new ArmorItem(this.material,EquipmentSlot.LEGS));
        boots = (ArmorItem)register(registryName + "_boots", new ArmorItem(this.material,EquipmentSlot.FEET));
    }

    private static Item register(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Shurlin.MODID, name), item);
    }

    private class ArmorItem extends net.minecraft.item.ArmorItem{
        public ArmorItem(ArmorMaterial material, EquipmentSlot slot) {
            super(material, slot, new Item.Settings().group(ItemGroups.SHURLIN));
        }
    }
}
