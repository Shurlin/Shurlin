package xyz.shurlin.inventory;

import net.minecraft.entity.player.PlayerEntity;
import xyz.shurlin.util.ShurlinLevel;

public class BreakerInventory extends AbstractWorkerInventory {
    public BreakerInventory(ShurlinLevel shurlinLevel) {
        super(2, shurlinLevel);
    }
}
