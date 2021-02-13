package xyz.shurlin.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;

public class BasicArmors {
    private final ArmorMaterial material;
    private final ShurlinArmorItem helmet;
    private final ShurlinArmorItem chestplate;
    private final ShurlinArmorItem leggings;
    private final ShurlinArmorItem boots;

    public BasicArmors(ArmorMaterial material, String registryName) {
        this.material = material;
        helmet = (ShurlinArmorItem) register(registryName + "_helmet", new ShurlinArmorItem(this.material, EquipmentSlot.HEAD));
        chestplate = (ShurlinArmorItem) register(registryName + "_chestplate", new ShurlinArmorItem(this.material, EquipmentSlot.CHEST));
        leggings = (ShurlinArmorItem) register(registryName + "_leggings", new ShurlinArmorItem(this.material, EquipmentSlot.LEGS));
        boots = (ShurlinArmorItem) register(registryName + "_boots", new ShurlinArmorItem(this.material, EquipmentSlot.FEET));
    }

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Shurlin.MODID, name), item);
    }

    private static class ShurlinArmorItem extends net.minecraft.item.ArmorItem {
        public ShurlinArmorItem(ArmorMaterial material, EquipmentSlot slot) {
            super(material, slot, new Settings().group(ItemGroups.SHURLIN));
        }
    }

    public ArmorMaterial getMaterial() {
        return material;
    }

    public ShurlinArmorItem getHelmet() {
        return helmet;
    }

    public ShurlinArmorItem getChestplate() {
        return chestplate;
    }

    public ShurlinArmorItem getLeggings() {
        return leggings;
    }

    public ShurlinArmorItem getBoots() {
        return boots;
    }
}
