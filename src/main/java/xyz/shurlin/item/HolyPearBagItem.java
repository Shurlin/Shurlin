package xyz.shurlin.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.*;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import xyz.shurlin.inventory.PortableInventory;
import xyz.shurlin.screen.BiggerContainerScreenHandler;

public class HolyPearBagItem extends BasicItem {
    private static final Text TITLE = new TranslatableText("container.portable_container");
    private static final int SIZE = 104;
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(SIZE, ItemStack.EMPTY);

    HolyPearBagItem() {
        super(new Item.Settings().group(ItemGroups.SHURLIN).maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            PortableInventory inventory = new PortableInventory(104, stack);
            CompoundTag tag = stack.getOrCreateTag();
            inventory.readTags(tag.getList("inventory",10));
            user.openHandledScreen(createScreenHandler(inventory, user.inventory.selectedSlot));
            user.incrementStat(Stats.OPEN_CHEST);
        }

        return TypedActionResult.success(stack);
    }

    private SimpleNamedScreenHandlerFactory createScreenHandler(Inventory inventory, int slot) {
        return new SimpleNamedScreenHandlerFactory((syncId, inv, player) -> new BiggerContainerScreenHandler(syncId, inv, inventory, slot),TITLE);
    }
}
