package xyz.shurlin.inventory;

import net.minecraft.inventory.SimpleInventory;
import xyz.shurlin.util.ShurlinLevel;

public class WorkerInventory extends SimpleInventory{
    public ShurlinLevel shurlinLevel;

    public WorkerInventory(int size, ShurlinLevel shurlinLevel) {
        super(size);
        this.shurlinLevel = shurlinLevel;
    }
}
