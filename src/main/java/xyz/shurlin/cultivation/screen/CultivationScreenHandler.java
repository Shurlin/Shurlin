package xyz.shurlin.cultivation.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import xyz.shurlin.cultivation.CultivationManager;
import xyz.shurlin.cultivation.CultivationRealm;

public class CultivationScreenHandler extends ScreenHandler {
    private CultivationRealm realm;

    CultivationScreenHandler(int syncId, CultivationRealm realm) {
        super(null, syncId);
        this.realm = realm;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return CultivationManager.INSTANCE.isCultivated(player);
    }
}
