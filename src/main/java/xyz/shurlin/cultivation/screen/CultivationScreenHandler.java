package xyz.shurlin.cultivation.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import xyz.shurlin.cultivation.CultivationManager;
import xyz.shurlin.cultivation.CultivationRealm;
import xyz.shurlin.screen.ScreenHandlerTypes;

public class CultivationScreenHandler extends ScreenHandler {
    CultivationRealm realm;

    public CultivationScreenHandler(int syncId, CultivationRealm realm) {
        super(ScreenHandlerTypes.CULTIVATION_SCREEN_HANDLER_TYPE, syncId);
        this.realm = realm;
    }

    public CultivationScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId,CultivationManager.INSTANCE.getCultivationRealmByEntity(playerInventory.player));
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return CultivationManager.INSTANCE.isCultivated(player);
    }
}
