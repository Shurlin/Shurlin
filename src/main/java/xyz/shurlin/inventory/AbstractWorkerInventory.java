package xyz.shurlin.inventory;

import net.minecraft.inventory.SimpleInventory;
import xyz.shurlin.util.ShurlinLevel;

public abstract class AbstractWorkerInventory extends SimpleInventory{
    public ShurlinLevel shurlinLevel;

    AbstractWorkerInventory(int size, ShurlinLevel shurlinLevel) {
        super(size);
        this.shurlinLevel = shurlinLevel;
    }
}
