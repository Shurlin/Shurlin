package xyz.shurlin.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import xyz.shurlin.Shurlin;

public class ItemGroups {
//    static final ItemGroup SHURLIN = new ItemGroup(ItemGroup.GROUPS.length, "shurlin"){
//        @Override
//        public ItemStack createIcon() {
//            return new ItemStack(Items.PLANT_ESSENCE);
//        }
//    };

    static final ItemGroup SHURLIN = FabricItemGroupBuilder.create(new Identifier(Shurlin.MODID, Shurlin.MODID)).build();
}
