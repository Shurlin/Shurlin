package xyz.shurlin.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.util.collection.DefaultedList;
import xyz.shurlin.Shurlin;

import java.util.ArrayList;
import java.util.Vector;

public class ConnectiveInventory extends SimpleInventory {
    private PlayerEntity player;
    private static ArrayList<ConnectiveInventory> connectiveInventories;

    private ConnectiveInventory(int size, PlayerEntity player) {
        super(size);
        this.player = player;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void readTags(ListTag allTags) {
        for(int i = 0; i < allTags.size(); ++i) {
            ListTag personalTags = allTags.getList(i);
            ConnectiveInventory inventory = connectiveInventories.get(i);
            for (int j = 0; j < personalTags.size(); j++) {
                ItemStack itemStack = ItemStack.fromTag(personalTags.getCompound(i));
                if (!itemStack.isEmpty()) {
                    inventory.addStack(itemStack);
                }
            }
        }
    }

    public ListTag getTags() {
        ListTag allTags = new ListTag();
        for (ConnectiveInventory inventory : connectiveInventories) {
            for (int j = 0; j < inventory.size(); j++) {
                ListTag personalTags = new ListTag();
                ItemStack itemStack = inventory.getStack(j);
                if (!itemStack.isEmpty()) {
                    personalTags.add(itemStack.toTag(new CompoundTag()));
                }
                allTags.add(personalTags);
            }

        }
        return allTags;
    }

    public static ConnectiveInventory getConnectiveInventory(int size, PlayerEntity player){
        if (connectiveInventories != null)
            for(ConnectiveInventory inventory : connectiveInventories){
                if (inventory.getPlayer() == player)
                    return inventory;
            }
        if(connectiveInventories == null)
            connectiveInventories = new ArrayList<>();
        ConnectiveInventory inventory = new ConnectiveInventory(size, player);
        connectiveInventories.add(inventory);
        Shurlin.LOGGER.debug(connectiveInventories.size());
        return inventory;
    }
}
